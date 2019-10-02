
import java.math.BigDecimal;

public class SavingsAccount extends Account {

	private BigDecimal overdrawLimit;
	
	/**
	 * Constructor. Used to create an account derived from given account information. Goes through superclass for construction.
	 * 
	 * @param accountNumber The number ID on the account
	 * @param accountOwner The person who owns the account
	 * @param accountBalance The dollar balance within the account
	 */
	public SavingsAccount(String accountNumber, String accountOwner, BigDecimal accountBalance) {
		super(accountNumber, accountOwner, accountBalance);
	}

	/**
	 * Constructor. Used to create an account derived from a given User object. Goes through superclass for construction.
	 * 
	 * @throws InvalidTransactionException Thrown when an attempted transaction is invalid
	 */
	public SavingsAccount(User user) {
		super(user);
	}
	
	/**
	 * Used when adding a positive amount of money into an account.
	 * 
	 * @param amount The amount being deposited into the account's balance
	 * @throws InvalidTransactionException Thrown when an attempted transaction is invalid
	 */
	@Override
	public void deposit(BigDecimal amount) throws InvalidTransactionException {
		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			throw new InvalidTransactionException("Cannot deposit negative amount.");
		} else {
			accountBalance = accountBalance.add(amount);
		}
	}
	
	/**
	 * Used when deducting funds from an account's balance.
	 * 
	 * @param amount The amount to be deducted from the account's balance
	 * @throws InvalidTransactionException Thrown when an attempted transaction is invalid
	 */
	@Override
	public void withdraw(BigDecimal amount) throws InvalidTransactionException {
		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			throw new InvalidTransactionException("Cannot withdraw negative amount.");
		} else if (amount.compareTo(accountBalance) == 1) {
			throw new InvalidTransactionException("Cannot withdraw a balance greater than Savings Account amount.");
		} else {
			accountBalance = accountBalance.subtract(amount);
		}
	}
	
	/**
	 * Prints overdrawLimit for the account
	 */
	@Override
	public void printOverdrawLimit() {
		//Print as a plain string
		System.out.println("Overdraw Limit: $" + overdrawLimit.toPlainString());
	}

	public BigDecimal getOverdrawLimit() {
		return overdrawLimit;
	}

	public void setOverdrawLimit(BigDecimal overdrawLimit) {
		this.overdrawLimit = overdrawLimit;
	}
	
	
	
	
}
