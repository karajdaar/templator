templator
=========

An eclipse plugin that generates code based on a Freemarker template and JDT API

Download
--------

[Templator 1.0.1][dl] (1.924 MB) -- 20 Mar 2013

[dl]: https://github.com/karajdaar/templator/blob/master/updatesite.archives/templator.zip?raw=true


Introduction
-----------

Plugin installs a simple popup menu "Generate From Template" when the user right clicks on a file ending with .gen. 

To get started, i recommend keeping your generator files in a generator folder. 

The generator instructions are in a file ending with .gen. The instructions are in JSON format

<pre>
{
"classNames":[
"fully.qualified.package.SampleClass1", 
"fully.qualified.package.SampleClass2", 
"fully.qualified.package.SampleClass3", 
"fully.qualified.package.SampleClass4" 
],
"templateName":"generate_test.ftl",
"outputFileTemplate":"src/test/java/fully/qualified/package/${unit.types[0].elementName}Test.java"
}
</pre>

The classNames provide the context for each invocation of the templateName ( in this case "generate_test.ftl"). This context is provided as "unit" variable in the freemarker 
template. This variable is an instance of org.eclipse.jdt.core.api.ICompilationUnit[icu].

[icu]: http://publib.boulder.ibm.com/infocenter/iadthelp/v6r0/index.jsp?topic=/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/ICompilationUnit.html 

The other object available in the freemarker context is "helper" variable which is an instance of Helper[helper] class.

[helper]: https://github.com/karajdaar/templator/blob/master/com.github.templator/src/com/github/templator/popup/actions/Helper.java

The output is directed to the name generated from outputFileTemplate which is also freemarker string with the same context as the templateName


