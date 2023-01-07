<#macro form_find>
<div id="find-form" hidden style="display: flex; flex-direction: column; align-items: center; justify-content: center; width: 250px; height: 200px; background-color: white; border: 1px solid black; border-radius: 10px;">
  <form>
    <div class="form-outline mb-4">
      <label style="margin-left: 5px" class="form-label">Enter room id:</label>
      <input id="find-input" type="text" name="roomId" class="form-control" />
    </div>
    <button type="button" onclick="findRoom()" class="btn btn-primary btn-block mb-4">Find a room</button>
  </form>
  <script>
    function findRoom() {
      let value = document.getElementById("find-input").value;
      location.assign("/rooms/"+value+"/find");
    }
  </script>
</div>
</#macro>