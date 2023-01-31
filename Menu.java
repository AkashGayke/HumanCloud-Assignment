import java.util.Scanner;

public class Menu 
{
	public static void run()
	{
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("********* Linear Data Structures *********");
			System.out.println("1. Array");
			System.out.println("2. Linked List");
			System.out.println("3. Stack");
			System.out.println("4. Queue");
			System.out.println("5. Exit");
			System.out.println("------------------------------------------");
			System.out.print("Enter Your Choice: ");
			int choice = sc.nextInt();
			
			switch (choice) 
			{
				case 1:
					System.out.println("\n********* Array Operations *********");
					MyArray ma = new MyArray();
					
					boolean flag = true;
					
					while(flag)
					{
						System.out.println("\nChoose one from the below options...");
						System.out.println("\n1.insert\n2.delete\n3.update\n4.print\n5.back");

						System.out.println("\nWhich operation you have to perform:");
						int ch = sc.nextInt();
						switch (ch) 
						{
							case 1:
								ma.insert();
								break;
					
							case 2:
								ma.delete();;
								break;
							
							case 3:
								ma.update();
								break;
						
							case 4:
								ma.print();;
								break;
							
							case 5:
								System.out.println("\nBack to main menu\n");
								flag = false;
								break;
							
							default:
								System.out.println("\nPlease Enter valid choice!!");
						}
					}
					break;
					
				case 2:
					System.out.println("\n********* LinkedList Operations *********");
					MyLinkedList ml = new MyLinkedList();
					
					boolean flag1 = true;
					
					while(flag1)
					{
						System.out.println("\nChoose one from the below options...");
						System.out.println("\n1.add\n2.addFirst\n3.addLast\n4.insertAtIndex\n5.removeAtindex\n6.display\n7.back");
						
						System.out.println("\nWhich operation you have to perform:");
						int ch1 = sc.nextInt();
						
						switch (ch1) 
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
								System.out.println("\nBack to main menu\n");
								flag1= false;
								break;
							
							default:
								System.out.println("\nPlease Enter valid choice!!");
						}
					}
					break;
						
				case 3:
					System.out.println("\n********* Stack Operations *********");
					MyStack ms = new MyStack();
					
					boolean flag2 = true;
					
					while(flag2)
					{
						System.out.println("\nChoose one from the below options...");
						System.out.println("\n1.Push\n2.Pop\n3.peek\n4.show\n5.back");
						
						System.out.println("\nWhich operation you have to perform:");
						int ch3 = sc.nextInt();
						
						switch (ch3) 
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
								System.out.println("\nBack to main menu\n");
								flag2 = false;
								break;
							
							default:
								System.out.println("\nPlease Enter valid choice!!");
						}
					}
					break;
					
				case 4:
					System.out.println("\n********* Queue Operations *********");
					MyQueue mq = new MyQueue();
					
					boolean flag3 = true;
					
					while(flag3)
					{
						System.out.println("\nChoose one from the below options...");
				    	System.out.println("\n1.enQueue\n2.deQueue\n3.peek\n4.Show\n5.back");
						
						System.out.println("\nWhich operation you have to perform:");
						int ch4 = sc.nextInt();
						
						switch (ch4) 
						{
							case 1:
								mq.enqueue(sc);
								break;
					
							case 2:
								mq.dequeue();
								break;
							
							case 3:
								mq.peek();
								break;
								
							case 4:
								mq.display();
								break;
							
							case 5:
								System.out.println("\nBack to main menu\n");
								flag3 = false;
								break;
							
							default:
								System.out.println("\nPlease Enter valid choice!!");
						}
					}
					break;
					
				case 5:
					System.out.println("Exiting...");
					
					System.exit(0);
					break;
					
				default:
					System.out.println("\nPlease Enter valid choice!!");
			}
		}
	}
}
