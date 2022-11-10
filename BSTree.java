
import static sun.net.www.http.HttpClient.New;




class BSTree {
    
    static class Node {    
        int value; 
        Node left, right; 
          
        Node(int value)
        { 
            this.value = value; 
            left = null; 
            right = null; 
        } 
    } 
  
    void insert(Node node, int value) {
        if (value < node.value) 
        {
            if (node.left != null) 
            {
                insert(node.left, value); 
            }
            else
            {
                System.out.println("Inserted " + value + " to left of " + node.value); 
                node.left = new Node(value); 
            } 
        }
        else{
          if (node.right != null) 
          {
              insert(node.right, value);
          }
          else 
          {
            System.out.println("Inserted " + value + " to right of "+ node.value);
            node.right = new Node(value);
          }
        }
      }
    
    
    
    void preorder(Node node) 
    {
        if(node == null) 
        {
            return;
        }
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }
    
    
    
    
    void inorder(Node node) 
    {
        if(node == null) 
        {
            return;
        }

        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }
    
    
    void postorder(Node node) 
    {
        if(node == null)
        {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value+ " ");
  }
    
    
    
    
    
    
    
    
    
     Node delete(Node root, int value) 
    {
        if(root == null) return root;
        if(value > root.value){ 
            root.right = delete(root.right, value);
        }
        else if(value < root.value)
        { 
            root.left = delete(root.left, value);
        }
        else
        { 
            if(root.left == null && root.right == null){ 
                root = null;
            }
            else if(root.right != null)
            { 
                root.value = successor(root); 
                root.right = delete(root.right, root.value);
            }
            else
            {
                root.value = predecessor(root);
                root.left = delete(root.left, root.value);
            }
        }
        return root;
    }
    private int successor(Node root)
    {
        root = root.right;
        while(root.left != null)
        {
            root = root.left;
        }
        return root.value;
    }
    private int predecessor(Node root)
    {
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.value;
    }

    
    
  
  


    public static void main(String[] args) 
    {
        BSTree baketEtoPa = new BSTree();
        Node root = new Node(7);
        baketEtoPa.insert(root, 2);
        baketEtoPa.insert(root, 1);
        baketEtoPa.insert(root, 10);
        baketEtoPa.insert(root, 9);
        baketEtoPa.insert(root, 4);
        baketEtoPa.insert(root, 6);
        baketEtoPa.insert(root, 13);
        baketEtoPa.insert(root, 14);
        baketEtoPa.insert(root, 12);
        baketEtoPa.insert(root, 3);
    
    
        System.out.println();
        System.out.println();
        baketEtoPa.preorder(root);
        System.out.println();
        System.out.println();
        baketEtoPa.inorder(root);
        System.out.println();
        System.out.println();
        baketEtoPa.postorder(root);
        
        
        
        baketEtoPa.delete(root, 4);
        
        
        
        
        System.out.println();
        System.out.println();
        baketEtoPa.preorder(root);
        
    }

}