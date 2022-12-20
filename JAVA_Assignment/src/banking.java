import java.util.Scanner;

class bankingSystem{

	public void transaction(String transactionType ) {
		try (Scanner inp = new Scanner(System.in)) {

			try {
				switch (transactionType)
				{
				case "credit":
					System.out.println("Kindly Enter Amount to Credit: ");
					float cred = inp.nextFloat();
					System.out.println("Amount "+cred+" credited Successfully");
					break;


				case "debit":
					System.out.println("Kindly Enter Amount to Debit: ");
					float deb = inp.nextFloat();
					System.out.println("Amount "+deb+" debited Successfully");
					break;


				case "balanceInquiry":
					System.out.println("Balance is $7000");
					break;


				case "pinChange":
					System.out.println("Kindly Enter New PIN");
					int pin = inp.nextInt();
					System.out.println("Your new PIN is :"+ pin);
					break;

				default:
					throw new UnsupportedTransactionException();
				}

			}catch(UnsupportedTransactionException e){

				System.out.println(e.getMessage());

			}
		}
	}
}


public class banking {


	public static void main(String[] args)
	{
		bankingSystem obj =  new bankingSystem();
		System.out.println("Please Enter a Transaction Type \n"
				+ "A.credit, \n B.debit, \n C.balanceInquiry and \n D.pinChange");
		try (Scanner sc = new Scanner(System.in)) {
			String input = sc.nextLine();
			obj.transaction(input);

		}

	}

}

















