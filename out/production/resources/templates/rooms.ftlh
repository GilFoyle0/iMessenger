<#import "parts/common.ftlh" as c>
<#import "parts/left_part.ftlh" as l>
<#import "parts/right_part.ftlh" as r>
<#import "parts/form_create.ftlh" as f>
    <#import "parts/form_find.ftlh" as fr>
<@c.common>
    <div style="display: flex; align-items: center; justify-content: space-between; margin: 2vh auto; width: 80%; height: 80%; background-color: rgba(19,20,16,0.8); border-radius: 12px">
    <#if rooms??>
    <@l.left_part>
        <#list rooms as room>
            <div style="display: flex; justify-content: flex-start; align-items: center; width: 100%; margin-top: 2px; border-radius: 12px">
                <button type="button" class="btn btn-outline-danger" onclick="location.assign('/rooms/${room.getId()}/remove');">X</button>
                <button type="button" class="btn btn-outline-primary" onclick="location.assign('/rooms/${room.getId()}');" style="margin-right: 2px; width: 100%">${room.getName()}</button>
            </div>
        </#list>
    </@l.left_part>
        <#if currentRoom??>
            <@r.right_part>
                <@f.form_create/>
                <@fr.form_find/>
                <div id="chat-name" style="display:flex; justify-content: center; align-items: center; width:100%; height: 10%;">
                    <span style="background-color: #1e8686; height: 100%; border-radius: 0 0 10px 10px; color: white; font-size: 18px; padding-left: 10px; padding-right: 10px">${currentRoom.getName()}<span style="color: #000000; margin-left: 10px">id:${currentRoom.getId()}</span></span>
                </div>
                <div id="chat" style="display: flex; flex-direction: column-reverse; width:100%;height:90%; resize: none; overflow-y: auto; overflow-x: hidden">
                    <#if messages??>
                        <div class="allMessageInRoom">
                            <#list messages as message>
                                <div class="messageInRoom">
                                 <span class="messageInRoomUsername">
                                     ${message.user.getUsername()} <span style="color: rgba(27,29,25,0.8); font-size: small; text-align: right; top: 0; right: 0; margin-left: 5px;">${message.getDate()}</span>
                                       </span>
                                        <p class="messageInRoomText">
                                        ${message.getMessage()}
                                       </p>
                                </div>
                            </#list>
                        </div>
                    </#if>
                </div>
                <div id="chat_input" style="width: 100%; height: max-content; border-top: 2px solid #1E8686FF">
                    <form id="form" action="/rooms/${currentRoom.getId()}" method="post" style="display: flex; align-items: center; flex-direction: row; justify-content: space-between; height: 100%;">
                    <textarea
                            id="textId"
                            onkeyup="textAreaAdjust(this)"
                            class="form-control
                            px-3 py-1.5 text-base font-normal text-gray-700
                            bg-white bg-clip-padding
                            transition ease-in-out
                            focus:text-black focus:bg-white focus:black focus:outline-none"
                            placeholder="Write a message..."
                            name="message"
                            style="margin-left:5px; height: 60px; max-height: 150px; width: 80%; resize: none; overflow-y: auto; overflow-x: hidden; word-wrap: break-word"
                    ></textarea>
                        <button type="submit" class="btn btn-primary" style="margin-left: 10px; margin-right: 30px; padding: -5px">Send</button>
                    </form>
                </div>
            </@r.right_part>
            <#else>
                <@r.right_part>
                    <div>ROOM NOT FOUND</div>
                    <@f.form_create/>
                    <@fr.form_find/>
                </@r.right_part>
        </#if>
    <#else>
        <@l.left_part>
            <p style="margin:auto; color: white">
                ROOM NOT FOUND
            </p>
        </@l.left_part>
        <@r.right_part>
            <p>
                CREATE OR FIND A ROOM
            </p>
            <@f.form_create/>
            <@fr.form_find/>
        </@r.right_part>
    </#if>
        <script>
            function textAreaAdjust(element) {
                element.style.height = "1px";
                element.style.height = (25+element.scrollHeight)+"px";
            }
        </script>


    </div>

</@c.common>