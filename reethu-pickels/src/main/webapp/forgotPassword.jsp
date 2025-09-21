<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/forgotPassword.css">
    <script src="js/forgotPassword.js"></script>
</head>

<body>
    <!--NavBar-->
        <nav class="navbar fixed-top">
            <div class="container-fluid d-flex align-items-center" id="divForNav">
                <a class="navbar-brand" href="https://x-workz.in/" id="xworkz-logo">
                    <img src="Assets/xworkzlogo.png" alt="xworkz-logo" width="100px" height="50px">
                </a>
                <a class="navbar-brand mx-auto" href="#">
                    <img src="Assets/reetho-logo-cropped.png" alt="center-logo" width="60px" height="50px"
                        style="margin-left: -100px;">
                </a>
               <a href="toLogin"> <button type="button" class="btn btn-outline-warning">Login</button></a>
               <a href="toSignUp" id="signUp" style="margin-left:10px ;margin-right: 20px;">Sign Up</a>
            </div>
        </nav>

    <div id="divForforPassword" class="divForforPassword">
        <h4 style="margin-left:90px ;">Forgot Password</h4>
        <div>
            <form action="otpSend" method="post" class="">
            <div><input type="email" class="form-control" placeholder="Enter Registered Email" aria-label="email" name="email" id="email"
                    style="margin-top: 10px;" />
                <div id="emailMessage" class="invalid-feedback"></div>
            </div>

            <div style="margin-top: 10px;">
                <button type="submit" class="btn btn-primary center">send-otp</button>
            </div>
        </form>
        </div>




        <div class="row justify-content-left mt-3">
            <div class="col">
                <div class="card p-4 text-center">
                    <h5 class="mb-4">Enter OTP</h5>
                    <div id="otp" class="d-flex justify-content-center gap-2" >
                        <input class="form-control text-center otp-input" type="text" maxlength="1" disabled/>
                        <input class="form-control text-center otp-input" type="text" maxlength="1" disabled/>
                        <input class="form-control text-center otp-input" type="text" maxlength="1" disabled/>
                        <input class="form-control text-center otp-input" type="text" maxlength="1" disabled/>
                        <input class="form-control text-center otp-input" type="text" maxlength="1" disabled/>
                        <input class="form-control text-center otp-input" type="text" maxlength="1" disabled/>
                    </div>
                    <button class="btn btn-primary mt-4" onclick="getOtpButton()">Verify OTP</button>
                </div>
            </div>
        </div>
    </div>


    </div>
    <!-- Forgot Password Form -->
    <footer class="bg-dark text-white py-2 fixed-bottom" id="footer">
        <div class="inline center">
            <span class="mb-0">&copy; 2025 Reethu Pickles. All Rights Reserved.</span>
        </div>
        <div class="inline end"><span id="DateAndTime"></span></div>
    </footer>
</body>

</html>