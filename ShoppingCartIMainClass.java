// Importing the necessary libraries
import java.util.HashMap;
import java.util.ArrayList;

//Making of the Item class in which we are storing the the itemId, Name, Description and Price.
class Item{
	int ItemId;
	String name;
	String Description;
	int Price;
	
//	Making the constructor of the Item class to store the value
	public Item(int ItemId, String name, String Description, int Price) {
		this.ItemId = ItemId;
		this.name = name;
		this.Description = Description;
		this.Price = Price;
	}
}

// Making a class which will keep record of all the track of items present in the cart whether
// the item is deleted or updated also check if a item is present or not.
class shoppingCart{
	
//	using HashMap to store the values in which we are taking the itemId and its Quantity in the HashMap.
	HashMap<Integer, Integer> cart = new HashMap<>();
	
//	Function to add items in the cart 
	public void addToCart(Integer itemId, int qty) {
		
//		Checking whether the item is already present in the cart, if not present then putting item in the cart else updating it.
		boolean check = checkItem(itemId);
		if(check == false) {
			cart.put(itemId, qty);
		}else {
			int newQty = cart.get(itemId) + qty;
			cart.put(itemId, newQty);
		}
	}
	
//  Function to Displaying the Quantity of the item present in the cart
	public int displayQty(Integer itemId) {
//		Before display Quantity we have to check whether its present in the cart or not.
		boolean check = checkItem(itemId);
		if(check == false) {
			System.out.println("Item is not Present in the Cart");
			return 0;
		}
		return cart.get(itemId);
	}
	
	
//  Function to Updating the Quantity of the item in the cart.
	public void updateQuantity(Integer itemId, int qty) {
//		Before updating the quantity checking the item is present or not.
		boolean check = checkItem(itemId);
		if (check == false) {
			System.out.println("Item is not Present in the Cart");
		}else {
			int newValue =  qty;
			cart.put(itemId, newValue);
		}
		
	}
	
	
//	Function to Deleting the item from the cart.
	public void deleteItem(Integer itemId) {
//		Before deleting the item checking whether the item is present or not.
		boolean check = checkItem(itemId);
		if (check == false) {
			System.out.println("Item is not present in the cart");
		}else {
			cart.remove(itemId);
		}
	}
	
	
//	Function to Calculating the total amount in the cart
	public double DisplayBill(ArrayList<Item> arr) {
		double bill = 0;
		for(Item item: arr) {
			boolean check = checkItem(item.ItemId);
			if (check)
				bill += cart.get(item.ItemId)*item.Price;
			else
				continue;
		}
		return bill;
	}
	
//	Function to check item contains in the cart or not.
	public boolean checkItem(Integer itemId) {
		return cart.containsKey(itemId);
	}
}

public class ShoppingCartIMainClass {
	public static void main(String args[]) {
//		Creating an Arraylist to store the Item 
		ArrayList<Item> arr = new ArrayList<>();
		
//		initializing a id variable for uniquely identity each item
		int id = 0;
//		Creating some demo items 
		Item a1 = new Item(++id, "Pen", "tool used for writing or drawing", 10);	
		Item a2 = new Item(++id, "Laptop", "personal computer", 50000);
		Item a3 = new Item(++id, "Headphone", "used to listen music", 3000);
		
//		Adding the items in the Arraylist
		arr.add(a1);
		arr.add(a2);
		arr.add(a3);
		
		
//		Adding the items in the cart and passing how many quantity to be added
		shoppingCart s = new shoppingCart();
		s.addToCart(a1.ItemId, 15);
		s.addToCart(a2.ItemId, 2);
		s.addToCart(a3.ItemId, 4);
		s.addToCart(a2.ItemId, 4);
		
//		Printing the Quantity of item id 2
		System.out.println(s.displayQty(2));
		
//		Calculating the total bill of the cart
		double totalBill = s.DisplayBill(arr);
		System.out.println(totalBill);
		
//		Updating the Quantity of Item id 2 and again calculating the total bill
		s.updateQuantity(2, 3);
		System.out.println(s.displayQty(2));
		double totalBill1 = s.DisplayBill(arr);
		System.out.println(totalBill1);
		
//		Deleting the Item id 2 and Printing the item id 2 and printing the total bill
		s.deleteItem(2);
		s.displayQty(2);
		System.out.println(s.DisplayBill(arr));
		
	}
}
