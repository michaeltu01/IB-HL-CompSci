public class BSTDriver
{
 public static void main(String[] args)
 {
//add 50 24 72 22 37 61 89 53 10 66 
  BST myBST = new BST(50);
  myBST.add(72);
  myBST.add(96);
  myBST.add(107);
  myBST.add(26);
  myBST.add(12);
  myBST.add(11);
  myBST.add(9);
  myBST.add(2);
  myBST.add(10);
  myBST.add(25);
  myBST.add(51);
  myBST.add(16);
  myBST.add(17);
  myBST.add(95);

  System.out.println("Printing the first tree");
  myBST.print();
  System.out.println();

  System.out.println("Data added in normal order");
  System.out.println("InOrder");
  myBST.printInOrder(myBST.getRoot());
  System.out.println("\nPreOrder");
  myBST.printPreOrder(myBST.getRoot());
  System.out.println("\nPostOrder");
  myBST.printPostOrder(myBST.getRoot());
  System.out.println("\nPrint2");
  myBST.printPrint2(myBST.getRoot());
  System.out.println("\nPrint3");
  myBST.printPrint3(myBST.getRoot());
  }
 }