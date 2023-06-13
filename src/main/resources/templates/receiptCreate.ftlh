<#import "parts/common.ftlh" as c>
<@c.page>

    <div>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Поступление товаров на основе цен на товары по дате ${date}
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
                <label for="contractor">ПРОДУКТ</label>
                <select class="custom-select" id="productPrice" name="productPrice">
                    <#list pp as product>
                        <option value="${product.getId()}">${product.getProduct().getName()} по цене ${product.getPrice()}</option>
                    </#list>
                </select>
                <label for="contractor">СКЛАД</label>
                <select class="custom-select" id="warehouse" name="warehouse">
                    <#list warehouses as warehouse>
                        <option value="${warehouse.getId()}">${warehouse.getName()}</option>
                    </#list>
                </select>
                </br>
                <label for="contractor">Количество</label>
                <input type="number" name="count" id="ocunt" placeholder="Кол-во"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>
</@c.page>