base index

<div>
<#if items??>
    <#list items as item>
    <div>
        <#list item?keys as key>
            <#if !item[key]?is_sequence && item[key]?has_content>
            <div>${key}</div>
                <#if item[key]?is_boolean>
            <div>${item[key]?c}</div>
                <#elseif item[key]?is_date_like>
            <div>${item[key]?string("yyyy/MM/dd HH:mm:ss")}</td>
                <#else>
            <div>${item[key]}</div>
                </#if>
            </#if>
        </#list>
        <div>
        <#list item?keys as key>
            <#if item[key]?is_sequence>
            <a href="">${key}</a>
            </#if>
        </#list>
        <div>
    </div>
    </#list>
</#if>
</div>
