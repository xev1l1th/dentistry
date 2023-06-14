<#import "parts/common.ftlh" as c>
<@c.page>
    <#list data as d>
        Для услуги ${d.getKey()} возможны цены : <#list d.getValue() as v>${v.getPrice()}руб </#list> <br/>
    </#list>
</@c.page>