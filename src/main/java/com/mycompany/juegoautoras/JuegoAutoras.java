/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.juegoautoras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author paolabolelli
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.mycompany.juegoautoras")
public class JuegoAutoras {

    public static void main(String[] args) {
     SpringApplication.run(JuegoAutoras.class, args);
    }
}


