base details

<form id="createForm" action="" method="POST">
    <#list detail_template as field>
    <div>
        <#if field.name != "id" && field.type != "interface java.util.List">
        <div>${field.name}</div>
            <#if field.type == "class java.lang.String">
        <input type="text" name="${field.name}" value=""/>
            </#if>
        </#if>
    <div>
    </#list>
    <br>
        <input type="submit" value="submit"/>
    </br>
</form>
