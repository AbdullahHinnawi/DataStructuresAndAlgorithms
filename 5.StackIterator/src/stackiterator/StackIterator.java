/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackiterator;

/**
 *
 * @author kamaj
 */
interface Iterator {
    boolean hasNext();
    Object next();
}

public class StackIterator implements Iterator {
    private int  current;
    private Stack container; // container on tietorakenne, jota iteroidaan


    StackIterator (Stack stack) { // konstruktori on "package visible"
        container = stack;
        current = 0;
    }
    // palautetaan tieto siitä, löytyyko rakenteesta seuraava alkio
    // hmm... palautetaan tieto siitä, osoittaako nykypositio (current) alkiota vai ei.
    public boolean hasNext() {
        return container.getStackItem(current)!=null;

    }
    // palautetaan nykyinen (lista-alkio) ja siirretään nykypositiota pykälä eteenpäin
    public ListItem next() {
        int oldCurrent = current;
        current++;
        return container.getStackItem(oldCurrent);
    }

}

