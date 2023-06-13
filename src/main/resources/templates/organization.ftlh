<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>

    <#if isAdmin>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Создать организацию
        </a>
    </#if>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/organization" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.text}</#if>" name="name" placeholder="Введите название" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="address" placeholder="Введите адрес"/>
                </div>
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


    <div class="card-columns" id="message-list">
        <#list organizations as message>
            <div class="card my-3" data-id="${message.id}">
                <div class="m-2">
                    <span>Id: ${message.id}</span><br/>
                    <i>Название: ${message.name}</i><br/>
                    <i>Адрес: ${message.address}</i><br/>
                    <i>ИНН: ${message.inn}</i><br/>
                    <i>${message.createdTime.toString()}</i><br/>
                </div>
                <div class="card-footer text-muted container">
                    <#if isAdmin>
                    <div class="row">
                        <a class="col btn btn-primary" href="/organization/edit?organisation=${message.id}">Редактировать</a>
                    </div>
                    <div class="row">
                        <a class="col btn btn-primary" href="/organization/delete?organisation=${message.id}">Удалить</a>
                    </div>
                    </#if>
                </div>
            </div>
        <#else>
        </#list>
    </div>
</@c.page>
