<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>
    <#if isAdmin>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Создать товар
        </a>
    </#if>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/product" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.text}</#if>" name="name" placeholder="Введите наименование" />
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
        <#list products as p>
            <div class="card my-3" data-id="${p.id}">
                <div class="m-2">
                    <span>Id: ${p.id}</span><br/>
                    <i>Наименование: ${p.name}</i><br/>
                    <i>Описание: ${p.description}</i><br/>
                </div>
                <div class="card-footer text-muted container">
                    <#if isAdmin>
                        <div class="row">
                            <a class="col btn btn-primary" href="/product/edit?product=${p.id}">Редактировать</a>
                        </div>
                        <div class="row">
                            <a class="col btn btn-primary" href="/product/delete?product=${p.id}">Удалить</a>
                        </div>
                    </#if>
                </div>
            </div>
        <#else>
            No data
        </#list>
    </div>
</@c.page>
