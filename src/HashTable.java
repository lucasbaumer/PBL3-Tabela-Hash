public abstract class HashTable {
    protected int tamanho = 32;
    protected ListaEncadeada[] tabela;
    protected int colisoes = 0;

    public HashTable() {
        tabela = new ListaEncadeada[tamanho];
        for(int i = 0; i < tamanho; i++ ) {
            tabela[i] = new ListaEncadeada();
        }
    }

    protected abstract int hash(String chave);

    public void inserir(String chave) {
        int index = hash(chave);
        if(!tabela[index].estaVazia()) colisoes++;
        tabela[index].adicionar(chave);
    }

    public boolean procurar(String chave) {
        int index = hash(chave);
        return tabela[index].contem(chave);
    }

    public int getColisoes() {
        return colisoes;
    }

    public ListaEncadeada[] getTabela() {
        return tabela;
    }
}
