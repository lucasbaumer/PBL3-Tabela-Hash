import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public abstract class HashTable {
    protected int tamanho = 32;
    protected List<String>[] tabela;
    protected int colisoes = 0;

    public HashTable() {
        tabela = new List[tamanho];
        for(int i = 0; i < tamanho; i++ ) {
            tabela[i] = new ArrayList<>();
        }
    }

    protected abstract int hash(String chave);

    public void inserir(String chave) {
        int index = hash(chave);
        if(!tabela[index].isEmpty()) colisoes++;
        tabela[index].add(chave);
    }

    public boolean procurar(String chave) {
        int index = hash(chave);
        return tabela[index].contains(chave);
    }

    public int getColisoes() {
        return colisoes;
    }

    public List<String>[] getTabela() {
        return tabela;
    }
}
