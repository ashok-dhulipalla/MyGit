package bca2012.project3.SimulatorFor8085;
//package sic;
import java.io.*;

import javax.swing.JOptionPane;
class Instruction
{
  private Hextodec h= new Hextodec();
  private Bintodec b= new Bintodec();
  private Registers r= new Registers();
  private Flags f= new Flags();
  private Memory memory= new Memory();
  private Simulator sim= new Simulator();
  public void execute(String s)
  {
//    System.out.println(s);
    r.incPC(s.length()/2);
    String str,str1;
    char temp,temp1;
    char arr[];
    int i,j;
    switch(s.substring(0,2))
    {
      case "00"://No Operation
		break;
      case "01":// LXI B ADDRESS...Load address into BC Pair
		r.setC(s.substring(2,4));
		r.setB(s.substring(4,6));
		System.out.println("01");
		break;
      case "02"://STAX B...Store accumulator value into BC pair
		str= r.getB() + r.getC();
		memory.assignData(str,r.getA());
		System.out.println("02");
		break;
      case "03"://INX B...Increment BC pair by 1
		r.incPairB();		
		System.out.println("03");
		break;
      case "04"://INR B...Increment register B by 1
		r.incB();
		f.checkS(r.getB());
		f.checkZ(r.getB());
		f.checkP(r.getB());
		System.out.println("04");
		break;
      case "05"://DCR B...Decrement register B by 1
		r.decB();
		f.checkS(r.getB());
		f.checkZ(r.getB());
		f.checkP(r.getB());
		System.out.println("05");
		break;
      case "06"://MVI B DATA...Move Data to Register B immediately
		r.setB(s.substring(2,4));
		System.out.println("06");
		break;
      case "07"://RLC ...Rotate Accumulator value in Binary by one position Left
		str= Integer.toBinaryString(h.getDecimalNum(r.getA()));
		while(str.length() < 8)
		{
			str= "0" + str;
		}
		arr= str.toCharArray();
		if(arr[0] == '0')
			f.setCY(0);
		else
			f.setCY(1);
		temp= arr[0];

                for(i= 0;i < 7;i++)
		{
			arr[i]= arr[i+1];	
		}
		arr[7]= temp;
		str= String.valueOf(arr);
		
		r.setA(Integer.toHexString(b.getDecimalNum(str)));

		System.out.println("07");
		break;
      case "09"://DAD B...ADD BC PAIR TO THE HL PAIR REGISTERS.
		str= r.getB() + r.getC();
		str1= r.getH() + r.getL();
		str= additionOf16Bit(h.getDecimalNum(str) ,h.getDecimalNum(str1));
		r.setH(str.substring(0,2));
		r.setL(str.substring(2,4));
		r.setM(memory.getData(r.getH() + r.getL()));
		System.out.println("09");
		break;
      case "0A"://LDAX B ...Load BC Pair to accumulator
		str= r.getB() + r.getC();
		r.setA(memory.getData(str));
		System.out.println("0A");
		break;
      case "0B"://DCX B...Decrement BC pair by 1
		r.decPairB();		
		System.out.println("0B");
		break;
      case "0C"://INR C...Increment Register C by 1
		r.incC();
		f.checkS(r.getC());
		f.checkZ(r.getC());
		f.checkP(r.getC());
		System.out.println("0C");
		break;
      case "0D"://DCR C...Decrement Register C by 1
		r.decC();
		f.checkZ(r.getC());
		f.checkP(r.getC());
		f.checkS(r.getC());
		System.out.println("0D");
		break;
      case "0E"://MVI C DATA...Move Data to Register C immediately
		r.setC(s.substring(2,4));
		System.out.println("0E");
		break;
      case "0F"://RRC...Rotate Accumulator value in Binary by one position Right
		str= Integer.toBinaryString(h.getDecimalNum(r.getA()));
		while(str.length() < 8)
		{
			str= "0" + str;
		}
		arr= str.toCharArray();

		f.setCY(arr[7]);
		temp= arr[7];

                for(i= 7;i > 0;i--)
		{
			arr[i]= arr[i-1];	
		}
		arr[0]= temp;
		str= String.valueOf(arr);
		
		r.setA(Integer.toHexString(b.getDecimalNum(str)));

		System.out.println("0F");
		break;
      case "11"://LXI D ADDRESS...Load address into DE Pair
		r.setE(s.substring(2,4));
		r.setD(s.substring(4,6));
		System.out.println("11");
		break;
      case "12"://STAX D...Store accumulator value into DE pair 
		str= r.getD() + r.getE();
		memory.assignData(str,r.getA());
		System.out.println("12");
		break;
      case "13"://INX D...Increment DE pair by 1
		r.incPairD();		
		System.out.println("13");
		break;
      case "14"://INR D...Increment Register D by 1
		r.incD();
		f.checkS(r.getD());
		f.checkZ(r.getD());
		f.checkP(r.getD());
		System.out.println("14");
		break;
      case "15"://DCR D...Decrement Register D by 1
		r.decD();
		f.checkS(r.getD());
		f.checkZ(r.getD());
		f.checkP(r.getD());
		System.out.println("15");
		break;
      case "16"://MVI D DATA...Move Data to Register D immediately
		r.setD(s.substring(2,4));
		System.out.println("16");
		break;
      case "17"://RAL...Rotate Accumulator value in Binary by one position Left through Carry
		str= Integer.toBinaryString(h.getDecimalNum(r.getA()));
		while(str.length() < 8)
		{
			str= "0" + str;
		}
		arr= str.toCharArray();

		str1= Integer.toString(f.getCY());	
		temp= str1.charAt(0);
		f.setCY(arr[0]);

                for(i= 0;i < 7;i++)
		{
			arr[i]= arr[i+1];	
		}
		arr[7]= temp;
		str= String.valueOf(arr);
		
		r.setA(Integer.toHexString(b.getDecimalNum(str)));

		System.out.println("17");
		break;
      case "19"://DAD D...ADD DE PAIR TO THE HL PAIR REGISTERS.
		str= r.getD() + r.getE();
		str1= r.getH() + r.getL();
		str= additionOf16Bit(h.getDecimalNum(str) ,h.getDecimalNum(str1));
		r.setH(str.substring(0,2));
		r.setL(str.substring(2,4));
		System.out.println("19");
		break;
      case "1A"://LDAX D...Load DE Pair to accumulator
		str= r.getD() + r.getE();
		r.setA(memory.getData(str));
		System.out.println("1A");
		break;
      case "1B"://DCX D...Decrement DE pair by 1
		r.decPairD();		
		System.out.println("1B");
		break;
      case "1C"://INR E...Increment Register E by 1
		r.incE();
		f.checkS(r.getE());
		f.checkZ(r.getE());
		f.checkP(r.getE());
		System.out.println("1C");
		break;
      case "1D"://DCR E...Decrement register E by 1
		r.decE();
		f.checkS(r.getE());
		f.checkZ(r.getE());
		f.checkP(r.getE());
		System.out.println("1D");
		break;
      case "1E"://MVI E DATA...Move Data to Register E immediately
		r.setE(s.substring(2,4));
		System.out.println("1E");
		break;
      case "1F"://RAR...Rotate Accumulator value in Binary by one position Right through Carry
		str= Integer.toBinaryString(h.getDecimalNum(r.getA()));
		while(str.length() < 8)
		{
			str= "0" + str;
		}
		arr= str.toCharArray();

		str1= Integer.toString(f.getCY());	
		temp= str1.charAt(0);
		f.setCY(arr[7]);

                for(i= 7;i > 0;i--)
		{
			arr[i]= arr[i-1];	
		}
		arr[0]= temp;
		str= String.valueOf(arr);
		
		r.setA(Integer.toHexString(b.getDecimalNum(str)));

		System.out.println("1F");
		break;
      case "20"://RIM...Read Status of the Interrupt
		break;
      case "21"://LXI H ADDRESS...Load address into HL Pair
		r.setL(s.substring(2,4));
		r.setH(s.substring(4,6));
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("21");
		break;
      case "22"://SHLD ADDRESS...contents of H and L are Stored into address
		str= s.substring(4,6) + s.substring(2,4);
		memory.assignData(str,r.getL());
		i= h.getDecimalNum(str);
		i++;
		str= Integer.toHexString(i);
		while(str.length() < 4)
		{
			str= "0" + str;
		}
		memory.assignData(str,r.getH());
		System.out.println("22");
		break;
      case "23"://INX H...Increment HL pair by 1
		r.incPairH();		
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("23");
		break;
      case "24"://INR H...Increment Register H by 1
		r.incH();
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		f.checkS(r.getH());
		f.checkZ(r.getH());
		f.checkP(r.getH());
		System.out.println("24");
		break;
      case "25"://DCR H...Decrement Register H by 1
		r.decH();
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		f.checkS(r.getH());
		f.checkZ(r.getH());
		f.checkP(r.getH());
		System.out.println("25");
		break;
      case "26"://MVI H DATA...Move Data to Register H immediately
		r.setH(s.substring(2,4));
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("26");
		break;
      case "27"://DAA....CONTENT OF A REGISTER IS CHANGED FROM BINARY VALUE TO THE 4-BIT BINARY CODED DECIMAL DIGITS(BCD).
		str= r.getA();
		i= h.getDecimalNum(str);
		str= Integer.toBinaryString(i);
		while(str.length() < 8)
		{
			str= "0" + str;
		}
		if(b.getDecimalNum(str.substring(4,8)) > 9)
		{
			i= i + 6;
		}
		if(b.getDecimalNum(str.substring(0,4)) > 9)
		{
			i= i + 96;
		}
		str= Integer.toHexString(i);
		if(str.length() > 2)
		{
			f.setCY(1);
			str= str.substring(1,3);
		}
		r.setA(str);
		System.out.println("27");
		break;
      case "29"://DAD H...ADD HL PAIR TO THE HL PAIR REGISTERS.
		str= r.getH() + r.getH();
		str= additionOf16Bit(h.getDecimalNum(str) ,h.getDecimalNum(str));
		r.setH(str.substring(0,2));
		r.setL(str.substring(2,4));
		r.setM(memory.getData(r.getH() + r.getL()));
		System.out.println("29");
		break;
      case "2A"://LHLD ADDRESS...Load data in address into HL pair directly
		str= s.substring(4,6) + s.substring(2,4);
		r.setL(memory.getData(str));
		i= h.getDecimalNum(str);
		i++;
		str= Integer.toHexString(i);
		while(str.length() < 4)
		{
			str= "0" + str;
		}
		r.setH(memory.getData(str));
		System.out.println("2A");
		break;
      case "2B"://DCX H...Decrement HL pair by 1
		r.decPairH();		
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("2B");
		break;
      case "2C"://INR L...Increment Register L by 1
		r.incL();
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		f.checkS(r.getL());
		f.checkZ(r.getL());
		f.checkP(r.getL());
		System.out.println("2C");
		break;
      case "2D"://DCR L...Decrement Register L by 1
		r.decL();
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		f.checkS(r.getL());
		f.checkZ(r.getL());
		f.checkP(r.getL());
		System.out.println("2D");
		break;
      case "2E"://MVI L DATA...Move Data to Register L immediately
		r.setL(s.substring(2,4));
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("2E");
		break;
      case "2F"://CMA...Complement A
		str1= "";
		i= h.getDecimalNum(r.getA());
		str= Integer.toBinaryString(i);
		while(str.length() < 8)
		{
			str= "0" + str;
		}
		for(i= 0;i < 8;i++)
		{
			if(str.charAt(i) == '0')
			{
				str1= str1 + "1";
			}
			else
			{
				str1= str1 + "0";
			}
		}
		i= b.getDecimalNum(str1);
		str= Integer.toHexString(i);
		r.setA(str);
		System.out.println("2F");
		break;
      case "30"://SIM...Set Interrupt mask
		break;
      case "31"://LXI SP ADDRESS...Load address into SP
		str= s.substring(4,6) + s.substring(2,4);
		r.setSP(str);
		System.out.println("31");
		break;
      case "32"://STA ADDRESS...Store Accululator value into address
		str= s.substring(4,6) + s.substring(2,4);
		r.insert(str);
		memory.assignData(str,r.getA());
		System.out.println("32");
		break;
      case "33"://INX SP...Increment SP pair by 1
		r.incPairSP();		
		System.out.println("33");
		break;
      case "34"://INR M...Increment Register M by 1
		r.incM();
		str= r.getH() + r.getL();
		memory.assignData(str,r.getM());
		f.checkS(r.getM());
		f.checkZ(r.getM());
		f.checkP(r.getM());
		System.out.println("34");
		break;
      case "35"://DCR M...Decrement Register M by 1
		r.decM();
		str= r.getH() + r.getL();
		memory.assignData(str,r.getM());
		f.checkS(r.getM());
		f.checkZ(r.getM());
		f.checkP(r.getM());
		System.out.println("35");
		break;
      case "36"://MVI M DATA...Move Data to Register M immediately
		r.setM(s.substring(2,4));
		str= r.getH() + r.getL();
		memory.assignData(str,r.getM());
		System.out.println("36");
		break;
      case "37"://STC...Set Carry flag to 1
		f.setCY(1);
		System.out.println("37");
		break;
      case "39"://DAD SP...ADD SP PAIR TO THE HL PAIR REGISTERS.
		str= r.getSP();
		str1= r.getH() + r.getL();
		str= additionOf16Bit(h.getDecimalNum(str) ,h.getDecimalNum(str1));
		r.setH(str.substring(0,2));
		r.setL(str.substring(2,4));
		System.out.println("39");
		break;
      case "3A"://LDA ADDRESS...Load Data in address into A
		str= s.substring(4,6) + s.substring(2,4);
		r.insert(str);
		r.setA(memory.getData(str));
		System.out.println("3A");
		break;
      case "3B"://DCX SP...Decrement SP by 1
		r.decPairSP();		
		System.out.println("3B");
		break;
      case "3C"://INR A...Increment Register A by 1
		r.incA();
		f.checkS(r.getA());
		f.checkZ(r.getA());
		f.checkP(r.getA());
		System.out.println("3C");
		break;
      case "3D"://DCR A...Decrement Register A By 1
		r.decA();
		f.checkS(r.getA());
		f.checkZ(r.getA());
		f.checkP(r.getA());
		System.out.println("3D");
		break;
      case "3E"://MVI A DATA...Move Data to Register A immediately
		r.setA(s.substring(2,4));
		System.out.println("3E");
		break;
      case "3F"://CMC...Complement with Carry
		if(f.getCY() == 1)
			f.setCY(0);
		else
			f.setCY(1);
		System.out.println("3F");
		break;
      case "40"://MOV B B...Move Value in Register B to Register B
		r.setB(r.getB());
		System.out.println("40");
		break;
      case "41"://MOV B C...Move Value in Register C to Register B
		r.setB(r.getC());
		System.out.println("41");
		break;
      case "42"://MOV B D...Move Value in Register D to Register B
		r.setB(r.getD());
		System.out.println("42");
		break;
      case "43"://MOV B E...Move Value in Register E to Register B
		r.setB(r.getE());
		System.out.println("43");
		break;
      case "44"://MOV B H...Move Value in Register H to Register B
		r.setB(r.getH());
		System.out.println("44");
		break;
      case "45"://MOV B L...Move Value in Register L to Register B
		r.setB(r.getL());
		System.out.println("45");
		break;
      case "46"://MOV B M...Move Value in Register M to Register B
		r.setB(r.getM());
		System.out.println("46");
		break;
      case "47"://MOV M A...Move Value in Register A to Register B
		r.setB(r.getA());
		System.out.println("47");
		break;
      case "48"://MOV C B...Move Value in Register B to Register C
		r.setC(r.getB());
		System.out.println("48");
		break;
      case "49"://MOV C C...Move Value in Register C to Register C
		r.setC(r.getC());
		System.out.println("49");
		break;
      case "4A"://MOV C D...Move Value in Register D to Register C
		r.setC(r.getD());
		System.out.println("4A");
		break;
      case "4B"://MOV C E...MOV C B...Move Value in Register E to Register C
		r.setC(r.getE());
		System.out.println("4B");
		break;
      case "4C"://MOV C H...Move Value in Register H to Register C
		r.setC(r.getH());
		System.out.println("4C");
		break;
      case "4D"://MOV C L...Move Value in Register L to Register C
		r.setC(r.getL());
		System.out.println("4D");
		break;
      case "4E"://MOV C M...Move Value in Register M to Register C
		r.setC(r.getM());
		System.out.println("4E");
		break;
      case "4F"://MOV C A...Move Value in Register A to Register C
		r.setC(r.getA());
		System.out.println("4F");
		break;
      case "50"://MOV D B...Move Value in Register B to Register D
		r.setD(r.getB());
		System.out.println("50");
		break;
      case "51"://MOV D C...Move Value in Register C to Register D
		r.setD(r.getC());
		System.out.println("51");
		break;
      case "52"://MOV D D...Move Value in Register D to Register D
		r.setD(r.getD());
		System.out.println("52");
		break;
      case "53"://MOV D E...Move Value in Register E to Register D
		r.setD(r.getE());
		System.out.println("53");
		break;
      case "54"://MOV D H...Move Value in Register H to Register D
		r.setD(r.getH());
		System.out.println("54");
		break;
      case "55"://MOV D L...Move Value in Register L to Register D
		r.setD(r.getL());
		System.out.println("55");
		break;
      case "56"://MOV D M...Move Value in Register M to Register D
		r.setD(r.getM());
		System.out.println("56");
		break;
      case "57"://MOV D A...Move Value in Register A to Register D
		r.setD(r.getA());
		System.out.println("57");
		break;
      case "58"://MOV E B...Move Value in Register B to Register E
		r.setE(r.getB());
		System.out.println("58");
		break;
      case "59"://MOV E C...Move Value in Register C to Register E
		r.setE(r.getC());
		System.out.println("59");
		break;
      case "5A"://MOV E D...Move Value in Register D to Register E
		r.setE(r.getD());
		System.out.println("5A");
		break;
      case "5B"://MOV E E...Move Value in Register E to Register E
		r.setE(r.getE());
		System.out.println("5B");
		break;
      case "5C"://MOV E H...Move Value in Register H to Register E
		r.setE(r.getH());
		System.out.println("5C");
		break;
      case "5D"://MOV E L...Move Value in Register L to Register E
		r.setE(r.getL());
		System.out.println("5D");
		break;
      case "5E"://MOV E M...Move Value in Register M to Register E
		r.setE(r.getM());
		System.out.println("5E");
		break;
      case "5F"://MOV E A...Move Value in Register A to Register E
		r.setE(r.getA());
		System.out.println("5F");
		break;
      case "60"://MOV H B...Move Value in Register B to Register H
		r.setH(r.getB());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("60");
		break;
      case "61"://MOV H C...Move Value in Register C to Register H
		r.setH(r.getC());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("61");
		break;
      case "62"://MOV H D...Move Value in Register D to Register H
		r.setH(r.getD());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		sim.changeColor(7);
		System.out.println("62");
		break;
      case "63"://MOV H E...Move Value in Register E to Register H
		r.setH(r.getE());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("63");
		break;
      case "64"://MOV H H...Move Value in Register H to Register H
		r.setH(r.getH());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("64");
		break;
      case "65"://MOV H L...Move Value in Register L to Register H
		r.setH(r.getL());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("65");
		break;
      case "66"://MOV H M...Move Value in Register M to Register H
		r.setH(r.getM());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("66");
		break;
      case "67"://MOV H A...Move Value in Register A to Register H
		r.setH(r.getA());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("67");
		break;
      case "68"://MOV L B...Move Value in Register B to Register L
		r.setL(r.getB());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("68");
		break;
      case "69"://MOV L C...Move Value in Register C to Register L
		r.setL(r.getC());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("69");
		break;
      case "6A"://MOV L D...Move Value in Register D to Register L
		r.setL(r.getD());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("6A");
		break;
      case "6B"://MOV L E...Move Value in Register E to Register L
		r.setL(r.getE());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("6B");
		break;
      case "6C"://MOV L H...Move Value in Register H to Register L
		r.setL(r.getH());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("6C");
		break;
      case "6D"://MOV L L...Move Value in Register L to Register L
		r.setL(r.getL());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("6D");
		break;
      case "6E"://MOV L M...Move Value in Register M to Register L
		r.setL(r.getM());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("6E");
		break;
      case "6F"://MOV L A...Move Value in Register A to Register L
		r.setL(r.getA());
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("6F");
		break;
      case "70"://MOV M B...Move Value in Register B to Register M
		r.setM(r.getB());
		memory.assignData(r.getH() + r.getL(),r.getM());
		System.out.println("70");
		break;
      case "71"://MOV M C...Move Value in Register C to Register M
		r.setM(r.getC());
		memory.assignData(r.getH() + r.getL(),r.getM());
		System.out.println("71");
		break;
      case "72"://MOV M D...Move Value in Register D to Register M
		r.setM(r.getD());
		memory.assignData(r.getH() + r.getL(),r.getM());
		System.out.println("72");
		break;
      case "73"://MOV M E...Move Value in Register E to Register M
		r.setM(r.getE());
		memory.assignData(r.getH() + r.getL(),r.getM());
		System.out.println("73");
		break;
      case "74"://MOV M H...Move Value in Register H to Register M
		r.setM(r.getH());
		memory.assignData(r.getH() + r.getL(),r.getM());
		System.out.println("74");
		break;
      case "75"://MOV M L...Move Value in Register L to Register M
		r.setM(r.getL());
		memory.assignData(r.getH() + r.getL(),r.getM());
		System.out.println("75");
		break;
      case "76"://HLT....Halt the program
		r.setPC("-1");
		System.out.println("76");
		break;
      case "77"://MOV M A...Move Value in Register A to Register M
		r.setM(r.getA());
		memory.assignData(r.getH() + r.getL(),r.getM());
		System.out.println("77");
		break;
      case "78"://MOV A B...Move Value in Register B to Register A
		r.setA(r.getB());
		System.out.println("78");
		break;
      case "79"://MOV A C...Move Value in Register C to Register A
		r.setA(r.getC());
		System.out.println("79");
		break;
      case "7A"://MOV A D...Move Value in Register D to Register A
		r.setA(r.getD());
		System.out.println("7A");
		break;
      case "7B"://MOV A E...Move Value in Register E to Register A
		r.setA(r.getE());
		System.out.println("7B");
		break;
      case "7C"://MOV A H...Move Value in Register H to Register A
		r.setA(r.getH());
		System.out.println("7C");
		break;
      case "7D"://MOV A L...Move Value in Register L to Register A
		r.setA(r.getL());
		System.out.println("7D");
		break;
      case "7E"://MOV A M...Move Value in Register M to Register A
		r.setA(r.getM());
		System.out.println("7E");
		break;
      case "7F"://MOV A A...Move Value in Register A to Register A
		r.setA(r.getA());
		System.out.println("7F");
		break;
      case "80"://ADD B....A=A+B
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getB());
		addition(i,j,s);
		System.out.println("80");
		break;
      case "81"://ADD C....A=A+C
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getC());
		addition(i,j,s);
		System.out.println("81");
		break;
      case "82"://ADD D....A=A+D
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getD());
		addition(i,j,s);
		System.out.println("82");
		break;
      case "83"://ADD E....A=A+E
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getE());
		addition(i,j,s);
		System.out.println("83");
		break;
      case "84"://ADD H....A=A+H
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getH());
		addition(i,j,s);
		System.out.println("84");
		break;
      case "85"://ADD L....A=A+L
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getL());
		addition(i,j,s);
		System.out.println("85");
		break;
      case "86"://ADD M....A=A+M
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getM());
		addition(i,j,s);
		System.out.println("86");
		break;
      case "87"://ADD A....A=A+A
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getA());
		addition(i,j,s);
		System.out.println("87");
		break;
      case "88"://ADC B...A=A+B+CARRY
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getB()) + f.getCY();
		addition(i,j,s);
		System.out.println("88");
		break;
      case "89"://ADC C...A=A+C+CARRY
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getC()) + f.getCY();
		addition(i,j,s);
		System.out.println("89");
		break;
      case "8A"://ADC D...A=A+D+CARRY
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getD()) + f.getCY();
		addition(i,j,s);
		System.out.println("8A");
		break;
      case "8B"://ADC E...A=A+E+CARRY
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getE()) + f.getCY();
		addition(i,j,s);
		System.out.println("8B");
		break;
      case "8C"://ADC H...A=A+H+CARRY
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getH()) + f.getCY();
		addition(i,j,s);
		System.out.println("8C");
		break;
      case "8D"://ADC L...A=A+L+CARRY
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getL()) + f.getCY();
		addition(i,j,s);
		System.out.println("8D");
		break;
      case "8E"://ADC M...A=A+M+CARRY
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getM()) + f.getCY();
		addition(i,j,s);
		System.out.println("8E");
		break;
      case "8F"://ADC A...A=A+A+CARRY
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(r.getA()) + f.getCY();
		addition(i,j,s);
		System.out.println("8F");
		break;
      case "90"://SUB B...A=A-B
		i= h.getDecimalNum(r.getA());
		str= twos(r.getB());	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("90");
		break;
      case "91"://SUB C...A=A-C
		i= h.getDecimalNum(r.getA());
		str= twos(r.getC());	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("91");
		break;
      case "92"://SUB D...A=A-D
		i= h.getDecimalNum(r.getA());
		str= twos(r.getD());	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("92");
		break;
      case "93"://SUB E...A=A-E
		i= h.getDecimalNum(r.getA());
		str= twos(r.getE());	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("93");
		break;
      case "94"://SUB H...A=A-H
		i= h.getDecimalNum(r.getA());
		str= twos(r.getH());	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("94");
		break;
      case "95"://SUB L...A=A-L
		i= h.getDecimalNum(r.getA());
		str= twos(r.getL());	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("95");
		break;
      case "96"://SUB M...A=A-M
		i= h.getDecimalNum(r.getA());
		str= twos(r.getM());	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("96");
		break;
      case "97"://SUB A...A=A-A
		i= h.getDecimalNum(r.getA());
		str= twos(r.getA());	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("97");
		break;
      case "98"://SBB B...A=A-B-CARRY
		i= h.getDecimalNum(r.getA());
                j= h.getDecimalNum(r.getB()) + f.getCY();
		str= twos(Integer.toHexString(j));	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("98");
		break;
      case "99"://SBB C...A=A-C-CARRY
		i= h.getDecimalNum(r.getA());
                j= h.getDecimalNum(r.getC()) + f.getCY();
		str= twos(Integer.toHexString(j));	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("98");
		break;
      case "9A"://SBB D...A=A-D-CARRY
		i= h.getDecimalNum(r.getA());
                j= h.getDecimalNum(r.getD()) + f.getCY();
		str= twos(Integer.toHexString(j));	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("98");
		break;
      case "9B"://SBB E...A=A-E-CARRY
		i= h.getDecimalNum(r.getA());
                j= h.getDecimalNum(r.getE()) + f.getCY();
		str= twos(Integer.toHexString(j));	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("98");
		break;
      case "9C"://SBB H...A=A-H-CARRY
		i= h.getDecimalNum(r.getA());
                j= h.getDecimalNum(r.getH()) + f.getCY();
		str= twos(Integer.toHexString(j));	
		subtraction(i,j,s);
		System.out.println("98");
		break;
      case "9D"://SBB L...A=A-L-CARRY
		i= h.getDecimalNum(r.getA());
                j= h.getDecimalNum(r.getL()) + f.getCY();
		str= twos(Integer.toHexString(j));	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("98");
		break;
      case "9E"://SBB M...A=A-M-CARRY
		i= h.getDecimalNum(r.getA());
                j= h.getDecimalNum(r.getM()) + f.getCY();
		str= twos(Integer.toHexString(j));	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("98");
		break;
      case "9F"://SBB A...A=A-A-CARRY
		i= h.getDecimalNum(r.getA());
                j= h.getDecimalNum(r.getA()) + f.getCY();
		str= twos(Integer.toHexString(j));	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("98");
		break;
      case "A0"://ANA B...A= A LOGICAL AND WITH B
		str= logicalAND(r.getA(),r.getB());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		System.out.println("A0");
		break;
      case "A1"://ANA C...A= A LOGICAL AND WITH C
		str= logicalAND(r.getA(),r.getC());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		System.out.println("A1");
		break;
      case "A2"://ANA D...A= A LOGICAL AND WITH D
		str= logicalAND(r.getA(),r.getD());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		System.out.println("A2");
		break;
      case "A3"://ANA E...A= A LOGICAL AND WITH E
		str= logicalAND(r.getA(),r.getE());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		System.out.println("A3");
		break;
      case "A4"://ANA H...A= A LOGICAL AND WITH H
		str= logicalAND(r.getA(),r.getH());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		System.out.println("A4");
		break;
      case "A5"://ANA L...A= A LOGICAL AND WITH L
		str= logicalAND(r.getA(),r.getL());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		System.out.println("A5");
		break;
      case "A6"://ANA M...A= A LOGICAL AND WITH M
		str= logicalAND(r.getA(),r.getM());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		System.out.println("A6");
		break;
      case "A7"://ANA A...A= A LOGICAL AND WITH A
		str= logicalAND(r.getA(),r.getA());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		System.out.println("A7");
		break;
      case "A8"://XRA B...A= A EXCUSIVE OR WITH B
		str= exclusiveOR(r.getA(),r.getB());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("A8");
		break;
      case "A9"://XRA C...A= A EXCUSIVE OR WITH C
		str= exclusiveOR(r.getA(),r.getC());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("A9");
		break;
      case "AA"://XRA D...A= A EXCUSIVE OR WITH D
		str= exclusiveOR(r.getA(),r.getD());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("AA");
		break;
      case "AB"://XRA E...A= A EXCUSIVE OR WITH E
		str= exclusiveOR(r.getA(),r.getE());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("AB");
		break;
      case "AC"://XRA H...A= A EXCUSIVE OR WITH H
		str= exclusiveOR(r.getA(),r.getH());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("AC");
		break;
      case "AD"://XRA L...A= A EXCUSIVE OR WITH L
		str= exclusiveOR(r.getA(),r.getL());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("AD");
		break;
      case "AE"://XRA M...A= A EXCUSIVE OR WITH M
		str= exclusiveOR(r.getA(),r.getM());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("AE");
		break;
      case "AF"://XRA A...A= A EXCUSIVE OR WITH A
		str= exclusiveOR(r.getA(),r.getA());
		r.setA(str);
		System.out.println(r.getA());
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("AF");
		break;
      case "B0"://ORA B...A=A LOGICAL OR WITH B
		str= logicalOR(r.getA(),r.getB());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("B0");
		break;
      case "B1"://ORA C...A=A LOGICAL OR WITH C
		str= logicalOR(r.getA(),r.getC());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("B1");
		break;
      case "B2"://ORA D...A=A LOGICAL OR WITH D
		str= logicalOR(r.getA(),r.getD());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("B2");
		break;
      case "B3"://ORA E...A=A LOGICAL OR WITH E
		str= logicalOR(r.getA(),r.getE());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("B3");
		break;
      case "B4"://ORA H...A=A LOGICAL OR WITH H
		str= logicalOR(r.getA(),r.getH());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("B4");
		break;
      case "B5"://ORA L...A=A LOGICAL OR WITH L
		str= logicalOR(r.getA(),r.getL());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("B5");
		break;
      case "B6"://ORA M...A=A LOGICAL OR WITH M
		str= logicalOR(r.getA(),r.getM());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("B6");
		break;
      case "B7"://ORA A...A=A LOGICAL OR WITH A
		str= logicalOR(r.getA(),r.getA());
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		f.setAC(0);
		System.out.println("B7");
		break;
      case "B8"://CMP B
		if(h.getDecimalNum(r.getA()) < h.getDecimalNum(r.getB()))//IF A < B
		{
			f.setCY(1);
			f.setZ(0);
		}
		if(h.getDecimalNum(r.getA()) == h.getDecimalNum(r.getB()))//IF A == B
		{
			f.setZ(1);
			f.setCY(0);
		}
		if(h.getDecimalNum(r.getA()) > h.getDecimalNum(r.getB()))//IF A> B
		{
			f.setZ(0);
			f.setCY(0);
		}
		System.out.println("B8");
		break;
      case "B9"://CMP C
		if(h.getDecimalNum(r.getA()) < h.getDecimalNum(r.getC()))//IF A < C
		{
			f.setCY(1);
			f.setZ(0);
		}
		if(h.getDecimalNum(r.getA()) == h.getDecimalNum(r.getC()))//IF A == C
		{
			f.setZ(1);
			f.setCY(0);
		}
		if(h.getDecimalNum(r.getA()) > h.getDecimalNum(r.getC()))//IF A > C
		{
			f.setZ(0);
			f.setCY(0);
		}
		System.out.println("B9");
		break;
      case "BA"://CMP D
		if(h.getDecimalNum(r.getA()) < h.getDecimalNum(r.getD()))//IF A < D
		{
			f.setCY(1);
			f.setZ(0);
		}
		if(h.getDecimalNum(r.getA()) == h.getDecimalNum(r.getD()))//IF A == D
		{
			f.setZ(1);
			f.setCY(0);
		}
		if(h.getDecimalNum(r.getA()) > h.getDecimalNum(r.getD()))//IF A > D
		{
			f.setZ(0);
			f.setCY(0);
		}
		System.out.println("BA");
		break;
      case "BB"://CMP E
		if(h.getDecimalNum(r.getA()) < h.getDecimalNum(r.getE()))//IF A < E
		{
			f.setCY(1);
			f.setZ(0);
		}
		if(h.getDecimalNum(r.getA()) == h.getDecimalNum(r.getE()))//IF A == E
		{
			f.setZ(1);
			f.setCY(0);
		}
		if(h.getDecimalNum(r.getA()) > h.getDecimalNum(r.getE()))//IF A > E
		{
			f.setZ(0);
			f.setCY(0);
		}
		System.out.println("BB");
		break;
      case "BC"://CMP H
		if(h.getDecimalNum(r.getA()) < h.getDecimalNum(r.getH()))//IF A < H
		{
			f.setCY(1);
			f.setZ(0);
		}
		if(h.getDecimalNum(r.getA()) == h.getDecimalNum(r.getH()))//IF A == H
		{
			f.setZ(1);
			f.setCY(0);
		}
		if(h.getDecimalNum(r.getA()) > h.getDecimalNum(r.getH()))//IF A > H
		{
			f.setZ(0);
			f.setCY(0);
		}
		System.out.println("BC");
		break;
      case "BD"://CMP L
		if(h.getDecimalNum(r.getA()) < h.getDecimalNum(r.getL()))//IF A < L
		{
			f.setCY(1);
			f.setZ(0);
		}
		if(h.getDecimalNum(r.getA()) == h.getDecimalNum(r.getL()))//IF A == L
		{
			f.setZ(1);
			f.setCY(0);
		}
		if(h.getDecimalNum(r.getA()) > h.getDecimalNum(r.getL()))//IF A > L
		{
			f.setZ(0);
			f.setCY(0);
		}
		System.out.println("BD");
		break;
      case "BE"://CMP M
		if(h.getDecimalNum(r.getA()) < h.getDecimalNum(r.getM()))//IF A < M
		{
			f.setCY(1);
			f.setZ(0);
		}
		if(h.getDecimalNum(r.getA()) == h.getDecimalNum(r.getM()))//IF A == M
		{
			f.setZ(1);
			f.setCY(0);
		}
		if(h.getDecimalNum(r.getA()) > h.getDecimalNum(r.getM()))//IF A > M
		{
			f.setZ(0);
			f.setCY(0);
		}
		System.out.println("BE");
		break;
      case "BF"://CMP A
		if(h.getDecimalNum(r.getA()) < h.getDecimalNum(r.getA()))//IF A < A
		{
			f.setCY(1);
			f.setZ(0);
		}
		if(h.getDecimalNum(r.getA()) == h.getDecimalNum(r.getA()))//IF A == A
		{
			f.setZ(1);
			f.setCY(0);
		}
		if(h.getDecimalNum(r.getA()) > h.getDecimalNum(r.getA()))//IF A > A
		{
			f.setZ(0);
			f.setCY(0);
		}
		System.out.println("BF");
		break;
      case "C0"://RNZ...RETURNS IF Z FLAG IS NOT SET.
		if(f.getZ() == 0)
		{
			RETURN(s);
		}
		System.out.println("C0");
		break;
      case "C1"://POP B...B=TOP DATA FROM STACK.
		r.setC(memory.getData(r.getSP()));
		r.incPairSP();
		r.setB(memory.getData(r.getSP()));
		r.incPairSP();
		System.out.println("C1");
		break;
      case "C2"://JNZ ADDRESS OR LABEL...JUMPS TO ADDRESS IF Z FLAG IS NOT SET.
		if(f.getZ() != 1)
		{
			str= s.substring(4,6) + s.substring(2,4);
			r.setPC(str);
		}
		System.out.println("C2");
		break;
      case "C3"://JMP ADDRESS OR LABEL...JUMPS TO ADDRESS
		str= s.substring(4,6) + s.substring(2,4);
		r.setPC(str);
		System.out.println("C3");
		break;
      case "C4"://CNZ ADDRESS OR LABEL...CALLS FUNCTION IF Z FLAG IS NOT SET.
		if(f.getZ() == 0)
		{
			CALL(s);
		}
		System.out.println("C4");
		break;
      case "C5"://PUSH B...TOP OF STACK= B
		r.decPairSP();
		memory.assignData(r.getSP(),r.getB());
		r.decPairSP();
		memory.assignData(r.getSP(),r.getC());
		System.out.println("C5");
		break;
      case "C6"://ADI DATA...A=IMMEDIATE DATA + A.
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(s.substring(2,4));
		addition(i,j,s);
		System.out.println("C6");
		break;
      case "C7"://RST 0
		break;
      case "C8"://RZ...RETURNS IF Z FLAG IS SET.
		if(f.getZ() == 1)
		{
			RETURN(s);
		}
		System.out.println("C8");
		break;
      case "C9"://RET...RETURNS to the function from where this is called.
		RETURN(s);
		System.out.println("C9");
		break;
      case "CA"://JZ ADDRESS OR LABEL...JUMPS TO ADDRESS IF Z FLAG IS SET.
		if(f.getZ() == 1)
		{
			str= s.substring(4,6) + s.substring(2,4);
			r.setPC(str);
		}
		System.out.println("CA");
		break;
//      case "CB":
//		break;
      case "CC"://CZ ADDRESS OR LABEL...CALLS FUNCTION IF Z FLAG IS  SET.
		if(f.getZ() == 1)
		{
			CALL(s);
		}
		System.out.println("CC");
		break;
      case "CD":
		CALL(s);
		System.out.println("CD");
		break;
      case "CE":
		i= h.getDecimalNum(r.getA());
		j= h.getDecimalNum(s.substring(2,4)) + f.getCY();
		addition(i,j,s);
		System.out.println("CE");
		break;
      case "CF"://RST 1
		break;
      case "D0"://RNC...RETURNS IF CY FLAG IS NOT SET.
		if(f.getCY() == 0)
		{
			RETURN(s);
		}
		System.out.println("D0");
		break;
      case "D1"://POP D...D=TOP DATA FROM STACK.
		r.setE(memory.getData(r.getSP()));
		r.incPairSP();
		r.setD(memory.getData(r.getSP()));
		r.incPairSP();
		System.out.println("D1");
		break;
      case "D2"://JNC ADDRESS OR LABEL...JUMPS TO ADDRESS IF CY FLAG NOT IS SET.
		if(f.getCY() != 1)
		{
			str= s.substring(4,6) + s.substring(2,4);
			r.setPC(str);
		}
		System.out.println("D2");
		break;
      case "D3"://OUT PORT NUMBER...PORT VALUE= A.
		i= h.getDecimalNum(s.substring(2,4));
		if(i == 1)
			r.setPort1(r.getA());
		else
		if(i == 2)
			r.setPort2(r.getA());
		else
		if(i == 3)
			r.setPort3(r.getA());
		else
		{
			JOptionPane.showMessageDialog(null,"in valid Port "+i, "alert", JOptionPane.ERROR_MESSAGE); 
			Loader.setError();
			sim.setdef();
		}
		System.out.println("D3");
		break;
      case "D4"://CNC ADDRESS OR LABEL...CALLS FUNCTION IF CY FLAG IS NOT SET.
		if(f.getCY() == 0)
		{
			CALL(s);
		}
		System.out.println("D4");
		break;
      case "D5"://PUSH D...TOP OF STACK= D
		r.decPairSP();
		memory.assignData(r.getSP(),r.getD());
		r.decPairSP();
		memory.assignData(r.getSP(),r.getE());
		System.out.println("D5");
		break;
      case "D6"://SUI DATA...A=A-IMMEDIATE DATA.
		System.out.println(r.getA());
		i= h.getDecimalNum(r.getA());
		str= twos(s.substring(2,4));	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println(r.getA());
		System.out.println("D6");
		break;
      case "D7"://RST 2
		break;
      case "D8"://RC...RETURNS IF CY FLAG IS SET.
		if(f.getCY() == 1)
		{
			RETURN(s);
		}
		System.out.println("D8");
		break;
//      case "D9":
//		break;
      case "DA"://JC ADDRESS OR LABEL...JUMPS TO ADDRESS IF CY FLAG IS SET.
		if(f.getCY() == 1)
		{
			str= s.substring(4,6) + s.substring(2,4);
			r.setPC(str);
		}
		System.out.println("DA");
		break;
      case "DB"://IN PORT NUMBER...A= PORT VALUE.
		i= h.getDecimalNum(s.substring(2,4));
		if(i == 1)
			r.setA(r.getPort1());
		else
		if(i == 2)
			r.setA(r.getPort2());
		else
		if(i == 3)
			r.setA(r.getPort3());
		else
		{
			JOptionPane.showMessageDialog(null,"in valid Port "+i, "alert", JOptionPane.ERROR_MESSAGE); 
			Loader.setError();
			sim.setdef();
		}
		System.out.println("DB");
		break;
      case "DC"://CC ADDRESS OR LABEL...CALLS FUNCTION IF CY FLAG IS SET.
		if(f.getCY() == 1)
		{
			CALL(s);
		}
		System.out.println("DC");
		break;
//      case "DD":
//		break;
      case "DE"://SBI DATA...A=A-IMMEDIATE DATA-CARRY.
		i= h.getDecimalNum(r.getA());
                j= h.getDecimalNum(s.substring(2,4)) + f.getCY();
		str= twos(Integer.toHexString(j));	
		j= h.getDecimalNum(str);
		subtraction(i,j,s);
		System.out.println("DE");
		break;
      case "DF"://RST 3
		break;
      case "E0"://RPO...RETURNS IF P FLAG IS NOT SET.
		if(f.getP() == 0)
		{
			RETURN(s);
		}
		System.out.println("E0");
		break;
      case "E1"://POP H...H=TOP DATA FROM STACK.
		r.setL(memory.getData(r.getSP()));
		r.incPairSP();
		r.setH(memory.getData(r.getSP()));
		r.incPairSP();
		r.setM(memory.getData(r.getH() + r.getL()));
		System.out.println("C1");
		break;
      case "E2"://JPO ADDRESS OR LABEL...JUMPS TO ADDRESS IF P FLAG NOT IS SET.
		if(f.getP() != 1)
		{
			str= s.substring(4,6) + s.substring(2,4);
			r.setPC(str);
		}
		System.out.println("E2");
		break;
      case "E3"://XTHL....EXCHANGE H AND L WITH TOP OF STACK.
		str= memory.getData(r.getSP());
		memory.assignData(r.getSP(),r.getL());
		r.setL(str);
		r.incPairSP();
		str= memory.getData(r.getSP());
		memory.assignData(r.getSP(),r.getH());
		r.setH(str);
		r.decPairSP();
		System.out.println("E3");
		break;
      case "E4"://CPO ADDRESS OR LABEL...CALLS FUNCTION IF P FLAG IS NOT SET.
		if(f.getP() == 0)
		{
			CALL(s);
		}
		System.out.println("E4");
		break;
      case "E5"://PUSH H...TOP OF STACK= H
		r.decPairSP();
		memory.assignData(r.getSP(),r.getH());
		r.decPairSP();
		memory.assignData(r.getSP(),r.getL());
		System.out.println("E5");
		break;
      case "E6"://ANI DATA...A= A LOGICAL AND WITH DATA.
		str= logicalAND(r.getA(),s.substring(2,4));
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		System.out.println("A0");
		break;
      case "E7"://RST 4
		break;
      case "E8"://RPE...RETURNS IF P FLAG IS SET.
		if(f.getP() == 1)
		{
			RETURN(s);
		}
		System.out.println("E8");
		break;
      case "E9"://PCHL...LOAD PROGRAMME COUNTER WITH HL CONTENT.
		str= r.getH() + r.getL();
		r.setPC(str);
		System.out.println("E9");
		break;
      case "EA"://JPE ADDRESS OR LABEL...JUMPS TO ADDRESS IF P FLAG IS SET.
		if(f.getP() == 1)
		{
			str= s.substring(4,6) + s.substring(2,4);
			r.setPC(str);
		}
		System.out.println("EA");
		break;
      case "EB"://XCHG...EXCHANGE H AND L WITH D AND E.
		str= r.getH();
		r.setH(r.getD());
		r.setD(str);
		str= r.getL();
		r.setL(r.getE());
		r.setE(str);
		str= r.getH() + r.getL();
		r.setM(memory.getData(str));
		System.out.println("EB");
		break;
      case "EC"://CPE ADDRESS OR LABEL...CALLS FUNCTION IF P FLAG IS SET.
		if(f.getP() == 1)
		{
			CALL(s);
		}
		System.out.println("EC");
		break;
      case "EE"://XRI DATA...A= A EXCLUSIVE OR WITH DATA.
		str= exclusiveOR(r.getA(),s.substring(2,4));
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		System.out.println("A0");
		break;
      case "EF"://RST 5
		break;
      case "F0"://RP...RETURNS IF S FLAG IS NOT SET.
		if(f.getS() == 0)
		{
			RETURN(s);
		}
		System.out.println("F0");
		break;
      case "F1"://POP PSW...PSW=TOP DATA FROM STACK.
		str= "";
		i= h.getDecimalNum(memory.getData(r.getSP()));
		str= Integer.toBinaryString(i);
		while(str.length() < 8)
		{
			str= "0" + str;
		}
		r.decPairSP();
		f.setS(str.charAt(0));
		f.setZ(str.charAt(1));
		f.setAC(str.charAt(3));
		f.setP(str.charAt(5));
		f.setCY(str.charAt(7));
		r.setA(memory.getData(r.getSP()));
		r.decPairSP();
		System.out.println("F1");
		break;
      case "F2"://JP ADDRESS OR LABEL...JUMPS TO ADDRESS IF S FLAG NOT IS SET.
		if(f.getS() != 1)
		{
			str= s.substring(4,6) + s.substring(2,4);
			r.setPC(str);
		}
		System.out.println("F2");
		break;
      case "F3":
		break;
      case "F4"://CP ADDRESS OR LABEL...CALLS FUNCTION IF S FLAG IS NOT SET.
		if(f.getS() == 0)
		{
			CALL(s);
		}
		System.out.println("F4");
		break;
      case "F5"://PUSH PSW...TOP OF STACK= PSW
		str= "";
		r.decPairSP();
		memory.assignData(r.getSP(),r.getA());
		r.decPairSP();
		str+= f.getS();
		str+= f.getZ();
		str+=  "0" + f.getAC() + "0" + f.getP() + "0" + f.getCY();
		System.out.println(str+"....");
		i= b.getDecimalNum(str);
		str= Integer.toHexString(i);
		memory.assignData(r.getSP(),str);
		System.out.println("F5");
		break;
      case "F6"://ORI DATA...A= A LOGICAL OR WITH DATA.
		str= logicalOR(r.getA(),s.substring(2,4));
		r.setA(str);
		f.checkZ(r.getA());
		f.checkP(r.getA());
		f.checkS(r.getA());
		f.setCY(0);
		System.out.println("A0");
		break;
      case "F7"://RST 6
		break;
      case "F8"://RM...RETURNS IF S FLAG IS SET.
		if(f.getS() == 1)
		{
			RETURN(s);
		}
		System.out.println("F8");
		break;
      case "F9"://SPHL....COPY H AND L REGISTERS TO THE STACK POINTER.
		r.setSP(r.getH() + r.getL());
		System.out.println("F9");
		break;
      case "FA"://JM ADDRESS OR LABEL...JUMPS TO ADDRESS IF S FLAG IS SET.
		if(f.getS() == 1)
		{
			str= s.substring(4,6) + s.substring(2,4);
			r.setPC(str);
		}
		System.out.println("FA");
		break;
      case "FB":
		break;
      case "FC"://CM ADDRESS OR LABEL...CALLS FUNCTION IF S FLAG IS SET.
		if(f.getS() == 1)
		{
			CALL(s);
		}
		System.out.println("FC");
		break;
      case "FE"://CPI IMMEDIATE DATA...
		str= s.substring(2,4);
		if(h.getDecimalNum(r.getA()) < h.getDecimalNum(str))//IF A < DATA
		{
			f.setCY(1);
			f.setZ(0);
		}
		if(h.getDecimalNum(r.getA()) == h.getDecimalNum(str))//IF A == DATA
		{
			f.setZ(1);
			f.setCY(0);
		}
		if(h.getDecimalNum(r.getA()) > h.getDecimalNum(str))//IF A > DATA
		{
			f.setZ(0);
			f.setCY(0);
		}
		System.out.println("FE");
		break;
      case "FF"://RST 7
		break;
    }
  }
  public String twos(String str)//RETURNS TWOS COMPLEMENT OF THE GIVEN NUMBER.
  {
    int i= 255 - (h.getDecimalNum(str)) + 1;
    str= Integer.toHexString(i);
    if(str.length() == 2)
      return(str);
    else
    {
      if(str.length() == 1)
      {
        str= "0" + str;
        return(str);
      }
      return(str.substring(1,3));
    }
  }
  public String logicalAND(String str1,String str2)//RETURNS RESULT OF LOGICAL AND OF STR1,STR2.
  {
    String str3= "";
    char[] ch= new char[1];
    char[] ch1= new char[1];
    int i= h.getDecimalNum(str1); 
    int j= h.getDecimalNum(str2); 
    str1= Integer.toBinaryString(i);
    while(str1.length() < 8)
    {
      str1= "0" + str1;
    }
    str2= Integer.toBinaryString(j);
    while(str2.length() < 8)
    {
      str2= "0" + str2;
    }
    for(i= 0;i < 8;i++)
    {        
      ch[0]= str1.charAt(i);
      ch1[0]= str2.charAt(i);
      if(new String(ch).equals("1") && new String(ch1).equals("1"))    //IF BOTH ARE 1 ,THEN RESULT IS ONE     
        str3+= "1";
      else
        str3+= "0";														//ELSE 0.
    }
    i= b.getDecimalNum(str3); 
    str3= Integer.toHexString(i);
    if(str3.length() == 1)
      str3= "0" + str3;
    return(str3);
  }
  public String logicalOR(String str1,String str2)//RETURNS RESULT OF LOGICAL OR OF STR1,STR2.
  {
    String str3= "";
    char[] ch= new char[1];
    char[] ch1= new char[1];
    int i= h.getDecimalNum(str1); 
    int j= h.getDecimalNum(str2); 
    str1= Integer.toBinaryString(i);
    while(str1.length() < 8)
    {
      str1= "0" + str1;
    }
    str2= Integer.toBinaryString(j);
    while(str2.length() < 8)
    {
      str2= "0" + str2;
    }
    for(i= 0;i < 8;i++)
    {        
      ch[0]= str1.charAt(i);
      ch1[0]= str2.charAt(i);
      if(new String(ch).equals("1") || new String(ch1).equals("1"))    //IF ANY ONE IS 1,THEN RESULT IS 1.    
        str3+= "1";
      else
        str3+= "0";														//ELSE 0.
    }
    i= b.getDecimalNum(str3); 
    str3= Integer.toHexString(i);
    if(str3.length() == 1)
      str3= "0" + str3;
    return(str3);
  }
  public String exclusiveOR(String str1,String str2)//RETURNS RESULT OF EXCLUSIVE OR OF STR1,STR2.
  {
    String str3= "";
    char[] ch= new char[1];
    char[] ch1= new char[1];
    int i= h.getDecimalNum(str1); 
    int j= h.getDecimalNum(str2); 
    str1= Integer.toBinaryString(i);
    while(str1.length() < 8)
    {
      str1= "0" + str1;
    }
    str2= Integer.toBinaryString(j);
    while(str2.length() < 8)
    {
      str2= "0" + str2;
    }
    for(i= 0;i < 8;i++)
    {       
      ch[0]= str1.charAt(i);
      ch1[0]= str2.charAt(i);
      if((new String(ch).equals("1") && new String(ch1).equals("1")) || (new String(ch).equals("0") && new String(ch1).equals("0")))        
        str3+= "0";											//IF BOTH ARE SAME THEN RESULT IS 0.
      else
        str3+= "1";											//ELSE 1.
    }
    i= b.getDecimalNum(str3); 
    str3= Integer.toHexString(i);
    if(str3.length() == 1)
      str3= "0" + str3;
    return(str3);
  }
  public void subtraction(int i,int j,String s)//SUBTRACTS NUMBERS AND GIVES RESULT IN TWOS COMPLEMENT.
  {												//AND SETS FLAGS AS NECCESARY.
	String str;
	i= i + j;
	str= Integer.toHexString(i);
	if(str.length() == 3)
	{
		f.setCY(0);
		r.setA(str.substring(1,3));
	}
	else
	{
		if(str.length() == 2)
		{
			r.setA(str);
			f.setCY(1);
		}
		else
		{
			r.setA("0"+ str);
			f.setCY(1);
		}
	}
	f.checkZ(r.getA());
	f.checkP(r.getA());
	f.checkS(r.getA());
  }
  public void addition(int i,int j,String s)//ADD NUMBERS AND GIVES RESULT IN TWOS COMPLEMENT.
  {												//AND SETS FLAGS AS NECCESARY.
	String str;
	i= i + j;
	str= Integer.toHexString(i);
	if(str.length() == 3)
	{
		f.setCY(1);
		r.setA(str.substring(1,3));
	}
	else
	{
		if(str.length() == 2)
		{
			r.setA(str);
			f.setCY(0);
		}
		else
			r.setA("0"+ str);
	}
	f.checkZ(r.getA());
	f.checkP(r.getA());
	f.checkS(r.getA());
  }
  public String additionOf16Bit(int i,int j)//ADDITION OF 16 BIT NUMBER.
  {
	String str;
	i= i + j;
	str= Integer.toHexString(i);
	if(str.length() > 4)
	{
		f.setCY(1);
	}
	else
	{
		while(str.length() < 4)
		{
			str= "0" + str;
		}
	}
	return(str);
  }
  public void CALL(String s)//SETS THE PC TO THE TARGET ADDRESS.
  {
	String str;
	str= r.getPC();
	r.decPairSP();
	memory.assignData(r.getSP(),str.substring(0,2));
	r.decPairSP();
	memory.assignData(r.getSP(),str.substring(2,4));
	r.setPC(s.substring(4,6) + s.substring(2,4));
  }
  public void RETURN(String s)//SETS THE PC TO ADDRESS FROM WHERE IT CALLED.
  {
	String str,str1;
	str= memory.getData(r.getSP());
	while(str.length() < 2)
	{
		str= "0" + str;
	}
	r.incPairSP();
	str1= memory.getData(r.getSP());
	while(str1.length() < 2)
	{
		str1= "0" + str1;
	}
	str= str1 + str;
	r.setPC(str);
  }
}
