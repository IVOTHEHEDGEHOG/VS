package main;

import java.util.concurrent.Semaphore;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(); //Inst�nciando o buffer
        Semaphore semaforo = new Semaphore(1); //Inst�nciando o sem�foro

        Scanner leitor = new Scanner(System.in);
        System.out.println("Numero de Produtor");
        int num = leitor.nextInt(); //Lendo o valor inserido pelo usu�rio
        Produtor[] p = new Produtor[num];

        for (int i = 0; i < p.length; i++) {
            p[i] = new Produtor(buffer, i, semaforo);
        }
        System.out.println("Numero de Consumidor");
        num = leitor.nextInt(); //Lendo o valor inserido pelo usu�rio

        Consumidor[] c = new Consumidor[num];

        for (int i = 0; i < c.length; i++) {
            c[i] = new Consumidor(buffer, i, semaforo);
        }

        for (int i = 0; i < p.length; i++) {
            p[i].start();
        }
        for (int i = 0; i < c.length; i++) {
            c[i].start();
        }

    }

}
