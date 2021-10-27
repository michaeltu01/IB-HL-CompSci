
public class BST
{
 private TreeNode root;

 public BST()
 {
  root = new TreeNode(null);
 }

 public BST(Comparable initValue)
 {
  root = new TreeNode(initValue);
 }

 public void add(Comparable newObj)
 {
  TreeNode newNode = new TreeNode(newObj);
  if(root == null)
  {
   root = newNode;
  }
  else
  {
   addNode(root, newNode);
  }
 }

 private void addNode(TreeNode curr, TreeNode newNode)
 {
  int comp = newNode.getValue().compareTo(curr.getValue());

  if(comp < 0)
  {
   if(curr.getLeft() == null)
   {
    curr.setLeft(newNode);
   }
   else
   {
    addNode(curr.getLeft(), newNode);
   }
  }
  if(comp > 0)
  {
   if(curr.getRight() == null)
   {
    curr.setRight(newNode);
   }
   else
   {
    addNode(curr.getRight(), newNode);
   }
  }
 }

 public TreeNode getRoot()
 {
  return root;
 }
 
 public void print()
 {
   if(root != null)
     printNodes(root);
 }
 
 private void printNodes(TreeNode node)
 {
   if(node.getLeft()!= null)
     printNodes(node.getLeft());
   System.out.println(node.getValue());
   if(node.getRight()!= null)
     printNodes(node.getRight()); 
 }
 
                      

 public void printInOrder(TreeNode curr)
 {
  if (curr.getLeft() != null)
  {
   printInOrder(curr.getLeft());
  }
  System.out.println(curr.getValue());
  if (curr.getRight() != null)
  {
   printInOrder(curr.getRight());
  }
 }

 public void printPreOrder(TreeNode curr)
 {
  System.out.println(curr.getValue());
  if (curr.getLeft() != null)
  {
   printPreOrder(curr.getLeft());
  }
  if (curr.getRight() != null)
  {
   printPreOrder(curr.getRight());
  }
 }

 public void printPostOrder(TreeNode curr)
 {
  if (curr.getLeft() != null)
  {
   printPostOrder(curr.getLeft());
  }
  if (curr.getRight() != null)
  {
   printPostOrder(curr.getRight());
  }
  System.out.println(curr.getValue());
 }
 public void printPrint2(TreeNode curr)
 {
  if (curr.getRight() != null)
  {
   printPrint2(curr.getRight());
  }
  System.out.println(curr.getValue());
  if (curr.getLeft() != null)
  {
   printPrint2(curr.getLeft());
  }
 }
 public void printPrint3(TreeNode curr)
 {
  if (curr.getRight() != null)
  {
   printPrint3(curr.getRight());
  }
  if (curr.getLeft() != null)
  {
   printPrint3(curr.getLeft());
  }
  System.out.println(curr.getValue());
 }
}