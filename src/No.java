public class No {
    String valor;
    No esquerda, direita;

    public No(String valor, No esquerda, No direita) {
        this.valor = valor;
        esquerda = direita = null;
    }

    public int contagemNo(No no){
        if(no == null){
            return 0;
        }
        return 1 + contagemNo(no.esquerda) + contagemNo(no.direita);
    }

}

