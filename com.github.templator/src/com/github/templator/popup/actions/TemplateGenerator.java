package com.github.templator.popup.actions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.templator.Activator;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class TemplateGenerator {

	static class GeneratorConfiguration {

		List<String> classNames;
		String templateName;
		String outputFileTemplate;
		Boolean doAll = Boolean.FALSE;

		public GeneratorConfiguration() {

		}

		public List<String> getClassNames() {
			return classNames;
		}

		public void setClassNames(List<String> classNames) {
			this.classNames = classNames;
		}

		public String getTemplateName() {
			return templateName;
		}

		public void setTemplateName(String templateName) {
			this.templateName = templateName;
		}

		public String getOutputFileTemplate() {
			return outputFileTemplate;
		}

		public void setOutputFileTemplate(String outputFileTemplate) {
			this.outputFileTemplate = outputFileTemplate;
		}

		public Boolean isDoAll() {
			return doAll;
		}

		public void setDoAll(Boolean val) {
			doAll = val;
		}
	}

	private static Configuration config = new Configuration();
	static {
		config.setObjectWrapper(new DefaultObjectWrapper());
	}

	/**
	 * Uses the list of compilation units and the template to generate
	 * code into outputFileTemplate.
	 * The context consists of the hash map of the units with the unit name as the key
	 * @param units
	 * @param templateName
	 * @param outputFilename
	 * @param project
	 */
	public static void generateAll(HashMap<String, ICompilationUnit> units,
			String templateName, String outputFilename, IJavaProject currentProject) throws Exception {
		// -- looks for folder called generator. FIXME: move to preferences.
		// Creates it if necessary.
		setTemplateDirectory(currentProject);
		// -- load template based on template name
		Template template = config.getTemplate(templateName);
		// fillin the root map
		HashMap<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("units", units);
		rootMap.put("helper", new Helper());
		//
		if (outputFilename == null) {
			return;
		}
		IPath outputPath = currentProject.getResource().getLocation()
				.append(outputFilename);
		File outFile = outputPath.toFile();
		// TODO; if file exists, use resources to store previous version of
		// generated file??
		FileWriter wr = new FileWriter(outFile);
		//
		template.process(rootMap, wr);
		wr.flush();
		wr.close();
		// refresh the project to see the new file
		// currentProject.getProject().getFile(outputPath).getParent().refreshLocal(IResource.DEPTH_ONE,
		// null);
		currentProject.getResource().refreshLocal(IResource.DEPTH_INFINITE,
				null);
	}
	/**
	 * Uses the compilation unit, to extract the fields and method necessary to
	 * provide context for the template<br/>
	 * The template folder is assumed to be "generator" under the java project
	 * of compilation unit<br/>
	 * The template name is defined as in freemarker docs <a href=
	 * "http://freemarker.sourceforge.net/docs/api/freemarker/cache/TemplateCache.html#getTemplate(java.lang.String, java.util.Locale, java.lang.String, boolean)"
	 * >getTemplate()</a> <br/>
	 * The outputFileTemplate is a template (freemarker) as a string with the same objects in its context( namely the unit) as the template for generation
	 * 
	 * @param unit
	 * @param templateName
	 * @param outputFileTemplate
	 * @throws Exception
	 */
	public static void generate(ICompilationUnit unit, String templateName,
			String outputFileTemplate, IJavaProject currentProject)
			throws Exception {
		// -- looks for folder called generator. FIXME: move to preferences.
		// Creates it if necessary.
		setTemplateDirectory(currentProject);
		// -- load template based on template name
		Template template = config.getTemplate(templateName);
		// fillin the root map
		HashMap<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("unit", unit);
		rootMap.put("helper", new Helper());
		//
		String outputFilename = processAndLoadStringTemplate(
				outputFileTemplate, config, rootMap);
		if (outputFilename == null) {
			return;
		}
		IPath outputPath = currentProject.getResource().getLocation()
				.append(outputFilename);
		File outFile = outputPath.toFile();
		// TODO; if file exists, use resources to store previous version of
		// generated file??
		FileWriter wr = new FileWriter(outFile);
		//
		template.process(rootMap, wr);
		wr.flush();
		wr.close();
		// refresh the project to see the new file
		// currentProject.getProject().getFile(outputPath).getParent().refreshLocal(IResource.DEPTH_ONE,
		// null);
		currentProject.getResource().refreshLocal(IResource.DEPTH_INFINITE,
				null);
	}

	private static String processAndLoadStringTemplate(
			String outputFileTemplate, Configuration config, Object rootMap)
			throws Exception {
		try {
			Template t = new Template("outputFileTemplate", new StringReader(
					outputFileTemplate), config);
			StringWriter wr = new StringWriter();
			t.process(rootMap, wr);
			return wr.toString();
		} catch (Exception ex) {
			Activator
					.getDefault()
					.getLog()
					.log(new Status(Status.ERROR, Activator.PLUGIN_ID, ex
							.getMessage()));
			return null;
		}
	}

	public static void setTemplateDirectory(IJavaProject currentProject)
			throws CoreException, IOException {
		IFolder templateFolder = currentProject.getProject().getFolder(
				"generator");
		if (!templateFolder.exists()) {
			templateFolder.create(IResource.NONE, true, null);
		}
		config.setDirectoryForTemplateLoading(templateFolder.getLocation()
				.toFile());
	}

	public static void generate(IJavaProject project, IFile file)
			throws Exception {
		if (file.exists()) {
			ObjectMapper mapper = new ObjectMapper();
			GeneratorConfiguration configuration = mapper.readValue(file
					.getLocation().toFile(), GeneratorConfiguration.class);

			if (configuration != null) {
				if (configuration.isDoAll()) {
					HashMap<String, ICompilationUnit> units = new HashMap<String, ICompilationUnit>();
					for (String className : configuration.getClassNames()) {
						ICompilationUnit unit = getCompilationUnitFor(
								className, project);
						if (unit == null) {
							continue;
						}
						units.put(unit.getElementName(),unit);
					}
					generateAll(units, configuration.getTemplateName(),
							configuration.getOutputFileTemplate(), project);
				} else {
					for (String className : configuration.getClassNames()) {
						ICompilationUnit unit = getCompilationUnitFor(
								className, project);
						if (unit == null) {
							continue;
						}
						generate(unit, configuration.getTemplateName(),
								configuration.getOutputFileTemplate(), project);
					}
				}
			}
		}
	}


	public static ICompilationUnit getCompilationUnitFor(String className,
			IJavaProject project) {
		try {
			return project.findType(className, new NullProgressMonitor())
					.getCompilationUnit();
		} catch (Exception ex) {
			Activator
					.getDefault()
					.getLog()
					.log(new Status(Status.ERROR, Activator.PLUGIN_ID,
							"Could not find class: " + className));
			return null;
		}
	}

}
