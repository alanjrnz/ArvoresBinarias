class No {
    String valor;
    No esquerda, direita;

    public No(String valor, No esquerda, No direita) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

public class Arvore{
    No raiz;
}
