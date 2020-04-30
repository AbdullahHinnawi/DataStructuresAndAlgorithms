import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stack {

    private ListItem mTop;
    private int mSize;

    public Stack() {
        mTop = null;
        mSize = 0;
    }


    public void push(double aData) {

        ListItem newItem = new ListItem();
        newItem.setData(aData);
        newItem.setNext(mTop);
        mTop = newItem;
        mSize++;
    }


    public ListItem pop() {

        ListItem poistettu = null;

        if (mSize > 0) {
            poistettu = mTop;
            mTop = mTop.getNext();
            mSize--;
        }

        return poistettu;
    }

    public void printReversedStack() {

        ListItem li = mTop;
        List<String> list = new ArrayList<>();
        StringBuilder reversedStack= new StringBuilder(" ");

        while (li != null){
            list.add(li.getData() + " ");
            li= li.getNext();
        }

        Collections.reverse(list);
        for(String s : list){
            reversedStack.append(s);
        }
        System.out.println(reversedStack);

    }


    public int getSize() {
        return mSize;
    }
}