class Ordenacao {
    private int[] arrayParaOrdenar;

    public Ordenacao(int[] arrayParaOrdenar) {
        this.arrayParaOrdenar = arrayParaOrdenar;
    }

    public void ordena() {
        // Utilizando o algoritmo Bubble Sort conforme apresentado na questão
        int tamanho = arrayParaOrdenar.length;
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - i - 1; j++) {
                if (arrayParaOrdenar[j] > arrayParaOrdenar[j + 1]) {
                    // Troca os elementos se estiverem fora de ordem
                    int temp = arrayParaOrdenar[j];
                    arrayParaOrdenar[j] = arrayParaOrdenar[j + 1];
                    arrayParaOrdenar[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayParaOrdenar.length; i++) {
            sb.append(arrayParaOrdenar[i]);
            if (i < arrayParaOrdenar.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}

public class BubbleSort {
    public static void main(String[] args) {
        Ordenacao a = new Ordenacao(new int[]{2, 4, 5, 4, -2, 0, 1});
        a.ordena();
        System.out.println(a);
    }
}
