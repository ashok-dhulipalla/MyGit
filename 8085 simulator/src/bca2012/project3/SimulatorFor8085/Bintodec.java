package bca2012.project3.SimulatorFor8085;
//package sic;
import java.util.Scanner;
class Bintodec
{
  public int getDecimalNum(String str)//convert binary number into decimal number.
  {
    int j= 1,value= 0,a;
    char[] ch= new char[1];
    for(int i= str.length() - 1;i > -1;i--)
    {
      ch[0]= str.charAt(i);
      String s= new String(ch);
      a= Integer.valueOf(s); 
      value+= a * j;
      j*= 2;
    }
    return(value);
  }
  public static void main(String[] args)
  {
    Bintodec b= new Bintodec();
    System.out.println(b.getDecimalNum("00000001"));
  }
}
