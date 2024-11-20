/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoautoras;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 *
 * @author paolabolelli
 */
@Entity
@Table(name = "preguntas")
public class Pregunta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    // Le puse Integer en vez de int porque estoy teniendo problema con el repository
    @Column(name = "id_pregunta") 
    private Integer idPregunta;
    
    @Column(name = "texto") 
    private String textoPregunta;
    
    @Column(name = "alternativa_1") 
    private String alternativa1;
    
    @Column(name = "alternativa_2") 
    private String alternativa2;
    
    @Column(name = "alternativa_3") 
    private String alternativa3;
    
    @Column(name = "alternativa_4") 
    private String alternativa4;
    
    @Column(name = "respuesta") 
    private int respuestaCorrecta;
    
    
    

    // Getters y setters
    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
        
    }
    
    public String getAlternativa1() {    
        return alternativa1;
    }

    public void setAlternativa1(String alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public String getAlternativa2() {
        return alternativa2;
    }

    public void setAlternativa2(String alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public String getAlternativa3() {
        return alternativa3;
    }

    public void setAlternativa3(String alternativa3) {
        this.alternativa3 = alternativa3;
    }

    public String getAlternativa4() {
        return alternativa4;
    }

    public void setAlternativa4(String alternativa4) {
        this.alternativa4 = alternativa4;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
/* 
    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }  
  */ 
    
    // Constructor vacío
    public Pregunta() {
    }

     
    // Constructor con parámetros
    public Pregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public Pregunta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
   
    
    
    /*
    public Pregunta(String textoPregunta, List<Alternativa> alternativas) {
        this.textoPregunta = textoPregunta;
        this.alternativas = alternativas;
    }
*/
 
    // Constructor con todos los parámetros, sin id

    public Pregunta(String textoPregunta, String alternativa1, String alternativa2, String alternativa3, String alternativa4, int respuestaCorrecta) {
        this.textoPregunta = textoPregunta;
        this.alternativa1 = alternativa1;
        this.alternativa2 = alternativa2;
        this.alternativa3 = alternativa3;
        this.alternativa4 = alternativa4;
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    // Constructor con todos los parámetros, incluida la respuesta

    public Pregunta(Integer idPregunta, String textoPregunta, String alternativa1, String alternativa2, String alternativa3, String alternativa4, int respuestaCorrecta) {
        this.idPregunta = idPregunta;
        this.textoPregunta = textoPregunta;
        this.alternativa1 = alternativa1;
        this.alternativa2 = alternativa2;
        this.alternativa3 = alternativa3;
        this.alternativa4 = alternativa4;
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
  
   

}