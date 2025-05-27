public class HashTable04 extends HashTable {
    @Override
    protected int hash(String chave) {
        // Hash baseada em XOR dos caracteres
        int hash = 0;
        for (int i = 0; i < chave.length(); i++) {
            hash ^= chave.charAt(i);
        }
        return Math.abs(hash) % tamanho;
    }
}
