import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        int array[];
        try{
            String this_path = System.getProperty("user.dir") + "/leitor/";
            
            Scanner leitor_arquivo = new Scanner(new FileReader(this_path + "10000_numbers.txt"));
            while(leitor_arquivo.hasNextLine()) {
                String linha_arquivo = leitor_arquivo.nextLine();
                numeros.add(Integer.valueOf(linha_arquivo));
            }
            array = numeros.stream().mapToInt(i -> i).toArray();
            SelectionSort.printArray(array, 0, array.length);
        }catch(FileNotFoundException e){
            System.out.println("Exceção: " + e);
        }
    }

    int minIndex(int Array[] , int start, int end)
    {
        int minIndex = start;

        for (int i = start+1; i < end; i++) 
        {
            if ( Array[i] < Array[minIndex] ) 
            {
                minIndex = i;    
            }    
        }
        return minIndex;
    }
     int[] sorting(int Array[],int length)
    {
        for (int i = 0; i < length-1; i++) 
        {
                int minI = minIndex(Array, i, length);
                int temp = Array[minI];
                Array[minI] = Array[i];
                Array[i] = temp;
            }
        return Array;
    }

    /**
     * SelectionSort
     */
    public static void printArray(int v[], int inicio, int fim){
            
            int Array[] = v;

            SelectionSort s1 = new SelectionSort();
            long startTime = System.nanoTime();
            int sortedArray[] = s1.sorting(Array, Array.length);
            long endTime = System.nanoTime();

            for (int i = 0; i < Array.length; i++) {
                if(i != Array.length){
                    // System.out.print(", ");
                }
                // System.out.print(sortedArray[i]);
                System.out.println(sortedArray[i]);
            }
            double seconds = (endTime - startTime) * 1e-9;
            // System.out.printf(".\nTempo de execução em segundos: %.9f segundos\n",seconds);
            System.out.printf("Tempo de execução em segundos: %.9f segundos\n",seconds);

        }
}