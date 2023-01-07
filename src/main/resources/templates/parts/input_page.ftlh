<#import "base.ftlh" as c>

<#macro input_page>
    <@c.base>

        <div style="top: 50%; left: 50%; position: absolute; transform: translate(-50%, -50%)">
            <h1 style="color: white; margin-left: 30px; margin-right: 30px;">iMessenger</h1>
            <#nested>
        </div>
    </@c.base>
</#macro>