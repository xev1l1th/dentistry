<#import "parts/common.ftlh" as c>
<@c.page>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Создать организацию
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.text}</#if>" name="name" placeholder="Введите название" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="address" placeholder="Введите адресс"/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="inn" placeholder="Введите инн"/>
                </div>

                <input type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>


    <div class="card-columns" id="message-list">
        <#list organizations as message>
            <div class="card my-3" data-id="${message.id}">
                <div class="m-2">
                    <span>${message.id}</span><br/>
                    <i>${message.name}</i>
                    <i>${message.address}</i>
                    <i>${message.inn}</i>
                    <i>${message.createdTime.toString()}</i>
                </div>
                <div class="card-footer text-muted container">
                    <div class="row">
                        <a class="col btn btn-primary" href="/organization/edit?organisation=${message.id}">Edit</a>
                    </div>
                </div>
            </div>
        <#else>
            No data
        </#list>
    </div>
</@c.page>
