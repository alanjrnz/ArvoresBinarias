import javax.management.remote.NotificationResult;

public class ArvoreRubroNegra {
    NoRubroNegro raiz;
    private final NoRubroNegro NIL;

    public ArvoreRubroNegra(NoRubroNegro nil) {
        NIL = new NoRubroNegro(-1);

    }


    public void  inserir(int valor){
        NoRubroNegro no = new NoRubroNegro(valor);
        no.esquerdo = no.direito = no.pai = NIL;

        NoRubroNegro y = null;
        NoRubroNegro x = raiz;



        while (x != null) {
        y= x;
        if(no.valor < x.valor) x = x.esquerdo;
        else x = x.direito;
        }

        no.pai = y;
        if(y == null) raiz = no;
        else if (no.valor < y.valor ) y.esquerdo = no;
        else y.direito = no;

        no.esquerdo = NIL;
        no.direito  = NIL;
        no.cor =Color.red;

        CorrecaoAoInserir(no);
    }

    public void CorrecaoAoInserir(NoRubroNegro k){
        while (k.pai !=  null && k.pai.cor == Color.red){
            if(k.pai == k.pai.pai.esquerdo){
                NoRubroNegro u = k.pai.pai.direito;

                if(u.cor == Color.red){
                    k.pai.cor = Color.black;
                    u.cor = Color.black;
                    k.pai.pai.cor = Color.red;
                    k = k.pai.pai;
                }else{
                    if(k == k.pai.esquerdo){
                        k = k.pai;
                        RotacaoDireita(k);
                    }
                    k.pai.cor = Color.black;
                    k.pai.pai.cor = Color.red;
                    RotacaoEsquerda(k.pai.pai);
                }
                if(k == raiz) break;
            }
        raiz.cor = Color.black;
        }
    }
 public void transplante(NoRubroNegro u, NoRubroNegro v){
        if(u.pai == null) raiz = v;
        else if(u == u.pai.esquerdo) u.pai.esquerdo = v;
        else u.pai.direito =v;
        v.pai = u.pai;
 }

    private NoRubroNegro minimo(NoRubroNegro no){
        while(no.esquerdo != NIL) no = no.esquerdo;
        return  no;
    }

    public void remover(int valor){
        NoRubroNegro z = buscaArvore(raiz,valor);
        if(z == NIL) return;;
        NoRubroNegro y = z;
        Color yOriginalColor = y.cor;
        NoRubroNegro x;

        if(z.esquerdo == NIL){
            x = z.direito;
            transplante(z,z.direito);
        }else if(z.direito == NIL){
            x = z.esquerdo;
            transplante(z,z.esquerdo);
        }else{
            y = minimo(z.direito);
            yOriginalColor = y.cor;
            x = y.direito;
            if(y.pai == z) x.pai = x;
            else{
                transplante(y,y.direito);
                y.direito = z.direito;
                y.direito = z.direito;
                y.direito.pai = y;
            }
            transplante(z,x);
            y.esquerdo = z.esquerdo;
            y.esquerdo.pai = y;
            y.cor = z.cor;
        }
        if(yOriginalColor == Color.black) deleteFix(y);
    }

    public void deleteFix(NoRubroNegro x){
        NoRubroNegro w;
        while (x != raiz && x.cor == Color.black){
            if(x == x.pai.esquerdo){
                w = x.pai.direito;
                if(w.cor == Color.red){
                    w.cor = Color.red;
                    x.pai.cor = Color.red;
                    RotacaoEsquerda(x.pai);
                    w = x.pai.direito;
                }
                if(w.esquerdo.cor == Color.black && w.direito.cor == Color.black){
                    w.cor = Color.red;
                    x = x.pai;
                }else{
                    if(w.direito.cor == Color.black){
                        w.esquerdo.cor = Color.black;
                        w.cor = Color.red   ;
                     RotacaoDireita(w);
                     w = x.pai.esquerdo;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = Color.black;
                    w.direito.cor = Color.black;
                    RotacaoEsquerda(x.pai);
                    x = raiz;
                }
                else{
                    w = x.pai.esquerdo;
                    if()
                }
            }
        }
    }
    public NoRubroNegro buscaArvore(NoRubroNegro no, int valor){
        if(no == NIL || valor == no.valor) return no;
        if( valor < no.valor) return buscaArvore(no.esquerdo,valor);
        return buscaArvore(no.direito,valor);
    }



    private  void auxEmOrder(NoRubroNegro no){
        if(no != null){
            auxEmOrder(no.esquerdo);
            String colorSufix = (no.cor = Color.red);
            System.out.println(no.valor + colorSufix + " ");
            auxEmOrder(no.direita);
        }
    }
    private  void RotacaoEsquerda(NoRubroNegro x){
        NoRubroNegro y = x.direito;
        x.direito = y.esquerdo;
        if(y.esquerdo != NIL) y.esquerdo.pai = x;

        y.pai = x.pai;


        if(x.pai == null) raiz = y;

        else if (x==x.pai.esquerdo) x.pai.esquerdo = y;
        else x.pai.direito = y;

        y.esquerdo = x;
        x.pai   = y;
    }
    private void RotacaoDireita(NoRubroNegro y){
        NoRubroNegro x = y.esquerdo;
        y.esquerdo = x.direito;
        if(x.direito != NIL) x.direito.pai = y;

        x.pai = y.pai;

        if(y.pai == null)raiz = x;
        else if(y == y.pai.direito) y.pai.direito = x;
        else y.pai.esquerdo = x;

        x.direito =y;
        y.pai = x;




    }

}

