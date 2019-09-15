
import java.math.BigDecimal;

public class SavingsAccount extends Account {

	private BigDecimal overdrawLimit;
	private final double COMPOUND_INTEREST_RATE = 0.01;
	
	public SavingsAccount(String accountNumber, String accountOwner, BigDecimal accountBalance, BigDecimal overdrawLimit) {
		super(accountNumber, accountOwner, accountBalance);
		this.overdrawLimit = overdrawLimit;
	}

	@Override
	public void printOverdrawLimit() {
		//Print as a plain string
		System.out.println("Overdraw Limit: $" + overdrawLimit.toPlainString());
	}
	
	@Override
	public void withdraw(BigDecimal amount) throws Exception {
		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			throw new Exception("Cannot withdraw negative amount.");
		} else if (amount.compareTo(accountBalance) == -1) {
			throw new Exception("Cannot withdraw a balance greater than Savings Account amount.");
		} else {
			accountBalance = accountBalance.subtract(amount);
		}
	}
	
	
}
