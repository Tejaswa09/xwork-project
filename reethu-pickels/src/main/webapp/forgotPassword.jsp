<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page  isELIgnored="false" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/forgotPassword.css">
    <script src="js/forgotPassword.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

</head>

<body data-is-otp-valid="${isOtpValid}" data-mailsendstatus="${mailSendStatus}">
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
    <div class="toast-container position-fixed  start-50 translate-middle p-3" style="top: 15%">

              <div id="otpSuccessToast" class="toast bg-info text-dark" role="alert" aria-live="assertive" aria-atomic="true" data-bs-autohide="true" data-bs-delay="2000">
                <div class="toast-header">
                  <strong class="me-auto">Success!</strong>
                </div>
                <div class="toast-body">
                  An OTP has been successfully sent to ${emailForForgotPass}.
                </div>
              </div>

    </div>
    <div id="divForforPassword" class="divForforPassword">
        <h4 style="margin-left:90px ;">Forgot Password</h4>
        <div>
            <form action="sendOtp" method="post" class="">
            <div><input type="email" class="form-control" placeholder="Enter Registered Email" aria-label="email" name="email" id="email" value="${emailForForgotPass}"
                    style="margin-top: 10px;" />
                <div id="emailMessage" class="invalid-feedback"></div>
            </div>

            <div style="margin-top: 10px;">
                <button type="submit" class="btn btn-primary center" id="sendOtpButton">send-otp</button>
            </div>
        </form>
        </div>

<form action="validateOtp">
<div class="row justify-content-left mt-3" id="divForOtp">
            <div class="col">
                <div class="card p-4 text-center">
                    <h5 class="mb-4">Enter OTP</h5>
                    <div id="otp" class="d-flex justify-content-center gap-2" >
                        <input class="form-control text-center otp-input" type="text" maxlength="1" required disabled/>
                        <input class="form-control text-center otp-input" type="text" maxlength="1" required disabled/>
                        <input class="form-control text-center otp-input" type="text" maxlength="1" required disabled/>
                        <input class="form-control text-center otp-input" type="text" maxlength="1" required disabled/>
                        <input class="form-control text-center otp-input" type="text" maxlength="1" required disabled/>
                        <input class="form-control text-center otp-input" type="text" maxlength="1" required disabled/>

                        <input type="email" name="email" value="${emailForForgotPass}" hidden/>
                        <input type="text" name="otp" id="otphiddenValue" hidden/>
                    </div>
                    <div id="messageForOtp" class="invalid-feedback d-block">${messageForValidationOtp}</div>
                    <button type="submit" class="btn btn-primary mt-4" >Verify OTP</button>
                </div>
            </div>

        </div>
      </div>
</form>





    </div>
    <!-- Forgot Password Form -->
    <footer class="bg-dark text-white py-2 fixed-bottom" id="footer">
        <div class="inline center">
            <span class="mb-0">&copy; 2025 Reethu Pickles. All Rights Reserved.</span>
        </div>
        <div class="inline end"><span id="DateAndTime"></span></div>
    </footer>
    <script>
        let mailSendStatus = "${mailSendStatus}";
        let isValid ="${isOtpValid}";
        let toastMsg ="${toastMsg}";
    </script>
</body>

</html>