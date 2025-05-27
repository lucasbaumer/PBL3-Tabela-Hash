public class HashTable02 extends HashTable {
    @Override
    protected int hash(String chave) {
        int hash = 1;
        for (int i = 0; i < chave.length(); i++) {
            hash = (chave.charAt(i) + 1) * hash;
            hash = hash % tamanho;
        }
        return Math.abs(hash) % tamanho;
    }
}

