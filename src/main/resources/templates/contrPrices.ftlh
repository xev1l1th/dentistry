<#import "parts/common.ftlh" as c>
<@c.page>
    <a class="col btn btn-primary" href="/contrproductprices/create">Cоздать ввод цен поставщиков</a>


    <div class="card-columns" id="message-list">
        <#list cpp as message>
            <div class="card my-3" data-id="${message.id}">
                <div class="m-2">
                    <span>${message.id}</span><br/>
                    <i>${message.contractor.name}</i>
                    <i>${message.getResponsibleEmployee().getName()}</i>
                    <i>${message.getCreatedDate().toString()}</i>
                </div>
                <div class="card-footer text-muted container">
                    <div class="row">
                        <a class="col btn btn-primary" href="/contrproductprices/edit?cpp=${message.id}">Edit</a>
                    </div>
                </div>
            </div>
        <#else>
            No data
        </#list>
    </div>
</@c.page>
