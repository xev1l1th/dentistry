<#import "parts/common.ftlh" as c>
<@c.page>
    <#list report as r>
        <div>
            Отчет по ${r.getKey()}
        </div>
    <table>
        <thead>
        <tr>
            <th colspan="2">ТОВАР/КОЛВО</th>
        </tr>

        </thead>
        <tbody>
        <#list r.getValue() as s>
            <tr>
                <td>
                    Информация по складу ${s.getWarehouse()}
                </td>
            </tr>
            <#list s.getProductInfoAsSet() as info>
        <tr>
            <td>${info.getKey()}</td>
            <td>${info.getValue()}</td>
        </tr>
        </#list>
            <tr>
                <td>
                    Всего товаров ${s.getTotal()}
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    </#list>
    <br/>

</@c.page>