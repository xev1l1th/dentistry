<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>

    <div>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Оказание услуги
    </a>
    </div>
    <div class="collapse show" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <label for="contractor">КОНТРАГЕНТ</label>
                <select class="custom-select" id="contractor" name="contractor">
                    <#list contractors as con>
                        <option value="${con.getId()}">${con.getName()}</option>
                    </#list>
                </select>
                </br>
                <label for="contractor">СОТРУДНИК</label>
                <select class="custom-select" id="employee" name="employee">
                    <#list employees as emp>
                        <option value="${emp.getId()}">${emp.getName()}</option>
                    </#list>
                </select>
                </br>
                <label for="contractor">ОРГАНИЗАЦИЯ</label>
                <select class="custom-select" id="organisation" name="organisation">
                    <#list orgs as org>
                        <option value="${org.getId()}">${org.getName()}</option>
                    </#list>
                </select>
                </br>
                <label for="contractor">УСЛУГА</label>
                <select class="custom-select" id="service" name="service">
                    <#list services as product>
                        <option value="${product.getId()}">${product.getName()}</option>
                    </#list>
                </select>
                </br>
                <label for="contractor">ЦЕНА</label>
                <input type="number" name="price" id="price" placeholder="ЦЕНА"/>
                <#if isAdmin>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
                </#if>
            </form>
        </div>
    </div>
</@c.page>