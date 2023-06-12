<#import "parts/common.ftlh" as c>
<@c.page>
    <#list info as i>
        ${i.getContractor().getName()}
        <br>
        <#list i.getProductPrices() as e>
            ${e.getProduct().getName()} costs ${e.getPrice()}
        </#list>
        <br>
    </#list>
</@c.page>