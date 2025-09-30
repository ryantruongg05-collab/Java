
public class EWalletTest {

	public static void main(String[] args) {
		EWallet ew1 = new EWallet();
		ew1.init("T456", 10, 100);
		EWallet ew2 = new EWallet();
		ew2.init("T890", 0, 500);
		EWallet ew3 = new EWallet();
		ew3.init("T456", 10, 80);
		
		if(ew1.equals(ew3)){
			System.out.println("EW1 and EW3 - Same");
		}else{
			System.out.println("EW1 and EW3 - not the Same");
		}
		
		if(ew1.equals(ew2)){
			System.out.println("EW1 and EW2 - Same");
		}else{
			System.out.println("EW1 and EW2 - not the Same");
		}
		
		
		/*
		if(ew1==ew3){
			System.out.println("Same");
		}else{
			System.out.println("Different");
		}
		*/
		/*
		ew1.topUp(30);
		ew1.display();
		ew1.deduct(10);
		ew1.display();
		
		ew2.topUp(3000);
		ew2.deduct(3000);
		*/
	}

}