package main;

public class Buffer {

    int valor[];
    int c = 0;
    int i = 0, f = 0;

    //Define o tamanho do buffer
    public Buffer() {
        valor = new int[5];
    }

    public boolean podeProduzir() {
        return c < valor.length;
    }

    public boolean podeConsumir() {
        return c > 0;
    }
    //Função para colocar o número de itens

    public void produzir(int v) {
        c++;
        f = (f + 1) % valor.length;
        valor[f] = v;
        //.out.println("p" + f + "" + c);
    }
    //Função para pegar o número de itens

    public int consumir() {
        c--;
        i = (i + 1) % valor.length;

        //System.out.println("c" + i + "" + c);
        return valor[i];
    }
}
