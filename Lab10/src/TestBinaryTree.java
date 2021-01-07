import java.util.Iterator;

/** Class containing a main program to test the
  * LinkedBinaryTree class.  The test tree constructed
  * in this program looks like this:

  *              6

  *            /   \

  *           4     8

  *          / \   / \

  *         2   5 7  10

  *        / \       /

  *       1   3     9

  * 
  * @author CS1027
  */

public class TestBinaryTree {  

  public static void main (String[] args) {

    LinkedBinaryTree<Integer> leftTree;
    LinkedBinaryTree<Integer> rightTree;
    LinkedBinaryTree<Integer> tree;    

    // construct the left subtree of the binary tree

    LinkedBinaryTree<Integer> t1 = new LinkedBinaryTree<Integer>(1);
    LinkedBinaryTree<Integer> t2 = new LinkedBinaryTree<Integer>(3);
    LinkedBinaryTree<Integer> t3 = new LinkedBinaryTree<Integer>(2,t1,t2);
    t1 = new LinkedBinaryTree<Integer>(5);
    leftTree = new LinkedBinaryTree<Integer>(4,t3,t1);    

    // construct the right subtree of the binary tree

    t1 = new LinkedBinaryTree<Integer>(9);
    t2 = new LinkedBinaryTree<Integer>(10,t1,null);
    t3 = new LinkedBinaryTree<Integer>(7);
    rightTree = new LinkedBinaryTree<Integer>(8,t3,t2);    

    // add the root node

    tree = new LinkedBinaryTree<Integer>(6, leftTree, rightTree);    

    // Test isEmpty

    if (tree.isEmpty()) 
      System.out.println("Test 1 failed.");
    else
      System.out.println("Test 1 passed.");

	 // Test size
    try {
    	if (tree.size(tree.getRoot()) != 10)    
    		System.out.println("Test 2 failed.");
    	else
    		System.out.println("Test 2 passed.");
    }
    catch (Exception e) {
    	System.out.println("Test 2 failed.");
    }
    
    // Check whether the tree contains the element 9

    try {
    	if (tree.contains(tree.getRoot(),9))
    		System.out.println("Test 3 passed.");
    	else
    		System.out.println("Test 3 failed.");
    }
    catch (Exception e) {
    	System.out.println("Test 3 failed.");   	
    }
    
    // Test preorder traversal

    Iterator<Integer> it = tree.iteratorPreOrder();
    int i = 0;
    Integer v;
    boolean testPassed = true;
    int[] res = {6,4,2,1,3,5,8,7,10,9};
    try {
    while(it.hasNext()) {
      v = it.next();
      if (!v.equals(res[i])) testPassed = false;
      ++i;
    }
    }
    catch (Exception e) {
    	testPassed = false;
    }
    if (testPassed) System.out.println("Test 4 passed.");
    else System.out.println("Test 4 failed.");

    // Test postorder traversal

    it = tree.iteratorPostOrder();
    i = 0;
    testPassed = true;
    int[] res1 = {1,3,2,5,4,7,9,10,8,6};
    try {
    	while(it.hasNext()) {
    		v = it.next();
    		if (!v.equals(res1[i])) testPassed = false;
    		++i;
    	}
    }
    catch (Exception e) {
    	testPassed = false;
    }
    if (testPassed) System.out.println("Test 5 passed.");
    else System.out.println("Test 5 failed.");

    // Test level order traversal

    it = tree.iteratorLevelOrder();
    i = 0;
    testPassed = true;
    int[] res2 = {6,4,8,2,5,7,10,1,3,9};
    try {
    	while(it.hasNext()) {
    		v = it.next();
    		if (!v.equals(res2[i])) testPassed = false;
    		++i;
    	}
    }
    catch (Exception e) {
    	testPassed = false;
    }
    if (testPassed) System.out.println("Test 6 passed.");
    else System.out.println("Test 6 failed.");    
  }
}