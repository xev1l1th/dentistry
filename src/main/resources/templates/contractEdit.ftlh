<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="card my-3" data-id="${contract.id}">
        <div class="m-2">
            <span>${contract.id}</span><br/>
            <i>${contract.name}</i><br/>
            <i>${contract.description}</i><br/>
            <i>${contract.organisation.name}</i><br/>
            <i>${contract.owner.name}</i><br/>
        </div>
        <div class="card-footer text-muted container">
            <div class="row">
                <a class="col btn btn-primary" href="/contracts/edit?contract=${contract.id}">Edit</a>
            </div>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Country editor
    </a>
    <div class="collapse show" id="collapseExample">
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
                <div class="form-group">
                    <input type="text" class="form-control" name="inn" placeholder="Введите inn"/>
                </div>
                <input type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>
</@c.page>