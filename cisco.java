
public class cisco {

	public static void main(String args[]) {
		System.out.print("greate dya");
		try {
			int value = Integer.parseInt("99i") ;
			if (value > 90) {
				System.out.print("!!");
			} 
			}
			catch (NumberFormatException nfe) {
				System.out.print(" I will go for a swim") ;
			} 
			finally {
				 System.out.print("hello");
			}
		}
	}
