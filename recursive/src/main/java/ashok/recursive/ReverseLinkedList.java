package ashok.recursive;

public class ReverseLinkedList {

	static Node head;
	Node tail;
	
	/* Linked list Node*/
    class Node 
    { 
        int data; 
        Node next; 
        Node(int d) {data = d; next = null; } 
    }
    
    private void addNode(int data)
    {
    	if(head == null)
    		head = tail = new Node(data);
    	else
    	{
    		Node newNode= new Node(data);
    		tail.next= newNode;
    		tail= newNode;
    	}
    }
    
    private void print()
    {
    	Node temp = head;
    	while(temp != null)
    	{
    		System.out.print(temp.data+" ");
    		temp= temp.next;
    	}
    }
    
    private void reversePrintWithRecursion(Node head)
    {
    	if(head != null)
    	{
    		//passing next nodes pointer to recursive method.
    		reversePrintWithRecursion(head.next);
    		//printing current nodes data
    		System.out.print(head.data+" ");
    	}
    }
    
    public static void main(String[] args) {
		ReverseLinkedList list= new ReverseLinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(12);
		list.addNode(18);
		
		System.out.println("Printing List as it is:");
		list.print();
		System.out.println();
		
		System.out.println("Printing List in reverse order using recursion:");
		list.reversePrintWithRecursion(head);
	}
}
