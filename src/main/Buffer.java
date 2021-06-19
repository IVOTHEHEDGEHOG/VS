package main;

public class Buffer {

	int valor;
	boolean disponivel;
	
	//Define o buffer se ele existe ou n�o
	public Buffer() {
		valor = 0;
		disponivel = false;
	}
	//Fun��o para colocar o n�mero de itens
	public void coloca(int v) {
		valor = v;
		disponivel = true;
	}
	//Fun��o para pegar o n�mero de itens
	public int pega() {
		disponivel = false;
		return valor;	
	}
	//M�todo que sempre retorna que o buffer est� dispon�vel
	public boolean estaDisponivel() {
		return disponivel;
	}
}