package bca2012.project3.SimulatorFor8085;
import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
class Zoom extends Thread 
{
  private static int delay= 200,size= 30,x= 450,y= 25;
  private static boolean ret= false;
  private Mypanel p;
  Zoom(Mypanel p1)
  {
    p= p1;
  }
  public static void set()
  {
	  ret= true;
  }
  public void run()
  {
    while(true)
    {
    	if(ret)
    	{
    		return;
    	}
    	while(size != 40)
    	{
    		size++;
    		y+=3;
    		x-=3;
    	       try
    	        {
    				Thread.sleep(delay);
    	        }
    	        catch(Exception e)
    	        {
    	        	
    	        }
    	}
    	while(size != 30)
    	{
    		size--;
    		y-= 3;
    		x+= 3;
    	       try
    	        {
    				Thread.sleep(delay);
    	        }
    	        catch(Exception e)
    	        {
    	        	
    	        }
    	}
        p.repaint();
    }
  }
  public int getSize() 
  {
	return size;
  }
  public int getX() 
  {
	return x;
  }
  public int getY() 
  {
	return y;
  }
}