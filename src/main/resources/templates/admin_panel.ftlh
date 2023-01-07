<#import "parts/common.ftlh" as c>
<#import "parts/form_create.ftlh" as f>
<#import "parts/form_find.ftlh" as fr>


<@c.common>
    <div style="display: flex; align-items: center; justify-content: center; margin: 2vh auto; width: 80%; height: 80%; background-color: #82C3FFCC; border: solid 2px #0895a2; border-radius: 10px;">
    <#if rooms??>
        <div id="chat" style="display: flex; flex-direction: column; align-items: center; justify-content: start; width: 100%; height: 100%; border-radius: 10px; background-color: #82C3FFCC; overflow-y: auto">
                <#list rooms as room>
                    <div style="display: flex; justify-content: flex-start; align-items: center; width: 100%; margin-top: 2px; border-radius: 12px">
                        <button type="button"
                                class="btn btn-danger"
                                onclick="location.assign('/admin/${room.getId()}/');">
                            X
                        </button>
                        <button type="button"
                                class="btn btn-dark"
                                onclick="location.assign('/rooms/${room.getId()}');"
                                style="width: 100%">
                            ${room.getName()}
                        </button>
                    </div>
                </#list>
        </div>
            <@f.form_create/>
            <@fr.form_find/>
        <#else>
        <div style="display: flex; flex-direction: column; align-items: center; justify-content: center; width: 100%; height: 100%; border: solid 2px #0895a2; border-radius: 10px; background-color: #82C3FFCC">
            <div style="color: black">ROOM NOT FOUND</div>
            <@f.form_create/>
            <@fr.form_find/>
        </div>

    </#if>
    </div>
</@c.common>

