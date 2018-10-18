package bca2012.project3.SimulatorFor8085;
//package sic;
import java.util.Scanner;
import java.io.*;
class RegId
{
  public static int getId(String s) throws IOException
  {
    switch(s)
    {
      case "B":
		return(0);
      case "C":
		return(1);
      case "D":
		return(2);
      case "E":
		return(3);
      case "H":
		return(4);
      case "L":
		return(5);
      case "M": case "SP": case "PSW":
		return(6);
      case "A":
		return(7);
      default:
		return(-1);
    }
  }
}
