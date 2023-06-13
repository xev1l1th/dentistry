<#import "parts/common.ftlh" as c>
<#include "parts/secur.ftlh">
<@c.page>

    <#if isAdmin>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Ввод цен поставщиков
    </a>
    </#if>
    <div class="collapse show" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/contrproductprices/create" enctype="multipart/form-data">
                <select class="custom-select" id="contractor" name="contractor">
                    <#list contractors as con>
                        <option value="${con.getId()}">${con.getName()}</option>
                    </#list>
                </select>
                <select class="custom-select" id="employee" name="employee">
                    <#list employees as emp>
                        <option value="${emp.getId()}">${emp.getName()}</option>
                    </#list>
                </select>
                <select class="custom-select" id="product" name="product">
                    <#list products as product>
                        <option value="${product.getId()}">${product.getName()}</option>
                    </#list>
                </select>
                <input type="number" name="price" id="price" placeholder="ЦЕНА"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>
</@c.page>