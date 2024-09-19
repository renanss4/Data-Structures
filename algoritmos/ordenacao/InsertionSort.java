package algoritmos.ordenacao;

class OrdenacaoInsertion {
    private int[] arrayParaOrdenar;

    public OrdenacaoInsertion(int[] arrayParaOrdenar) {
        this.arrayParaOrdenar = arrayParaOrdenar;
    }

    public void ordena() {
        // Implementação do Insertion Sort
        int tamanho = arrayParaOrdenar.length;
        for (int i = 1; i < tamanho; i++) {
            int chave = arrayParaOrdenar[i];
            int j = i - 1;

            // Move os elementos maiores que a chave para uma posição à frente
            while (j >= 0 && arrayParaOrdenar[j] > chave) {
                arrayParaOrdenar[j + 1] = arrayParaOrdenar[j];
                j = j - 1;
            }
            arrayParaOrdenar[j + 1] = chave;
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

public class InsertionSort {
    public static void main(String[] args) {
        OrdenacaoInsertion a = new OrdenacaoInsertion(new int[]{2, 4, 5, 4, -2, 0, 1});
        a.ordena();
        System.out.println(a);
    }
}

