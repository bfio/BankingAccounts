package accounts;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class SavingsAccountTest {
	
	public User user = new User("12345", "John Smith", new BigDecimal(100));
	public BigDecimal amount = new BigDecimal(100);
	
	@Test
	public void deposit100_actual200() throws InvalidTransactionException {
		SavingsAccount savings = new SavingsAccount(user);
		savings.deposit(amount);
		assertEquals(new BigDecimal(200), savings.getAccountBalance());
	}
	
	@Test
	public void withdraw100_actual0() throws InvalidTransactionException {
		SavingsAccount savings = new SavingsAccount(user);
		savings.withdraw(amount);
		assertEquals(new BigDecimal(0), savings.getAccountBalance());
	}

}
