public class ArvoreAVL {
 NoAVL raiz;

    public ArvoreAVL() {
        this.raiz = raiz;
    }

    //Inserção
    //Remoção
    //balancear
    //Rotação(R & L)
    public int Altura(NoAVL no){
        return  no != null ? no.Altura : 0;
    }

    public int fatorBalanceamento(NoAVL no){
       return Altura(no.direita) - Altura(no.esquerda);
    }

    public void AtualizaAltura(NoAVL no){
        int alturaEsquerda = Altura(no.esquerda);
        int alturaDireita = Altura(no.direita);
        no.Altura = (Math.max(alturaDireita, alturaEsquerda))+1;
    }


    public void Remover(NoAVL no){

    }


        private NoAVL RotacaoDireita(NoAVL y){
           NoAVL x = y.esquerda;
           NoAVL T2 = x.direita;
            x.direita = y;
           y.esquerda = T2;
            y.Altura = Math.max(Altura(y.esquerda), Altura(y.direita))+ 1;
            x.Altura = Math.max(Altura(x.esquerda),Altura(x.direita))+1;

        return x;
        }
        private NoAVL RotacaoEsquerda(NoAVL x){
            NoAVL y = x.direita;
            NoAVL T2 = y.esquerda;
            x.direita = T2;
            y.esquerda = x;

            y.Altura = Math.max(Altura(y.esquerda), Altura(y.direita))+ 1;
            x.Altura = Math.max(Altura(x.esquerda),Altura(x.direita))+1;

            return y;
        }

    public NoAVL inserir(NoAVL no, int valor){
        if(no == null)
            return new NoAVL(valor);

        if(valor < no.valor){
            no.esquerda = inserir(no.esquerda, valor);
        } else if(valor > no.valor) {
            no.direita = inserir(no.direita, valor);
        } else {
            return no;
        }

        no.Altura = Math.max(Altura(no.esquerda), Altura(no.direita)) + 1;

        int fatorBalanceamento = fatorBalanceamento(no);

        if(fatorBalanceamento > 1 && valor < no.esquerda.valor){
            return RotacaoDireita(no);
        }
        if(fatorBalanceamento < -1 && valor > no.direita.valor){
            return RotacaoEsquerda(no);
        }
        if(fatorBalanceamento > 1 && valor > no.esquerda.valor){
            no.esquerda = RotacaoEsquerda(no.esquerda);
            return RotacaoDireita(no);
        }

        if(fatorBalanceamento < -1 && valor < no.direita.valor){
            no.direita = RotacaoDireita(no.direita);
            return RotacaoEsquerda(no);
        }

        return no;
    }
    public void PercursoEmOrdem(NoAVL no){
        if(no !=null){
            PercursoEmOrdem(no.esquerda);
            System.out.println(no.valor + " ");
            PercursoEmOrdem(no.direita);
        }
    }
}
