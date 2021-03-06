package structural.bridge;

public class MediumSoda extends Soda {  
	public MediumSoda() {
		setSodaImp();
	}

	public void pourSoda() {
		SodaImp sodaImp = this.getSodaImp();
		for (int i = 0; i < 2; i++) {
			System.out.print("...glug.Medium..");
			sodaImp.pourSodaImp();
		}
		System.out.println(" ");
	}
}
