package algoritmos.ordenacao;

class OrdenacaoSelection {
    private int[] arrayParaOrdenar;

    public OrdenacaoSelection(int[] arrayParaOrdenar) {
        this.arrayParaOrdenar = arrayParaOrdenar;
    }

    public void ordena() {
        // Implementação do Selection Sort
        int tamanho = arrayParaOrdenar.length;
        for (int i = 0; i < tamanho - 1; i++) {
            int minIndex = i;

            // Encontra o menor elemento no array não ordenado
            for (int j = i + 1; j < tamanho; j++) {
                if (arrayParaOrdenar[j] < arrayParaOrdenar[minIndex]) {
                    minIndex = j;
                }
            }

            // Troca o menor elemento encontrado com o primeiro elemento não ordenado
            int temp = arrayParaOrdenar[minIndex];
            arrayParaOrdenar[minIndex] = arrayParaOrdenar[i];
            arrayParaOrdenar[i] = temp;
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

public class SelectionSort {
    public static void main(String[] args) {
        OrdenacaoSelection a = new OrdenacaoSelection(new int[]{2, 4, 5, 4, -2, 0, 1});
        a.ordena();
        System.out.println(a);
    }
}
