package bca2012.project3.SimulatorFor8085;
//package sic;
//getting and setting values for Flags in 8085 simulator
class Flags
{
   private static int S= 0,Z= 0,AC= 0,P= 0,CY= 0;
   private static int count= 1;
   Hextodec h= new Hextodec();
   public int getS()
   {
     return(S);
   }
   public int getZ()
   {
     return(Z);
   }
   public int getAC()
   {
     return(AC);
   }
   public int getP()
   {
     return(P);
   }
   public int getCY()
   {
     return(CY);
   }
   public void setS(int value)
   {
     S= value;
   }
   public void setZ(int value)
   {
     Z= value;
   }
   public void setAC(int value)
   {
     AC= value;
   }
   public void setP(int value)
   {
     P= value;
   }
   public void setCY(int value)
   {
     CY= value;
   }
   public void checkZ(String str)
   {
     if(str.equals("00"))
       Z= 1;
     else
       Z= 0;
   }
   public void checkP(String str)//checks whether number of 1's are even or not.sets parity flag if even otherwise reset.
   {
     if(str.equals("00") || str.equals("01"))
     {
       if(str.equals("00"))
         P= 1;
       else
         P= 0;
     }
     else
     {
       binary(h.getDecimalNum(str));
       int i= count;
       if(i%2 == 0)
         P= 1;
       else
         P= 0;
     }
     count= 1;
   }
   public void binary(int num)//counting number of 1's in number.
   {
     int j;
     j= num%2;
     if(num/2 != 1)
       binary(num/2);
     count+= j;
   }
   public void checkS(String str)//check whether it is negative number or not..if negative sign flag is set or reset .
   {
     int i= h.getDecimalNum(str);
     if(i >= 128)
       S= 1;
     else
       S= 0;
   }
   public void initialise()
   {
     S= 0;
     Z= 0;
     AC= 0;
     P= 0;
     CY= 0;
   }
}
