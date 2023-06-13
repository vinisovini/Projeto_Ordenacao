public class BubbleSort {
    public static void bubbleSort(long[] valores) {
        long n = valores.length;
        boolean houveTroca;

        for (int i = 0; i < n - 1; i++) {
            houveTroca = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (valores[j] > valores[j + 1]) {
                    long temp = valores[j];
                    valores[j] = valores[j + 1];
                    valores[j + 1] = temp;
                    houveTroca = true;
                }
            }
            // Se nenhum elemento foi trocado durante uma iteração, o array está ordenado
            if (!houveTroca) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        long[] valores = {64, 25, 12, 22, 1164, 215, 112, 222, 111};
        System.out.println("Array antes da ordenação: ");
        for (long element : valores) {
            System.out.print(element + " ");
        }
        System.out.println();

        long startTime = System.nanoTime();

        bubbleSort(valores);

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