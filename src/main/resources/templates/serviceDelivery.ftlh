<#import "parts/common.ftlh" as c>
<@c.page>
    <div>
    <a class="btn btn-primary" href="/servicedelivery/create" role="button" aria-expanded="false" aria-controls="collapseExample">Cоздать ввод цен на услуги</a>
    </div>

    <div class="card-columns" id="message-list">
        <#list all as message>
            <div class="card my-3" data-id="${message.id}">
                <div class="m-2">
                    <span>${message.id}</span><br/>
                    <i>${message.contractor.name}</i>
                    <i>${message.getResponsibleEmployee().getName()}</i>
                    <i>${message.getOrganisation().getName()}</i>
                </div>
                <div class="card-footer text-muted container">
                    <div class="row">
                        <a class="col btn btn-primary" href="/servicedelivery/edit?serviceDelivery=${message.id}">Edit</a>
                    </div>
                </div>
            </div>
        <#else>
            No data
        </#list>
    </div>
</@c.page>
