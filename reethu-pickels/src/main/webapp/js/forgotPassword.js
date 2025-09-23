document.addEventListener('DOMContentLoaded', function () {
    const DateAndTime = document.getElementById('DateAndTime');
    function updateDateAndTime() {
        DateAndTime.innerHTML = new Date().toLocaleString();
    }
    setInterval(updateDateAndTime, 1000);

    //email validation

    const email = document.getElementById('email');

    email.addEventListener('blur', async function () {
        const emailFeedback = document.getElementById('emailMessage');
        const trimmedEmail = this.value.trim();

        if (trimmedEmail === '') {
            emailFeedback.textContent = "Email required";
            email.classList.add('is-invalid');
            return;
        }

        if (!/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(trimmedEmail)) {
            emailFeedback.textContent = "Enter valid Email";
            email.classList.add('is-invalid');
            return;
        }


        const response = await axios(`http://localhost:8082/reethu-pickels/isEmailAvailable?email=${trimmedEmail}`)

        console.log(response);
        if (response.data === 'Email is Available') {
            emailFeedback.textContent = "";
            email.classList.remove('is-invalid');
        } else {
            emailFeedback.textContent = "Email is Not Registered";
            email.classList.add('is-invalid');
        }



    });

    if(toastMsg === 'true'){
    // Get the toast element from the page
            const successToastElement = document.getElementById('otpSuccessToast');

            // Create a new Bootstrap Toast instance from the element
            const successToast = new bootstrap.Toast(successToastElement);

            // Show the toast
            successToast.show();
    }



    // In your forgotPassword.js, inside the DOMContentLoaded listener
    if (mailSendStatus === 'true') {

        // Your other code to enable OTP fields...
        const otpInputs = document.querySelectorAll('.otp-input');
        otpInputs.forEach(input => {
            input.disabled = false;
        });

        const sendButten = document.getElementById('sendOtpButton');

        sendButten.disabled = true;
    }


    const otpInputs = document.querySelectorAll('.otp-input');

    otpInputs.forEach((input, index) => {
        // Event listener for when a digit is entered
        input.addEventListener('input', () => {
            // If a character is entered and there's a next input box, focus on it
            if (input.value.length === 1 && index + 1 < otpInputs.length) {
                otpInputs[index + 1].focus();
            }

            const otpCombinedValues = Array.from(otpInputs)
                .map(input => input.value)
                .join('');
            console.log(otpCombinedValues);
            if (otpCombinedValues.length === 6) {
                let hiddenOtpInput = document.getElementById('otphiddenValue');
                hiddenOtpInput.value = otpCombinedValues;
                console.log('Hidden OTP field updated:', hiddenOtpInput.value);
            }
        });

        // Event listener for the Backspace key
        input.addEventListener('keydown', (event) => {
            // If Backspace is pressed, the input is empty, and it's not the first box
            if (event.key === 'Backspace' && input.value.length === 0 && index > 0) {
                // Focus on the previous input box
                otpInputs[index - 1].focus();
            }
        });

    });


    if (isValid === 'false') {
        const divForOtp = document.getElementById('divForOtp');
        const messageForOtp = document.getElementById('messageForOtp');

        divForOtp.classList.add('is-invalid');
        messageForOtp.textContent = "incorrect otp";
    }
});
