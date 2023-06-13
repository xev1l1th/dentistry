<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>
    <div class="card my-3" data-id="${contractor.id}">
        <div class="m-2">
            <span>Id: ${contractor.id}</span><br/>
            <i>Наименование: ${contractor.name}</i>
            <i>ИНН: ${contractor.inn}</i>
            <i>Страна: ${contractor.country.name}</i>
        </div>
        <div class="card-footer text-muted container">
            <div class="row">
                <a class="col btn btn-primary" href="/contractor/edit?contractor=${contractor.id}">Редактирование</a>
            </div>
        </div>
    </div>

    <#if isAdmin>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Свернуть
        </a>
    </#if>
    <div class="collapse show" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/contractors/edit" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.text}</#if>" name="name" placeholder="Введите наименование" />
                </div>
                <select class="custom-select" id="country" name="country">
                    <#list countries as country>
                        <option value="${country.getId()}">${country.getName()}</option>
                    </#list>
                </select>
                <div class="form-group">
                    <input type="text" class="form-control" name="inn" placeholder="Введите ИНН"/>
                </div>
                <input type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>
</@c.page>