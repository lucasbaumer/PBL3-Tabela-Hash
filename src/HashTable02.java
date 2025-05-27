public class HashTable02 extends HashTable {
    @Override
    protected int hash(String chave) {
        int hash = 0;
        for (int i = 0; i < chave.length(); i++) {
            hash += chave.charAt(i) * (i + 1);
        }
        return hash % tamanho;
    }
}

