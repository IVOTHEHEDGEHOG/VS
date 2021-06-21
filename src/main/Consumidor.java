package main;

import java.util.concurrent.Semaphore;

public class Consumidor extends Thread {

    Buffer buffer;
    Semaphore semaforo;
    int id;
    int dormindo;

    //Construtor do consumidor
    public Consumidor(Buffer buffer, int id, Semaphore s) {

        this.buffer = buffer;
        this.id = id;
        this.semaforo = s;
    }

    @Override
    public void run() {
        while (true) {
            while (!buffer.podeConsumir()) {
                //System.out.println("Consumidor "+id+" esperando");
                try {
                	dormindo = (int) (Math.random() * 100.0);
                    sleep (dormindo);
                    System.out.println("Consumidor dormindo por " + dormindo + " milissegundos");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
          //Verifica se o buffer está disponível
            try {
                semaforo.acquire();
                if (!buffer.podeConsumir()) {

                    semaforo.release();
                    continue;
                }
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            int v = buffer.consumir();
            //Escreve no console a quantidade de valor que o consumidor consumiu
            System.out.println("Consumidor " + id
                    + " consumiu o valor " + v);
            semaforo.release();

            try {
                //Adormercer do buffer
                long s = 100 + (int) (Math.random() * 100.0);
                //System.out.println("Consumidor sleep " + s);
                sleep(s);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
