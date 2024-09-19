package algoritmos.embaralhamento;

import java.util.Random;

class EmbaralhamentoKnuth {
    private int[] arrayParaEmbaralhar;

    public EmbaralhamentoKnuth(int[] arrayParaEmbaralhar) {
        this.arrayParaEmbaralhar = arrayParaEmbaralhar;
    }

    public void embaralha() {
        // Implementação do algoritmo de Embaralhamento de Knuth
        Random random = new Random();
        int tamanho = arrayParaEmbaralhar.length;

        for (int i = tamanho - 1; i > 0; i--) {
            // Gera um índice aleatório entre 0 e i
            int j = random.nextInt(i + 1);

            // Troca o elemento atual com o elemento aleatório
            int temp = arrayParaEmbaralhar[i];
            arrayParaEmbaralhar[i] = arrayParaEmbaralhar[j];
            arrayParaEmbaralhar[j] = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayParaEmbaralhar.length; i++) {
            sb.append(arrayParaEmbaralhar[i]);
            if (i < arrayParaEmbaralhar.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}

public class KnuthShuffle {
    public static void main(String[] args) {
        EmbaralhamentoKnuth a = new EmbaralhamentoKnuth(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        a.embaralha();
        System.out.println(a);
    }
}
