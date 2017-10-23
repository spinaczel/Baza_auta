import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class Odczyt {
    public static void main(String args[])throws IOException {
    FileReader fileReader = new FileReader("baza.txt");
    BufferedReader bufferedReader = new BufferedReader (fileReader);

    int iloscLinii = 0;
    String array[] = new String[1];

    System.out.println ("Wyswietlenie bazy samochodów");
    try {
        Thread.sleep (2000);
    } catch (Exception e) {}

    try {
        String textLine = bufferedReader.readLine ();
        do {
            //zczytuje i liczy ilosc linii
            System.out.println((iloscLinii+1)+" "+textLine);
            array[iloscLinii]=textLine;
            textLine = bufferedReader.readLine();
            iloscLinii = iloscLinii+1;
            array = Arrays.copyOf (array, iloscLinii+1);
        } while (textLine !=null);

        array = Arrays.copyOf(array,array.length-1);
    for (int i=0;i<array.length;i++) {
        System.out.println ((i + 1)+" "+  array[i]);
    }
    } finally {
        {
            bufferedReader.close ();
        }
    }

    System.out.println("Podaj pozycję, którą chcesz edytować");
    int numer;
    Scanner scannerOdczyt = new Scanner (System.in);
    numer = scannerOdczyt.nextInt ( );

    while (numer <1 || numer > array.length ) {
        System.out.println("Zły przedział! podaj jeszcze raz");
        numer = scannerOdczyt.nextInt ( );
    }

    System.out.println("Podaj marke i kolor samochodu");

    Scanner scannerOdczyt2 = new Scanner(System.in);
    String auto = scannerOdczyt2.nextLine ();

//zapisanie w tablicy wprowadzonych danych i zapisanie w pliku
    array[numer-1]=auto;

    FileWriter fileWrite = new FileWriter ("baza.txt");
    BufferedWriter bufferedWriter = new BufferedWriter (fileWrite);

    try {
        for (String writer : array){
            bufferedWriter.write(writer);
            bufferedWriter.newLine ();
        }
    } finally {
        bufferedWriter.close ();
    }



    }
}
