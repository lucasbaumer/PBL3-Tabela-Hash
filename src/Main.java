import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] nomes = FileUtil.readNamesArray("./src/female_names.txt");

        HashTable hash01 = new HashTable01();
        HashTable hash02 = new HashTable02();

        long start01 = System.nanoTime();
        for (String nome : nomes) hash01.inserir(nome);
        long insertTime01 = System.nanoTime() - start01;

        long startSearch01 = System.nanoTime();
        for (String nome : nomes) hash01.procurar(nome);
        long searchTime01 = System.nanoTime() - startSearch01;

        long start02 = System.nanoTime();
        for (String nome : nomes) hash02.inserir(nome);
        long insertTime02 = System.nanoTime() - start02;

        long startSearch02 = System.nanoTime();
        for (String nome : nomes) hash02.procurar(nome);
        long searchTime02 = System.nanoTime() - startSearch02;

        System.out.println("===== RELATÓRIO DE COMPARAÇÃO =====");
        printReport("HashTable01", hash01, insertTime01, searchTime01);
        printReport("HashTable02", hash02, insertTime02, searchTime02);
    }

    private static void printReport(String title, HashTable hash, long insertTime, long searchTime) {
        System.out.println("\n--- " + title + " ---");
        System.out.println("Colisões totais: " + hash.getColisoes());
        System.out.println("Tempo total de inserção (ms): " + insertTime / 1_000_000);
        System.out.println("Tempo total de busca (ms): " + searchTime / 1_000_000);
        var table = hash.getTabela();
        System.out.println("Tamanho da tabela hash: " + table.length);
        System.out.println("Distribuição das chaves (agrupada a cada 100 posições):");
        int grupo = 100;
        for (int i = 0; i < table.length; i += grupo) {
            int soma = 0;
            for (int j = i; j < i + grupo && j < table.length; j++) {
                soma += (table[j] != null) ? ((ListaEncadeada) table[j]).quantidade() : 0;
            }
            if (soma > 0) {
                System.out.println("Posições " + i + "-" + Math.min(i + grupo - 1, table.length - 1) + ": " + soma + (soma == 1 ? " item" : " itens"));
            }
        }
        System.out.println("Colisões por grupo (clusterização, a cada 100 posições):");
        for (int i = 0; i < table.length; i += grupo) {
            int colisoesGrupo = 0;
            for (int j = i; j < i + grupo && j < table.length; j++) {
                int qtd = (table[j] != null) ? ((ListaEncadeada) table[j]).quantidade() : 0;
                if (qtd > 1) colisoesGrupo += (qtd - 1);
            }
            if (colisoesGrupo > 0) {
                System.out.println("Posições " + i + "-" + Math.min(i + grupo - 1, table.length - 1) + ": " + colisoesGrupo + " colisões");
            }
        }
    }
}