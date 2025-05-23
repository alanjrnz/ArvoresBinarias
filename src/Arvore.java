import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public void PercursoEmOrdem(No no){
        if(no !=null){
            PercursoPreOrdem(no.esquerda);
            System.out.println(no.valor + " ");
            PercursoPreOrdem(no.direita);
        }
    }

    public void PercursoPosOrdem(No no){
        if(no != null){
            PercursoPosOrdem(no.esquerda);
            PercursoPosOrdem(no.direita);
            System.out.println(no.valor);
        }
    }

    public void PercursoEmNivel(No no){
        if(no != null){
            Queue<No> fila = new LinkedList<>();
            fila.add(no);

            while (!fila.isEmpty()){
                No atual = fila.poll();
                System.out.println(atual.valor);

                if(atual.esquerda != null){
                    fila.add(atual.esquerda)
                }
                if(atual.direita != null){
                    fila.add(atual.direita);
                }
            }
        }
    }


    public void PreOrdemSemRecursividade(No raiz) {
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            System.out.println(atual.valor + " ");

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }

            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
        }
    }


    public void EmOrdemSemRecursividade(No raiz) {
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }
            System.out.println(atual.valor + " ");

            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
        }
    }

}



