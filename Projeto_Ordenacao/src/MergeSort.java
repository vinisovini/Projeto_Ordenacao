public class MergeSort {
    public static void mergeSort(long[] valores) {
        if (valores.length <= 1) {
            return;
        }

        int mid = valores.length / 2;
        long[] left = new long[mid];
        long[] right = new long[valores.length - mid];

        // Preenche as duas sublistas
        for (int i = 0; i < mid; i++) {
            left[i] = valores[i];
        }
        for (int i = mid; i < valores.length; i++) {
            right[i - mid] = valores[i];
        }

        // Chama recursivamente o Merge Sort nas duas sublistas
        mergeSort(left);
        mergeSort(right);

        // Combina as duas sublistas ordenadas
        merge(valores, left, right);
    }

    private static void merge(long[] valores, long[] left, long[] right) {
        int i = 0, j = 0, k = 0;

        // Combina as sublistas em ordem crescente
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                valores[k] = left[i];
                i++;
            } else {
                valores[k] = right[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes da sublista esquerda, se houver
        while (i < left.length) {
            valores[k] = left[i];
            i++;
            k++;
        }

        // Copia os elementos restantes da sublista direita, se houver
        while (j < right.length) {
            valores[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        long[] valores = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array antes da ordenação: ");
        for (long element : valores) {
            System.out.print(element + " ");
        }
        System.out.println();

        long startTime = System.nanoTime();

        mergeSort(valores);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Array após a ordenação: ");
        for (long element : valores) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("Tempo de processamento: " + duration + " nanossegundos");
    }
}