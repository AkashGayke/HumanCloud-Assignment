import java.util.Scanner;

public class MyLinkedList 
{
	// |data|link| <-- Node
	static Scanner sc = new Scanner(System.in);
	
	private Node head;
	private Node tail;
	private int size;
	
	public MyLinkedList() {
		this.size = 0;
	}
	
	private static class Node // inner node class
	{
		private int data;
		private Node next;
		
		Node(int data)
		{
			this.data = data;
		}
		
		public Node(int data, Node next) 
		{
			this.data = data;
			this.next = next;
		}
	}
	
	// inserting a node
	public void add()
	{
		System.out.println("Enter the data: ");
		int data = sc.nextInt();
		
		Node insert = new Node(data);
		
		if(head == null)
		{
			head = insert;
			return;		
		}
		
		Node temp = head; // traversing the list
		
		while(temp.next != null)
		{
			temp = temp.next;
		}
		
		temp.next = insert;
	}
	
	public void addFirst()
	{
		System.out.println("Enter the data: ");
		int data = sc.nextInt();
		
		Node node = new Node(data); // create a new node
		
		node.next = head;
		head = node;
		
		if(tail == null) {
			tail = head; // head and tail pointing to same node
		}
		
		size++;
	}
	
	public void addLast()
	{
		if(head == null)
		{
			System.out.println("LinkedList is empty...");
		}
		else
		{
			System.out.println("Enter the data: ");
			int data = sc.nextInt();
			
			Node node = new Node(data);
			
			Node temp = head;
			
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = node;
			
			size++;
		}
	}
	
	public void insertAtindex()
	{
		if(head == null)
		{
			System.out.println("\nLinkedList is empty...");
		}
		
		System.out.println("Enter the data: ");
		int data = sc.nextInt();
		
		System.out.println("Enter the index[index starts from 0]: ");
		int index = sc.nextInt();
		
		if(index == 0) 
		{
			addFirst();
			return;
		}
		
		if(index == size)
		{
			addLast();
			return;
		}
		
		Node temp = head;
		
		for(int i=1; i<index; i++)
		{
			temp = temp.next;
		}
		
		Node node = new Node(data, temp.next);
		
		temp.next = node;
		
		size++;
		
		System.out.println("\nData "+data+" is inserted at "+index+" position");
	}
	
	public void removeAtindex()
	{	
		if(head == null)
		{
			System.out.println("\nLinkedList is empty...");
		}
		else
		{
			System.out.println("Enter the index(index starts from 0): ");
			int index = sc.nextInt();
			
			if(index==0)
			{
				head = head.next;
			}
			else
			{
				Node n = head;
				Node n1 = null;
				
				for(int i=0;i<index-1;i++)
				{
					n = n.next;
				}
				n1 = n.next;
				n.next = n1.next;
				
				System.out.println("\n Element "+n1.data+" Removed");
			}
		}
	}
	
	public int deleteFirst()
	{
		int val = head.data;
		head = head.next;
		
		if(head == null)
		{
			tail = null;
		}
		
		size--;
		
		return val;
	}
	
	public int deleteLast()
	{
		if(size <= 1)
		{
			return deleteFirst();
		}
		
		Node secondLast = get(size-2);
		
		int val = tail.data;
		
		tail = secondLast;
		tail.next = null;
		
		return val;
	}
	
	public Node get(int index)
	{
		/*
		 * System.out.println("Enter the index: "); int index = sc.nextInt();
		 */
		
		Node node = head;
		
		for(int i=0; i<index; i++)
		{
			node = node.next;
		}
		
		return node;
	}
	
	// delete particular index
	public int delete()
	{
		System.out.println("Enter the index: "); 
		int index = sc.nextInt();
		
		if(index == 0)
		{
			return deleteFirst();
		}
		
		if(index == size-1)
		{
			return deleteLast();
		}
		
		Node prev = get(index-1);
		
		int val = prev.next.data;
		
		prev.next = prev.next.next;
		
		return val;
	}
	
	// Printing list
	public void display() 
	{
		if(head == null)
		{
			System.out.println("\nPlease Enter the data into the node...");
		}
		else
		{
			Node temp = head;// reference for head
			
			System.out.println("\nPrinting linkedlist elements...");
			
			System.out.print("\nHead -> ");
			while(temp != null)
			{
				System.out.print(temp.data+" -> ");
				temp = temp.next;
			}
			System.out.print("Tail\n");
		}
	}
	
	public static void main(String[] args) 
	{
		MyLinkedList ml = new MyLinkedList();
		
		int choice = 0;
		
		while(choice!=5)
		{
			System.out.println("\n\nChoose one from the below options...");
			System.out.println("\n1.add\n2.addFirst\n3.addLast\n4.insertAtIndex\n5.removeAtindex\n6.display\n7.Exit");
			
			System.out.println("\nEnter your choice:");
			choice = sc.nextInt();
			
			switch (choice) 
			{
				case 1:
					ml.add();
					break;
			
				case 2:
					ml.addFirst();
					break;
					
				case 3:
					ml.addLast();
					break;
				
				case 4:
					ml.insertAtindex();
					break;
				
				case 5:
					ml.removeAtindex();
					break;
					
				case 6:
					ml.display();
					break;
					
				case 7:
					System.out.println("Exiting...");
					
					System.exit(0);
					break;
					
				default:
					System.out.println("Please Enter valid choice");
			}
		}
	}
}
