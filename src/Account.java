import java.math.BigDecimal;
import java.text.NumberFormat;

public abstract class Account {
	
	protected String accountNumber;
	protected String accountOwner;
	protected BigDecimal accountBalance;
	protected BigDecimal overdrawLimit;
	
	/**
	 * Constructor. Used to create an account derived from given account information
	 * 
	 * @param accountNumber The number ID on the account
	 * @param accountOwner The person who owns the account
	 * @param accountBalance The dollar balance within the account
	 */
	public Account(String accountNumber, String accountOwner, BigDecimal accountBalance) {
		this.accountNumber = accountNumber;
		this.accountOwner = accountOwner;
		this.accountBalance = accountBalance;
	}
	
	/**
	 * Constructor. Used to create an account derived from a given User object. 
	 * 
	 * @param user The User associated with the account
	 */
	public Account(User user) {
		this.accountBalance = user.accountBalance;
		this.accountNumber = user.accountNumber;
		this.accountOwner = user.accountOwner;
	}

	/**
	 * Used when adding a positive amount of money into an account.
	 * 
	 * @param amount The amount being deposited into the account's balance
	 * @throws InvalidTransactionException Thrown when an attempted transaction is invalid
	 */
	public abstract void deposit(BigDecimal amount) throws InvalidTransactionException;
	
	/**
	 * Used when deducting funds from an account's balance.
	 * 
	 * @param amount The amount to be deducted from the account's balance
	 * @throws InvalidTransactionException Thrown when an attempted transaction is invalid
	 */
	public abstract void withdraw(BigDecimal amount) throws InvalidTransactionException;

	/**
	 * Prints overdrawLimit for the account
	 */
	public void printOverdrawLimit() {
		System.out.println("Overdraw Limit: " + currencyFormat(overdrawLimit));
	}
	
	/**
	 * Prints instantaneous balance of an account in proper currency format
	 */
	public void printBalance() {
		System.out.println("Current balance: " + currencyFormat(getAccountBalance()));
	}

	/**
	 * Formats currency properly as dollars
	 * 
	 * @param n BigDecimal to be formatted as currency
	 * @return String value of correctly formatted balance
	 */
	public static String currencyFormat(BigDecimal n) {
	    return NumberFormat.getCurrencyInstance().format(n);
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
}
