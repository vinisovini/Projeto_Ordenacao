public class SelectionSort {
    public static void selectionSort(long[] valores) {
        long n = valores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Encontra o menor elemento na sublista não ordenada
            for (int j = i + 1; j < n; j++) {
                if (valores[j] < valores[minIndex]) {
                    minIndex = j;
                }
            }

            // Troca o menor elemento com o primeiro elemento da sublista não ordenada
            long temp = valores[minIndex];
            valores[minIndex] = valores[i];
            valores[i] = temp;
        }
    }

    public static void main(String[] args) {
        long[] valores = {-5,64, 25, 12, 22,-10, 1164, 215, 112, 222, 111};
        System.out.println("Array antes da ordenação: ");
        for (long element : valores) {
            System.out.print(element + " ");
        }
        System.out.println();

        long startTime = System.nanoTime();

        selectionSort(valores);

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