package queueproject;

public class Queue {

    private ListItem head;
    private ListItem tail;
    private int size;

    public Queue(){
        head = null;
        tail= null;
        size = 0;
    }

    public void push(String aData){
        ListItem li = new ListItem();
        li.setData(aData);
        if(size == 0){
            head= li;
        }else{
            tail.setNext(li);
            System.out.println(" tail next : " + tail.getNext().getData());
        }
        tail=li;
        size++;
        System.out.println("head : " + head.getData() + " tail : " + tail.getData() );

    }
    public ListItem pop(){
        if(size> 0){
        ListItem helper = head;
        head= head.getNext();
        size--;
        return helper;
        }else{
            return  null;
        }

    }
    public void printItems(){
        ListItem li = head;
        System.out.print("Jonon sisältö: ");
        while(li != null){
            System.out.print(li.getData() + " ");
            li= li.getNext();
        }
    }

    public int getSize(){
        return size;
    }
}
