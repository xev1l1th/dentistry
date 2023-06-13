<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="card my-3" data-id="${organization.id}">
        <div class="m-2">
            <span>Id: ${organization.id}</span><br/>
            <i>Название: ${organization.name}</i>
            <i>Адрес: ${organization.address}</i>
            <i>ИНН ${organization.inn}</i>
        </div>
        <div class="card-footer text-muted container">
            <div class="row">
                <a class="col btn btn-primary" href="/organization/edit?organisation=${organization.id}">Редактирование</a>
            </div>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Свернуть
    </a>
    <div class="collapse show" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.text}</#if>" name="name" placeholder="Введите название" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="address" placeholder="Введите адрес"/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="inn" placeholder="Введите ИНН"/>
                </div>
                <input type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>
</@c.page>