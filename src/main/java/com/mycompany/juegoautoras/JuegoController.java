/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoautoras;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author paolabolelli
 */

@RestController
@RequestMapping("/api/preguntas")
public class JuegoController {

    @Autowired
    private PreguntaService preguntaService;

}
 /* ahora el juego incia con al refrescar página 
    
    @PostMapping("/iniciar")
    public ResponseEntity<String> iniciarJuego(@RequestParam Integer idUsuario) {
        return ResponseEntity.ok("¡Juego iniciado");
     
    }
 */ 

/* esta en preguntas controller

    @GetMapping("/random")
    public ResponseEntity<Pregunta> getPreguntaAleatoria() {
        Pregunta pregunta = preguntaService.getPreguntaAleatoria();
        
        if (pregunta != null) {
            return ResponseEntity.ok(pregunta);
        
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

}*/

    
/* probanding
    @GetMapping("/preguntas")
    public ResponseEntity<List<Pregunta>> obtenerPreguntasAleatorias(@RequestParam int idSesion) {
        List<Pregunta> preguntas = preguntaService.getPreguntasAleatorias(idSesion);
        if (preguntas != null && !preguntas.isEmpty()) {
            return ResponseEntity.ok(preguntas);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
*/
/* como cambié la lógica en PreguntaController, lo comento:
    @GetMapping("/pregunta")
    public ResponseEntity<Pregunta> obtenerPreguntaAleatoria(@RequestParam int idSesion) {
        Pregunta pregunta = preguntaService.getPreguntaAleatoria(idSesion);
        return ResponseEntity.ok(pregunta);
    }
*/
