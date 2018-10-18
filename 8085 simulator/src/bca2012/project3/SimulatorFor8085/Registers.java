package bca2012.project3.SimulatorFor8085;
import javax.swing.JOptionPane;
//getting and setting values for Registers in 8085 simulator
class Registers
{
   private static String[] reg= new String[8];
   private static String[] reg1= new String[2];
   private static String[] reg2= new String[3];
   private static Simulator sim= new Simulator();
   private static Hextodec h= new Hextodec();
   private static Flags f= new Flags();
   public void initialise()//initializing all registers to zeroes.
   {
	 int i;
     for(i= 0;i < 8;i++)
     {
       reg[i]= "00";
     }
     for(i= 0;i < 2;i++)
     {
       reg1[i]= "0000";
       if(i == 0)
         i= 1;
     }
     for(i= 0;i < 3;i++)
     {
       reg2[i]= "00";
     }
   }
   public String getA()
   {
     return(reg[0]);
   }
   public String getB()
   {
     return(reg[1]);
   }
   public String getC()
   {
     return(reg[2]);
   }
   public String getD()
   {
     return(reg[3]);
   }
   public String getE()
   {
     return(reg[4]);
   }
   public String getH()
   {
     return(reg[5]);
   }
   public String getL()
   {
     return(reg[6]);
   }
   public String getM()
   {
     return(reg[7]);
   }
   public String getSP()
   {
     return(reg1[0]);
   }
   public String getPC()
   {
     return(reg1[1]);
   }
   public String getPort1()
   {
     return(reg2[0]);
   }
   public String getPort2()
   {
     return(reg2[1]);
   }
   public String getPort3()
   {
     return(reg2[2]);
   }
   public void exception(String value)//checking error
   {
     if(value.length() > 2)
     {
    	 JOptionPane.showMessageDialog(null,"exception occured", "alert", JOptionPane.ERROR_MESSAGE);
    	 Loader.setError();
     }
   }
   public void exception1(String value)//checking error
   {
     if(value.length() > 4)
     {
    	JOptionPane.showMessageDialog(null,"exception occured", "alert", JOptionPane.ERROR_MESSAGE);
		Loader.setError();
     }
   }
   public void setA(String value)
   {
     exception(value);
     reg[0]= value.toUpperCase();
     if(reg[0].length() != 2)
       reg[0]= "0" + reg[0];
     sim.changeColor(0);
   }
   public void setB(String value)
   {
     exception(value);
     reg[1]= value.toUpperCase();
     if(reg[1].length() != 2)
       reg[1]= "0" + reg[1];
     sim.changeColor(1);
   }
   public void setC(String value)
   {
     exception(value);
     reg[2]= value.toUpperCase();
     if(reg[2].length() != 2)
       reg[2]= "0" + reg[2];
     sim.changeColor(2);
   }
   public void setD(String value)
   {
     exception(value);
     reg[3]= value.toUpperCase();
     if(reg[3].length() != 2)
       reg[3]= "0" + reg[3];
     sim.changeColor(3);
   }
   public void setE(String value)
   {
     exception(value);
     reg[4]= value.toUpperCase();
     if(reg[4].length() != 2)
       reg[4]= "0" + reg[4];
     sim.changeColor(4);
   }
   public void setH(String value)
   {
     exception(value);
     reg[5]= value.toUpperCase();
     if(reg[5].length() != 2)
       reg[5]= "0" + reg[5];
     sim.changeColor(5);
     insert(reg[5]+reg[6]);
   }
   public void insert(String str)//insert given address into memory table if not exist.
   {
	   System.out.println("insert  "+str);
	    boolean in= true;
	    String address;
	    if(!str.equals("0000"))
	    {
		for(int i= 0;i < sim.rowsNumber();i++)
	        {
	    	  address= sim.getValue(i, 0);
	    	  if(address != null && address.toLowerCase().equals(str.toLowerCase()))
	    	  {
	    		 in= false;
	    		 break;
	    	  }
	    }
	    if(in)
	    {
	      for(int i= 0;i < sim.rowsNumber();i++)
	      {
	    	  if((address= sim.getValue(i,0)) == null || address.equals(""))
	    	  {
	    		  sim.setValue(str.toUpperCase(), i, 0);
	    		  break;
	    	  }
	      }
	    }
	    }
	    
   }
   public void setL(String value)
   {
     exception(value);
     reg[6]= value.toUpperCase();
     if(reg[6].length() != 2)
       reg[6]= "0" + reg[6];
     sim.changeColor(6);
   }
   public void setM(String value)
   {
     exception(value);
     reg[7]= value.toUpperCase();
     if(reg[7].length() != 2)
       reg[7]= "0" + reg[7];
     sim.changeColor(7);
   }
   public void setSP(String value)
   {
     exception1(value);
     reg1[0]= value.toUpperCase();
     while(reg1[0].length() < 4)
       reg1[0]= "0" + reg1[0];
     sim.changeColor(8);
   }
   public void setPC(String value)
   {
     exception1(value);
     reg1[1]= value.toUpperCase();
     if(!reg1[1].equals("-1"))
       while(reg1[1].length() < 4)
         reg1[1]= "0" + reg1[1];
     sim.changeColor(9);
   }
   public void setPort1(String value)
   {
     exception(value);
     reg2[0]= value.toUpperCase();
   }
   public void setPort2(String value)
   {
     exception(value);
     reg2[1]= value.toUpperCase();
   }
   public void setPort3(String value)
   {
     exception(value);
     reg2[2]= value.toUpperCase();
   }
   public void incPC(int value)//increasing PC value by 1
   {
     int i;
     i= h.getDecimalNum(reg1[1]) + value; 
     reg1[1]= Integer.toHexString(i);
     while(reg1[1].length() < 4)
       reg1[1]= "0" + reg1[1];
     reg1[1]= reg1[1].toUpperCase();
     sim.changeColor(9);
   }
   public void decReg(int a)
   {
     int i;
     if(reg[a].equals("00"))
     {
       reg[a]= "FF";
       f.setS(1);
     }
     else
     {
       i= h.getDecimalNum(reg[a]) - 1;
       reg[a]= Integer.toHexString(i);
       if(reg[a].length() == 1)
         reg[a]= "0" + reg[a];
       reg[a]= reg[a].toUpperCase();
     }
     sim.changeColor(a);
   }
   public void decA()
   {
     decReg(0);
   }
   public void decB()
   {
     decReg(1);
   }
   public void decC()
   {
     System.out.println(reg[2]+"......");
     decReg(2);
   }
   public void decD()
   {
     decReg(3);
   }
   public void decE()
   {
     decReg(4);
   }
   public void decH()
   {
     decReg(5);
   }
   public void decL()
   {
     decReg(6);
   }
   public void decM()
   {
     decReg(7);
   }
   public void incPair(int a,int b)//increasing as a pair(BC,DE,HL).
   {
     String s;
     int i;
     s= reg[a] + reg[b];
     i= h.getDecimalNum(s) + 1; 
     s= Integer.toHexString(i);
     while(s.length() < 4)
       s= "0" + s;
     reg[a]= s.substring(0,2);
     reg[b]= s.substring(2,4);
     sim.changeColor(a);
     sim.changeColor(b);
   }
   public void incPairH()
   {
     incPair(5,6);
     insert(reg[5]+reg[6]);
   }
   public void incPairB()
   {
     incPair(1,2);
   }
   public void incPairD()
   {
     incPair(3,4);
   }
   public void incPairSP()//increasing SP by 1.
   {
     int i= h.getDecimalNum(reg1[0]) + 1;
     String s= Integer.toHexString(i);
     while(s.length() < 4)
       s= "0" + s;
     reg1[0]= s;
     sim.changeColor(8);
   }

   public void incReg(int a)
   {
     int i;
     if(reg[a].equals("FF"))
     {
       reg[a]= "00";
       f.setCY(1);
     }
     else
     {
       f.setCY(0);
       i= h.getDecimalNum(reg[a]) + 1;
       reg[a]= Integer.toHexString(i);
       if(reg[a].length() == 1)
         reg[a]= "0" + reg[a];
     }
     reg[a]= reg[a].toUpperCase();
     sim.changeColor(a);
   }
   public void incA()
   {
     incReg(0);
   }
   public void incB()
   {
     incReg(1);
   }
   public void incC()
   {
     incReg(2);
   }
   public void incD()
   {
     incReg(3);
   }
   public void incE()
   {
     incReg(4);
   }
   public void incH()
   {
     incReg(5);
   }
   public void incL()
   {
     incReg(6);
   }
   public void incM()
   {
     incReg(7);
   }
   public void decPair(int a,int b)//decreasing as a pair.
   {
     String s;
     int i;
     s= reg[a] + reg[b];
     i= h.getDecimalNum(s) - 1; 
     s= Integer.toHexString(i);
     while(s.length() < 4)
       s= "0" + s;
     reg[a]= s.substring(0,2);
     reg[b]= s.substring(2,4);
     sim.changeColor(a);
     sim.changeColor(b);
 //    System.out.println(reg[a]+reg[b]);
   }
   public void decPairH()
   {
     decPair(5,6);
     insert(reg[5]+reg[6]);
   }
   public void decPairB()
   {
     decPair(1,2);
   }
   public void decPairD()
   {
     decPair(3,4);
   }
   public void decPairSP()
   {
     if(reg1[0].equals("0000"))
     {
       reg1[0]= "FFFF";
     }
     else
     {
       int i= h.getDecimalNum(reg1[0]) - 1;
       String s= Integer.toHexString(i);
       while(s.length() < 4)
         s= "0" + s;
       reg1[0]= s;
     }
     sim.changeColor(8);
   }
}
