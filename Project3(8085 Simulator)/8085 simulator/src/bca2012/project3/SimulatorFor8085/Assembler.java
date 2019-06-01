package bca2012.project3.SimulatorFor8085;
//import sic.OpcodeTable;
//import sic.SourceLine;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
class Assembler 
{
  OpcodeTable opTab;
  ArrayList<SourceLine> line;
  Map<String,Integer> symTab;
  Registers r= new Registers();
  int location;
  BufferedReader input1;
  String temp;
  /**
   * @param source file with assembly code.
   */
  public Assembler(String source)throws FileNotFoundException
  {
    Pair.initialise();
    r.initialise();
    opTab= new OpcodeTable("opcode1s8085.txt");
    symTab= new HashMap<String,Integer>(); 
    line= new ArrayList<SourceLine>();
    input1= new BufferedReader(new FileReader("objcode.txt"));
    firstPass(source);
    secondPass();
  }
  void firstPass(String source)throws FileNotFoundException	//takes file
  {
    String l,opcode="",operand,label;
    boolean first= true;
    try
    {
      BufferedReader input= new BufferedReader(new FileReader(source));
      while((l= input.readLine()) != null)//reading line by line from source file.
      {
        l= l.trim();
        System.out.println(l+" in assembler");
        SourceLine sl= new SourceLine();
	if(!l.equals(""))
          sl= new SourceLine(l,opTab);//sending line by line for SourceLine class for parsing it.
	else
	  continue;
	if(first)							//if it is first line.
	{
		if((opcode= sl.getOpcode()) != null)//if opcode exist
		{
	        	if(opcode.equals("START"))//if it is start initializing starting address as operand.
			{
				temp=	sl.getLocation();
				if(temp == null)
				{
					JOptionPane.showMessageDialog(null, "address required for "+opcode, "alert", JOptionPane.ERROR_MESSAGE); 
			    	Loader.setError();
				}
				else
				{
					Loader.incLine();
					Hextodec h= new Hextodec();
					location= h.getDecimalNum(sl.getLocation());
					first= false;
				}
			}
		}
	}
	if(!sl.getOpcode().equals("START"))
	{
	  sl.setAddress(location);
	  if((label= sl.getLabel()) != null)//if line has a label
	  {
		  if(symTab.get(label) == null)//if label not exist already.
			  symTab.put(label,location);
		  else							//else throw an error
		  {
			  JOptionPane.showMessageDialog(null, "Label "+label+" already exist", "alert", JOptionPane.ERROR_MESSAGE); 
			  Loader.setError();
		  }
	  }
	  location+= sl.getSize();//next line address is calculated according to size of this opcode.
          line.add(sl);			//adding each splitted line to arraylist.
	}
      }
    }
    catch(Exception io)
    {
      System.out.println(io);
    }
  }
  /**
   * This deals with the second pass.
   * @throws FileNotFoundException
   */
  void secondPass()throws FileNotFoundException//making object code and writing to objcode.txt file.
  {
    String str;
    try
    {
      BufferedWriter out= new BufferedWriter(new FileWriter("objcode.txt"));
      SourceLine sl;
      String hex,opcode,hexacode,operand;
      Integer address;
      for(int i= 0;i < line.size();i++) 
      {
        sl= line.get(i);
        if((opcode= sl.getOpcode()) != null)//if opcode exist
        {
		str= Integer.toHexString(sl.getAddress()).toUpperCase();//get address of opcode
		while(str.length() < 4)
		{
			str= "0" + str;
		}
		out.write(str +"     ");//write into object.txt file
                out.flush();
                hexacode= sl.getHex();
		if(hexacode.length() == 1)
               	  out.write("0");
               	out.write(hexacode);
		if(sl.getSize() == 2)		//if size of opcode is 2
		{
			if(sl.getData() == null)//data is required
			{
				JOptionPane.showMessageDialog(null, "data required for "+opcode, "alert", JOptionPane.ERROR_MESSAGE); 
		    	Loader.setError();
			}
			else if(sl.getData().length() > 2)
			{
				JOptionPane.showMessageDialog(null, "only 8-bit data should be enterd "+sl.getData(), "alert", JOptionPane.ERROR_MESSAGE); 
			    	Loader.setError();
				return;
			}
			else
				out.write(sl.getData());//write data to file.
		}
		if(sl.getSize() == 3)//if size is 3
		{
			if((hexacode= sl.getLocation()) == null)
			{
			    JOptionPane.showMessageDialog(null, "no Label or Address enterd", "alert", JOptionPane.ERROR_MESSAGE); 
			    Loader.setError();
			}
			else if((address= symTab.get(sl.getLocation())) == null)
			{
			  if(hexacode.length() > 4)
			  {
			    JOptionPane.showMessageDialog(null, "adress should be in 16-bit "+hexacode, "alert", JOptionPane.ERROR_MESSAGE); 
			    Loader.setError();
			    return;
			  }
                          while(hexacode.length() < 4)
                            hexacode= "0" + hexacode;
			  out.write(hexacode.substring(2,4));
			  out.write(hexacode.substring(0,2));
			}
			else
			{
			  hexacode= Integer.toHexString(address).toUpperCase();
                          while(hexacode.length() < 4)
                            hexacode= "0" + hexacode;
			  out.write(hexacode.substring(2,4));
			  out.write(hexacode.substring(0,2));
			}
		}
                out.newLine();
                out.flush();
        }
      }
    }
    catch(IOException io)
    {
      System.out.println(io);
    }

  }
  public String toString()
  {
    try
    {
      String l;
      System.out.println(opTab);
      Set<String> key= symTab.keySet();
      System.out.println("________________");
      System.out.println("[1;32mLABEL	LOCATION[0m|");
      System.out.println("________________|");

      for(String s : key)
	System.out.println(s+"	"+symTab.get(s)+"	|");//printing SYMTAB 
      System.out.println("________________|");
      System.out.println("\n[4;32mOBJECT CODE[0m");
      while((l= input1.readLine()) != null)
        System.out.println(l);
    }
    catch(IOException io)
    {
      System.out.println(io);
    }
      return("\n");
  }
  public static void main(String[] args) throws FileNotFoundException
  {
      Assembler asemb= new Assembler("test.txt");
      asemb.secondPass();
      System.out.println(asemb);
  }
}
