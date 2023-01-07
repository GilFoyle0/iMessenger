
<#import "parts/input_page.ftlh" as c>


<@c.input_page>
    <div style="display: flex; flex-direction: column; align-items: center; justify-content: center; width: 300px; height: 425px; background-color: white">

        <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
            <li class="nav-item" role="presentation">
                <a class="nav-link" id="tab-login" data-mdb-toggle="pill" href="/login" role="tab"
                   aria-controls="pills-register" aria-selected="false">Login</a>
            </li>
            <li class="nav-item" role="presentation">
                <a class="nav-link active" id="tab-register" data-mdb-toggle="pill" href="/registration" role="tab"
                   aria-controls="pills-login" aria-selected="true">Register</a>
            </li>
        </ul>

        <div class="tab-content">
            <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
                <form action="/registration" method="post">
                    <div class="text-center mb-3">
                        <p style="font-size: 30px">Registration</p>
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Username</label>
                        <input type="text" name="username" class="form-control" />
                        <label class="form-label">Password</label>
                        <input type="password" name="password" class="form-control" />
                    </div>
                    <button type="submit" class="btn btn-primary btn-block mb-4">
                        Register</button>
                    <div class="text-center">
                        <p>Have an account? <a href="/login">Log in!</a></p>
                    </div>
                </form>
            </div>
    </div>


</@c.input_page>





