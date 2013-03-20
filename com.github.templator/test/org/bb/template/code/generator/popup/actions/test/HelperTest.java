package org.bb.template.code.generator.popup.actions.test;

import org.junit.Assert;
import org.junit.Test;

import com.github.templator.popup.actions.Helper;

public class HelperTest {
	@Test
	public void testCamelCaseConversion(){
		Helper helper = new Helper();
		Assert.assertEquals("java_name",helper.camelCaseToUnderscore("javaName"));
		Assert.assertEquals("my_really_long_name2",helper.camelCaseToUnderscore("myReallyLongName2"));
	}
}
