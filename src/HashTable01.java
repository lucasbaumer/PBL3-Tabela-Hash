public class HashTable01 extends HashTable {
    @Override
    protected int hash(String chave) {
        int hash = 0;
        for (int i = 0; i < chave.length(); i++) {
            hash += chave.charAt(i);
        }
        return Math.abs(hash) % tamanho;
    }
}

