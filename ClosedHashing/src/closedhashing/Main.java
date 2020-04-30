package closedhashing;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ClosedHashing closedHashing =  new ClosedHashing();
        int input;

        do{
            System.out.println("1. Lisää luku.");
            System.out.println("2. Etsi luku");
            System.out.println("0. Lopeta.");
            Scanner in = new Scanner(System.in);
            input = in.nextInt();
            in.nextLine();

            switch(input) {
                case 1:
                    System.out.println("Anna luku.");
                    input = in.nextInt();
                    in.nextLine();
                    closedHashing.insert(input);
                    closedHashing.print();
                    break;
                case 2:
                    System.out.println("Anna etsittävä luku.");
                    input = in.nextInt();
                    in.nextLine();
                    if(closedHashing.find(input) != -1) {
                        System.out.println("luku " + closedHashing.find(input) + " löydy\n");
                    }else{
                        System.out.println("luku " + input+ " ei löytynyt\n");
                    }
                    break;
            }
        }while (input!= 0);
    }

}
