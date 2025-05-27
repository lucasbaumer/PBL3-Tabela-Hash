public class HashTable01 extends HashTable {
    @Override
    protected int hash(String chave) {
        return Math.abs(chave.hashCode()) % tamanho;
    }
}

