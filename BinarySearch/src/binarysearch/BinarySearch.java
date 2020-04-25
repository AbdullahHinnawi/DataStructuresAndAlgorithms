package binarysearch;

public class BinarySearch {

    private int[] numerot;
    private int määrä;

    public BinarySearch() {
        numerot = new int[24];
        määrä = 0;
    }

    public int binaryInsert(int arvo) {
        if (määrä == 0) {
            return 0;
        }

        int min = 0;
        int max = määrä - 1;

        while (true) {
            // Palautetaan kokonaisluku esim. 1/2 = 0
            int index = (max + min) / 2;
            if (min == index) {
                if (numerot[index] > arvo) {
                    return index;
                }
            }
            if (numerot[index] < arvo) {
                min = index + 1;

                if (min > max) {

                    return index + 1;
                }
            } else if (min > max) {

                return index;
            } else {

                max = index - 1;
            }

        }


    }

    public void insert(int numero) {

        if (määrä == 24) {
            System.out.println("taulu on täynnä!");
        } else {
            int index = binaryInsert(numero);
            for (int i = määrä; i > index; i--) {
                numerot[i] = numerot[i-1];
            }
            numerot[index] = numero;
            määrä++;
        }
    }

    public int find(int arvo, int min, int max) {

        if (max >= min) {
            int mid = min + (max-min)/2;

            if (numerot[mid]==arvo) {
                return mid;
            }

            if (numerot[mid]>arvo) {
                return find(arvo, min, mid-1);
            }

            return find(arvo, mid+1, max);

        }
        return -1;
    }

    public int getMaara() {
        return määrä-1;
    }

    public int[] getNumerot() {
        return numerot;
    }

}