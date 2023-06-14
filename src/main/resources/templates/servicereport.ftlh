<#import "parts/common.ftlh" as c>
<@c.page>
    <#list data as d>
        Услуга: ${d.getKey()} Цена: <#list d.getValue() as v>${v.getPrice()}руб </#list> <br/>
    </#list>
</@c.page>