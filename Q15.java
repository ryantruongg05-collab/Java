import java.util.Scanner;

public class Q15 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String[] names = new String[5];
        String[] mobiles = new String[5];

        for(int i=0;i<names.length;i++) {
            System.out.print("Enter name " + (i+1) + ": ");
            names[i] = kb.nextLine();
            System.out.print("Enter mobile " + (i+1) + ": ");
            mobiles[i] = kb.nextLine();
        }

        System.out.print("Enter name to search: ");
        String nameToSearch = kb.nextLine();
        
        //linear search
		boolean nameFound = false;
		for(int i=0;i<names.length;i++){
			String currentName = names[i];
			//found the name!
			if(currentName.toLowerCase().equals(nameToSearch.toLowerCase())){
				//use the index to get the mobile
				System.out.println("Mobile:"+mobiles[i]);
				nameFound = true;
			}
		}
		if(!nameFound){
			System.out.println("Name not found");
		}
    }

}