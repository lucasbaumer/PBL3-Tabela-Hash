import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        java.util.List<String> nomes = FileUtil.readNames("C:\\Users\\Lucas Baumer\\Documents\\Lucas\\FACULDADE\\5periodo\\ProblemasEstr\\PBL03-Tabela-Hash\\src\\female_names.txt");

        HashTable hash01 = new HashTable01();
        HashTable hash02 = new HashTable02();

        long start01 = System.nanoTime();
        for(String nome : nomes) hash01.inserir(nome);
        long insertTime01 = System.nanoTime() - start01;

        long startSearch01 = System.nanoTime();
        for(String nome : nomes) hash01.procurar(nome);
        long searchTime01 = System.nanoTime() - startSearch01;

        long start02 = System.nanoTime();
        for (String nome : nomes) hash02.inserir(nome);
        long insertTime02 = System.nanoTime() - start02;

        long startSearch02 = System.nanoTime();
        for (String nome : nomes) hash02.procurar(nome);
        long searchTime02 = System.nanoTime() - startSearch02;

        System.out.println("===== RELATÓRIO DE COMPARAÇÃO =====");
        printReport("Hash A", hash01, insertTime01, searchTime01);
        printReport("Hash B", hash02, insertTime02, searchTime02);
    }

    private static void printReport(String title, HashTable hash, long insertTime, long searchTime) {
        System.out.println("\n--- " + title + " ---");
        System.out.println("Colisões: " + hash.getColisoes());
        System.out.println("Tempo de inserção (ms): " + insertTime / 1_000_000);
        System.out.println("Tempo de busca (ms): " + searchTime / 1_000_000);
        ListaEncadeada[] table = hash.getTabela();
        System.out.println("Tamanho da tabela hash: " + table.length);
        System.out.println("Distribuição das chaves:");
        for (int i = 0; i < table.length; i++) {
            int qtd = (table[i] != null) ? table[i].quantidade() : 0;
            System.out.println("Posição " + i + ": " + qtd + " itens");
        }
    }
}