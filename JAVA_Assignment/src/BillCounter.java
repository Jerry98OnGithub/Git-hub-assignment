import java.util.ArrayList;
import java.util.Scanner;

public class BillCounter {

	String itemName = null;
	float price = 0.0f;
	int quantity = 0;
	boolean raw = false;
	boolean manufactured = false;
	float tax = 0.0f;

	void salestax() {
		float totalTax = 0.0f;
		if (raw)
			totalTax = 0.155f;
		else if (manufactured)
			totalTax = 0.205f;
		tax = totalTax * price * quantity;

	}
	public String toString() {

		float subtotal = (quantity * price) + tax;
		System.out.println("ITEM NAME " +  "  " + "QUANTITY" + "  " +  "      TOTAL(incl. Tax)");

		return     itemName + "             " + quantity + "          - " + subtotal + " ";

	}


	public static class calculation {
		public static void main(String[] args) throws Exception {
			try (Scanner sc = new Scanner(System.in)) {
				ArrayList<BillCounter> list = new ArrayList<BillCounter>();
				int no = 1;
				while (true) {
					BillCounter input = new BillCounter();
					System.out.println("Add Product: "+ no);
					//Item Name----------
					System.out.print(" Enter itemName: ");
					String itemName = sc.next();
					input.itemName = itemName;
					//Item Quantity***********
					System.out.println("Enter quantity: ");
					int qty = sc.nextInt();
					input.quantity = qty;
					//Item Price***********
					System.out.print(" Enter price: ");
					float price = sc.nextFloat();
					input.price = price;
					//Item Type-----------
					System.out.print(" Is it Raw[y/n]: ");	
					String r = sc.next();
					if ( r.toLowerCase().equals("y"))
						input.raw = true;
					System.out.print(" Is it manufactured[y/n]: ");
					String m = sc.next();
					if(m.toLowerCase().equals("y"))
						input.manufactured = true;
					//**********************
					input.salestax();
					list.add(input);
					no++;
					//Asking for more items***********
					System.out.print("Do you want to add more Items [Y / N]: ");
					String add = sc.next();
					System.out.println("\n");
					if (add.toLowerCase().equals("n"))
						break;	
				}


				float totalPrice = 0.0f;
				float totalTax = 0.0f;
				float finalPrice = 0.0f;
				for ( int i = 0; i<list.size(); i++) {
					BillCounter billCounter = (BillCounter) list.get(i);
					totalPrice += billCounter.price * billCounter.quantity;
					totalTax += billCounter.tax;
					System.out.println(billCounter);
					finalPrice = totalPrice + totalTax;
				}

				System.out.println("\n");
				System.out.println("Applied Salestax :" + totalTax);
				System.out.println("total : " + finalPrice);
			}



		}

	}
}