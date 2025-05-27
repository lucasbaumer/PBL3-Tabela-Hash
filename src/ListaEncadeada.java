public class ListaEncadeada {
    public static class Node {
        public String chave;
        public Node proximo;

        public Node(String chave) {
            this.chave = chave;
            this.proximo = null;
        }
    }

    private Node cabeca;

    public ListaEncadeada() {
        cabeca = null;
    }

    public void adicionar(String chave) {
        Node novo = new Node(chave);
        novo.proximo = cabeca;
        cabeca = novo;
    }

    public boolean contem(String chave) {
        Node atual = cabeca;
        while (atual != null) {
            if (atual.chave.equals(chave))
                return true;
            atual = atual.proximo;
        }
        return false;
    }

    public boolean estaVazia() {
        return cabeca == null;
    }

    public Node getCabeca() {
        return cabeca;
    }

    public int quantidade() {
        int count = 0;
        Node atual = cabeca;
        while (atual != null) {
            count++;
            atual = atual.proximo;
        }
        return count;
    }

    public boolean remover(String chave) {
        Node atual = cabeca;
        Node anterior = null;
        while (atual != null) {
            if (atual.chave.equals(chave)) {
                if (anterior == null) {
                    cabeca = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return false;
    }
}
