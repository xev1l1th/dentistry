<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">

<@c.page>
    <#if isAdmin>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Создать график работы
        </a>
    </#if>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/workschedule" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.text}</#if>" name="name" placeholder="Введите название" />
                </div>
                <input type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить график</button>
                </div>
            </form>
        </div>
    </div>


    <div class="card-columns" id="message-list">
        <#list schedules as message>
            <div class="card my-3" data-id="${message.id}">
                <div class="m-2">
                    <span>${message.id}</span><br/>
                    <i>${message.name}</i>
                </div>
                <#if isAdmin>
                <div class="card-footer text-muted container">
                    <div class="row">
                        <a class="col btn btn-primary" href="/workschedule/edit?workSchedule=${message.id}">Редактировать</a>
                    </div>
                </div>

                <div class="card-footer text-muted container">
                    <div class="row">
                        <a class="col btn btn-primary" href="/workschedule/delete?workSchedule=${message.id}">Удалить</a>
                    </div>
                </div>
                </#if>
            </div>
        <#else>
        </#list>
    </div>



</@c.page>
