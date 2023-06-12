<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="card my-3" data-id="${sd.id}">
        <div class="m-2">
            <span>${sd.id}</span><br/>
            <i>${sd.contractor.name}</i><br/>
            <i>${sd.getResponsibleEmployee().getName()}</i><br/>
            <#list sdpPrices as price>
                <a class="btn btn-primary" href="/servicedelivery/editprice?serviceDeliveryPrice=${price.id}">Edit</a>
                <i>${price.getProduct().getName()} cтоит  ${price.getPrice()} рублей</i><br/>
               </#list>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить товаро цену поставщиков editor
    </a>
    <div class="collapse show" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <select class="custom-select" id="service" name="service">
                    <#list services as product>
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