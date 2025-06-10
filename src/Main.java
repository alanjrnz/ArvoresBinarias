public class Main {
    public static void main(String[] args) {

//   No raiz = new No("A",null ,null);
//   raiz.esquerda = new No("B",null,null);
//   raiz.direita = new No("C",null, null);
//   raiz.esquerda.esquerda = new No("D",null,null);
//   raiz.esquerda.direita = new No("E",null,null);
//   raiz.direita.direita = new No("F", null,null);
//    Arvore arvore = new Arvore(raiz);
//        System.out.println(arvore.contagemNo(raiz));
//        arvore.PercursoPosOrdem(raiz);
//        arvore.PercursoEmOrdem(raiz);
//        arvore.PercursoPreOrdem(raiz);

    ArvoreAVL arvoreAVL = new ArvoreAVL();

    int[] chaves ={10,20,40,20,50,25};

     for (int chave : chaves){
         arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, chave);
     }
        System.out.println("Percurso em order da árvore AVL: ");
     arvoreAVL.PercursoEmOrdem(arvoreAVL.raiz);

    }
}