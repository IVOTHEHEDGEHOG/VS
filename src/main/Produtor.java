package main;

import java.util.concurrent.Semaphore;

public class Produtor extends Thread {

    Buffer buffer;
    Semaphore semaforo;
    int id;

    //Construtor do produtor
    public Produtor(Buffer buffer, int id, Semaphore s) {
        this.buffer = buffer;
        this.id = id;
        this.semaforo = s;
    }

    @Override
    public void run() {
        while (true) {

            while (!buffer.podeProduzir()) {
                //System.out.println("Produtor "+id+" esperando");
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
          //Verifica se o buffer não está disponível
            try {
                semaforo.acquire();
                if (!buffer.podeProduzir()) {

                    semaforo.release();
                    continue;
                }
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            //Cria um valor aleatório para produzir
            int v = (int) (Math.random() * 1000.0);
            buffer.produzir(v);
            //Escreve no console a quantidade de valor que o produtor produziu
            System.out.println("Produtor " + id
                    + " produziu o valor " + v);
            semaforo.release();
            //Em caso de erro ele adormece a thread por um tempo aleatório
            try {
                long s = 100 + (int) (Math.random() * 100.0);
                //System.out.println("Produtor sleep " + s);
                sleep(s);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
