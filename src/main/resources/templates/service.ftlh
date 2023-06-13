<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>
    <#if isAdmin>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Создать услугу
    </a>
    </#if>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/services" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.text}</#if>" name="name" placeholder="Введите название" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="description" placeholder="Введите описание"/>
                </div>

                <input type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>


    <div class="card-columns" id="message-list">
        <#list services as s>
            <div class="card my-3" data-id="${s.id}">
                <div class="m-2">
                    <span>Id: ${s.id}</span><br/>
                    <i>Название: ${s.name}</i><br/>
                    <i>Описание: ${s.description}</i><br/>
                </div>
                <#if isAdmin>
                <div class="card-footer text-muted container">
                    <div class="row">
                        <a class="col btn btn-primary" href="/services/edit?service=${s.id}">Редактировать</a>
                    </div>
                </div>
                <div class="card-footer text-muted container">
                    <div class="row">
                        <a class="col btn btn-primary" href="/services/delete?service=${s.id}">Удалить</a>
                    </div>
                </div>
                </#if>
            </div>
        <#else>
        </#list>
    </div>
</@c.page>
