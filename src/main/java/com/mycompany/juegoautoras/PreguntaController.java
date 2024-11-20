/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoautoras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

/**
 *
 * @author paolabolelli
 */

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    // Obtener todas las preguntas
    @GetMapping
    public List<Pregunta> obtenerTodasLasPreguntas() {
        return preguntaService.obtenerTodasLasPreguntas();
    }

    // Obtener pregunta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pregunta> obtenerPreguntaPorId(@PathVariable Integer idPregunta) {
        Optional<Pregunta> pregunta = preguntaService.obtenerPreguntaPorId(idPregunta);
        if (pregunta.isPresent()) {
            return ResponseEntity.ok(pregunta.get());
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Crear nueva pregunta
    @PostMapping
    public Pregunta guardarPregunta(@RequestBody Pregunta pregunta) {
        return preguntaService.guardarPregunta(pregunta);
    }
    
    // Obtener pregunta aleatoria 
    @GetMapping("/random")
    public ResponseEntity<Pregunta> getPreguntaAleatoria() {

        try {
            Pregunta pregunta = preguntaService.getPreguntaAleatoria();
            return ResponseEntity.ok(pregunta);
        } catch (RuntimeException e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
}
  
    
/* esto fue un intento de hacer lista de preguntas 
    @GetMapping("/random/{idSesion}")
    public ResponseEntity<List<Pregunta>> obtenerPreguntasAleatorias(@PathVariable int idSesion) {
        Pregunta pregunta = preguntaService.getPreguntaAleatoria(idSesion); 
        if (pregunta != null) {
            return ResponseEntity.ok(pregunta);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }      
*/

    // VALIDAR respuesta de una pregunta
   @PostMapping("/validar")
    public ResponseEntity<String> validarRespuesta(@RequestParam("idPregunta") Integer idPregunta,
                                     @RequestParam("respuestaUsuario") int respuestaUsuario) {
        // Obtener la pregunta por su ID
        Pregunta pregunta = preguntaService.obtenerPreguntaPorId(idPregunta).orElse(null);
        
        if (pregunta == null) {
            System.out.println("Pregunta no encontrada para ID: " + idPregunta);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pregunta no encontrada");
        }
        System.out.println("Pregunta obtenida: " + pregunta.getTextoPregunta());
        System.out.println("Respuesta correcta de la pregunta: " + pregunta.getRespuestaCorrecta());

         // Validar la respuesta del usuario
        boolean esCorrecta = preguntaService.validarRespuesta(pregunta, respuestaUsuario);

        if (esCorrecta) {
            return ResponseEntity.ok("¡Respuesta correcta!");
        } else {
            return ResponseEntity.ok("La respuesta correcta es: " + pregunta.getRespuestaCorrecta());
        }
    }
}
    /* probando por qué da undefined
    Validar la respuesta
            boolean esCorrecta = preguntaService.validarRespuesta(pregunta, respuestaUsuario);

            if (esCorrecta) {
                return ResponseEntity.ok("¡Respuesta correcta!");
            } else {
                return ResponseEntity.ok("Respuesta incorrecta. La respuesta correcta es: " + pregunta.getRespuestaCorrecta());
            }
        }
   
        // Si la pregunta no existe, retornamos 404
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pregunta no encontrada");
    }
    
    */
