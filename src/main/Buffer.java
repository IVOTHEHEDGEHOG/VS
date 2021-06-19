package main;

public class Buffer {

	int valor;
	boolean disponivel;
	
	//Define o buffer se ele existe ou não
	public Buffer() {
		valor = 0;
		disponivel = false;
	}
	//Função para colocar o número de itens
	public void coloca(int v) {
		valor = v;
		disponivel = true;
	}
	//Função para pegar o número de itens
	public int pega() {
		disponivel = false;
		return valor;	
	}
	//Método que sempre retorna que o buffer está disponível
	public boolean estaDisponivel() {
		return disponivel;
	}
}