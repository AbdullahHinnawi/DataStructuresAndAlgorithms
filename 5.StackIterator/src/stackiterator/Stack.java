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
public class Stack {


        private ListItem[] stackItems;
        private int size;

        public Stack() {
                stackItems = new ListItem[100];
                size= 0;

        }
        //  palautetaan pino-iteraattori
        public StackIterator iterator() {

                return new StackIterator(this);
        }
        // muodostetaan uusi alkio ja viedään se huipulle
        public void push(String aData) {
                ListItem newItem = new ListItem(); // luodaan uusi lista-alkio
                newItem.setData(aData);
                stackItems[size] = newItem;
                size++;

        }
        // poistetaan alkio pinon huipulta, jos pinossa ei alkioita palautetaan null
        public ListItem pop() {
                ListItem takeAway = null;
                for(int i = stackItems.length-1 ;i>= 0; i--){
                        if(stackItems[i]!= null){
                                takeAway = stackItems[i];
                                stackItems[i]= null;
                                size--;
                                break;
                        }
                }
                return takeAway;
        }
        // palautetaan pinottujen alkioiden lukumäärä
        public int getSize() {
                return size;
        }

        // listataan sisältö
        public void printItems() {
                for(int i = 0; i< stackItems.length; i++){
                        if(stackItems[i]!= null)
                        System.out.print(stackItems[i].getData() + " ");

                }
        }
        public ListItem getStackItem(int index){
                return stackItems[index];
        }

}

