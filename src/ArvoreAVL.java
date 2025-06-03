public class ArvoreAVL {
 NoAVL raiz;

    public ArvoreAVL(NoAVL raiz) {
        this.raiz = raiz;
    }

    //Inserção
    //Remoção
    //balancear
    //Rotação(R & L)
    public int Altura(NoAVL no){
        return  no != null ? no.Altura : -1;
    }

    public int fatorBalanceamento(NoAVL no){
       return Altura(no.direita) - Altura(no.esquerda)
    }

    public void AtualizaAltura(NoAVL no){
        int alturaEsquerda = Altura(no.esquerda);
        int alturaDireita = Altura(no.direita);
        no.Altura = (alturaDireita > alturaDireita ? alturaDireita : alturaEsquerda)+1;
    }
    public void Inserir(String valor, NoAVL no){

    }

    public void Remover(NoAVL no){

    }


    private NoAVL RotacaoDireita(NoAVL no){
       NoAVL noEsquerda = no.esquerda;
       no.esquerda = no.direita;
        noEsquerda.direita = no;
        AtualizaAltura(noEsquerda);
        AtualizaAltura(no.esquerda);

    return noEsquerda;
    }
    private NoAVL RotacaoEsquerda(NoAVL no){
        NoAVL noDireita = no.direita;
        no.direita = noDireita.esquerda;
        noDireita.esquerda = no;

        AtualizaAltura(noDireita);
        AtualizaAltura(no.esquerda);

        return noDireita;
    }

}
