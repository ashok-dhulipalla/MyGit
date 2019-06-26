package structural.bridge;

public class SuperSizeSoda extends Soda {  
	   public SuperSizeSoda() {
	       setSodaImp();
	   }
	   
	   public void pourSoda() {
	       SodaImp sodaImp = this.getSodaImp();
	       for (int i = 0; i < 5; i++) {
	           System.out.print("...glug.Super..");
	           sodaImp.pourSodaImp();
	       }
	       System.out.println(" ");       
	   }
	}
