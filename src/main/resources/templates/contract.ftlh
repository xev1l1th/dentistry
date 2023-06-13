<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>

    <#if isAdmin>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Создать договор
        </a>
    </#if>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/contracts" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.text}</#if>" name="name" placeholder="Введите название" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="description" placeholder="Введите описание"/>
                </div>
                <select class="custom-select" id="contractor" name="contractor">
                    <#list contractors as con>
                        <option value="${con.getId()}">${con.getName()}</option>
                    </#list>
                </select>
                <select class="custom-select" id="organisation" name="organisation">
                    <#list organizations as org>
                        <option value="${org.getId()}">${org.getName()}</option>
                    </#list>
                </select>
                    <input type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Сохранить</button>
                    </div>
            </form>
        </div>
    </div>


    <div class="card-columns" id="message-list">
        <#list contracts as message>
            <div class="card my-3" data-id="${message.id}">
                <div class="m-2">
                    <span>Id: ${message.id}</span><br/>
                    <i>Название: ${message.name}</i><br/>
                    <i>Описание: ${message.description}</i><br/>
                    <i>Название организации: ${message.organisation.name}</i><br/>
                    <i>Владелец: ${message.owner.name}</i><br/>
                </div>
                <div class="card-footer text-muted container">
                    <#if isAdmin>
                        <div class="row">
                            <a class="col btn btn-primary" href="/contracts/edit?contract=${message.id}">Редактировать</a>
                        </div>

                        <div class="row">
                            <a class="col btn btn-primary" href="/contracts/delete?contract=${message.id}">Удалить</a>
                        </div>
                    </#if>
                </div>
            </div>
        <#else>
        </#list>
    </div>
</@c.page>
