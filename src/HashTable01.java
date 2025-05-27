public class HashTable01 extends HashTable {
    @Override
    protected int hash(String chave) {
        // Função hash simples: soma dos códigos dos caracteres
        int hash = 0;
        for (int i = 0; i < chave.length(); i++) {
            hash += chave.charAt(i);
        }
        return Math.abs(hash) % tamanho;
    }

    @Override
    protected int hash2(String chave) {
        // Segunda função hash: valor primo menor que tamanho - (soma dos códigos % primo)
        int hash = 0;
        for (int i = 0; i < chave.length(); i++) {
            hash += chave.charAt(i);
        }
        int primo = 31; // menor que 32
        int step = primo - (Math.abs(hash) % primo);
        return (step == 0) ? 1 : step; // nunca pode ser zero
    }
}

