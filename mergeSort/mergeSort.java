package mergeSort;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {

  void merge(int array[], int p, int q, int r) {

    int n1 = q - p + 1;
    int n2 = r - q;

    int L[] = new int[n1];
    int M[] = new int[n2];

    for (int i = 0; i < n1; i++)
      L[i] = array[p + i];
    for (int j = 0; j < n2; j++)
      M[j] = array[q + 1 + j];

    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    while (i < n1 && j < n2) {
      if (L[i] <= M[j]) {
        array[k] = L[i];
        i++;
      } else {
        array[k] = M[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      array[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      array[k] = M[j];
      j++;
      k++;
    }
  }

  void mergeSort(int array[], int left, int right) {
    if (left < right) {

      int mid = (left + right) / 2;

      mergeSort(array, left, mid);
      mergeSort(array, mid + 1, right);

      merge(array, left, mid, right);
    }
  }

  public static void printArray(int v[], int inicio, int fim) {

    int[] array = v;

    Main ob = new Main();
    long startTime = System.nanoTime();
    ob.mergeSort(array, 0, array.length - 1);
    long endTime = System.nanoTime();

    System.out.println("Sorted Array:");
    System.out.println(Arrays.toString(array));
    double seconds = (endTime - startTime) * 1e-9;
    System.out.printf("Tempo de execução em segundos: %.9f segundos\n",seconds);
  }

  public static void main(String[] args){
    List<Integer> numeros = new ArrayList<>();
    int array[];
    try{
        String this_path = System.getProperty("user.dir") + "/mergeSort/leitor/";
        
        Scanner leitor_arquivo = new Scanner(new FileReader(this_path + "10000_numbers.txt"));
        while(leitor_arquivo.hasNextLine()) {
            String linha_arquivo = leitor_arquivo.nextLine();
            numeros.add(Integer.valueOf(linha_arquivo));
        }
        array = numeros.stream().mapToInt(i -> i).toArray();
        Main.printArray(array, 0, array.length);
    }catch(FileNotFoundException e){
        System.out.println("Exceção: " + e);
    }
}
}