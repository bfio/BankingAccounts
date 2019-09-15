import java.math.BigDecimal;

public abstract class Account {
	
	protected String accountNumber;
	protected String accountOwner;
	protected BigDecimal accountBalance;
	protected BigDecimal overdrawLimit;
	
	public Account(String accountNumber, String accountOwner, BigDecimal accountBalance) {
		this.accountNumber = accountNumber;
		this.accountOwner = accountOwner;
		this.accountBalance = accountBalance;
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
	
	public void printBalance() {
		System.out.println("Current balance: " + getAccountBalance().toString());
	}
	
	public void deposit(BigDecimal amount) throws Exception {
		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			throw new Exception("Cannot deposit negative amount.");
		} else {
			accountBalance = accountBalance.add(amount);
		}
	}
	
	public void withdraw(BigDecimal amount) throws Exception {
		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			throw new Exception("Cannot withdraw negative amount.");
		} else {
			accountBalance = accountBalance.subtract(amount);
		}
	}

	public void printOverdrawLimit() {
		System.out.println("Overdraw Limit: " + overdrawLimit.toPlainString());
	}
}
