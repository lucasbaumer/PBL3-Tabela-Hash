public class HashTable05 extends HashTable {
    @Override
    protected int hash(String chave) {
        // Hash baseada em soma alternada dos códigos dos caracteres
        int hash = 0;
        for (int i = 0; i < chave.length(); i++) {
            if (i % 2 == 0) {
                hash += chave.charAt(i);
            } else {
                hash -= chave.charAt(i);
            }
        }
        return Math.abs(hash) % tamanho;
    }
}
