public class NoAVL {
    String valor;
    NoAVL esquerda, direita;
    int Altura;
    public NoAVL(String valor, NoAVL esquerda, NoAVL direita, int altura) {
        this.valor = valor;
        this.Altura = altura;
        esquerda = direita = null;
    }

}
