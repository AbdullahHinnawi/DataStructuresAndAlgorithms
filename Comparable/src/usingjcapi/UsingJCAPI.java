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
        Iterator itr;
        int i;
        for (i = 0; i < 10; i++) {
            genBalance = ((float) r.nextInt(1000) / 10);
            myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
            cardUsers.add(myCard);
        }
        System.out.println("Travel cards without sorting:");
        itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("");

        // Sort travel cards by number using TrafficCard compareTo(Object o) method
        System.out.println("Travel cards sorted by number: ");
        Collections.sort(cardUsers);
        itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("");


        // Sort travel cards by balance using BalanceComparator.java
        System.out.println("Travel cards sorted by balance: ");
        Collections.sort(cardUsers, new BalanceComparator());
        itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("");


        // Sort travel cards by name using NameComparator.java
        System.out.println("Travel cards sorted by name: ");
        Collections.sort(cardUsers, new NameComparator());
        itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("");


        // Tehtävä 21
        // Sort travel cards by number using Lambda
        Collections.sort(cardUsers, (o1,o2) -> (int)(o1.mTravellerNumber - o2.mTravellerNumber));
        System.out.println("Travel cards sorted by number using Lambda: ");
        itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("");



        // Tehtävä 22 Lambda-lausekkeen käyttö tietovirran yhteydessä
        System.out.println("Travel cards sorted by number >= 25 and balance > 30: ");
        cardUsers.stream()
                .filter(trafficCard -> trafficCard.mTravellerNumber >= 25)
                .filter(trafficCard -> trafficCard.mBalance > 30)
                .forEach(e -> System.out.println(e.toString()));
    }
    
}
