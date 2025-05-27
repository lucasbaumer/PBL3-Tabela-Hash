public abstract class HashTable {
    protected int tamanho = 32;
    protected ListaEncadeada[] tabela;
    protected int colisoes = 0;
    protected int elementos = 0;
    protected double loadFactor = 0.75;

    public HashTable() {
        tabela = new ListaEncadeada[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ListaEncadeada();
        }
    }

    protected abstract int hash(String chave);

    public void inserir(String chave) {
        if ((double)(elementos + 1) / tamanho > loadFactor) {
            rehash();
        }
        int index = hash(chave);
        ListaEncadeada lista = tabela[index];
        if (!lista.contem(chave)) {
            if (!lista.estaVazia()) colisoes++;
            lista.adicionar(chave);
            elementos++;
        }
    }

    private void rehash() {
        int novoTamanho = proximoPrimo(tamanho * 2);
        ListaEncadeada[] antigaTabela = tabela;
        tabela = new ListaEncadeada[novoTamanho];
        for (int i = 0; i < novoTamanho; i++) {
            tabela[i] = new ListaEncadeada();
        }
        int antigoTamanho = tamanho;
        tamanho = novoTamanho;
        elementos = 0;
        colisoes = 0;
        for (int i = 0; i < antigoTamanho; i++) {
            ListaEncadeada.Node atual = antigaTabela[i].getCabeca();
            while (atual != null) {
                inserir(atual.chave);
                atual = atual.proximo;
            }
        }
    }

    private int proximoPrimo(int n) {
        while (!ehPrimo(n)) n++;
        return n;
    }

    private boolean ehPrimo(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public boolean procurar(String chave) {
        int index = hash(chave);
        return tabela[index].contem(chave);
    }

    public boolean remover(String chave) {
        int index = hash(chave);
        boolean removido = tabela[index].remover(chave);
        if (removido) elementos--;
        return removido;
    }

    public int getColisoes() {
        return colisoes;
    }

    public ListaEncadeada[] getTabela() {
        return tabela;
    }
}
