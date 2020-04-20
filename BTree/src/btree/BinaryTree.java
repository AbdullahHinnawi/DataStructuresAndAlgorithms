/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package btree;

/**
 *
 * @author kamaj
 */
public class BinaryTree {

    private Node root;
    
    public BinaryTree(String rootValue) {

        root = new Node(rootValue);
    }
    public BinaryTree(){

        root = null;
    }
    /*public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
        root = new Node(rootValue, left, right);
    } */
    
    public void insert(String aData){

        if(root == null){
            root = new Node(aData);
        }else{
            // compareTo: Compares two strings lexicographically.
            // lexicographic = lexicographical order = dictionary order = alphabetical order
            // lexicographic is a generalization of the way words are alphabetically ordered based on
            // the alphabetical order of their component letters.
            // compareTo method returns:
            // 0 if first string is lexicographically equal to second string.
            // positive number if first string is lexicographically greater than second string.
            // negative number if first string is lexicographically less than second string.
            int compare = root.getData().compareTo(aData);

           if(compare > 0){

               if(root.left()== null) {
                   root.setLeft(new BinaryTree(aData));
                   System.out.println(aData + " tallennettu " + root.getData() + " väsemmälle.");
               }else{
                   root.left().insert(aData);
               }

           }else if(compare < 0){
                   if(root.right()== null) {
                       root.setRight(new BinaryTree(aData));
                       System.out.println(aData + " tallennettu " + root.getData() + " oikealle.");
                   }else{
                       root.right().insert(aData);
                   }



           }
        }
        
    }
    
    public BinaryTree find(String aData){

        if(root != null){
            if(root.getData().equals(aData)){
                return this;
            }else{
                int compare = root.getData().compareTo(aData);
                if(compare > 0 && root.left() != null){
                    return root.left().find(aData);
                }else if(compare < 0 && root.right() != null){
                    return root.right().find(aData);
                }

            }

        }

        return null;

    }
    public void preOrder() {
        if (root != null) {
            System.out.println(root.getData()+',');
            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().preOrder();
            if (root.right() != null) // pääseekö oikealle?
                root.right().preOrder();
        }

    }

    public void postOrder() {
        if (root != null) {
            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().postOrder();
            if (root.right() != null) // pääseekö oikealle?
                root.right().postOrder();
            System.out.println(root.getData()+',');
        }

    }

    public void inOrder() {
        if (root != null) {

            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().inOrder();
            System.out.println(root.getData()+',');
            if (root.right() != null) // pääseekö oikealle?
                root.right().inOrder();
        }

    }

    /*
    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }

     */
}
