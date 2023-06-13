<#import "parts/common.ftlh" as c>
<@c.page>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        ВВОд цен на продажу создать
    </a>
    <div class="collapse show" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <label for="contractor">Выберите контрагента:</label>
                <select class="custom-select" id="contractor" name="contractor">
                    <#list contractors as con>
                        <option value="${con.getId()}">${con.getName()}</option>
                    </#list>
                </select>
                <label for="employee">Выберите ответственного:</label>
                <select class="custom-select" id="employee" name="employee">
                    <#list employees as emp>
                        <option value="${emp.getId()}">${emp.getName()}</option>
                    </#list>
                </select>
                <label for="product">Выберите продукт:</label>
                <select class="custom-select" id="product" name="product">
                    <#list products as product>
                        <option value="${product.getId()}">${product.getName()}</option>
                    </#list>
                </select>
                <label for="price">Выберите цену:</label>
                <input type="number" name="price" id="price" placeholder="ЦЕНА"/>
                <label for="date">Выберите дату:</label>
                <input type="date" id="date" name="date">
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>
</@c.page>