public class QuickSort {
    public static void quickSort(long[] valores, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(valores, low, high);

            // Chama o Quicksort recursivamente para as duas metades
            quickSort(valores, low, partitionIndex - 1);
            quickSort(valores, partitionIndex + 1, high);
        }
    }

    private static int partition(long[] valores, int low, int high) {
        long pivot = valores[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (valores[j] < pivot) {
                i++;
                // Troca valores[i] com valores[j]
                long temp = valores[i];
                valores[i] = valores[j];
                valores[j] = temp;
            }
        }

        // Troca o pivô (valores[high]) com o elemento valores[i+1]
        long temp = valores[i + 1];
        valores[i + 1] = valores[high];
        valores[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        long[] valores = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array antes da ordenação: ");
        for (long element : valores) {
            System.out.print(element + " ");
        }
        System.out.println();

        long startTime = System.nanoTime();

        quickSort(valores, 0, valores.length - 1);

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