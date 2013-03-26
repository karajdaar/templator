<#function getTypeName typeSignature>
	<#if typeSignature?starts_with("Q") && typeSignature?ends_with(";")>
		<#if typeSignature?matches("Q([^(])*<Q([^;]*);>;")>
			<#assign containedType = typeSignature?matches("Q([^(])*<Q([^;]*);>;")>
			<#if containedType>
				<#assign name=containedType?groups[2]>
			<#else>
				<#assign name=typeSignature?substring(1,typeSignature?length-1)>
			</#if>
		<#else>
			<#assign name=typeSignature?substring(1,typeSignature?length-1)>
		</#if>
	</#if>
	<#return name?trim>
</#function>

<#function guessFieldType field className>
	<#assign fieldName = field.elementName>
	<#if fieldName?starts_with("from")>
		<#assign fieldName=fieldName?string?substring(4)>
	<#elseif fieldName?starts_with("to")>
		<#assign fieldName=fieldName?string?substring(2)>
	</#if>
	<#if fieldName?starts_with("parent")>
		<#assign prefix="${className}">
	<#elseif fieldName == "id">
		<#assign prefix="${className}">
	<#elseif fieldName?lower_case?ends_with("id")>
		<#assign prefix="${fieldName?substring(0,fieldName?length-2)?capitalize}">
	<#else>
		<#assign prefix = getTypeName(field.typeSignature)>
	</#if>
	<#if prefix="Order">
  		<#assign prefix="PurchaseOrder">
  	<#elseif prefix="Email">
  		<#assign prefix="Mail">
  	</#if>
	<#return prefix>						
</#function>

<#assign colors = ["peru","aquamarine","brown3","darkgreen","gold","darkorchid1","chartreuse","darkorange1","deeppink","dodgerblue"]>
digraph Relationships {
  graph[ bgcolor="gray72" ];
  node [shape=box,color=grey, style=filled];
<#list units?keys as name>
<#assign unit=units[name]>
  "${unit.types[0].elementName}" [style = "filled" fillcolor = "${colors[name_index%10]}" label = "${unit.types[0].elementName}"];
<#list unit.types[0].fields as field>
  <#assign typeName = guessFieldType(field unit.types[0].elementName)>
  <#if typeName != "String">
  "${unit.types[0].elementName}" -> "${typeName}" [label = "${field.elementName}" fontcolor = "${colors[name_index%10]}" color = "${colors[name_index%10]}"];
  </#if>
</#list>
</#list>
 overlap=false;
 fontsize=12;
 splines=true;
 nodesep=0.2;
}