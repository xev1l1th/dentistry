<#import "parts/common.ftlh" as c>
<@c.page>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Создать склад
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.text}</#if>" name="name" placeholder="Введите название" />
                </div>
                <select class="custom-select" id="employee" name="employee">
                    <#list employees as e>
                        <option value="${e.getId()}">${e.getName()}</option>
                    </#list>
                </select>
                <select class="custom-select" id="warehouseType" name="warehouseType">
                    <#list warehouseType as w>
                        <option value="${w}">${w.getName()}</option>
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
        <#list warehouses as w>
            <div class="card my-3" data-id="${w.id}">
                <div class="m-2">
                    <span>${w.id}</span><br/>
                    <i>${w.name}</i><br/>
                    <i>${w.getResponsibleEmployee().getName()}</i><br/>
                    <i>${w.getDocumentType().getName()}</i><br/>
                </div>
                <div class="card-footer text-muted container">
                    <div class="row">
                        <a class="col btn btn-primary" href="/warehouse/edit?warehouse=${w.id}">Edit</a>
                    </div>
                </div>
            </div>
        <#else>
            No data
        </#list>
    </div>
</@c.page>
