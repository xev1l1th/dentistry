<#import "parts/common.ftlh" as c>
<@c.page>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Создать договор
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.text}</#if>" name="name" placeholder="Введите название" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="description" placeholder="Введите description"/>
                </div>
                <select class="custom-select" id="contractor" name="contractor">
                    <#list contractors as con>
                        <option value="${con.getId()}">${con.getName()}</option>
                    </#list>
                </select>
                <select class="custom-select" id="organisation" name="organisation">
                    <#list organizations as org>
                        <option value="${org.getId()}">${org.getName()}</option>
                    </#list>
                </select>
                    <input type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Сохранить</button>
                    </div>
            </form>
        </div>
    </div>


    <div class="card-columns" id="message-list">
        <#list contracts as message>
            <div class="card my-3" data-id="${message.id}">
                <div class="m-2">
                    <span>${message.id}</span><br/>
                    <i>${message.name}</i><br/>
                    <i>${message.description}</i><br/>
                    <i>${message.organisation.name}</i><br/>
                    <i>${message.owner.name}</i><br/>
                </div>
                <div class="card-footer text-muted container">
                    <div class="row">
                        <a class="col btn btn-primary" href="/contracts/edit?contract=${message.id}">Edit</a>
                    </div>
                </div>
            </div>
        <#else>
            No data
        </#list>
    </div>
</@c.page>
