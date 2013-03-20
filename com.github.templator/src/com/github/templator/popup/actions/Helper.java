package com.github.templator.popup.actions;

import java.util.ArrayList;
import java.util.Date;

import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;

import com.github.templator.Activator;

/**
 * Houses helper methods to help with common needs
 * 
 * @author nsandhu
 * 
 */
public class Helper {

	public Helper() {

	}

	public Date now() {
		return new Date();
	}

	/**
	 * takes a java camel case name and returns the equivalent python style name
	 * with underscores to separate words E.g. aNiceVariableName becomes
	 * a_nice_variable_name
	 * 
	 * @param javaName
	 * @return python style name
	 */
	public String camelCaseToUnderscore(String javaName) {
		return javaName.replaceAll("(\\p{Ll})(\\p{Lu})", "$1_$2").toLowerCase();
	}

	public String pluaralize(String name) {
		if (name == null) {
			return "";
		}
		if (name.endsWith("s")) {
			return name + "es";
		} else {
			return name + "s";
		}
	}

	public ArrayList<String> getMethodNames(ICompilationUnit unit) {
		ArrayList<String> methodNames = new ArrayList<String>();
		try {
			IType[] allTypes = unit.getAllTypes();
			IType mainType = allTypes[0];
			for (IMethod m : mainType.getMethods()) {
				methodNames.add(m.getElementName());
			}
		} catch (Exception ex) {
			Activator
					.getDefault()
					.getLog()
					.log(new Status(Status.ERROR, Activator.PLUGIN_ID, ex
							.getMessage()));
		}
		return methodNames;
	}
}
