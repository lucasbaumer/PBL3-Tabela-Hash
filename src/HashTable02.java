public class HashTable02 extends HashTable {
    @Override
    protected int hash(String chave) {
        // Função hash simples: multiplicação dos códigos dos caracteres
        int hash = 1;
        for (int i = 0; i < chave.length(); i++) {
            hash *= (chave.charAt(i) + 1); // +1 para evitar multiplicação por zero
            hash = hash % tamanho; // mantém o valor dentro do range
        }
        return Math.abs(hash) % tamanho;
    }

    @Override
    protected int hash2(String chave) {
        // Segunda função hash: valor primo menor que tamanho - (produto dos códigos % primo)
        int hash = 1;
        for (int i = 0; i < chave.length(); i++) {
            hash *= (chave.charAt(i) + 1);
            hash = hash % tamanho;
        }
        int primo = 31; // menor que 32
        int step = primo - (Math.abs(hash) % primo);
        return (step == 0) ? 1 : step; // nunca pode ser zero
    }
}

