public class ListaEncadeada {
    private static class Node {
        String chave;
        Node proximo;

        Node(String chave) {
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
}
