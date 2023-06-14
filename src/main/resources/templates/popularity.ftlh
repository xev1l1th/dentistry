<#import "parts/common.ftlh" as c>
<@c.page>
    <#list data as d>
        Продукт: ${d.getKey()} В количестве: ${d.getValue()}  <#if 300 < d.getValue()> Товар популярен, требуется дополнительная закупка. </#if>
        <br/>
    </#list>
</@c.page>