<#import "base.ftlh" as c>

<#macro common>
    <@c.base>
        <#include "navbar.ftlh">
        <div class="w-full h-full">
            <#nested>
        </div>
    </@c.base>
</#macro>