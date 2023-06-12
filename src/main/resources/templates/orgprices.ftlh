<#import "parts/common.ftlh" as c>
<@c.page>
    <#list info as r>
        <div>
            ЦЕна продажи Report for ${r.getKey()}
        </div>
        <table>
            <thead>
            <tr>
                <th colspan="2">ТОВАР/ЦЕНА</th>
            </tr>

            </thead>
            <tbody>
            <#list r.getValue() as s>
                    <tr>
                        <td>${s.getName()}</td>
                        <td>${s.getPrice()}</td>
                    </tr>
                <tr>
                </tr>
            </#list>
            </tbody>
        </table>
    </#list>
    <br/>

</@c.page>