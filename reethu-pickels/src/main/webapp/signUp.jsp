<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reethu Pickles</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css">
    <link rel="icon" type="image/png" href="Assets/logo.png">
    <script src="js/register.js"></script>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
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
           <a href="toHome"><button type="button" class="btn btn-outline-warning">Home</button></a>
        </div>
    </nav>

    <!-- Sign up form -->
    <form class="formClass" action="signUp" method="post">
        <h3>Sign up</h3>
        <div class="row">
            <div class="col">
                <h6>First Name</h6>
                <input type="text" name="firstName" class="form-control" placeholder="First name" aria-label="First name" id="firstName"
                    minlength="3" maxlength="15" required>
                <div id="firstName-feedback" class="invalid-feedback"></div>
            </div>
            <div class="col">
                <h6>Last Name</h6>
                <input type="text" name="lastName" class="form-control" placeholder="Last name" aria-label="Last name" id="lastName"
                    min="3" max="15" required>
                <div id="lastName-feedback" class="invalid-feedback"></div>
            </div>
        </div>
        <div class="row" style="padding-top: 10px;">
            <div class="col">
                <h6>Email address</h6>
                <input type="email" name="email" class="form-control" id="emailAddress" placeholder="name@example.com" required>
                <div id="email-feedback" class="invalid-feedback"></div>
            </div>
        </div>
        <div class="row" style="padding-top: 10px;">
            <div class="col">
                <h6>Phone Number</h6>
                <input type="tel" name="mobileNumber" class="form-control" id="mobileNumber" placeholder="Mobile Number" maxlength="10"
                    pattern="[0-9]{10}" required>
                <div id="mobile-feedback" class="invalid-feedback"></div>
            </div>
        </div>
        <div class="row" style="padding-top: 10px;">
            <div class="col">

                <h6>Date of Birth</h6>
                <input type="text" name="dateOfBirth" class="form-control" id="dateOfBirth" placeholder="Date of Birth" required>
                <a class="input-button" title="toggle" data-toggle>
                        <i class="icon-calendar"></i>
                    </a>
                <div id="dob-feedback" class="invalid-feedback"></div>
            </div>
        </div>
        <div class="row" style="padding-top: 10px;">
            <div>
                <h6>Gender</h6>
                <input type="radio" name="gender" id="male" value="Male" required>
                <label for="male">male</label>
                <input type="radio" name="gender" id="female" value="Female" required>
                <label for="female">female</label>
            </div>
        </div>
        <div class="row" style="padding-top: 10px;">
            <div class="col">
                <h6>Country</h6>
                <select class="form-select countryName" name="country" aria-label="Select Country"  required>
                    <option value="" data-countryId="" disabled selected>Select Country</option>
                </select>
            </div>
            <div class="col">
                <h6>State</h6>
                <select class="form-select stateName" name="state" aria-label="Select State" required>
                    <option value="" data-stateId="" disabled selected>Select State</option>
                </select>
            </div>
        </div>
        <div class="row" style="padding-top: 10px;">
            <div class="col">
                <h6>City</h6>
                <select class="form-select cityName" name="city"aria-label="Select City" required>
                    <option value="" data-id="" disabled selected>Select City</option>
                </select>
            </div>
            <div class="col">
                <h6>Pin Code</h6>
                <input type="text" name="pincode" id="pincode" class="form-control" placeholder="Pincode" maxlength="6"
                    required>
            </div>
        </div>

        <div class="row" style="padding-top: 10px;">
            <div class="col password-wrapper">
                <h6>Password</h6>
                <div class="input-group">
                    <input type="password" name="password"class="form-control" id="password" placeholder="Password" required>
                    <button class="btn btn-outline-secondary input-group-text" id="togglePassword" type="button">
                        <i class="bi bi-eye-slash"></i> <!-- Eye Icon -->
                    </button>
                </div>
                <div id="message" style="padding-top: 5px;"></div>
                <div>
                    <ul style="list-style: none; padding: 0;">
                        <li id="length"><i class='bi bi-x-lg' style='color:red;'></i> At least 8 characters</li>
                        <li id="uppercase"><i class='bi bi-x-lg' style='color:red;'></i> At least one uppercase letter
                        </li>
                        <li id="lowercase"><i class='bi bi-x-lg' style='color:red;'></i> At least one lowercase letter
                        </li>
                        <li id="number"><i class='bi bi-x-lg' style='color:red;'></i> At least one number</li>
                        <li id="special"><i class='bi bi-x-lg' style='color:red;'></i> At least one special character
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row" style="padding-top: 10px;">
            <h6>Confirm Password</h6>
            <div class="input-group">
                <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password"
                    required>
            </div>
            <div id="confirmMessage" style="padding-top: 5px;"></div>
        </div>
        <button type="submit" class="btn btn-outline-warning" id="sumbitButton">submit</button>
    </form>

    <!--footer-->
    <footer class="bg-dark text-white text-center py-2 " id="footer">
        <div class="container">
            <p class="mb-0">&copy; 2025 Reethu Pickles. All Rights Reserved.</p>
        </div>
    </footer>

</body>

</html>