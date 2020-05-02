package treeset;

import java.util.Iterator;
import java.util.TreeSet;

public class Menu {
    //main alkaa-----------------------------------------------------------------------------
    public static void main(String[] args) {

        printMenu();

    }

    //main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
    private static void printMenu() {
        char select;
        TreeSet<Integer> treeSet = new TreeSet<>();
        String data;
        do {

            System.out.println("\n\t\t\t1. Lisää avain.");
            System.out.println("\t\t\t2. Etsi avaimella.");
            System.out.println("\t\t\t3. Poista solmu.");
            System.out.println("\t\t\t4. Käy puu läpi sisäjärjestyksessä (in-order traversal).");
            System.out.println("\t\t\t0. lopetus ");
            System.out.print("\n\n"); // tehdään tyhjiä rivejä
            select = Lue.merkki();
            switch (select) {
                case '1':
                    System.out.println("Anna uusi avain");
                    data = Lue.rivi();
                    treeSet.add(Integer.valueOf(data));
                    System.out.println("Avain lisätty");
                    break;
                case '2':
                    System.out.println("Anna etsittävä avain (merkkijono)");
                    data = Lue.rivi();
                    if (treeSet.contains(Integer.valueOf(data))) {
                        System.out.println("Avain löytyi.");
                    } else
                        System.out.println("Avainta ei löytynyt.");

                    break;
                case '3':
                    data = Lue.rivi();
                    if (treeSet.contains(Integer.valueOf(data))) {
                        treeSet.remove(Integer.valueOf(data));
                        System.out.println("Avain poistettu");
                    } else
                        System.out.println("Avainta ei löytynyt.");
                    break;
                case '4':
                    System.out.println("puu sisäjärjestyksessä: ");
                    Iterator<Integer> iterator = treeSet.iterator();
                    while(iterator.hasNext()){
                        System.out.println(iterator.next() + " ");
                    }
                    char h3 = Lue.merkki();
                    break;

            }
        }
        while (select != '0');
    }
//printMenu loppuu ----------------------------------------------------------------
}

