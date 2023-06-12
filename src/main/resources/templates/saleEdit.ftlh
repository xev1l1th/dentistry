<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="card my-3" data-id="${spp.id}">
        <div class="m-2">
            <span>${spp.id}</span><br/>
            <i>${spp.contractor.name}</i><br/>
            <i>${spp.getResponsibleEmployee().getName()}</i><br/>
            <i>${spp.getCreatedDate().toString()}</i><br/>
            <#list spp.getProductPrices() as price>
                <i>${price.getProduct().getName()} продается за ${price.getPrice()} рублей</i><br/>
                <a class="col btn btn-primary" href="/saleprices/editprice?price=${price.id}">Edit</a>
            </#list>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить  цену на продажу editor
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