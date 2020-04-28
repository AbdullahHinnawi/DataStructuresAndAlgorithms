package heap;

public class Heap {

    private int[] arvot;
    private int määrä;
    private int MaxMäärä;

    public Heap(int maxMäärä) {
        this.MaxMäärä = maxMäärä;
        arvot = new int[maxMäärä];
        määrä = 0;
    }

    public void insert(int arvo, int index) {
        if(määrä == MaxMäärä){
            System.out.println("Kasa on täynnä");
        }else {
            if (määrä == 0) {
                arvot[0] = arvo;
                määrä++;
            } else {
                if (arvot[(index - 1) / 2] < arvo) {
                    arvot[index] = arvo;
                    määrä++;
                } else {
                    arvot[index] = arvot[(index - 1) / 2];
                    arvot[(index - 1) / 2] = 0;
                    insert(arvo, (index - 1) / 2);
                }
            }
        }
    }

    public void deleteMinimum(int index) {

        int vasen = (2*index)+1;
        int oikea = (2*index)+2;
        if (vasen < määrä && oikea < määrä) {
            if (arvot[määrä-1]<arvot[vasen]&&arvot[määrä-1]<arvot[oikea]) {
                arvot[index] = arvot[määrä-1];
                arvot[määrä-1] = 0;
                määrä--;
            } else {
                if (arvot[vasen]<arvot[oikea]) {
                    arvot[index] = arvot[vasen];
                    deleteMinimum(vasen);
                } else {
                    arvot[index] = arvot[oikea];
                    deleteMinimum(oikea);
                }
            }
        } else {
            arvot[index] = arvot[määrä-1];
            arvot[määrä-1] = 0;
            määrä--;
        }
    }

    public int getMäärä() {
        return määrä;
    }

    public int[] getArvot() {
        return arvot;
    }

    public int getMinimum(){
        return arvot[0];
    }

    public void printHeap(){
        System.out.println("--------------");
        System.out.println("Pienin numero: " + getMinimum());
        System.out.println("Alkioiden Määrä: " + getMäärä());
        System.out.println("Kasan sisältö: ");
        for(int i: getArvot()){
            if(i!= 0){
                System.out.print(i + "  ");
            }
        }
        System.out.println("\n--------------");

    }
}