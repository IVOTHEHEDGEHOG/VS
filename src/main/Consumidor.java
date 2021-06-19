package main;

import java.util.concurrent.Semaphore;

public class Consumidor extends Thread {
       
	Buffer buffer;
	Semaphore semaforo;
	int id;
        int num;

    //Construtor do consumidor
	public Consumidor(Buffer buffer[], int id, Semaphore s) {

		this.buffer = buffer[num];
		this.id = id;
		this.semaforo = s;
	}
	
	@Override
	public void run() {
		while (true) {
			
			try {
				semaforo.acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//verifica se o buffer está disponível
			if (buffer.estaDisponivel()) {
				int v = buffer.pega();
				//escreve no console a quantidade de valor que o consumidor consumiu
				System.out.println("Consumidor " + id + 
						" consumiu o valor " + v);
			}
			semaforo.release();
			
			try {
				//Adomecer do buffer
				sleep(100 + (int)(Math.random() * 1000.0));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
