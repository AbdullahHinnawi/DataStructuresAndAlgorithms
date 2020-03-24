package queueproject;

public class Stack {

    private ListItem top;
    private int size;

    public Stack(){
        top = null;
        size= 0;
    }

    // muodosta uusi lista-alkio ja vie se pinon huipulle
    public void push(String aData){
        ListItem li = new ListItem();
        li.setData(aData);
        li.setNext(top);
        top= li;
        size++;

    }
    // poista ja palauta alkio pinon huipulta,
    // jos pino tyhjä palauta null
    public ListItem pop(){
        if(size>0){
            ListItem helper = top;
            top = top.getNext();
            size--;
            return helper;
        }else
        return null;
    }
    // tulosta pinon sisältö muuttamatta pinoa
    public void printItems() {
        ListItem li = top;
        System.out.print("Pinon sisältö: ");
        while(li != null){
            System.out.print(li.getData() + " ");
            li= li.getNext();
        }
    }
    public int getSize() {
        return size;
    }

}

