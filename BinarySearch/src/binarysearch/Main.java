package binarysearch;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch();
        int input;

        int[] numerot = {3, 8, 40, -2, 50, -33, 80};
        for(int i : numerot){
            binarySearch.insert(i);
        }


        do{
            System.out.println("1. Lisää numero.");
            System.out.println("2. Etsi numeron indexi.");
            System.out.println("3. Tulosta numerot.");
            System.out.println("0. Lopeta.");
            Scanner in = new Scanner(System.in);
            input = in.nextInt();
            in.nextLine();

            switch(input) {
                case 1:
                    System.out.println("Anna numero.");
                    input = in.nextInt();
                    in.nextLine();
                    binarySearch.insert(input);
                    System.out.println("--------");
                    for (int i : binarySearch.getNumerot()) {
                        if (i!=0) {
                            System.out.println(i);
                        }
                    }
                    System.out.println("--------");
                    break;
                case 2:
                    System.out.println("Anna etsittävä numero.");
                    input = in.nextInt();
                    in.nextLine();
                    System.out.println("Numeron indexi: "+binarySearch.find(input, 0, binarySearch.getMaara()));
                    break;
                case 3:
                    System.out.println("Numerot suuruusjärjestyksessä:");
                    for (int i : binarySearch.getNumerot()) {
                        if (i!=0) {
                            System.out.println(i);
                        }

                    }
                    System.out.println("---------");
                    break;
            }
        }while (input!= 0);
    }

}