/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package btree;

/**
 *
 * @author Abdullah Hinnawi
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

        int height;
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

    public void delete(String aData) {

        if(find(aData) == null){
            System.out.println("Not found!!!");
        }else {

            int compare = aData.compareTo(root.getData());
            if (compare < 0) {
                root.left().delete(aData);
            } else if (compare > 0) {
                root.right().delete(aData);
            } else {

                // if nodeToBeDeleted do not have child (Leaf node)
                if (root.left() == null && root.right() == null) {
                    root = null;
                    System.out.println(aData + " node has no subtrees, deleted successfully!");
                }
                // if nodeToBeDeleted has only left child
                else if (root.left() != null && root.right() == null) {
                    root = root.left().getRoot();
                    System.out.println(aData + " node has a subtree to the left, deleted successfully");

                }
                // if nodeToBeDeleted has only right child
                else if (root.left() == null && root.right() != null) {
                    root = root.right().getRoot();
                    System.out.println(aData + " node has a subtree to the right, deleted successfully");

                }
                // if nodeToBeDeleted have both children
                else {
                    System.out.println("Node has subtrees to the left and right");
                    //we need to connect parent of node to the leftmost node(minimum) of right sub tree
                    // or rightmost node(maximum) of left subtree.
                    Node temp = root;
                    System.out.println("Temp " + temp.getData());
                    // Finding minimum element from right
                    Node minNode = temp.right().getMinimumNode();
                    System.out.println("minNode " + minNode.getData());
                    // Replacing current node with minimum node from right subtree
                    root = new Node(minNode.getData());
                    System.out.println("Replaced, root now is :  " + root.getData());
                    // set minimum node's left binary tree
                    root.setLeft(temp.left());
                   System.out.println("root.left " + root.left().root.getData());
                    // set minimum node's right binary tree
                    root.setRight(temp.right());
                   System.out.println("root.right " + root.right().root.getData());
                    // Deleting minimum node from right
                    root.right().delete(root.getData());
                    System.out.println("minimum node from right " + root.getData() + " deleted!");

                }

            }
            // Check if there is references to empty binary trees.
            if (root != null) {
                if (root.left() != null) {
                    if (root.left().root == null) {
                        root.setLeft(null);
                    }
                }
                if (root.right() != null) {
                    if (root.right().root == null) {
                        root.setRight(null);
                    }
                }
            }

        }

    }
    // Get minimum node (element) in binary search tree
    public Node getMinimumNode(){

        if(root.left()!=null){
            return root.left().getMinimumNode();
        }
        return root;

    }

    // To get the height of a tree
    public int maxHeight(BinaryTree tree){
        if(tree != null){
            int leftHeight = maxHeight(tree.getRoot().left());
            int rightHeight = maxHeight(tree.getRoot().right());
            if(leftHeight > rightHeight){
                return leftHeight+1;
            }else{
                return rightHeight+1;
            }
        }
        return 0;
    }

    public void preOrder() {
        if (root != null) {
            System.out.println(root.getData()+ ", solmusta avautuvan alipuun korkeus on " + (maxHeight(find(root.getData()))-1));
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
            System.out.println(root.getData()+ ", solmusta avautuvan alipuun korkeus on " + (maxHeight(find(root.getData()))-1));
        }

    }

    public void inOrder() {
        if (root != null) {

            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().inOrder();
            System.out.println(root.getData()+ ", solmusta avautuvan alipuun korkeus on " + (maxHeight(find(root.getData()))-1));
            if (root.right() != null) // pääseekö oikealle?
                root.right().inOrder();
        }

    }
    public Node getRoot(){
        return root;
    }

    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }

    public void setRoot(Node root){
        this.root = root;
    }
    public BinaryTree getRight(){
        return root.right();
    }
    public BinaryTree getLeft(){
        return root.left();
    }
}
