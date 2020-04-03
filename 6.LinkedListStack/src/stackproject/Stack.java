package stackproject;


import java.util.Iterator;
import java.util.LinkedList;

public class Stack {

    private LinkedList<ListItem> list;

    public Stack(){
        list = new LinkedList<>();
    }

    // muodosta uusi lista-alkio ja vie se pinon huipulle
    public void push(String aData){
        ListItem li = new ListItem();
        li.setData(aData);
        list.add(li);

    }
    // poista ja palauta alkio pinon huipulta,
    // jos pino tyhjä palauta null
    public ListItem pop(){
        ListItem takeAway = null;
        if(!list.isEmpty()){
            takeAway = list.getLast();
            list.removeLast();
        }
        return takeAway;


    }
    // tulosta pinon sisältö muuttamatta pinoa
    public void printItems() {
        Iterator<ListItem> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getData() +" ");
        }

    }

    public int getSize() {
        return list.size();
    }

}

