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
template. This variable is an instance of [org.eclipse.jdt.core.api.ICompilationUnit].

[org.eclipse.jdt.core.api.ICompilationUnit]: http://publib.boulder.ibm.com/infocenter/iadthelp/v6r0/index.jsp?topic=/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/ICompilationUnit.html 

The other object available in the freemarker context is "helper" variable which is an instance of [Helper] class.

[Helper]: https://github.com/karajdaar/templator/blob/master/com.github.templator/src/com/github/templator/popup/actions/Helper.java

The output is directed to the name generated from outputFileTemplate which is also freemarker string with the same context as the templateName

Another ability is to provide context to all the classes as "units" variable which is a HashMap of the simple name of the main type in each unit and the unit. In that case the 
template called once with all the units in the context. In that case, the outputFileTemplate is interpreted as is and not as a freemarker template. To enable this mode
add a "doAll" variable and set it to true in the .gen file


<pre>
{
"classNames":[
"fully.qualified.package.SampleClass1", 
"fully.qualified.package.SampleClass2", 
"fully.qualified.package.SampleClass3", 
"fully.qualified.package.SampleClass4" 
],
"templateName":"generate_dot_diagram.ftl",
"outputFileTemplate":"class_relationship.dot",
"doAll": "true"
}
</pre>

Sample Application
------------------

A sample application borrowing some classes from the PetStore java application. It uses freemarker template to generate class
relationship diagram in dot format ([graphviz]). 

Take a look at the generator folder under that project. Once the plugin is installed, you should be able to right click on the 
generate_graph_relationships.gen and click on Generate From Template. That will create the object_relationships.dot which when 
viewed with [graphviz] looks like this.

![object_relationships.png](https://raw.github.com/karajdaar/templator/master/sample/generator/object_relationships.png "Class Relationships from sample.domain package using the Generator")
 
[graphviz]: http://www.graphviz.org/

[![githalytics.com alpha](https://cruel-carlota.pagodabox.com/6fd4f2a902f938b153ba3e7463913348 "githalytics.com")](http://githalytics.com/karajdaar/templator)