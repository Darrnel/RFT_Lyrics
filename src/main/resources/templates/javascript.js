
var modalReg = document.getElementById('registerForm');
var modalLogin = document.getElementById('loginForm');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modalReg) {
        modalReg.style.display = "none";
        clearReg();
    }
    if (event.target == modalLogin) {
        modalLogin.style.display = "none";
        clearLogin();
    }
}

function clearLogin() {
	document.getElementById('usernameLogin').value = '';
	document.getElementById('passwordLogin').value = '';
}
function clearReg() {
	document.getElementById('usernameReg').value = '';
	document.getElementById('emailReg').value = '';
	document.getElementById('passwordReg').value = '';
	document.getElementById('passwordRepeatReg').value = '';
}