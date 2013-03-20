package com.github.templator.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.github.templator.Activator;

public class TemplateGeneratorAction implements IObjectActionDelegate {

	private Shell shell;
	private ISelection currentSelection;

	/**
	 * Constructor for Action1.
	 */
	public TemplateGeneratorAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) currentSelection;
			if (selection.getFirstElement() instanceof IFile) {
				IFile file = (IFile) selection.getFirstElement();
				IProject project = file.getProject();
				try {
					if (project.hasNature(JavaCore.NATURE_ID)) {
						IJavaProject javaProject = JavaCore.create(project);
						try {
							TemplateGenerator.generate(javaProject, file);
						} catch (Exception e) {
							Activator
									.getDefault()
									.getLog()
									.log(new Status(Status.ERROR,
											Activator.PLUGIN_ID, e.getMessage()));
						}
					} else {
						MessageDialog.openError(shell,
								"Template based generator", "Project: "
										+ project.getName()
										+ " is not a java project?");
					}
				} catch (CoreException ex) {
					Activator
							.getDefault()
							.getLog()
							.log(new Status(Status.ERROR, Activator.PLUGIN_ID,
									ex.getMessage()));
					MessageDialog.openError(shell, "Template based generator",
							"Project: " + project.getName()
									+ " is not open or doesn't exist?");
				}
			}
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		currentSelection = selection;
	}

}
