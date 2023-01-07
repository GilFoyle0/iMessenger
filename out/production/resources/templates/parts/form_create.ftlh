<#macro form_create>
    <div id="create-form" hidden style="display: flex; flex-direction: column; align-items: center; justify-content: center; width: 250px; height: 200px; background-color: white; border: 1px solid black; border-radius: 10px;">
        <form action="/rooms" method="post">
        <div class="form-outline mb-4">
            <label style="margin-left: 5px" class="form-label">Enter room name:</label>
            <input type="text" name="nameRoom" class="form-control" />
        </div>
        <button type="submit" class="btn btn-primary btn-block mb-4">Create a room</button>
        </form>
    </div>
</#macro>