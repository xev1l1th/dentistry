<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>

    <#if isAdmin>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Создать заказ
        </a>
    </#if>
    <div class="collapse" id="collapseExample">
        <div id="select-container" class="form-group mt-3">
            <form method="post" action="/order" enctype="multipart/form-data">
                <div id="fff">
                <label for="client">Выберите клиента:</label>
                <br/>
                <select class="custom-select" id="client" name="client">
                    <#list clients as cc>
                        <option value="${cc.getId()}">${cc.getFullName()}</option>
                    </#list>
                </select>
                <button type="button" onclick="addSelect()">Добавить продукт</button>
                <br/>
                    <label for="product">Выберите продукт:</label>
                    <select class="custom-select" name="product">
                        <#list all as e>
                            <option value="${e.getId()}">${e.getProduct().getName()} за ${e.getPrice()}</option>
                        </#list>
                    </select>
                    <br/>
                    <input type="number" name="count" placeholder="Количество" multiple/>
                    <br/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
                </div>
            </form>
        </div>
    </div>
    </div>

    <script>
        function addSelect() {
            var container = document.getElementById('fff');
            var select = document.createElement('select');
            select.className = 'custom-select';
            select.name = 'product';
            // Варианты выбора для нового селекта (можно добавить другие варианты)
            <#list all as cc>
            var option1 = document.createElement('option');
            option1.value = ${cc.getId()};
            option1.text = '${cc.getProduct().getName()} за ${cc.getPrice()}';
            select.appendChild(option1);
            </#list>
            var label = document.createElement('label');
            label.textContent = 'Выберите продукт:'

            var input = document.createElement('input');
            input.name = 'count'
            input.placeholder = 'Количество'
            input.type = 'number'
            input.multiple = true

            var insertBeforeElement = container.lastChild.previousSibling;
            container.insertBefore(label, insertBeforeElement);
            container.insertBefore(document.createElement('br'), insertBeforeElement);
            container.insertBefore(select, insertBeforeElement);
            container.insertBefore(document.createElement('br'), insertBeforeElement);
            container.insertBefore(input, insertBeforeElement);
            container.insertBefore(document.createElement('br'), insertBeforeElement);
        }
    </script>

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
                        <div class="row">
                            <a class="col btn btn-primary" href="/order/delete?order=${order.id}">Удалить</a>
                        </div>
                    </div>
                </#if>
            </div>
        <#else>
        </#list>
    </div>
</@c.page>
