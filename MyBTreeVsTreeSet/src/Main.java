import java.util.Random;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        final int SIZE = 100000;

        // BinaryTree
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("Filling binaryTree");
        long binaryTreeStart = System.currentTimeMillis();
        for(int i = 0; i< SIZE;){
            // convert double to integer then convert integer to String
            String s = Integer.toString((int)(Math.random()  * 1000000));
            if(binaryTree.find(s) == null){
                binaryTree.insert(s);
                i++;
            }

        }
        binaryTree.inOrder();
        long binaryTreeEnd = System.currentTimeMillis();
        System.out.println("");
        System.out.println("BinaryTree spent: " + (binaryTreeEnd-binaryTreeStart) + " ms");



        // TreeSet
        TreeSet<String> treeSet = new TreeSet<>();
        System.out.println("Filling treeSet");
        long treeSetStart = System.currentTimeMillis();
        for(int i = 0; i< SIZE;){
            // convert double to integer then convert integer to String
            String s = Integer.toString((int)(Math.random()  * 1000000));
            if(!treeSet.contains(s)){
                treeSet.add(s);
                i++;
            }
        }
        for(String n: treeSet){
            System.out.print(n + " ");
        }
        long treeSetEnd = System.currentTimeMillis();
        System.out.println("");
        System.out.println("TreeSet spent: " + (treeSetEnd -treeSetStart) + " ms" );













    }



}


