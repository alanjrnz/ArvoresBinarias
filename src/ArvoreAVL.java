public class ArvoreAVL {
    NoAVL raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    public int altura(NoAVL no) {
        if (no == null) {
            return 0;
        } else {
            return no.altura;
        }
    }

    public int fatorBalanceamento(NoAVL no) {
        if (no == null) {
            return 0;
        }
        return altura(no.direita) - altura(no.esquerda);
    }

    public NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    public NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public NoAVL inserir(NoAVL no, int valor) {
        if (no == null) {
            return new NoAVL(valor);
        }

        if (valor < no.valor) {
            no.esquerda = inserir(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserir(no.direita, valor);
        } else {
            return no;
        }

        no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;

        int fatorBalanceamento = fatorBalanceamento(no);

        if (fatorBalanceamento > 1) {
            if (no.esquerda != null && valor < no.esquerda.valor) {
                return rotacaoDireita(no);
            } else if (no.esquerda != null) {
                no.esquerda = rotacaoEsquerda(no.esquerda);
                return rotacaoDireita(no);
            }
        }

        if (fatorBalanceamento < -1) {
            if (no.direita != null && valor > no.direita.valor) {
                return rotacaoEsquerda(no);
            } else if (no.direita != null) {
                no.direita = rotacaoDireita(no.direita);
                return rotacaoEsquerda(no);
            }
        }

        return no;
    }

    public void percursoEmOrdem(NoAVL no) {
        if (no != null) {
            percursoEmOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            percursoEmOrdem(no.direita);
        }
    }
}
