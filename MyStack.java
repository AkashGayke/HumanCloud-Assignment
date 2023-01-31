import java.util.Scanner;

public class MyStack 
{
	Scanner sc = new Scanner(System.in);
	
	int capacity = 2;
	int[] stack = new int[capacity];
	int top = 0;
	
	public void push(Scanner sc)
	{
		if(size() == capacity)
		{
			System.out.println("\nStack is full, increasing capacity...");
			resize(2*capacity);
		}
	
		System.out.println("\nEnter data: ");
		int data = sc.nextInt();
				
		stack[top] = data;
			
		top++;
				
		System.out.println("\nItem Pushed: "+data);
		
	}
	
	public void resize(int newCapacity) 
	{
		int[] newStack = new int[newCapacity];
	
		for(int i=0; i<size(); i++) // copy all array to temp
		{
			newStack[i] = stack[i];
		}
		
		stack = newStack; // update reference
		
		capacity = newCapacity; // update capacity variable
	}
	
	public int pop()
	{
		int data = 0;
		
		if(isEmpty()) // check stack is empty
		{
			System.out.println("\nStack is empty --> Underflow !!");
		}
		else
		{
			top--;
			
			data = stack[top];
			
			stack[top] = 0;
			
			if(size() == capacity/4) // 2 == 8/4
				resize(capacity/2);  
			
			System.out.println("\nItem popped: " + data);
		}
		
		return data;
	}
	
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println("\nCannot peek from an empty stack!!");
			return 0;
		}else {
			int data;
			data = stack[top-1];
			System.out.println("\nPeek element is: "+data);	
			return data;
		}
	}
	
	public int size() 
	{
		return top;
	}
	
	public boolean isEmpty()
	{
		return top<=0;
	}
	
	void display()
	{
		if(isEmpty())
		{
			System.out.println("\nStack is Empty !!");
		}
		else 
		{
			System.out.println("\nPrinting stack elements...\n");
			for(int i=top-1;i>=0;i--)
			{
				System.out.println("|    |");
				System.out.println("  "+stack[i]);
				System.out.println(" ---- ");
			}	
		}
	}
	
	public static void main(String[] args) 
	{
		MyStack ms = new MyStack();
		
		int choice = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(choice!=4)
		{
			System.out.println("\nChoose one from the below options...");
			System.out.println("\n1.Push\n2.Pop\n3.peek\n4.show\n5.Exit");
			
			System.out.println("\nEnter your choice:");
			choice = sc.nextInt();
			
			switch (choice) 
			{
				case 1:
					ms.push(sc);
					break;
			
				case 2:
					ms.pop();
					break;
					
				case 3:
					ms.peek();
					break;
					
				case 4:
					ms.display();
					break;
					
				case 5:
					System.out.println("Exiting...");
					
					System.exit(0);
					break;
					
				default:
					System.out.println("Please Enter valid choice");
			}
		}
	}
}
