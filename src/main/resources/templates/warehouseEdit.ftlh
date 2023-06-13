<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="card my-3" data-id="${warehouse.id}">
        <div class="m-2">
            <span>Id: ${warehouse.id}</span><br/>
            <i>Название: ${warehouse.name}</i><br/>
            <i>Имя ответственного: ${warehouse.getResponsibleEmployee().getName()}</i><br/>
            <i>Тип документа: ${warehouse.getDocumentType().getName()}</i><br/>
        </div>
        <div class="card-footer text-muted container">
            <div class="row">
                <a class="col btn btn-primary" href="/warehouse/edit?warehouse=${warehouse.id}">Edit</a>
            </div>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Редактирование
    </a>
    <div class="collapse show" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.text}</#if>" name="name" placeholder="Введите название" />
                </div>
                <select class="custom-select" id="employee" name="employee">
                    <#list employee as e>
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
</@c.page>