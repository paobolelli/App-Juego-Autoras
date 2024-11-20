/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoautoras;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author paolabolelli
 */
 

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private final PreguntaRepository preguntaRepository;
    
    @Autowired
    public DataLoader(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }
    

    @Override
    public void run(String... args) throws Exception {
        List<Pregunta> preguntas = Arrays.asList(
        
        new Pregunta("¿Quién escribió 'Una habitación propia'?", 
                     "1.Sylvia Plath", "2.Margaret Atwood", "3.Toni Morrison","4.Virginia Woolf", 4),
        new Pregunta("¿En qué año se publicó 'Frankenstein'?", 
                     "1.1818", "2.1825", "3.1830", "4.1840", 1),
        new Pregunta("¿Qué autora escribió 'Orgullo y prejuicio'?", 
                     "1.Jane Austen", "2.Charlotte Brontë", "3.Emily Dickinson", "4.Louisa May Alcott", 1),
        new Pregunta("¿Cuál es el nombre de la protagonista de 'Cumbres Borrascosas'?", 
                     "1.Catherine Earnshaw", "2.Elizabeth Bennet", "3.Jo March", "4.Mina Harker", 1),
        new Pregunta("¿Quién escribió 'Los hombres me explican cosas'?", 
                     "1.Roxane Gay", "2.Toni Morrison", "3.Rebecca Solnit", "4.Sally Rooney", 3),
        new Pregunta("¿Qué autora escribió 'La mujer que mira a los hombres que miran a las mujeres'?", 
                    "1.Mariana Enriquez", "2.Siri Hustvedt", "3.Clara Sánchez", "4.Ana María Shua", 2),
        new Pregunta("¿Quién escribió 'El cuento de la criada'?", 
                     "1.Zora Neale Hurston", "2.Margaret Atwood", "3.Alice Walker", "4.Toni Morrison", 2),
        new Pregunta("¿En qué año se publicó 'Cumbres Borrascosas'?", 
                      "1.1853", "2.1861", "3.1867", "4.1847", 4),
        new Pregunta("¿Qué autora escribió 'Las Malas'?", 
                      "1.Aurora Venturini", "2.Laura Esquivel", "3.Camila Sosa Vilada", "4.Carolina de Robertis", 3),
        new Pregunta("¿Qué autora de la literatura peruana escribió 'Huaco Retrato'?", 
                     "1.Blanca Varela", "2.Gabriela Wiener", "3.Katya Adaui", "4.Carmen Ollé", 2),
        new Pregunta("¿Quién escribió 'El segundo sexo'?", 
                     "1.Simone de Beauvoir", "2.Virginia Woolf", "3.Sylvia Plath", "4.Maya Angelou", 1),
        new Pregunta("¿En qué país nació la escritora Isabel Allende?", 
                     "1.México", "2.Chile", "3.Argentina", "4.Perú", 4),
        new Pregunta("¿Qué autora escribió 'La señora Dalloway'?", 
                     "1.Virginia Woolf", "2.Sylvia Plath", "3.Dorothy Parker", "4.Agatha Christie", 1),
        new Pregunta("¿Quién es la autora de 'Inés del Alma Mía'?", 
                     "1.Isabel Allende", "2.Lina Meruane", "3.Marcela Serrano", "4.Patricia Cerda", 1),
        new Pregunta("¿Quién escribió 'La campana de cristal'?", 
                     "1.Anne Sexton", "2.Virginia Woolf", "3.Sylvia Plath", "4.Maya Angelou", 3),
        new Pregunta("¿Qué autora escribió 'La ridícula idea de no volver a verte'?", 
                     "1.Marisel Vera", "2.Rosa Montero", "3.Carmen Martín Gaite", "4.Ana María Matute", 2),
        new Pregunta("¿Quién escribió '¿Cuál es tu tormento', el libro en que se basa la película 'La habitación al lado?'", 
                     "1.Rachel Cusk", "2.Jennifer Egan", "3.Alice Munro", "4.Sigrid Nunez", 4),
        new Pregunta("¿Qué poeta chilena ganó el Premio Nobel de Literatura en 1945?", 
                     "1.Gabriela Mistral", "2.Isabel Allende", "3.Violeta Parra", "4.Lucia Guerra", 1),
        new Pregunta("¿Qué autora es conocida por haber escrito 'Teoría King Kong'?", 
                     "1.Judith Butler", "2.Virginia Woolf", "3.Virginie Despentes", "4.Almudena Grandes", 3),
        new Pregunta("¿Qué autora argentina escribió 'Nuestra parte de noche'?", 
                     "1.Angélica Gorodischer", "2.Samantha Schweblin", "3.Mariana Enriquez", "4.Camila Sosa Villada", 3),
        new Pregunta("¿En qué año se publicó 'El cuento de la criada'?", 
                     "1.1980", "2.1985", "3.1990", "4.1995", 2),
        new Pregunta("¿Qué autora mexicana escribió 'Como agua para chocolate'?", 
                     "1.Elena Poniatowska", "2.Rosario Castellanos", "3.Sandra Cisneros", "4.Laura Esquivel", 4),
        new Pregunta("¿Quién es la autora de 'Mujeres que corren con los lobos'?", 
                     "1.Clarissa Pinkola Estés", "2.Julia Kristeva", "3.Joy Harjo", "4.Alice Walker", 1),
        new Pregunta("¿Qué poeta estadounidense escribió 'Ariel'?", 
                     "1.Gwendolyn Brooks", "2.Sylvia Plath", "3.Maya Angelou", "4.Anne Sexton", 2),
        new Pregunta("¿Qué autora italiana es conocida por 'La amiga estupenda'?", 
                     "1.Grazia Deledda", "2.Dacia Maraini", "3.Elena Ferrante", "4.Oriana Fallaci", 3),
        new Pregunta("¿Quién escribió 'La novia oscura'?", 
                     "1.Laura Restrepo", "2.Marta Sanz", "3.Ana María Moix", "4.Rosa Montero", 1),
        new Pregunta("¿Qué autora escribió 'Querida Ijeawele'?", 
                     "1.Chimamanda Ngozi Adichie", "2.Zadie Smith", "3.Toni Morrison", "4.Jhumpa Lahiri", 1),
        new Pregunta("¿Qué autora africana escribió 'Americanah'?", 
                     "1.Nawal El Saadawi", "2.Tayari Jones", "3.Chimamanda Ngozi Adichie", "4.Maya Angelou", 3),
        new Pregunta("¿En qué novela Alice Walker explora temas de racismo y abuso?", 
                     "1.La canción de Salomón", "2.El color púrpura", "3.Hija de la fortuna", "4.Cisnes salvajes", 2),
        new Pregunta("¿Qué poeta estadounidense escribió 'Still I Rise'?", 
                     "1.Audre Lorde", "2.Gwendolyn Brooks", "3.Maya Angelou", "4.Sylvia Plath", 3),
        new Pregunta("¿Qué autora canadiense escribió 'Alias Grace'?", 
                     "1.Anne Carson", "2.Margaret Atwood", "3.Alice Munro", "4.Miriam Toews", 2),
        new Pregunta("¿Quién escribió 'El corazón helado'?", 
                     "1.Lucia Etxebarria", "2.Rosa Montero", "3.Almudena Grandes", "4.Carmen Laforet", 3),
        new Pregunta("¿Qué autora estadounidense escribió 'Beloved'?", 
                     "1.Jean Rhys", "2.Alice Walker", "3.Toni Morrison", "4.Zora Neale Hurston", 3),
        new Pregunta("¿Quién es la autora del libro 'Mujer en punto cero'?", 
                     "1.Chimamanda Ngozi Adichie", "2.Elif Shafak", "3.Julia Kristeva", "4.Nawal El Saadawi", 4),
        new Pregunta("¿Qué autora británica escribió 'La pasión'?", 
                     "1.Angela Carter", "2.A.S. Byatt", "3.Jeanette Winterson", "4.Doris Lessing", 3)
    );


        // Guardar preguntas en la base de datos
        preguntaRepository.saveAll(preguntas);
        
  }  
}

   

