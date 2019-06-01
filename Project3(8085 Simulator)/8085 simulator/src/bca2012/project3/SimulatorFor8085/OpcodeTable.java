package bca2012.project3.SimulatorFor8085;
import java.util.Scanner;
import java.util.HashMap;
import javax.swing.*;
import java.io.*;
import java.util.*;
class OpcodeTable
{
  Map<String,Pair> optable;
  Map<String,Integer> directive;
  OpcodeTable()
  {
  }
  OpcodeTable(String file)
  {
      optable= new HashMap<String,Pair>();		
      String l;
	try
	{
      		BufferedReader inline= new BufferedReader(new FileReader(file)); 
		while((l= inline.readLine()) != null)
		{
			l= l.trim();
			String[] arr= l.split("\\p{Blank}+");//splitting line.
				table(arr);
		}
	}
	catch(IOException io)
	{
		System.out.println(io);
	}		
  } 
  void table(String[] arr)
  {
	if(arr.length == 3)
	{
                arr[1]= arr[1].trim();
		Pair p= new Pair(Integer.valueOf(arr[2]),arr[1]);//initializing hexacode and size.
		optable.put(arr[0],p);
	}
	if(arr.length == 4)
	{
                arr[1]= arr[1].trim();
                arr[2]= arr[2].trim();
		Pair p= new Pair(arr[1],arr[2],Integer.valueOf(arr[3]));//initializing operand1 ,hexacode and size.
		System.out.println("after: "+arr[0]);
		optable.put(arr[0],p);
	}
	if(arr.length == 5)
	{
		Pair p= new Pair(arr[1],arr[2],arr[3],Integer.valueOf(arr[4]));//initializing operand1 ,operand2,hexacode and size.
		System.out.println("after: "+arr[0]);
		optable.put(arr[0],p);
	}



  }

  int getSize(String s)//returns size of the opcode.
  {
    Pair p= optable.get(s);
    if(p == null)//shows message if illegal opcode.
    {
	JOptionPane.showMessageDialog(null,s+" is illegal Opcode", "alert", JOptionPane.ERROR_MESSAGE); 
	Loader.setError();
    }
    return(p.size()); 
  }
  String getHexcode(String s)//returns base hexacode of the opcode.
  {
    Pair p= optable.get(s);
    if(p == null)//shows message if illegal opcode.
    {
	JOptionPane.showMessageDialog(null,s+" is illegal Opcode", "alert", JOptionPane.ERROR_MESSAGE); 
	Loader.setError();
    }
    return(p.hexcode()); 
  }
  String getHexcodeplus(String s,int x,int y)//returns calculated hexacode of the opcode.
  {
    Pair p= optable.get(s);
    if(p == null)//shows message if illegal opcode.
    {
	JOptionPane.showMessageDialog(null,s+" is illegal Opcode", "alert", JOptionPane.ERROR_MESSAGE); 
	Loader.setError();
    }
    return(p.hexcodeplus(x,y)); 
  }
  String getOperand1(String s)
  {
    Pair p= optable.get(s);
    if(p == null)//shows message if illegal opcode.
    {
	JOptionPane.showMessageDialog(null,s+" is illegal Opcode", "alert", JOptionPane.ERROR_MESSAGE); 
	Loader.setError();
    }
    return(p.operand1()); 
  }
  String getOperand2(String s)
  {
    Pair p= optable.get(s);
    if(p == null)//shows message if illegal opcode.
    {
	JOptionPane.showMessageDialog(null,s+" is illegal Opcode", "alert", JOptionPane.ERROR_MESSAGE); 
	Loader.setError();
    }
    return(p.operand2()); 
  }
  public String toString()
  {
    Set<String> opkey;
    opkey= optable.keySet();
    System.out.println("_________________________________________________________");
    System.out.println("[1;32mOPCODE	OPERAND1	OPERAND2	SIZE	HEXCODE [0m|");
    System.out.println("________________________________________________________|");
    for(String s : opkey)
    {
      System.out.println(s+"	"+getOperand1(s)+"		"+getOperand2(s)+"		"+getSize(s)+"	"+getHexcode(s)+"	|");  
    }
    System.out.println("________________________________________________________|"); 
    return("\n");
  }
  public static void main(String[] args)
  {
    Pair.initialise();
    Console c = System.console();
    OpcodeTable optab= new OpcodeTable("opcode1s8085.txt");
    System.out.println(optab);
  }
}
class Pair
{
  static String[][] matrix= new String[8][8];//matrix for calculation of hexacode.
  int size;//size of opcode.
  String hexcode;//hexacode of opcode.
  String operand1;//operand1 of opcode.(it can be register ,data or address.)
  String operand2;//operand2 of opcode.(it can be register ,data or address.)
  Pair()
  {
  }
  public static void initialise()//initializing matrix from 0 to 3f(in hexadecimal number) 
  {
    int count= 0;
    for(int i= 0;i < 8;i++)
    {
      for(int j= 0;j < 8;j++)
      {
        matrix[i][j]= Integer.toHexString(count);
        count++;
        System.out.print(matrix[i][j]+" ");
      }
        System.out.println();
    }
  }
  public String toString()
  {
    return("size is "+ size + "\n" +"hexacode is "+ hexcode);
  }
  Pair(int i,String j)
  {
    hexcode= j;
    size= i;
  }
  Pair(String op1,String j,int i)
  {
    operand1= op1;
    hexcode= j;
    size= i;
  }
  Pair(String op1,String op2,String j,int i)
  {
    operand1= op1;
    operand2= op2;
    hexcode= j;
    size= i;
  }
  int size()
  {
    return(size);
  }
  String hexcode()
  {
    return(hexcode);
  }
  String hexcodeplus(int x,int y)
  {
    System.out.println(hexcode+"testing");
    Hextodec h1= new Hextodec();
    int hex= h1.getDecimalNum(hexcode)+ h1.getDecimalNum(matrix[x][y]);//original hexacode is base hexacode plus matrix[x][y]
    System.out.println(hex+"dhfhdfjh");
    return(Integer.toHexString(hex));
  }
  String operand1()
  {
    return(operand1);
  }
  String operand2()
  {
    return(operand2);
  }
}
