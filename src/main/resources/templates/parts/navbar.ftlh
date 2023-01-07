<nav class="navbar bg-body-tertiary">
    <div class="container-fluid" style="display: flex; justify-content: start; align-items: center; flex-wrap: wrap">
        <a class="navbar-brand" href="/rooms">
            <span>iMessenger</span>
        </a>
        <div>
            <button id="create-open" onclick="openForm()" class="btn btn-primary">Create a room</button>
        </div>
        <div style="margin-left: 10px">
            <button id="find-open" onclick="openFindForm()" class="btn btn-primary">Find a room</button>
        </div>
        <#if admin??>
            <div class="admin-btn" style="margin-left: 10px">
                <button class="btn btn-primary" onclick="location.assign('/admin');">Admin Panel</button>
            </div>
        </#if>
        <form class="form-logout" action="/logout" method="post">
            <button type="submit" class="btn btn-outline-dark">Exit</button>
        </form>
    </div>
    <script>
        function openForm() {
            if(document.getElementById("create-form").hidden) {
                document.getElementById("create-open").textContent = "Сlose";
                document.getElementById("create-form").hidden = false;
                document.getElementById("create-open").style.backgroundColor = "#AD0303FF";
                if (document.getElementById("chat"))
                {
                    document.getElementById("chat").hidden = true;
                }
                if (document.getElementById("chat-name")) {
                    document.getElementById("chat-name").hidden = true;
                }
                if (document.getElementById("chat_input")) {
                    document.getElementById("chat_input").hidden = true;
                }
                document.getElementById("find-form").hidden = true;
                document.getElementById("find-open").textContent = "Find a room";
                document.getElementById("find-open").style.backgroundColor = '';
            } else {
                document.getElementById("create-open").textContent = "Create a room";
                document.getElementById("create-open").style.backgroundColor = '';
                document.getElementById("create-form").hidden = true;
                if (document.getElementById("chat"))
                {
                    document.getElementById("chat").hidden = false;
                }
                if (document.getElementById("chat-name")) {
                    document.getElementById("chat-name").hidden = false;
                }
                if (document.getElementById("chat_input")) {
                    document.getElementById("chat_input").hidden = false;
                }
            }
        }
        function openFindForm() {
            if(document.getElementById("find-form").hidden) {
                document.getElementById("find-open").textContent = "Сlose";
                document.getElementById("find-form").hidden = false;
                document.getElementById("find-open").style.backgroundColor = "#AD0303FF";
                if (document.getElementById("chat"))
                {
                    document.getElementById("chat").hidden = true;
                }
                if (document.getElementById("chat-name")) {
                    document.getElementById("chat-name").hidden = true;
                }
                if (document.getElementById("chat_input")) {
                    document.getElementById("chat_input").hidden = true;
                }
                document.getElementById("create-form").hidden = true;
                document.getElementById("create-open").textContent = "Create a room";
                document.getElementById("create-open").style.backgroundColor = '';
            } else {
                document.getElementById("find-open").textContent = "Find a room";
                document.getElementById("find-open").style.backgroundColor = '';
                document.getElementById("find-form").hidden = true;
                if (document.getElementById("chat"))
                {
                    document.getElementById("chat").hidden = false;
                }
                if (document.getElementById("chat-name")) {
                    document.getElementById("chat-name").hidden = false;
                }
                if (document.getElementById("chat_input")) {
                    document.getElementById("chat_input").hidden = false;
                }
            }
        }
    </script>
</nav>



