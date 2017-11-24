/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegamen;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author flotante
 */
public class Juegamen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        // TODO code application logic here
        //array 40 cartas
        int cartas[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //barajear
        juegocartas(cartas);
        //turno jugador
        float puntosjug = 0;
        float puntosmaq = 0;
        int carta = 0;
        int x = 0;
        do {
            //for (int i = 0, x = 0; i < cartas.length && x != 2; i++) {
            System.out.println("Tu carta es:" + cartas[carta]);
            if (cartas[carta] <= 7) {
                //puntosjug+=cartas[i]
                puntosjug = (float) (puntosjug + cartas[carta]);
            } else {
                puntosjug = (float) (puntosjug + 0.5);
            }
            System.out.println("Tus puntos son" + puntosjug);
            if (puntosjug > 7.5) {
                x = 2;
                System.out.println("El numero sobrepasa 7.5");
            } else {
                System.out.println("Pulsa '2' para plantarte o pulsa otro numero para pedir otra carta");
                x = sc.nextInt();
            }
            carta++;
        } while (x != 2);//turno maquina
        if (puntosjug > 7.5) {
            System.out.println("Los puntos son" + puntosjug + " y " + puntosmaq);
        } else {
            do {
                juegocartas(cartas);
                int cartis = 0;
                System.out.println("Carta de la maquina:" + cartas[cartis]);
                //for (int i = 0, x = 0; i < cartas.length && x != 2; i++) {
                if (puntosmaq < puntosjug) {
                    if (cartas[cartis] <= 7) {
                        puntosmaq = (float) (puntosmaq + cartas[cartis]);
                        //puntosmaq += cartas[i];
                    } else {
                        puntosmaq = (float) (puntosmaq + 0.5);
                        //puntosmaq += 0.5;
                    }
                    System.out.println("Los puntos de la maquina son: " + puntosmaq);
                }
                if (puntosmaq > 7.5) {
                    System.out.println("El numero sobrepasa 7.5");
                    System.out.println("Has ganado");
                    System.out.println("Los puntos son" + puntosjug + " y " + puntosmaq);
                } else if (puntosmaq == puntosjug) {
                    System.out.println("Has perdido gana la maquina");
                    System.out.println("Los puntos son" + puntosjug + " y " + puntosmaq);
                }   //puntosmaq>puntosjug
            } while (puntosmaq < puntosjug);
            if (puntosmaq > puntosjug) {
                System.out.println("Has perdido gana la maquina");
                System.out.println("Los puntos son" + puntosjug + " y " + puntosmaq);
            }
        }
    }

    public static void juegocartas(int[] array) {
        Random generadorNumerosAleatorios = new Random();
        int posicion;
        int posicion2;
        int swap;
        for (int i = 0; i < 20; i++) {
            posicion = generadorNumerosAleatorios.nextInt(array.length);
            posicion2 = generadorNumerosAleatorios.nextInt(array.length);
            swap = array[posicion];
            array[posicion] = array[posicion2];
            array[posicion2] = swap;
        }
    }
}
