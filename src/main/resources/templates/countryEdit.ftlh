<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="card my-3" data-id="${country.id}">
        <div class="m-2">
            <span>Id: ${country.id}</span><br/>
            <i>Страна: ${country.name}</i>
        </div>
        <div class="card-footer text-muted container">
            <div class="row">
                <a class="col btn btn-primary" href="/country/edit?country=${country.id}">Редактирование</a>
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
                <input type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>
</@c.page>