import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortComparison {
    public static void main(String[] args) {
        String arquivo;
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o arquivo a ser acessado:");
        System.out.println("1. couting.txt");
        System.out.println("2. num.1000.2.txt");
        System.out.println("3. num.1000.3.txt");
        System.out.println("4. num.1000.4.txt");
        System.out.println("5. num.10000.1.txt");
        System.out.println("6. num.10000.2.txt");
        System.out.println("7. num.10000.3.txt");
        System.out.println("8. num.10000.4.txt");
        System.out.println("9. num.100000.1.txt");
        System.out.println("10. num.100000.2.txt");
        System.out.println("11. num.100000.3.txt");
        System.out.println("12. num.100000.4.txt");

        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.close();

        switch (opcao) {
            case 1:
                arquivo = "couting.txt";
                break;
            case 2:
                arquivo = "num.1000.2.in.txt";
                break;
            case 3:
                arquivo = "num.1000.3.in.txt";
                break;
            case 4:
                arquivo = "num.1000.4.in.txt";
                break;
            case 5:
                arquivo = "num.10000.1.in.txt";
                break;
            case 6:
                arquivo = "num.10000.2.in.txt";
                break;
            case 7:
                arquivo = "num.10000.3.in.txt";
                break;
            case 8:
                arquivo = "num.10000.4.in.txt";
                break;
            case 9:
                arquivo = "num.100000.1.in.txt";
                break;
            case 10:
                arquivo = "num.100000.2.in.txt";
                break;
            case 11:
                arquivo = "num.100000.3.in.txt";
                break;
            case 12:
                arquivo = "num.100000.4.in.txt";
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        long[] valores = lerArray(arquivo);

        System.out.println("Array original: ");
        printArray(valores);

        // Teste do Selection Sort
        long[] valoresSelection = Arrays.copyOf(valores, valores.length);
        long startTimeSelection = System.nanoTime();
        SelectionSort.selectionSort(valoresSelection);
        long endTimeSelection = System.nanoTime();
        long durationSelection = (endTimeSelection - startTimeSelection)/1000;
        
        System.out.println("Tempo de processamento (Selection Sort): " + durationSelection + " microssegundos");

        // Teste do Bubble Sort
        long[] valoresBubble = Arrays.copyOf(valores, valores.length);
        long startTimeBubble = System.nanoTime();
        BubbleSort.bubbleSort(valoresBubble);
        long endTimeBubble = System.nanoTime();
        long durationBubble = (endTimeBubble - startTimeBubble)/1000;
        
        System.out.println("Tempo de processamento (Bubble Sort): " + durationBubble + " microssegundos");

        // Teste do Insertion Sort
        long[] valoresInsertion = Arrays.copyOf(valores, valores.length);
        long startTimeInsertion = System.nanoTime();
        InsertionSort.insertionSort(valoresInsertion);
        long endTimeInsertion = System.nanoTime();
        long durationInsertion = (endTimeInsertion - startTimeInsertion)/1000;
        
        System.out.println("Tempo de processamento (Insertion Sort): " + durationInsertion + " microssegundos");

        // Teste do Merge Sort
        long[] valoresMerge = Arrays.copyOf(valores, valores.length);
        long startTimeMerge = System.nanoTime();
        MergeSort.mergeSort(valoresMerge);
        long endTimeMerge = System.nanoTime();
        long durationMerge = (endTimeMerge - startTimeMerge)/1000;
        
        System.out.println("Tempo de processamento (Merge Sort): " + durationMerge + " microssegundos");

        // Teste do Quick Sort
        long[] valoresQuick = Arrays.copyOf(valores, valores.length);
        long startTimeQuick = System.nanoTime();
        QuickSort.quickSort(valoresQuick, 0, valoresQuick.length - 1);
        long endTimeQuick = System.nanoTime();
        long durationQuick = (endTimeQuick - startTimeQuick)/1000;
        
        System.out.println("Tempo de processamento (Quick Sort): " + durationQuick + " microssegundos");
    }

    private static long[] lerArray(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            List<Long> list = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                long value = Long.parseLong(line);
                list.add(value);
            }
            long[] valores = new long[list.size()];
            for (int i = 0; i < list.size(); i++) {
                valores[i] = list.get(i);
            }
            return valores;
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de texto!");;
        }
        return null;
    }

    private static void printArray(long[] valores) {
        for (long element : valores) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}