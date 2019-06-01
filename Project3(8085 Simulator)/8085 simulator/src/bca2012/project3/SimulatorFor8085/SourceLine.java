package bca2012.project3.SimulatorFor8085;
import java.util.*;
import java.io.*;
import javax.swing.JDialog;
import javax.swing.Popup;
import javax.swing.JOptionPane;
public class SourceLine
{
  private String label,opcode,reg1,reg2,data,location,hex;
  private int size,address;
  public SourceLine()
  {
  }
  /*
   * the function sourceLine takes each line of the assembly code and parses it and assign as
   * label,opcode,reg1,reg2,data,location.
   */
  public SourceLine(String s,OpcodeTable opTab) throws RuntimeException, IOException
  {
    System.out.println(s);
    s= s.trim();
    String[] arr;
    String[] arr1;
    String[] arr2;
    arr2= s.split("//");
    if(arr2.length == 2)
    {
    	s= arr2[0];
    }
    arr1= s.split(":");
    if(arr1.length == 2)				//separating label from the line of code.
    {
      label= arr1[0];
      arr1[1]= arr1[1].trim();
      arr= arr1[1].split("\\p{Blank}+");
    }
    else
    {
      arr= s.split("\\p{Blank}+");			//splitting remaining line after separating label.
    }
    switch(arr.length)
    {
      case 1:						//if only one word then it must be opcode.
		opcode= arr[0];
		calculateHex(opTab);
		break;
      case 2:						//if two words.
		opcode= arr[0];				//first word must be opcode.
		if(opTab.getSize(arr[0]) == 1)
		{
			reg1= arr[1];			//if size of opcode is 1,then other word must be register.
		}
		else
		{
			if(opTab.getSize(arr[0]) == 2)
			{
				if(arr[1].length() == 1)
					arr[1]= "0" + arr[1];
				data= arr[1];		//if size of opcode is 2,then other word must be data.
			}
			else
			{
				location= arr[1];	//if size of opcode is 3,then other word must be address.
			}
		}
		calculateHex(opTab);
		break;
      case 3:						//if words are three
		opcode= arr[0];				//first word must be opcode.
		reg1= arr[1];				//second word must be register.
		if(opTab.getSize(arr[0]) == 1)		//if size of opcode is 1,then third word must be source register.
		{
			reg2= arr[2];
		}
		else					
		{
			if(opTab.getSize(arr[0]) == 2)	//if size of opcode is 2,then third word must be the data.	
			{
				if(arr[2].length() == 1)
					arr[2]= "0" + arr[2];
				data= arr[2];
			}
			else				//if size of opcode is 3,then third word must be the address.
			{
				location= arr[2];
			}
		}
		calculateHex(opTab);
		break;
      default:						//if length is more than 3,gives an error message.
    	  JOptionPane.showMessageDialog(null, "wrong frmat", "alert", JOptionPane.ERROR_MESSAGE); 
		  Loader.setError();
    }
    size= opTab.getSize(opcode);
  }
  public int getSize()
  {
    return(size);
  }
  void setSize(int size)
  {
    this.size= size;
  }
  public String getData()
  {
    return(data);
  }
  void setData(String size)
  {
    this.data= data;
  }
  public int getAddress()
  {
    return(address);
  }
  void setAddress(int address)
  {
    this.address= address;
  }
  public String getLocation()
  {
    return(location);
  }
  void setLocation(String location)
  {
    this.location= location;
  }
  public String getHex()
  {
    return(hex);
  }
  void calculateHex(OpcodeTable opTab) throws IOException
  {
      String str= "register not found...after ";
      String str1= "register1 not found...after ";
      String str2= "register2 not found...after ";
      String err="register";
      String err1=" not exist";
      switch(opcode)
      {
        case "ADD":case "SUB":case "ADC":case "ANA":case "CMP":case "ORA":case "SBB":case "XRA":
		if(reg1 == null || RegId.getId(reg1) == -1)
		{
			if(reg1 != null)//no such register.
				JOptionPane.showMessageDialog(null,err+" "+reg1+err1, "alert", JOptionPane.ERROR_MESSAGE); 
			else		//register required.
				JOptionPane.showMessageDialog(null, str+opcode, "alert", JOptionPane.ERROR_MESSAGE); 
			Loader.setError();
		}
		else
		{
			if(reg1.equals("B") || reg1.equals("C") || reg1.equals("D") || reg1.equals("E") || reg1.equals("H") || reg1.equals("L") || reg1.equals("M") || reg1.equals("A"))
			{
				hex= opTab.getHexcodeplus(opcode,0,RegId.getId(reg1));//calucates hexcode for particular opcode.
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"register "+reg1+" not applicable for the "+opcode, "alert", JOptionPane.ERROR_MESSAGE);//this register is not applicable for this opcode.
				Loader.setError();
			}
		}
  		break;
        case "DAD":case "DCX":case "INX":case "LXI":
		if(reg1 == null || RegId.getId(reg1) == -1)
		{
			if(reg1 != null)//no such register.
				JOptionPane.showMessageDialog(null,err+" "+reg1+err1, "alert", JOptionPane.ERROR_MESSAGE); 
			else if(opcode.equals("LXI"))
				JOptionPane.showMessageDialog(null, "LXI takes one register and address", "alert", JOptionPane.ERROR_MESSAGE); 
			else 		//register required.
				JOptionPane.showMessageDialog(null, str+opcode, "alert", JOptionPane.ERROR_MESSAGE); 
			Loader.setError();
		}
		else
		{
			if(reg1.equals("B") || reg1.equals("D") || reg1.equals("H") || reg1.equals("SP"))
			{
				hex= opTab.getHexcodeplus(opcode,RegId.getId(reg1),0);//calucates hexcode for particular opcode.
				
			}
			else//this register is not applicable for this opcode.
			{
				JOptionPane.showMessageDialog(null,"register "+reg1+" not applicable for the "+opcode, "alert", JOptionPane.ERROR_MESSAGE);
				Loader.setError();
			}

		}
  		break;
        case "LDAX":case "STAX":
		if(reg1 == null || RegId.getId(reg1) == -1)
		{
			if(reg1 != null)//no such register.
				JOptionPane.showMessageDialog(null,err+" "+reg1+err1, "alert", JOptionPane.ERROR_MESSAGE); 
			else		//register required.
				JOptionPane.showMessageDialog(null, str+opcode, "alert", JOptionPane.ERROR_MESSAGE); 
			Loader.setError();
		}
		else
		{
			if(reg1.equals("B") || reg1.equals("D"))
			{
				hex= opTab.getHexcodeplus(opcode,RegId.getId(reg1),0);//calucates hexcode for particular opcode.
			}
			else//this register is not applicable for this opcode.
			{
				JOptionPane.showMessageDialog(null,"register "+reg1+" not applicable for the "+opcode, "alert", JOptionPane.ERROR_MESSAGE);
				Loader.setError();
			}
		}
  		break;
        case "PUSH":case "POP":
		if(reg1 == null || RegId.getId(reg1) == -1)
		{
			if(reg1 != null)//no such register.
				JOptionPane.showMessageDialog(null,err+" "+reg1+err1, "alert", JOptionPane.ERROR_MESSAGE); 
			else		//register required.
				JOptionPane.showMessageDialog(null, str+opcode, "alert", JOptionPane.ERROR_MESSAGE); 
			Loader.setError();
		}
		else
		{
			if(reg1.equals("B") || reg1.equals("D")  || reg1.equals("H")  || reg1.equals("PSW"))
			{
				hex= opTab.getHexcodeplus(opcode,RegId.getId(reg1),0);//calucates hexcode for particular opcode.
			}
			else//this register is not applicable for this opcode.
			{
				JOptionPane.showMessageDialog(null,"register "+reg1+" not applicable for the "+opcode, "alert", JOptionPane.ERROR_MESSAGE);
				Loader.setError();
			}
		}
  		break;
        case "DCR":case "INR":case "MVI":
		if(reg1 == null || RegId.getId(reg1) == -1)
		{
			if(reg1 != null)//no such register.
				JOptionPane.showMessageDialog(null,err+" "+reg1+err1, "alert", JOptionPane.ERROR_MESSAGE); 
			else if(opcode.equals("MVI"))
				JOptionPane.showMessageDialog(null, "MVI takes one register and data", "alert", JOptionPane.ERROR_MESSAGE);
			else 		//register required.
				JOptionPane.showMessageDialog(null, str+opcode, "alert", JOptionPane.ERROR_MESSAGE); 
			Loader.setError();
		}
		else
		{
			if(reg1.equals("B") || reg1.equals("C") || reg1.equals("D") || reg1.equals("E") || reg1.equals("H") || reg1.equals("L") || reg1.equals("M") || reg1.equals("A"))
			{
				hex= opTab.getHexcodeplus(opcode,RegId.getId(reg1),0);//calucates hexcode for particular opcode.
			}
			else//this register is not applicable for this opcode.
			{
				JOptionPane.showMessageDialog(null,"register "+reg1+" not applicable for the "+opcode, "alert", JOptionPane.ERROR_MESSAGE);
				Loader.setError();
			}
		}
  		break;
        case "MOV":
		if(reg1 == null || RegId.getId(reg1) == -1)
		{
			if(reg1 != null)//no such register.
				JOptionPane.showMessageDialog(null,err+" "+reg1+err1, "alert", JOptionPane.ERROR_MESSAGE); 
			else		//register required.
				JOptionPane.showMessageDialog(null, str1+opcode, "alert", JOptionPane.ERROR_MESSAGE); 
			Loader.setError();
		}
		else if(reg2 == null || RegId.getId(reg2) == -1)
		{
			if(reg2 != null)//no such register.
				JOptionPane.showMessageDialog(null,err+" "+reg2+err1, "alert", JOptionPane.ERROR_MESSAGE); 
			else		//register required.
				JOptionPane.showMessageDialog(null, str2+opcode, "alert", JOptionPane.ERROR_MESSAGE); 
			Loader.setError();
		}
		else if(reg1.equals("B") || reg1.equals("C") || reg1.equals("D") || reg1.equals("E") || reg1.equals("H") || reg1.equals("L") || reg1.equals("M") || reg1.equals("A"))
		{
			if(reg2.equals("B") || reg2.equals("C") || reg2.equals("D") || reg2.equals("E") || reg2.equals("H") || reg2.equals("L") || reg2.equals("M") || reg2.equals("A"))
			{
				hex= opTab.getHexcodeplus(opcode,RegId.getId(reg1),RegId.getId(reg2));//calucates hexcode for particular opcode.
			}
			else//this register1 is not applicable for this opcode.
			{
				JOptionPane.showMessageDialog(null,"register "+reg2+" not applicable for the "+opcode, "alert", JOptionPane.ERROR_MESSAGE);
				Loader.setError();
			}
		}
		else//this register2 is not applicable for this opcode.
		{
			JOptionPane.showMessageDialog(null,"register "+reg1+" not applicable for the "+opcode, "alert", JOptionPane.ERROR_MESSAGE);
			Loader.setError();
	        
		}
  		break;
        default:
		hex= opTab.getHexcode(opcode);
      } 
      hex= hex.toUpperCase();
  }
  public String getReg1()
  {
    return(reg1);
  }
  public void setReg1(String s)
  {
    reg1= s;
  }
  public String getReg2()
  {
    return(reg2);
  }
  public void setReg2(String s)
  {
    reg2= s;
  }
  public String getOpcode()
  {
    return(opcode);
  }
  public String getLabel()
  {
    return(label);
  }
  public void setOpcode(String s)
  {
    opcode= s;
  }
  public String toString()
  {
    return("{label= "+ label+", opcode= "+ opcode+", reg1= "+ reg1+",reg2= "+reg2+", size= "+size+", data= "+data+", address= "+address+",location= "+location+", hex= "+hex);
  }
}
