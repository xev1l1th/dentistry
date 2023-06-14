<#import "parts/common.ftlh" as c>
<@c.page>
    <#list all as order>
        <span>Id: ${order.id}</span><br/>
        <i>Клиент: ${order.getClient().getFullName()}</i><br/>
        <i>Продукт: ${order.getProduct().getProduct().getName()}</i><br/>
        <i>Цена: ${order.getProduct().getPrice()}</i><br/>
        <i>Количество: ${order.getCount()}</i><br/>
        <i>Выполнен</i>
        <br/>
        <br/>
    </#list>
</@c.page>