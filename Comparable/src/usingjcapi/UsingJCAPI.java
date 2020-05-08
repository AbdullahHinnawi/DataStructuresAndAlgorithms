/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingjcapi;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author kamaj
 */
public class UsingJCAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<TrafficCard> cardUsers = new ArrayList<TrafficCard>();
        RandomString rString = new RandomString(10);
        float genBalance;
        TrafficCard myCard;
        Random r = new Random();
        int i;
        for (i = 0; i < 10; i++) {
            genBalance = ((float) r.nextInt(1000) / 10);
            myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
            cardUsers.add(myCard);
        }
        System.out.println("Travel cards without sorting:");
        Iterator itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("");

        // Sort travel cards by number using TrafficCard compareTo(Object o) method
        System.out.println("Travel cards sorted by number: ");
        Collections.sort(cardUsers);
        Iterator itr2 = cardUsers.iterator();
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }
        System.out.println("");


        // Sort travel cards by balance using BalanceComparator.java
        System.out.println("Travel cards sorted by balance: ");
        Collections.sort(cardUsers, new BalanceComparator());
        Iterator itr3 = cardUsers.iterator();
        while (itr3.hasNext()) {
            System.out.println(itr3.next());
        }
        System.out.println("");


        // Sort travel cards by name using NameComparator.java
        System.out.println("Travel cards sorted by name: ");
        Collections.sort(cardUsers, new NameComparator());
        Iterator itr4 = cardUsers.iterator();
        while (itr4.hasNext()) {
            System.out.println(itr4.next());
        }






    }
    
}
