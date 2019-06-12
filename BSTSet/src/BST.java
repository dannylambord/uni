import java.util.Random;

public class BST {
	public static  Node root;
        public static int averageCompare = 0;
        public static int average;
        



	public BST(){
		this.root = null;
	}
	
       
        
	public boolean find(int id){
		Node current = root;
                int compare = 0;
		while(current!=null){
			if(current.data==id){
                            
                            averageCompare  = averageCompare + compare;
				return true;
			}else if(current.data>id){
				current = current.left;
                                compare++;
			}else{
				current = current.right;
                                compare++;
			}
		}
                
                averageCompare  = averageCompare + compare;
		return false;
	}
	
	public void insert(int id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
        }
	public static void main(String arg[])
        {
	    BST b = new BST();
            Random rand = new Random();
            int amount = 0;
            int averageTree = 0;
            int p = average = averageCompare/1000;
            int a = averageTree/1000;
                
            while (amount < 1000)
            {
                int x = 0;
                int bstAmount = rand.nextInt(9900) + 100;
                int bstNode = rand.nextInt(9900) + 100;
                averageTree = averageTree + bstAmount;

                while(x<bstAmount)
                {
                    int bstValue = rand.nextInt(9900) + 100;
                    b.insert(bstValue);
                    x++;
                }

                b.find(bstNode);
                amount++;
            }
                
            System.out.println(p);
            System.out.println(a);
	}
}

class Node{
	int data;
	Node left;
	Node right;	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}