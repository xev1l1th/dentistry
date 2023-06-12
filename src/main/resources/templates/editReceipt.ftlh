<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="card my-3" data-id="${receipt.id}">
        <div class="m-2">
            <span>${receipt.id}</span><br/>
            <i>${receipt.contractor.name}</i><br/>
            <i>${receipt.getResponsibleEmployee().getName()}</i><br/>
            <i>${receipt.getWarehouse().getName()}</i><br/>
            <i>${receipt.getOrganisation().getName()}</i><br/>
            <#list receipt.getContractorProductPrice() as price>
                <!--<a class="btn btn-primary" href="/servicedelivery/editprice?serviceDeliveryPrice=${price.id}">Edit</a> -->
                <i>${price.getProduct().getName()} cтоит  ${price.getReceivePrice()} рублей в количесве ${price.getReceiptCount()} и сумма ${price.getTotalSum()}</i><br/>
            </#list>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить поступление цену поставщиков editor
    </a>
    <div class="collapse show" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <select class="custom-select" id="productPrice" name="productPrice">
                    <#list pp as product>
                        <option value="${product.getId()}">${product.getProduct().getName()} по цене ${product.getPrice()}</option>
                    </#list>
                </select>
                <input type="number" name="count" id="count" placeholder="Количество"/>
                <input type="hidden" name="productReceipt" id="productReceipt" value="${receipt.getId()}"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>
</@c.page>