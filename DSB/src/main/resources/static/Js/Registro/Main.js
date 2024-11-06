function validatePasswords(event) {
    const password = document.getElementById('password').value;
    const newPassword = document.getElementById('newpassword').value;
    if (password !== newPassword) {
        event.preventDefault();
        alert('Las contraseñas no coinciden. Por favor, inténtelo de nuevo.');
    }
}