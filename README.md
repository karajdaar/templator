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

See the code-service project. The generator folder holds a couple of working files ending with .gen. This file has the instructions for the generate action. 

When invoked from the menu, the generate action takes the information in the config file (file ending with .gen), which includes the name of the template and the pattern of the file to be generated, and refreshes the project after its done.

The main objects available are 
1. the unit which is an instance of org.eclipse.jdt.core.api.ICompilationUnit for each of the classes configured in the .gen file
2. the helper which is an instance of Helper and contains methods like now() returning the current time.

