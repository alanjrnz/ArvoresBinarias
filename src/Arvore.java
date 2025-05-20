public class Arvore {
    No raiz;

    public Arvore(No raiz) {
        this.raiz = raiz;
    }

    public int contagemNo(No no){
        if(no == null){
            return 0;
        }
        return 1 + contagemNo(no.esquerda) + contagemNo(no.direita);
    }

    public void PercursoPreOrdem(No no){
    if(no != null){
        System.out.println(no.valor + " ");
        PercursoPreOrdem(no.esquerda);
        PercursoPreOrdem(no.direita);
    }
    }



}



