
public class Main {
	public static void main(String[] args) {
		Coin quarter = new Coin("quarter", 25);
		Coin dime = new Coin("dime", 10);
		System.out.println("A " + quarter.name() + " is worth "
			+ quarter.compareTo(dime) + "¢ more than a " + dime.name());
		
		BankAccount myAccount = new BankAccount("MyAccount", 134.52);
		BankAccount someoneElseAccount = new BankAccount("SomeoneElse'sAccount", 1435.32);
		System.out.println("Output is 1 if I am richer than someone else. Output: " + 
			myAccount.compareTo(someoneElseAccount));
	}
}
