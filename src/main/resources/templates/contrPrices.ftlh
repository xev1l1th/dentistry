<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>

    <#if isAdmin>
     <a class="col btn btn-primary" href="/contrproductprices/create">Cоздать ввод цен поставщиков</a>
    </#if>

    <div class="card-columns" id="message-list">
        <#list cpp as message>
            <div class="card my-3" data-id="${message.id}">
                <div class="m-2">
                    <span>${message.id}</span><br/>
                    <i>Наименование контрагента: ${message.contractor.name}</i><br/>
                    <i>Ответственное лицо: ${message.getResponsibleEmployee().getName()}</i><br/>
                    <i>Дата: ${message.getCreatedDate().toString()}</i>
                </div>
                <div class="card-footer text-muted container">
                    <#if isAdmin>
                        <div class="row">
                            <a class="col btn btn-primary" href="/contrproductprices/edit?cpp=${message.id}">Редактировать</a>
                        </div>
                        <div class="row">
                            <a class="col btn btn-primary" href="/contrproductprices/delete?cpp=${message.id}">Удалить</a>
                        </div>
                    </#if>
                </div>
            </div>
        <#else>
            No data
        </#list>
    </div>
</@c.page>
