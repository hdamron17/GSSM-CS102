
public class BankAccount implements Comparable<BankAccount> {
	private String name;
	private double balance;
	
	public BankAccount(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public int compareTo(BankAccount otherAccount) {
		if(this.balance - otherAccount.balance > 0.0)
			return 1;
		else if(this.balance - otherAccount.balance < 0.0) 
			return -1;
		else return 0;
	}
	
	public String name() {
		return name;
	}
	
	public double balance() {
		return balance;
	}

}
