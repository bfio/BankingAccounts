import java.math.BigDecimal;

public class User {
	
	protected String accountOwner;
	protected String accountNumber;
	protected BigDecimal accountBalance;
	
	public User(String accountOwner, String accountNumber, BigDecimal accountBalance) {
		super();
		this.accountOwner = accountOwner;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}
	public String getAccountOwner() {
		return accountOwner;
	}
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

}
