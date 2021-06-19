package main;
import java.util.concurrent.Semaphore;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
               
                int i;
                Scanner leitor = new Scanner(System.in);   
                System.out.println("Informe o Numero de Buffers: "); //Pede ao usu�rio pra inserir a quantidade de buffers 
                int num = leitor.nextInt(); //Lendo o valor inserido pelo usu�rio
               
                // 
		Buffer[] buffer = new Buffer[num]; //Inst�nciando o array de buffer com limitador
                Semaphore semaforo = new Semaphore(1); //Inst�nciando o semaf�ro
                
                for (i=0;i<buffer.length;i++){
                    
                    buffer[i]= new Buffer(); //Adicionando buffer no array de buffer
                }
		//Instanciando o produtor e o consumidor
		Produtor p = new Produtor(buffer, 1, semaforo);
		Consumidor c = new Consumidor(buffer, 1, semaforo);
		//Inicializando o produtor e o consumidor
		p.start();
		c.start();

	}

}
