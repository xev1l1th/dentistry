<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>
    <#if isAdmin>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Создать сотрудника
    </a>
    </#if>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/employee" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.text}</#if>" name="name" placeholder="Введите ФИО" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="position" placeholder="Введите должность"/>
                </div>
                <select class="custom-select" id="gender" name="gender">
                    <#list genders as g>
                        <option value="${g}">${g.getName()}</option>
                    </#list>
                </select>
                <select class="custom-select" id="employeeType" name="employeeType">
                    <#list types as t>
                        <option value="${t}">${t.getName()}</option>
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
        <#list employees as e>
            <div class="card my-3" data-id="${e.id}">
                <div class="m-2">
                    <span>Id: ${e.id}</span><br/>
                    <i>ФИО: ${e.name}</i><br/>
                    <i>Должность: ${e.position}</i><br/>
                    <i>Пол: ${e.getGender().getName()}</i><br/>
                    <i>Тип должности: ${e.getEmployeeType().getName()}</i><br/>
                </div>
                <div class="card-footer text-muted container">
                    <#if isAdmin>
                        <div class="row">
                            <a class="col btn btn-primary" href="/employee/edit?employee=${e.id}">Редактировать</a>
                        </div>
                        <div class="row">
                            <a class="col btn btn-primary" href="/employee/delete?employee=${e.id}">Удалить</a>
                        </div>
                    </#if>
                </div>
            </div>
        <#else>
            No data
        </#list>
    </div>
</@c.page>
