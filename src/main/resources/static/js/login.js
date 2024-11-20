/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


document.addEventListener('DOMContentLoaded', (e) => {
    const loginForm = document.getElementById('loginForm');

        loginForm.addEventListener('submit', function(event) {
            event.preventDefault(); // Evita que el formulario se envíe de la manera tradicional
           
            const formData = new FormData(loginForm);
            const loginData = {
                correoUsuario: formData.get('correoUsuario'),
                contrasenaUsuario: formData.get('contrasenaUsuario')
            };
            console.log(loginData);

            fetch('/usuarios/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(loginData) 
            })
            .then(response => {
                if (response.ok) {
                    alert('Log in exitoso! Serás redirigido al juego');
                    window.location.href = 'protected/juego.html';
                } else {
                    return response.text().then(text => { throw new Error(text); });
                }
            })
            .catch(error => {
                alert('Login fallido: ' + error.message);
            });
        });
});