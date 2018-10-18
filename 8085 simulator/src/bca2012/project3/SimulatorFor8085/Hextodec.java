package bca2012.project3.SimulatorFor8085;
import java.io.*;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
class Hextodec
{
  public int getDecimalNum(String str)//returns decimal number for the given string of hexadecimal number
  {
    int length,count= 1,digit= 0,decimal= 0;
    Simulator sim= new Simulator();
    length= str.length();
    for(int i= length-1;i > -1;i--)
    {
      char alp[]= new char[1];
      alp[0]= str.charAt(i);
      switch(alp[0])
      {
        case 'A':case 'a':
            digit= 10;
            break;
        case 'B':case 'b':
            digit= 11;
            break;
        case 'C':case 'c':
            digit= 12;
            break;
        case 'D':case 'd':
            digit= 13;
            break;
        case 'E':case 'e':
            digit= 14;
            break;
        case 'F':case 'f':
            digit= 15;
            break;
        case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
        	String s= new String(alp);
            digit= Integer.valueOf(s);
        	break;
        default://wont support negative number or other alphabets.
        	JOptionPane.showMessageDialog(null,str+" is not hexadecimal number", "alert", JOptionPane.ERROR_MESSAGE);
			Loader.setError();
			sim.setdef();
			return (1);
            
      } 

      decimal+= digit * count;
      count*= 16;
    }
    return(decimal);
  }
  public static void main(String[] arg)throws IOException
  {
    Hextodec h1= new Hextodec();
    System.out.println("enter hexadecimal number: ");
    BufferedReader hex= new BufferedReader(new InputStreamReader(System.in));
    String in= hex.readLine();
    in= in.toUpperCase();
    System.out.println(h1.getDecimalNum(in));
  }

}
