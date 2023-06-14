<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>

    <#if isAdmin>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Создать клиента
        </a>
    </#if>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/client" enctype="multipart/form-data">
                <label for="name">Введите имя:</label>
                <input type="text" name="name" id="name" placeholder="Имя"/>
                <label for="surname">Введите фамилию:</label>
                <input type="text" name="surname" id="surname" placeholder="Фамилия"/>

                <label for="patronymicName">Введите отчество:</label>
                <input type="text" name="patronymicName" id="patronymicName" placeholder="Отчество"/>
                <label for="count">Введите номер:</label>
                <input type="tel" name="phone" id="phone" placeholder="номер"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>


    <div class="card-columns" id="message-list">
        <#list all as cc>
            <div class="card my-3" data-id="${cc.getId()}">
                <div class="m-2">
                    <span>Id: ${cc.id}</span><br/>
                    <i>Клиент: ${cc.getFullName()}</i><br/>
                    <i>Номер: ${cc.getPhoneNumber()}</i><br/>
                </div>
            </div>
        <#else>
        </#list>
    </div>
</@c.page>
