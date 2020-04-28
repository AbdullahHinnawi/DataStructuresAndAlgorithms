package heap;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Heap heap =  new Heap(10);
        int input;

        int[] numerot = {30, 8, 2, 50, 20, 44, 5};
        for(int i : numerot){
            heap.insert(i, heap.getMäärä());
        }

        do{
            System.out.println("1. Lisää numero.");
            System.out.println("2. Poista pienin numero.");
            System.out.println("3. Tulosta kasan sisältö.");
            System.out.println("0. Lopeta.");
            Scanner in = new Scanner(System.in);
            input = in.nextInt();
            in.nextLine();

            switch(input) {
                case 1:
                    System.out.println("Anna numero.");
                    input = in.nextInt();
                    in.nextLine();
                    heap.insert(input, heap.getMäärä());
                    heap.printHeap();
                    break;
                case 2:
                    int minimum = heap.getMinimum();
                    heap.deleteMinimum(0);
                    System.out.println("Pienin numero " + minimum + " poistettu!");
                    heap.printHeap();
                    break;
                case 3:
                   heap.printHeap();
                   break;
            }
        }while (input!= 0);
    }

}
