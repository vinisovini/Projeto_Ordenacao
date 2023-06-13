public class InsertionSort {
    public static void insertionSort(long[] valores) {
        long n = valores.length;

        for (int i = 1; i < n; i++) {
            long key = valores[i];
            int j = i - 1;

            // Move os elementos maiores que a chave para a direita
            while (j >= 0 && valores[j] > key) {
                valores[j + 1] = valores[j];
                j--;
            }

            valores[j + 1] = key;
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

        insertionSort(valores);

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