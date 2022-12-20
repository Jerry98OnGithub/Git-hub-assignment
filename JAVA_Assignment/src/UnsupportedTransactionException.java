

@SuppressWarnings("serial")
public class UnsupportedTransactionException extends Exception {



	public UnsupportedTransactionException() {
		super("You have entered wrong transaction type. Enter Valid Transaction.");
	}

	public UnsupportedTransactionException(String message) {
		super(message);
	}

}
