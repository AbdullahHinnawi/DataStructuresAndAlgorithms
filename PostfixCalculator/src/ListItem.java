public class ListItem {

    private double mData;
    private ListItem mNext;

    public ListItem() {
        mNext = null; // taitaa olla oletusarvo
    }

    public double getData() {
        return mData;
    }
    public void setData(double mData) {
        this.mData = mData;
    }
    public ListItem getNext() {
        return mNext;
    }
    public void setNext(ListItem mNext) {
        this.mNext = mNext;
    }



}
