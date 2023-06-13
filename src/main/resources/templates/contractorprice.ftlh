<#import "parts/common.ftlh" as c>
<@c.page>
    <#list info as i>
        ${i.getContractor().getName()}
        <br>
        <#list i.getProductPrices() as e>
            ${e.getProduct().getName()} стоит ${e.getPrice()} рублей
        </#list>
        <br>
    </#list>
</@c.page>