<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>
    <#if isAdmin>
        <div>
        <a class="btn btn-primary" href="/servicedelivery/create" role="button" aria-expanded="false" aria-controls="collapseExample">Cоздать оказание услуги</a>
        </div>
    </#if>

    <div class="card-columns" id="message-list">
        <#list all as message>
            <div class="card my-3" data-id="${message.id}">
                <div class="m-2">
                    <span>Id: ${message.id}</span><br/>
                    <i>Контрагент: ${message.contractor.name}</i>
                    <i>Сотрудник: ${message.getResponsibleEmployee().getName()}</i>
                    <i>Организация: ${message.getOrganisation().getName()}</i>
                </div>
                <#if isAdmin>
                <div class="card-footer text-muted container">
                    <div class="row">
                        <a class="col btn btn-primary" href="/servicedelivery/edit?serviceDelivery=${message.id}">Редактировать</a>
                    </div>
                </div>
                <div class="card-footer text-muted container">
                    <div class="row">
                        <a class="col btn btn-primary" href="/servicedelivery/delete?serviceDelivery=${message.id}">Удалить</a>
                    </div>
                </div>
                </#if>
            </div>
        <#else>
        </#list>
    </div>
</@c.page>
