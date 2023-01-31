import java.util.Scanner;

public class MyQueue
{
    private int capacity = 4;
    int queue[];
    
    int front = 0;
    int rear = -1;
    int currentSize = 0;// total number of elements in queue
    
    public MyQueue()
    {
        queue = new int[capacity];
    }
    
    public void enqueue(Scanner sc)
    {
       if (isQueueFull())
       {
           System.out.println("Queue is full, increase capacity...");
           increaseCapacity();
       }
       else
       {
    	   System.out.println("Enter data: ");
    	   int item = sc.nextInt();
           
           rear++;
        
           if(rear == capacity-1)
           {
               rear = 0;
           }
           
           queue[rear] = item;
           currentSize++;
           
           System.out.println("\nElement " + item+ " is enter in the Queue");   
       }
    }
        
    public void dequeue()
    {
      if (isQueueEmpty())
      {
         System.out.println("\nUnderflow ! Unable to remove element from an empty Queue");
      }
      else
      {
         front++;
         if(front == capacity-1)
         {
             System.out.println("\nRemoved element: "+queue[front-1]); // front and rear pointing the same
             front = 0;
         }
         else
         {
             System.out.println("\nRemoved element: "+queue[front-1]);
         }
         currentSize--;
      }
    }
    
    public boolean isQueueFull()
    {
        if (currentSize == queue.length)
        {
            return true;
        }
        return false;
    }
    
    public boolean isQueueEmpty()
    {
        if (currentSize == 0)
        {
            return true;
        }
        return false;
    }
    
    private void increaseCapacity()
    {
        int newCapacity = queue.length*2;
       
        int[] newQueue = new int[newCapacity];
        
        int tmpFront = front;
        int index = 0;
        
        while(true)
        {
            newQueue[++index] = queue[tmpFront];
         
            tmpFront++;
            if(tmpFront == queue.length)
            {
                tmpFront = 0;
            }
            if(currentSize == index+1)
             {
                break;
             }
        }
        
        queue = newQueue;
        
        System.out.println("New array capacity: "+this.queue.length);
        //Reset front and rear values
        front = 0;
        rear = index;
    }
    
    public void peek()
    {
    	if(isQueueEmpty())
    	{
    		System.out.println("\nCannot peek from an empty queue!!");
    	}else {
    		System.out.println("\nPeek element is: "+queue[front]);
    	}
    }
    
    public void display()
	{	
		if(isQueueEmpty())
		{
			System.out.println("\nQueue is empty !!");
		}
		else
		{
			System.out.print("\nQueue is: \n\n");
			
			System.out.print("front -> ");
			for(int i=front;i<=rear;i++)
			{
				System.out.print(queue[i]+" <- ");
			}
			System.out.println("rear");
		}
	}
    
    public static void main(String a[])
    { 
       MyQueue queue = new MyQueue();
        
       int choice = 0;
		
       Scanner sc = new Scanner(System.in);
		
       while(choice!=4)
       {
    	   System.out.println("\n\nChoose one from the below options...");
    	   System.out.println("\n1.enQueue\n2.deQueue\n3.peek()\n4.Show\n5.Exit");
			
    	   System.out.println("\nEnter your choice:");
    	   choice = sc.nextInt();
			
    	   switch (choice) 
    	   {
    	   		case 1:
					queue.enqueue(sc);
					break;
			
				case 2:
					queue.dequeue();
					break;
				
				case 3:
					queue.peek();
					break;
					
				case 4:
					queue.display();
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

//https://github.com/AkashGayke/HumanCloud-Assignment.git
	
	
	
	
	
	