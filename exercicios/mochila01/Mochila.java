package exercicios.mochila01;

import java.util.Scanner;

public class Mochila {

    // Classe para armazenar informações sobre cada tipo de item
    static class Item {
        int ui; // utilidade
        int wi; // peso
        int di; // número de itens disponíveis
        int index; // índice do item original

        public Item(int ui, int wi, int di, int index) {
            this.ui = ui;
            this.wi = wi;
            this.di = di;
            this.index = index;
        }

        // Retorna a razão ui/wi
        public double getRatio() {
            return (double) ui / wi;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "ui=" + ui +
                    ", wi=" + wi +
                    ", di=" + di +
                    ", index=" + index +
                    ", ratio=" + getRatio() +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Definindo o tamanho máximo de itens que podem ser inseridos
        int maxItems = 100;  // Supondo que não teremos mais de 100 itens
        Item[] items = new Item[maxItems];
        int itemCount = 0; // Contador para o número real de itens inseridos

        // Leitura dos itens até a linha com "-1 -1 -1"
        System.out.println("Iniciando leitura dos itens:");
        while (true) {
            int ui = scanner.nextInt();
            int wi = scanner.nextInt();
            int di = scanner.nextInt();
            if (ui == -1 && wi == -1 && di == -1) {
                System.out.println("Fim da leitura dos itens.");
                break;
            }
            items[itemCount] = new Item(ui, wi, di, itemCount);
            System.out.println("Lido: " + items[itemCount].toString());
            itemCount++;
        }

        // Leitura da capacidade da mochila
        System.out.println("Capacidade da mochila lida:");
        int capacidade = scanner.nextInt();
        System.out.println("Capacidade da mochila: " + capacidade);

        // Ordena os itens pela razão ui/wi (implementando o algoritmo de ordenação manualmente)
        System.out.println("Iniciando ordenação dos itens pela razão ui/wi:");
        sortItemsByRatio(items, itemCount);

        // Exibindo a ordem dos itens após a ordenação
        System.out.println("Itens após ordenação:");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items[i].toString());
        }

        // Array para armazenar o resultado final (quantidade de cada item na mochila)
        int[] resultado = new int[itemCount];
        int capacidadeRestante = capacidade;

        // Preenche a mochila com os itens na ordem decrescente de razão ui/wi
        System.out.println("Iniciando o preenchimento da mochila:");
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            int maxQuantidade = Math.min(item.di, capacidadeRestante / item.wi);
            resultado[item.index] = maxQuantidade;
            capacidadeRestante -= maxQuantidade * item.wi;
            System.out.println("Adicionando " + maxQuantidade + " itens do tipo " + item.index + " na mochila. Capacidade restante: " + capacidadeRestante);

            // Se a capacidade acabou, encerra o loop
            if (capacidadeRestante == 0) {
                System.out.println("Capacidade da mochila esgotada.");
                break;
            }
        }

        // Exibe o resultado final
        System.out.println("Resultado final (itens na mochila):");
        for (int i = 0; i < itemCount; i++) {
            if (resultado[i] > 0) {
                System.out.println("Item " + i + ": " + resultado[i] + " unidades");
            }
        }

        scanner.close();
    }

    // Implementação manual da ordenação (Bubble Sort) baseada na razão ui/wi
    public static void sortItemsByRatio(Item[] items, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (items[j].getRatio() < items[j + 1].getRatio()) {
                    // Troca os itens de lugar
                    Item temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                    System.out.println("Trocando item " + items[j + 1].index + " com item " + items[j].index);
                }
            }
        }
    }
}
