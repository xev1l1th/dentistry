<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>
    <#if isAdmin>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Создать страну
        </a>
    </#if>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/country" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.text}</#if>" name="name" placeholder="Введите название" />
                </div>
                <input type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>


    <div class="card-columns" id="message-list">
        <#list countries as message>
            <div class="card my-3" data-id="${message.id}">
                <div class="m-2">
                    <span>Id: ${message.id}</span><br/>
                    <i>Страна: ${message.name}</i>
                </div>
                <div class="card-footer text-muted container">
                    <#if isAdmin>
                        <div class="row">
                            <a class="col btn btn-primary" href="/country/edit?country=${message.id}">Редактировать</a>
                        </div>
                        <div class="row">
                            <a class="col btn btn-primary" href="/country/delete?country=${message.id}">Удалить</a>
                        </div>
                    </#if>
                </div>
            </div>
        <#else>
            No data
        </#list>
    </div>
</@c.page>
