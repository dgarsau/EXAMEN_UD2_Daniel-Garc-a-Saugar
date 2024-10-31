package org.example;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Examen {

    Scanner entrada = new Scanner(System.in);

    public void ejercicio1() {

        Random random = new Random();

        int num;

        String ordenador;
        String eleccion="";
        int puntos_o = 0;
        int puntos_u = 0;
        boolean error = true;


        for (int i = 1; i <= 3; i++) {

            error = true; //error=true aquí porque en la siguiente ronda si es false no entra en el bucle otra vez

            System.out.println("Ronda " + i);

            while (error) {

                //este bucle controla la entrada del usuario, si la entrada no es p ni a ni t,
                //vuelve a pedirla, no me ha hecho falta un try catch porque estoy controlando una string

                System.out.println("¿Piedra, papel o tijera? (p/a/t)");
                eleccion = entrada.next();

                if (!(eleccion.equals("p") || eleccion.equals("a") || eleccion.equals("t"))) {
                    System.out.println("ERROR. Entrada no válida");
                } else {
                    error = false;
                }
            }

            //Esto lo iba a quitar ya que luego podría comparar con el ordenador usando p, a o t, pero lo
            //he dejado por la primera comparación ordenador.equals(eleccion) así las dos variables se llaman igual.

            if (eleccion.equals("p")) {
                eleccion = "Piedra";
            } else if (eleccion.equals("a")) {
                eleccion = "Papel";
            } else {
                eleccion = "Tijera";
            }

            //aquí con un random "elige" el ordenador, he usado int porque me parecía más fácil.
            num = random.nextInt(3) + 1;

            if (num == 1) {
                ordenador = "Piedra";
            } else if (num == 2) {
                ordenador = "Papel";
            } else {
                ordenador = "Tijera";
            }

            System.out.println("El ordenador ha elegido: " + ordenador);

            if (ordenador.equals(eleccion)) {
                System.out.println("Empate");
                i--; //esto resta una ronda en caso de empate, al volver a empezar el bucle se suma uno así que no
                     // habría problema en caso de empates consecutivos.
            } else if (ordenador.equals("Piedra") && eleccion.equals("Tijera") || ordenador.equals("Papel") && eleccion.equals("Piedra") || ordenador.equals("Tijera") && eleccion.equals("Papel")) {
                System.out.println("Has perdido!");
                puntos_o++;
                //Este if controla todos los casos en los que gana el ordenador.
            } else {
                System.out.println("Has ganado!");
                puntos_u++;
                //El resto de casos gana el usuario.
            }

            System.out.println("Marcador actual (PC-usuario): " + puntos_o + "-" + puntos_u);

            System.out.println("_________________________________");
            //Esto pinta una línea para separar las rondas.

        }

        if (puntos_o > puntos_u) {
            System.out.println("¡Gana el ordenador!");
        } else if (puntos_u > puntos_o) {
            System.out.println("¡Gana el usuario!");
        } else {
            System.out.println("Empate :(");
        }
    }

    public void ejercicio2(){

        int anyo=0;
        boolean error=true;

        LocalDateTime actual = LocalDateTime.now();
        //esto obtiene la fecha actual
        int anyo_actual = actual.getYear();
        //esto el año

        while(error) {
        //este error me sirve para controlar la entrada del usuario, con un if en caso de que introduzca un año no válido
        //y con el try catch que no introduzca texto.

            try {
                System.out.println("¿En qué año naciste?");
                anyo=entrada.nextInt();

                if (anyo < 1900 || anyo > anyo_actual) {
                    System.out.println("Error. No puedes introducir un año menor que 1900 ni mayor que el actual.");
                } else {
                    error = false;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Error. Entrada no válida.");
                entrada.nextLine();
            }
        }

        for(int i = 0 ; anyo<=anyo_actual ; anyo++){
            System.out.println(anyo + "-" + "edad: " + i);
            i++;
            //sumo 1 a i ya que estoy usando anyo para controlar el bucle
        }
    }
}






