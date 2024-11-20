/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
document.addEventListener('DOMContentLoaded', function() {
    let preguntasRestantes = 10; // contador de preguntas restantes
    
    
    // Lógica para iniciar el juego automáticamente al cargar la página
    document.getElementById('pregunta-container').style.display = 'block';  // Muestra el contenedor de la pregunta
    cargarPregunta();  // Cargar la primera pregunta
   
    /* ya no necesito el api para iniciar de juego controller
     
      Lógica para iniciar el juego
    document.getElementById('iniciarJuegoBtn').addEventListener('click', function() {
        // Iniciar el juego con el idUsuario
        fetch(`/api/preguntas/iniciar?idUsuario=${idUsuario}`, { method: 'POST' })
            .then(response => response.json())
            .then(data => {
                if (data === "¡Juego iniciado!") {
                    // Muestra el área de preguntas y oculta la creación de usuario si ya está todo listo
                    document.getElementById('preguntaContainer').style.display = 'block';
                    cargarPregunta();  // Cargar la primera pregunta
                } else {
                    alert("Hubo un error al iniciar el juego.");
                }
            })
            .catch(error => {
                console.error('Error al iniciar el juego:', error);
                alert("Hubo un problema al iniciar el juego.");
            });
    }); 
    */
    // Función para cargar la siguiente pregunta
    function cargarPregunta() {
        if (preguntasRestantes <= 0) {  // Verificar si ya no hay preguntas restantes
            alert("Ya no hay más preguntas disponibles.");
            terminarJuego();  // Finaliza el juego si no quedan preguntas
            return;  // Evita seguir con la ejecución si no hay preguntas
        }
        
            fetch(`/api/preguntas/random`)  // Obtener una pregunta aleatoria para esta sesión
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                    if (data) {
                        mostrarPregunta(data);
                    } else {
                        alert("No se pudieron cargar más preguntas.");
                    }
                })
                .catch(error => {
                    console.error('Error al cargar la pregunta:', error);
                    alert("Hubo un problema al cargar la pregunta.");
                });
    }

    // para mostrar la pregunta y sus alternativas en el DOM
    function mostrarPregunta(pregunta) {
        console.log(pregunta); 
        
        document.getElementById('textoPregunta').textContent = pregunta.textoPregunta;
        document.getElementById('alternativa1').textContent = pregunta.alternativa1;
        document.getElementById('alternativa2').textContent = pregunta.alternativa2;
        document.getElementById('alternativa3').textContent = pregunta.alternativa3;
        document.getElementById('alternativa4').textContent = pregunta.alternativa4;

        // Guardar la respuesta correcta para validarla con el input
         window.respuestaCorrecta = pregunta.respuestaCorrecta;
         console.log("Respuesta correcta asignada:", window.respuestaCorrecta);
    }

    // Función para validar la respuesta del jugador
    function validarRespuesta() {
        const respuestaUsuarioInput = document.getElementById('respuestaUsuario');
        const respuestaUsuario = parseInt(document.getElementById('respuestaUsuario').value); // Obtener el valor ingresado por el usuario

        if (isNaN(respuestaUsuario) || respuestaUsuario < 1 || respuestaUsuario > 4) {
            alert("Por favor ingresa un número entre 1 y 4.");
            return; // Si la respuesta no es válida, salir de la función
        }

        if (respuestaUsuario === window.respuestaCorrecta) {
            alert("¡Muy bien! Tu respuesta es correcta!");
        } else {
            alert("Respuesta incorrecta. La correcta es: " + window.respuestaCorrecta);
        }
        
        // Limpiar el campo de entrada después de validar
        respuestaUsuarioInput.value = "";

        preguntasRestantes--; // decrecimiento del nº de resp. faltantes
        if (preguntasRestantes > 0) {
            cargarPregunta();  // Cargar la siguiente pregunta
        } else {
            terminarJuego();  // Finaliza el juego si ya no quedan preguntas
        }
        
    }

    // Función para terminar el juego 
    function terminarJuego() {
        alert("El juego ha terminado. Te invitamos a seguir leyendo a grandes autoras");
       
    }
    
    // Manejar clic en el botón de validación
    document.getElementById('validarRespuestaBtn').addEventListener('click', function() {
        validarRespuesta();
    });

});


/*
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const nombreUsuario = document.getElementById('nombreUsuario').value;
    const contrasenaUsuario = document.getElementById('contrasenaUsuario').value;

    fetch('/usuarios/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombreUsuario, contrasenaUsuario })
    })
    .then(response => response.text())
    .then(data => {
        if (data === "Login exitoso") {
            window.location.href = "/protected.html";
        } else {
            alert(data);
        }
    })
    .catch(error => console.error('Error:', error));
});


document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const nombreUsuario = document.getElementById('nombreUsuarioRegistro').value;
    const contrasenaUsuario = document.getElementById('contrasenaRegistro').value;

    fetch('/usuarios/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombreUsuario, contrasenaUsuario })
    })
    .then(response => response.text())
    .then(data => alert(data))
    .catch(error => console.error('Error:', error));
});*/