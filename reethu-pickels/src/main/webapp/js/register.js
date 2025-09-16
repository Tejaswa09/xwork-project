document.addEventListener("DOMContentLoaded", function () {
    // First Name , Last Name validation
    //first name validation
    const firstName = document.getElementById('firstName')
    firstName.addEventListener('input', function () {
        firstName.value = firstName.value.replace(/[^A-Za-z\s]/g, '');

    })

    firstName.addEventListener('blur', function () {
        const firstNameFeedback = document.getElementById('firstName-feedback');
        const trimmedValue = firstName.value.trim();
        if (trimmedValue.length < 3) {
            firstNameFeedback.textContent = 'First Name should have atleast 3 letters.'
            firstName.classList.add('is-invalid')

        } else {

            firstNameFeedback.textContent = ''
            firstName.classList.remove('is-invalid')

        }
    })

    //last name validation
    const lastName = document.getElementById('lastName')
    lastName.addEventListener('input', function () {
        lastName.value = lastName.value.replace(/[^A-Za-z\s]/g, '');

    })

    lastName.addEventListener('blur', function () {
        const lastNameFeedback = document.getElementById('lastName-feedback');
        const trimmedValue = lastName.value.trim();
        if (trimmedValue.length  > 0) {

            lastNameFeedback.textContent = ''
            lastName.classList.remove('is-invalid')


        } else {
            lastNameFeedback.textContent = 'Last Name should have atleast 1 letters.'
            lastName.classList.add('is-invalid')


        }
    })
    //--------------------------------------------------------------------------------------------//

    // Mobile number validation
    const mobileNumber = document.getElementById('mobileNumber');
    mobileNumber.addEventListener('input', function () {
        mobileNumber.value = mobileNumber.value.replace(/[^0-9]/g, '');
    })

    mobileNumber.addEventListener('blur',async function () {
        const mobileFeedback = document.getElementById('mobile-feedback');
        const trimmedMobileNumber = this.value.trim();

        if(trimmedMobileNumber === ''){
            mobileFeedback.textContent = "Mobile Number is required";
            mobileNumber.classList.add('is-invalid');
            return ;
        }

        if(!/^[6-9]\d{9}$/.test(trimmedMobileNumber)){
            mobileFeedback.textContent = "Mobile Number should start with 6,7,8,9 and should have 10 digits";
            mobileNumber.classList.add('is-invalid');
            return ;
        }

        const response = await fetch(`http://localhost:8082/reethu-pickels/isMobileNumberAvailable?mobileNumber=${this.value}`)
        const isMobileNumberAvailable =await response.text();
        if(isMobileNumberAvailable == "Mobile Number is Available"){
            mobileFeedback.textContent = "Mobile Number is Already exist";
            mobileNumber.classList.add('is-invalid');

        }else{
            mobileFeedback.textContent = "";
            mobileNumber.classList.remove('is-invalid');
        }

    });


    //--------------------------------------------------------------------------------------------//
    //Email validation
    const email = document.getElementById('emailAddress');
        email.addEventListener('blur', async function () {
            const emailFeedback = document.getElementById('email-feedback');
            const trimmedEmail = this.value.trim();

            if(trimmedEmail === ''){
                emailFeedback.textContent ="Email required";
                email.classList.add('is-invalid');
                return;
            }

            if(!/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(trimmedEmail)){
                emailFeedback.textContent ="Enter valid Email";
                email.classList.add('is-invalid');
                return ;
            }


            const response=await fetch(`http://localhost:8082/reethu-pickels/isEmailAvailable?email=${this.value}`)
            const isEmailAvailable = await response.text();
            if(isEmailAvailable == "Email is Available"){
                emailFeedback.textContent ="Email already Exist";
                email.classList.add('is-invalid');
            }else{
                emailFeedback.textContent ="";
                email.classList.remove('is-invalid');
            }

        })

    //--------------------------------------------------------------------------------------------//

    const countrySelect = document.querySelector(".countryName");
    const stateSelect = document.querySelector(".stateName");
    const citySelect = document.querySelector(".cityName");

    //Fetch Countrys
    fetch('https://api.countrystatecity.in/v1/countries', {
        headers: {
            'X-CSCAPI-KEY': 'cngzYXlZcW1DYkV3cHlQUGtsam41YUxVVjl3YTB4cjB5WVpmdzVjdA=='
        }
    })
        .then(response => response.json())
        .then(data => {
            data.forEach(country => {
                const option = document.createElement('option');
                option.value = country.name;
                option.setAttribute("data-countryId",country.iso2) ;
                option.textContent = country.name;
                countrySelect.appendChild(option);
            });
        })
        .catch(error => console.error('Error Loading countries', error))

    //Fetch states
    countrySelect.addEventListener('change', function () {
        const selectedOption = this.options[this.selectedIndex]
        const countryCode = selectedOption.getAttribute('data-countryId');
        stateSelect.innerHTML = '<option value="" disabled selected>Select State</option>'; // Clear previous options
        citySelect.innerHTML = '<option value="" disabled selected>Select City</option>';
        console.log(countryCode);
        fetch(`https://api.countrystatecity.in/v1/countries/${countryCode}/states`, {
            headers: {
                'X-CSCAPI-KEY': 'cngzYXlZcW1DYkV3cHlQUGtsam41YUxVVjl3YTB4cjB5WVpmdzVjdA=='
            }
        })
            .then(response => response.json())
            .then(data => {
                data.forEach(state => {
                    const option = document.createElement('option');
                    option.value = state.name;
                    option.setAttribute("data-stateId",state.iso2);
                    option.textContent = state.name;
                    stateSelect.appendChild(option);
                })
            })
            .catch(error => console.error('Error loading states', error))
    })

    //fetch Cities
    stateSelect.addEventListener('change', function () {
        const selectedCountryOption = countrySelect.options[countrySelect.selectedIndex]
        const selectedStateOption = this.options[this.selectedIndex]
        const countryCode = selectedCountryOption.getAttribute("data-countryId");
        const stateCode = selectedStateOption.getAttribute("data-stateId")
        citySelect.innerHTML = '<option value="" disabled selected>Select City</option>'; // Clear previous options

        fetch(`https://api.countrystatecity.in/v1/countries/${countryCode}/states/${stateCode}/cities`, {
            headers: {
                'X-CSCAPI-KEY': 'cngzYXlZcW1DYkV3cHlQUGtsam41YUxVVjl3YTB4cjB5WVpmdzVjdA=='
            }
        })
            .then(response => response.json())
            .then(data => {
                data.forEach(city => {
                    const option = document.createElement('option');
                    option.value = city.name;
                    option.textContent = city.name;
                    citySelect.appendChild(option);
                })
            })
            .catch(error => console.error('Error loading states', error))
    })

    //password show hide
    const togglePassword = document.getElementById('togglePassword');
    const password = document.getElementById('password');

    togglePassword.addEventListener('click', function () {
        // Toggle the type of the password input
        const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
        password.setAttribute('type', type);

        // Toggle the eye icon
        const icon = this.querySelector('i');
        icon.classList.toggle('bi-eye');
        icon.classList.toggle('bi-eye-slash');
    });

    password.addEventListener('keyup', function (event) {
        const warning = document.getElementById('message');
        if (event.getModifierState("CapsLock")) {
            warning.innerHTML = "<h6 style='color:black;'>Caps Lock is ON</h6>";
        } else {
            warning.innerHTML = "";
        }
        if (event.getModifierState("NumLock")) {
            warning.innerHTML += "<h6 style='color:black;'>Num Lock is ON</h6>";
        } else {
            warning.innerHTML += "";
        }
    });


    //password validation
    let isLengthValid = false;
    let isUpperValid = false;
    let isLowerValid = false;
    let isSpecialValid = false;
    let isNumberValid = false;
    let isCnfPasswordValid = false;

    password.addEventListener('input', function () {
        const lenght = document.getElementById('length');
        const upper = document.getElementById('uppercase');
        const lower = document.getElementById('lowercase');
        const number = document.getElementById('number');
        const special = document.getElementById('special');



        const pwd = password.value;

        isLengthValid = pwd.length >= 8;
        isUpperValid = /[A-Z]/.test(pwd);
        isLowerValid = /[a-z]/.test(pwd);
        isSpecialValid = /[-’/`~!#*$@_%+=.,^&(){}[\]|;:”<>?\\]/.test(pwd);
        isNumberValid = /\d/.test(pwd);




        lenght.innerHTML = isLengthValid ? "<i class='bi bi-check-lg' style='color:green;'></i> At least 8 characters"
            : "<i class='bi bi-x-lg' style='color:red;'></i> At least 8 characters";


        upper.innerHTML = isUpperValid ? "<i class='bi bi-check-lg' style='color:green;'></i> At least one uppercase letter"
            : "<i class='bi bi-x-lg' style='color:red;'></i> At least one uppercase letter";


        lower.innerHTML = isLowerValid ? "<i class='bi bi-check-lg' style='color:green;'></i>At least one lowercase" :
            "<i class='bi bi-x-lg' style='color:red;'></i>At least one lowercase"


        special.innerHTML = isSpecialValid ? "<i class='bi bi-check-lg' style='color:green;'></i>At least one special character"
            : "<i class='bi bi-x-lg' style='color:red;'></i>At least one special character"


        number.innerHTML = isNumberValid ? "<i class='bi bi-check-lg' style='color:green;'></i>At least one number"
            : "<i class='bi bi-x-lg' style='color:red;'></i>At least one number"

    });

    //confirm password validation
    const cnfPassword = document.getElementById('confirmPassword');

    cnfPassword.addEventListener('input', function () {
        isCnfPasswordValid = password.value === cnfPassword.value;

        const confMessage = document.getElementById('confirmMessage');
        confMessage.innerHTML = isCnfPasswordValid ? "<i class='bi bi-check-lg' style='color:green;'></i> Passwords match"
            : "<i class='bi bi-x-lg' style='color:red;'></i> Passwords do not match";
    });

    // Enable or disable submit button based on all validations
    const form = document.querySelector("form");
    form.addEventListener("input", function () {
        if (isLengthValid && isUpperValid && isLowerValid && isSpecialValid && isNumberValid && isCnfPasswordValid) {
            document.getElementById("sumbitButton").disabled = false;
        } else {
            document.getElementById("sumbitButton").disabled = true;
        }
    });

    //Date of Birth validation
    const dob = document.getElementById('dateOfBirth');
    dob.addEventListener('blue', function () {
        const selectedDate = new Date(this.value);
        var today = new Date();
        const age = today.getFullYear() - selectedDate.getFullYear();
        age = age -1 ;
         if (age >= 16){
            const dobFeedback = document.getElementById('dob-feedback');
            dobFeedback.textContent = ''
            dob.classList.remove('is-invalid')
         }else{
            const dobFeedback = document.getElementById('dob-feedback');
            dobFeedback.textContent = 'Age must be atleast 16 years.'
            dob.classList.add('is-invalid')
         }

    });

    flatpickr("#dateOfBirth", {

        altInput: true,
        altFormat: "F j, Y",
        dateFormat: "Y-m-d",
        maxDate: "today",

});


})

