
public class EWallet {
	private String serialNumber;
	private double balance;
	private double maxAmount;
	
	public void init(String serialNumber, double balance, double maxAmount){
		this.serialNumber = serialNumber;
		this.balance = balance;
		this.maxAmount = maxAmount;
	}
	
	public void display(){
		System.out.println("Serial Number:"+serialNumber);
		System.out.println("Balance:"+balance);
		System.out.println("Max Amount:"+maxAmount);
	}
	
	public double getBalance(){
		return balance;
	}
	
	public String getSerialNumber(){
		return serialNumber;
	}
	
	public boolean isEmpty(){
		boolean isEmpty = false;
		if(balance==0){
			isEmpty = true;
		}
		return isEmpty;
	}
	
	private boolean canTopUp(double amount){
		boolean canTopUp = false;
		if(amount+balance<=maxAmount){
			canTopUp = true;
		}
		return canTopUp;
	}
	
	public void topUp(double amount){
		if(amount>0){
			if(canTopUp(amount)){
				balance+=amount;
			}else{
				System.out.println("Exceed max amount");
			}
		}else{
			System.out.println("Amount must be more than zero");
		}
	}
	
	public void deduct(double amount){
		if(amount>0){
			if(balance>=amount){
				balance-=amount;
			}else{
				System.out.println("Insufficient balance");
			}
		}else{
			System.out.println("Amount must be more than zero");
		}
	}

	public boolean equals(EWallet theOtherEWallet){
		boolean isTheSame = false;
		String theOtherEWalletSerialNumber = theOtherEWallet.getSerialNumber();
		if(serialNumber.equals(theOtherEWalletSerialNumber)){
			double theOtherEWalletBalance = theOtherEWallet.getBalance();
			if(balance == theOtherEWalletBalance){
				isTheSame = true;
			}
		}
		return isTheSame;
	}
	
	public static void main(String[] args){
		//test itself
		EWallet e = new EWallet();
		e.init("A111", 100, 150);
		e.deduct(120);
		e.deduct(-20);
		e.deduct(70);
		e.display();
	}
}