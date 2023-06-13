<#import "parts/common.ftlh" as c>
<@c.page>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
       Service Price editor for ${sdp.getId()}
    </a>
    <div class="collapse show" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <input type="hidden" name="productPrice" value="${sdp.getId()}">
                <div class="form-group">
                    <input type="number" class="form-control" name="price" placeholder="Введите цену"/>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>
</@c.page>