<#import "parts/common.ftlh" as c>
<@c.page>
    <#list report as r>
        <div>
            Report for ${r.getKey()}
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
                    инфа по складу ${s.getWarehouse()}
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
                    Тотал продуктов ${s.getTotal()}
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    </#list>
    <br/>

</@c.page>