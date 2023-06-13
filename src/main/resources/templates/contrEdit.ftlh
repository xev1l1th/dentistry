<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="card my-3" data-id="${cpp.id}">
        <div class="m-2">
            <span>Id: ${cpp.id}</span><br/>
            <i>Наименование контрагента: ${cpp.contractor.name}</i><br/>
            <i>Ответственное лицо: ${cpp.getResponsibleEmployee().getName()}</i><br/>
            <i>Дата: ${cpp.getCreatedDate().toString()}</i><br/>
            <#list cppPrices as price>
                <i>${price.getProduct().getName()} cтоит ${price.getPrice()} рублей</i><br/>
                <a class="col btn btn-primary" href="/contrproductprices/editprice?price=${price.id}">Редактировать</a>
            </#list>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить товаро цену поставщиков editor
    </a>
    <div class="collapse show" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
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