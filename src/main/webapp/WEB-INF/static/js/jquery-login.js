document.forms.loginForm.addEventListener("submit", function(event) {
	event.preventDefault();
	var emailElement = document.getElementById("email");
	var passwordElement = document.getElementById("password");

	var status = false;
	var message = "Please fill all mandatory fields";
	setBorderColor(emailElement);
	setBorderColor(passwordElement);

	// count number of input tags
	var numberOfInput = document.getElementsByTagName("input").length;
	var countNumberValidInput = 0;
	for (var j = 0; j < numberOfInput; j++) {
		// check all input are valid
		if (document.getElementsByTagName("input")[j].style.borderColor == "green")
			countNumberValidInput++;
	}
	// if all input are valid, set ok = true
	if (countNumberValidInput == numberOfInput - 1) {
		var email = emailElement.value;
		var password = passwordElement.value;
		var len = { min: 5, max: 50 };
		if (email.length < len.min || email.length > len.max) {
			message = "Email must be at least 5 characters and maximum 50 characters";
			emailElement.style.borderColor = "red";
		} else if (!validateEmail(email)) {
			message = "Email invalidate";
			emailElement.style.borderColor = "red";
		} else if (!validatePassword(password)) {
			message =
				"Password must be at least 8 characters and maximum 30 characters";
			passwordElement.style.borderColor = "red";
		} else {
			status = true;
		}
	}

	// if  status -> submit
	if (status) {
		document.getElementById("loginForm").submit();
	} else {
		document.getElementById("error").innerHTML = message;
	}
});
