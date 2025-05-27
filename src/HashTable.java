public abstract class HashTable {
    protected int tamanho = 32;
    protected String[] tabela;
    protected int colisoes = 0;

    public HashTable() {
        tabela = new String[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = null;
        }
    }

    protected abstract int hash(String chave);
    protected abstract int hash2(String chave);

    public void inserir(String chave) {
        int index = hash(chave);
        int step = hash2(chave);
        int tentativas = 0;
        while (tabela[index] != null) {
            if (tabela[index].equals(chave)) return; // já existe
            colisoes++;
            index = (index + step) % tamanho;
            tentativas++;
            if (tentativas >= tamanho) return; // tabela cheia
        }
        tabela[index] = chave;
    }

    public boolean procurar(String chave) {
        int index = hash(chave);
        int step = hash2(chave);
        int tentativas = 0;
        while (tabela[index] != null && tentativas < tamanho) {
            if (tabela[index].equals(chave)) return true;
            index = (index + step) % tamanho;
            tentativas++;
        }
        return false;
    }

    public int getColisoes() {
        return colisoes;
    }

    public String[] getTabela() {
        return tabela;
    }
}
