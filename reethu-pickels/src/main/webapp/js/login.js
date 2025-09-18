document.addEventListener("DOMContentLoaded",function(){
    function updateDateAndTime(){
        DateAndTime.innerHTML = new Date().toLocaleString();
    }
    setInterval(updateDateAndTime,1000);
//username validation
    const username = document.getElementById('username');
    let userNameAsEmail= false;
    let userNameAsMobile =false

    username.addEventListener('blur',async function(){
        const userNameValue = username.value;
        const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/ ;
        const phoneRegex = /^[6-9]\d{9}$/
        const msg = document.getElementById("usernameMessage");

        if(/^\d+$/.test(userNameValue)){
            if(phoneRegex.test(userNameValue)){
                msg.textContent = "";
                username.classList.remove('is-invalid');
                const userDtoValuesByAxios = await axios.get(`http://localhost:8082/reethu-pickels/isMobileNumberAvailable?mobileNumber=${this.value}`);

                if(userDtoValuesByAxios.data === 'Mobile Number is not Available'){
                    username.classList.add("is-invalid");
                    msg.textContent = "Mobile Number is not Registered";
                }else{
                    username.classList.remove("is-invalid");
                    msg.textContent = "";
                    userNameAsMobile = true;
                    userNameAsEmail = false;
                }

            }else {
                msg.textContent = "Enter valid phone number";
                username.classList.add('is-invalid');
            }
        }else {
            if(emailRegex.test(userNameValue)){
                msg.textContent = "";
                username.classList.remove('is-invalid');

                const userDtoValuesByAxios = await axios.get(`http://localhost:8082/reethu-pickels/isEmailAvailable?email=${this.value}`);

                                if(userDtoValuesByAxios.data === "Email is not Available"){
                                    username.classList.add("is-invalid");
                                    msg.textContent = "Email is not Registered";
                                }else{
                                    username.classList.remove("is-invalid");
                                    msg.textContent = "";
                                    userNameAsEmail = true;
                                    userNameAsMobile = false;
                                }
            }else {
                msg.textContent = "Enter valid email";
                username.classList.add('is-invalid');
            }
        }
    })
// Password visibility toggle
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

//    const loginButton = document.getElementById('loginButton');

//    loginButton.addEventListener('click',async function(){
//        const msg = document.getElementById("msgForPassword");
//
//        const loginCredentials = {
//            emailOrMobileNumber : username.value,
//            password : password.value,
//            date : new Date(),
//            time : new Date().toLocaleTimeString(),
//            userNameType : userNameAsEmail ? "email" : userNameAsMobile ? "mobile" : ""
//          }
//
//          const response = await fetch(
//            `http://localhost:8082/reethu-pickels/loginValidation`,
//            {
//                method : 'POST',
//                headers :{
//                    'Content-Type': 'application/json'
//                },
//                body : JSON.stringify(loginCredentials)
//            }
//          )
//
//
//            const result = await response.text();
//
//
//
//            if(response.ok){
//                password.classList.remove('is-invalid');
//                msg.textContent = "";
//                window.location.href = "response.jsp";
//
//            }else{
//                password.classList.add('is-invalid');
//                msg.textContent = "Wrong Password";
//            }
//
//    });

});

