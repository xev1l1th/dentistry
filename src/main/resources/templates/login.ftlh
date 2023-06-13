<#import "parts/common.ftlh" as c>
<@c.page>
    <form action="/login" method="post">
        <div class="form-group">
            <label class="col-sm-2 col-form-label"> User Name : </label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="User Name" />
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 col-form-label"> Password : </label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="Password" />
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-20">
                <button class="btn btn-primary" type="submit">Войти</button>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-20">
                <a class="btn btn-primary" href="/registration">Зарегестрироваться</a>
            </div>
        </div>
    </form>
</@c.page>