package main;

import java.util.concurrent.Semaphore;

public class Produtor extends Thread {
	Buffer buffer;
	Semaphore semaforo;
	int id;
        int num;
        
	//Construtor do produtor
	public Produtor(Buffer buffer[], int id, Semaphore s) {
		this.buffer = buffer[num];
		this.id = id;
		this.semaforo = s;
	}
	
	@Override
	public void run() {
		while (true) {
			
			//Cria um valor aleatório para produzir
			int v = (int) (Math.random() * 1000.0);
			
			try {
				semaforo.acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//Verifica se o buffer não está disponível
			if (!buffer.estaDisponivel()) {
				buffer.coloca(v);
			//Escreve no console a quantidade de valor que o produtor produziu
				System.out.println("Produtor " + id + 
					" produziu o valor " + v);
			}
			semaforo.release();
			//Em caso de erro ele adormece a thread por um tempo aleatório
			try {
				sleep(100 + (int)(Math.random() * 100.0));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
