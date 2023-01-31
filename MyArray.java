import java.util.Scanner;

public class MyArray 
{
	Scanner sc = new Scanner(System.in);
	
	int[] array ;
	int size; // number of elements
	int capacity; // actual size
	
	MyArray(){ 
		this(1); // default size 1 
	}
	  
	MyArray(int initialCapacity) 
	{
		array = new int[initialCapacity]; 
		size = 0;
	  
		capacity = initialCapacity; 
	}
	 
	public void insert()
	{	
		if(size == capacity)
			resize(2*capacity);	
		
		System.out.println("Enter Element in array: ");
		int ele = sc.nextInt();
		
		array[size++] = ele;	
	}
	
	public int delete()
	{
		if(size == 0) 
		{
			System.out.println("\nArray is empty!!");
			return 0;
		}
		else
		{
			int data = array[size-1]; // get the element
			
			size--;
			
			// check the array can have space 1/4 = 0.25
			if(size == capacity/4)
				resize(capacity/2); // reduce array by it's half size
			
			System.out.println("\n"+data+" is deleted.");
			
			return data;
		}
	}
	
	public void resize(int newCapacity) 
	{
		int[] temp = new int[newCapacity];
	
		for(int i=0; i<size; i++) // copy all array to temp
		{
			temp[i] = array[i];
		}
		
		array = temp; // update reference
		
		capacity = newCapacity; // update capacity variable
	}
	
	public void update() 
	{
		if(size == 0) 
		{
			System.out.println("\nArray is empty!!");
		}
		else
		{	
			System.out.println("Enter the number that you want to replace an array: ");
			int num = sc.nextInt();
			
			System.out.println("Enter the index on which you want to replace the number(Index starts from 0): "+num);
			int index = sc.nextInt();
			
			array[index] = num;
			
			System.out.println("\nnum "+num+" is updated at "+index+" position");
		}
	}
	
	public void print()
	{
		if(size == 0) 
		{
			System.out.println("\nArray is empty !!");
		}
		else
		{
			System.out.println("Printing array elements: ");
			for(int i=0; i<size; i++)
			{
				System.out.print(array[i]+" ");
			}
			System.out.println("\n\nSize is "+size+" and capacity is "+capacity);
		}
	}
	
	public static void main(String[] args) 
	{
		MyArray ma = new MyArray();
		
		int choice = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(choice!=5)
		{
			System.out.println("\n\nChoose one from the below options...");
			System.out.println("\n1.create\n2.delete\n3.update\n4.print\n5.Exit");
			
			System.out.println("\nEnter your choice:");
			choice = sc.nextInt();
			
			switch (choice) 
			{
				case 1:
					ma.insert();
					break;
			
				case 2:
					ma.delete();
					break;
					
				case 3:
					ma.update();
					break;
				
				case 4:
					ma.print();;
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

/*
 	Concept of dynamic array
 
	Capacity: size of the dynamically allocated array
	
	Size: Number of elements currently present in the array
			
		   0	
	array | |  capacity 1 and size 0
	
 insert 1 |1| c: 1 and s: 1
	
 insert 2 |1|2| c: 2*1 = 2 and s: 1 [2] // array is full (capacity == size)
		  temp
		  
 insert 3 |1|2|3| |	 c: 4 and s: 3  	 
 
  
  Delete Operation:
  
     0  1  2  3  4  5  6  7
  	|10|20|30|40|50|60|70|80|
  	
  	 Capacity: 8
  	 Size: 8
  	 
  	 if we remove 80 then we have to decrease the size
  	 
  	 array[7] = -1
  	 
  	After deleting element: 80
  	 
     0  1  2  3  4  5  6  7
  	|10|20|30|40|50|60|70|0|   Capacity: 8 and Size:7
  	 
  	After deleting element: 70
  	 
     0  1  2  3  4  5  6 7
  	|10|20|30|40|50|60|0|0|    Capacity: 8 and Size:6
  	
  	After deleting element: 50, 60
  
  	 0  1  2  3  4 5 6 7
  	|10|20|30|40|0|0|0|0|    Capacity: 8 and Size:4  c = 2*size or c = 4*size
  	
  	Half space will be wasted and how to achieve this
  	
  	Create a new array which is half of the size and size will be 4 
  	
  	|10|20|30|40|  and copy elements from actual array to newly created array
  	
  	Update reference to the newly created array array = temp
  	
  	Capacity: 4 and Size: 4 // Array is full
  	
*/