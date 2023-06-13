<#import "parts/common.ftlh" as c>
<@c.page>
    <#list data as d>
        Продукт: ${d.getKey()} в количестве : ${d.getValue()}  <#if 300 < d.getValue()>Популярен</#if>
        <br/>
    </#list>
</@c.page>