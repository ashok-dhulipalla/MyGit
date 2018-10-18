package bca2012.project3.SimulatorFor8085;
//package sic;
import java.io.*;

import javax.swing.JOptionPane;
class Memory
{
  private static int[] memory= new int[65536];//memory of 2^15.
  public String getData(String address)//returns data from the specified address(in hexadecimal form) from memory.
  { 
    int temp,value;
    String str;
    Hextodec h= new Hextodec();
    temp= h.getDecimalNum(address);
    str= Integer.toHexString(memory[temp]);
    if(str.length() == 1)
      str= "0" + str;
    return(str.toUpperCase());
  }
  void assignData(String address,String data)//assign given data to given address(hexadecimal form) in the memory.
  {
    int temp1,temp2;
    Hextodec h= new Hextodec();
    temp1= h.getDecimalNum(address);
    temp2= data.length();
    if(temp2 <= 2)
    {
        memory[temp1]= h.getDecimalNum(data);
    }
    else if(temp2 == 4)
    {
        memory[temp1]=h.getDecimalNum(data.substring(0,2));
        temp1++;
        memory[temp1]=h.getDecimalNum(data.substring(2,4));
    }
    else
    {
        memory[temp1]=h.getDecimalNum(data.substring(0,2));
        temp1++;
        memory[temp1]=h.getDecimalNum(data.substring(2,4));
        temp1++;
        memory[temp1]= h.getDecimalNum(data.substring(4,6));
    }
  }
}
