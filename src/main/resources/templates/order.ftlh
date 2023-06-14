<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>

    <#if isAdmin>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Создать заказ
        </a>
    </#if>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/order" enctype="multipart/form-data">
                <label for="client">Выберите Клиент:</label>
                <select class="custom-select" id="client" name="client">
                    <#list clients as cc>
                        <option value="${cc.getId()}">${cc.getFullName()}</option>
                    </#list>
                </select>
                <label for="product">Выберите продукт:</label>
                <select class="custom-select" id="product" name="product">
                    <#list all as e>
                        <option value="${e.getId()}">${e.getProduct().getName()} за ${e.getPrice()}</option>
                    </#list>
                </select>
                <label for="count">Выберите количество:</label>
                <input type="number" name="count" id="count" placeholder="Количество"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>


    <div class="card-columns" id="message-list">
        <#list orders as order>
            <div class="card my-3" data-id="${order.id}">
                <div class="m-2">
                    <span>Id: ${order.id}</span><br/>
                    <i>Клиент: ${order.getClient().getFullName()}</i><br/>
                    <i>Продукт: ${order.getProduct().getProduct().getName()}</i><br/>
                    <i>Цена: ${order.getProduct().getPrice()}</i><br/>
                    <i>Количество: ${order.getCount()}</i><br/>
                </div>
                <#if isAdmin>
                    <div class="card-footer text-muted container">
                        <div class="row">
                            <a class="col btn btn-primary" href="/order/commit?order=${order.id}">Выполнить</a>
                        </div>
                    </div>
                </#if>
            </div>
        <#else>
        </#list>
    </div>
</@c.page>
