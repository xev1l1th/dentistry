<#import "parts/common.ftlh" as c>
<#include "parts/common.ftlh">
<@c.page>

    <#if isAdmin>
     <a class="col btn btn-primary" href="/saleprices/create">Cоздать цену на продажу</a>
    </#if>
    <div class="card-columns" id="message-list">
        <#list spp as message>
            <div class="card my-3" data-id="${message.id}">
                <div class="m-2">
                    <span>${message.id}</span><br/>
                    <i>${message.contractor.name}</i>
                    <i>${message.getResponsibleEmployee().getName()}</i>
                    <i>${message.getCreatedDate().toString()}</i>
                </div>
                <div class="card-footer text-muted container">
                    <#if isAdmin>
                        <div class="row">
                            <a class="col btn btn-primary" href="/saleprices/edit?spp=${message.id}">Редактировать</a>
                        </div>
                        <div class="row">
                            <a class="col btn btn-primary" href="/saleprices/delete?spp=${message.id}">Удалить</a>
                        </div>
                    </#if>
                </div>
            </div>
        <#else>
        </#list>
    </div>
</@c.page>
