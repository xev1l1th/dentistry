<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">

<@c.page>
    <#if isAdmin>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Создать склад
        </a>
    </#if>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/warehouse" enctype="multipart/form-data">
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
                    <span>Id: ${w.id}</span><br/>
                    <i>Название: ${w.name}</i><br/>
                    <i>Имя ответственного: ${w.getResponsibleEmployee().getName()}</i><br/>
                    <i>Тип документа: ${w.getDocumentType().getName()}</i><br/>
                </div>
                <#if isAdmin>
                <div class="card-footer text-muted container">
                    <div class="row">
                        <a class="col btn btn-primary" href="/warehouse/edit?warehouse=${w.id}">Редактировать</a>
                    </div>
                </div>

                <div class="card-footer text-muted container">
                    <div class="row">
                        <a class="col btn btn-primary" href="/warehouse/delete?warehouse=${w.id}">Удалить</a>
                    </div>
                </div>
                </#if>
            </div>
        <#else>
        </#list>
    </div>
</@c.page>
