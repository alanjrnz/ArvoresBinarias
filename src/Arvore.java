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
            PercursoEmOrdem(no.esquerda);
            System.out.println(no.valor + " ");
            PercursoEmOrdem(no.direita);
        }
    }

    public void PercursoPosOrdem(No no){
        if(no != null){
            PercursoPosOrdem(no.esquerda);
            PercursoPosOrdem(no.direita);
            System.out.println(no.valor);
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

    public void PercursoEmNivel(No no){
        if(no != null){
            Queue<No> fila = new LinkedList<>();
            fila.add(no);

            while (!fila.isEmpty()){
                No atual = fila.poll();
                System.out.println(atual.valor);

                if(atual.esquerda != null){
                    fila.add(atual.esquerda);
                }
                if(atual.direita != null){
                    fila.add(atual.direita);
                }
            }
        }
    }


    public void emOrdemIterativo(No raiz){
        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while(atual != null || !pilha.isEmpty()){
            while(atual != null){
                pilha.push(atual);
                atual = atual.esquerda;
            }
        }
        atual = pilha.pop();
        System.out.println(atual.valor + " ");
        atual = atual.direita;
     }

    public void posOrdemIterativo(No raiz){
        if (raiz == null) { return; }

        Stack<No> pilha1 = new Stack<>();
        Stack<No> pilha2 = new Stack<>();
        pilha1.push(raiz);

        while(!pilha1.isEmpty()){
            No atual = pilha1.pop();
            pilha2.push(atual);

            if(atual.esquerda != null){
                pilha1.push(atual.esquerda);
            }
            if(atual.direita != null){
                pilha1.push(atual.direita);
            }
        }
        while(!pilha2.isEmpty()){
            System.out.println(pilha2.pop().valor + " ");
        }

    }



    public int contagemNoIterativo(No raiz){
        if(raiz == null){ return 0; }

        int contador = 0;
        Stack<No> pilha = new Stack<>();
        pilha.add(raiz);

        while(!pilha.isEmpty()){
            No atual = pilha.pop();
            contador++;

            if(atual.esquerda != null){
                pilha.push(atual.esquerda);
            }
            if(atual.direita != null){
                pilha.push(atual.direita);
            }
        }
        return contador;
    }
    public int contadorDeFolhas(No raiz){
        if (raiz == null) return 0;
        if(raiz.esquerda == null && raiz.direita== null) return 1;
        return contadorDeFolhas(raiz.esquerda) + contadorDeFolhas(raiz.direita);
    }

    public int contadorDeFolhasIterativoPilha(No no){
        if (no == null) return 0;

        int contador = 0;
        Stack<No> pilha = new Stack<>();
        pilha.add(no);

        while(!pilha.isEmpty()){
            No atual = pilha.pop();
            if(atual.esquerda == null && atual.direita == null) contador++;
            if(atual.esquerda != null) pilha.push(atual.esquerda);
            if(atual.direita != null) pilha.push(atual.direita);
        }
        return contador;
    }

    public int contarNosComFila(No raiz){
        if (raiz == null) return 0;

        int contador = 0;
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No no = fila.poll();
            contador++;
            if (no.esquerda != null) {
                fila.add(no.esquerda);
            }
            if (no.direita != null) {
                fila.add(no.direita);
            }
        }
        return contador;
    }

}



