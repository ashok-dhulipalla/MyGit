package bca2012.project3.SimulatorFor8085;
import java.util.*; 
import java.io.*; 
import javax.swing.JOptionPane; 
class Loader 
{ 
  private static String code;
  private static Simulator s= new Simulator();
  private static Map<String,String> objcodeTab; 
  private static Registers r= new Registers(); 
  private static Hextodec h= new Hextodec(); 
  private static Flags f= new Flags(); 
  private static Instruction i= new Instruction(); 
  private static int linecount= 0;
  private static  boolean error= false;
  private static String startAddress;
  private static Memory memory= new Memory(); 
  Loader()
  {
    objcodeTab= new HashMap<String,String>();
    readAndLoad();
    assign();
  }
  public void readAndLoad()//reads object code and load into memory as specified.
  {
    String l;
    boolean first= true;
    String[] arr;
    int row= 0;
    try
    {
      BufferedReader input= new BufferedReader(new FileReader("objcode.txt"));
      while((l= input.readLine()) != null)
      {
        l= l.trim();
        arr= l.split("\\p{Blank}+"); 
	if(h.getDecimalNum(arr[0]) < 65535)
	{
       	if(first)
        {
       		r.setPC(arr[0]);//setting PC as starting adress.
			startAddress= arr[0];
			first= false;
        }
        objcodeTab.put(arr[0],arr[1]);//putting object code in Hash map with key as address.
	    memory.assignData(arr[0],arr[1]);//writing object code to the memory.
		s.put(arr[0],linecount);//putting line number of that particular PC.
		linecount++;//increasing line number.
		int j= 0;
		//writing object code in hexadecimal form in the hexacode JTable
		for(int i= 0;i < (arr[1].length()/2) && error == false;i++)
		{
			s.setValuehex(arr[0],row,0);
			s.setValuehex(arr[1].substring(j,j+2),row,1);
			j += 2;
			row++;
			arr[0]= Integer.toHexString(h.getDecimalNum(arr[0]) + 1); 
			while(arr[0].length() < 4)
				arr[0]= "0" + arr[0];
		}
		row++;
	}
	else
	{
		JOptionPane.showMessageDialog(null, "Memory not supported", "alert", JOptionPane.ERROR_MESSAGE);
		Loader.setError();
		break;
	}
      }
      System.out.println(objcodeTab);
    }
    catch(IOException io)
    {
      System.out.println(io);
    }
  }
  /**
   * 
   */
  public void assign()//takes input from memory
  {
    String address, data;
    for(int i= 0;i < s.rowsNumber();i++)
    {
      address= s.getValue(i,0);
      if( address != null && address.length() > 4)//if address length is more than 16-bit.
      {
		JOptionPane.showMessageDialog(null, "address should be in 16-bit in meory "+address, "alert", JOptionPane.ERROR_MESSAGE); 
		error= true;
		return;
      }
      if(address != null && ((data= s.getValue(i,1)) != null))
      {
    	  if(data.length() > 2)//data is more than 8-bit.
    	  {
    		  	JOptionPane.showMessageDialog(null, "Input should be in 8-bit in memory "+data, "alert", JOptionPane.ERROR_MESSAGE); 
    		  	error= true;
    		  	return;
    	  }
    	  System.out.println(address+"testing");
    	  memory.assignData(address,data);  
      }
    }
    if(!s.getIn1().equals(""))
    	r.setPort1(s.getIn1());
    if(!s.getIn2().equals(""))
    	r.setPort2(s.getIn2());
    if(!s.getIn3().equals(""))
    	r.setPort3(s.getIn3());
  }
  public static void executer()//executes one step
  {
      System.out.println(r.getPC());
      code= objcodeTab.get(r.getPC());
      i.execute(code); 
      s.update();
  }
  public static void main(String[] args)throws FileNotFoundException
  {
    Loader ld;
    if(args.length != 1)
    {
      System.out.println("USAGE: java Loader sourceFileName.");
      return;
    }
    Assembler as= new Assembler(args[0]);
    System.out.println(as);
    if(error)
    {
    }
    else
      ld= new Loader();
  }
  public static void incLine()
  {
    linecount++;
  }
  public static void zero()
  {
    linecount= 0;
  }
  public static void setError()
  {
    error= true;
  }
  public static void resetError()
  {
    error= false;
  }
  public static boolean getError()
  {
    return(error);
  }
  public static String getAddress()//returns starting address for this program.
  {
    return(startAddress);
  }
}
