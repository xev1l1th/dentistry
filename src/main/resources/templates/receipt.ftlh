<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>

<div class="collapse show" id="collapseExample">
    <div class="form-group mt-3">
        <#if isAdmin>
        <#list times as t>
            <a class="col btn btn-primary" href="/receipt/create?time=${t}">Cоздать поступление товара на основе даты ${t}</a>
        </#list>
        </#if>
    </div>
</div>

    <div class="card-columns" id="message-list">
        <#list all as message>
            <div class="card my-3" data-id="${message.id}">
                <div class="m-2">
                    <span>Id: ${message.id}</span><br/>
                    <i>Название: ${message.contractor.name}</i><br/>
                    <i>Ответственное лицо: ${message.getResponsibleEmployee().getName()}</i><br/>
                    <i>Склад: ${message.getWarehouse().getName()}</i><br/>
                    <i>Контрагент: ${message.getContractor().getName()}</i><br/>
                    <i>Организация: ${message.getOrganisation().getName()}</i><br>
                </div>
                <div class="card-footer text-muted container">
                    <#if isAdmin>
                        <div class="row">
                            <a class="col btn btn-primary" href="/receipt/edit?productReceipt=${message.id}">Открыть</a>
                        </div>
                        <div class="row">
                            <a class="col btn btn-primary" href="/receipt/delete?productReceipt=${message.id}">Удалить</a>
                        </div>
                    </#if>
                </div>
            </div>
        <#else>
        </#list>
    </div>
</@c.page>
