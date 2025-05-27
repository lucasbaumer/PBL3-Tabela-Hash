public class HashTable03 extends HashTable {
    @Override
    protected int hash(String chave) {
        // Hash baseada em polinômio (exemplo: Horner)
        int hash = 0;
        int p = 31;
        for (int i = 0; i < chave.length(); i++) {
            hash = p * hash + chave.charAt(i);
            hash = hash % tamanho;
        }
        return Math.abs(hash) % tamanho;
    }
}
