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
        if(isEmailAvailable=='Email is Available'){
            emailFeedback.textContent ="";
            email.classList.remove('is-invalid');
        }else{
            emailFeedback.textContent="Email is Not Registered";
            email.classList.add('is-invalid');
        }
        console.log(isEmailAvailable);
    })

})
