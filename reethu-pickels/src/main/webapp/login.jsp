<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page  isELIgnored="false" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css">
    <link rel="icon" type="image/png" href="Assets/logo.png">
    <script src="js/login.js"></script>
    <link rel="stylesheet" href="css/login.css">

    <!-- axios -->
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

</head>

<body>
    <nav class="navbar fixed-top">
        <div class="container-fluid d-flex align-items-center" id="divForNav">
            <a class="navbar-brand" href="https://x-workz.in/" id="xworkz-logo">
                <img src="Assets/xworkzlogo.png" alt="xworkz-logo" width="100px" height="50px">
            </a>
            <a class="navbar-brand mx-auto" href="#">
                <img src="Assets/reetho-logo-cropped.png" alt="center-logo" width="60px" height="50px"
                    style="margin-left: -100px;">
            </a>
            <button type="button" class="btn btn-outline-warning" onclick="">Home</button>
        </div>
    </nav>

    <div class="divForLogin">
        <form class="formClass" action="loginValidation" method="post">
            <!-- UserName -->
            <h4 class="text-center">Login</h4>
            <br>
            <div><input type="text" class="form-control" placeholder="Email or Mobile Number" aria-label="Username"
                    name="emailOrMobileNumber" id="username" value="${email}"required>

            <div id="usernameMessage" class="invalid-feedback"></div>

            </div>
            <br>

            <!-- Password -->

            <div class="mb-3">

                <div class="input-group">
                    <input type="password"
                           class="form-control"
                           placeholder="Enter password"
                           name="password"
                           id="password"
                           required>
                    <button class="btn btn-outline-secondary" id="togglePassword" type="button">
                        <i class="bi bi-eye-slash"></i>
                    </button>
                </div>
                <div style="color:red">${ passwordStatusMessage }</div>
            </div>

            <br>
            <div>
                <button type="submit" class="btn btn-primary w-100" id="loginButton">Login</button>
            </div>

            <div style="margin-top: 5px;">
                <a href="#">forgot password</a>
            </div>
        </form>

    </div>

    <footer class="bg-dark text-white py-2 fixed-bottom" id="footer">
        <div class="inline center">
            <span class="mb-0">&copy; 2025 Reethu Pickles. All Rights Reserved.</span>
        </div>
        <div class="inline end"><span id="DateAndTime"></span></div>
    </footer>
</body>

</html>