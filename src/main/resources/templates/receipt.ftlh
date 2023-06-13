<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>

<div class="collapse show" id="collapseExample">
    <div class="form-group mt-3">
        <#if isAdmin>
        <#list times as t>
            <a class="col btn btn-primary" href="/receipt/create?time=${t}">Cоздать ввод цен на основе даты ${t}</a>
        </#list>
        </#if>
    </div>
</div>

    <div class="card-columns" id="message-list">
        <#list all as message>
            <div class="card my-3" data-id="${message.id}">
                <div class="m-2">
                    <span>${message.id}</span><br/>
                    <i>${message.contractor.name}</i><br/>
                    <i>${message.getResponsibleEmployee().getName()}</i><br/>
                    <i>${message.getWarehouse().getName()}</i><br/>
                    <i>${message.getContractor().getName()}</i><br/>
                    <i>${message.getOrganisation().getName()}</i><br>
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
            No data
        </#list>
    </div>
</@c.page>
