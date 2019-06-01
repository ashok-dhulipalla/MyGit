package bca2012.project3.SimulatorFor8085;
import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
class Name extends Thread 
{
  private int x,y,indicator,delay,size;
  private Mypanel p;
  private String name;
  private static boolean ret= false;
  Name(String string, int x1,int y1,int delay1,int indicator1,Mypanel p1,int size1)
  {
    x= x1;
    y= y1;
    delay= delay1;
    indicator= indicator1;
    p= p1;
    name= string;
    size= size1;
  }
  public void set()
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
    	if(indicator == 0)
        {
          if(y == p.getHeight())
            indicator= 1;
          if(x == p.getWidth()-300)
            indicator= 3;
          x++;
          y++;
          if(size > 30)
          size--;
        }
        if(indicator == 1)
        {
          if(x == p.getWidth()-300)
            indicator= 2;
          if(y == 80)
            indicator= 0;
          x++;
          y--;
          if(size < 50)
            size++;
        }
        if(indicator == 2)
        {
          if(y == 80)
            indicator= 3;
          if(x == 50)
            indicator= 1;
          x--;
          y--;
          if(size > 30)
            size--;
        }
        if(indicator == 3)
        {
          if(x == 50)
            indicator= 0;
          if(y == p.getHeight())
            indicator= 2;
          x--;
          y++;
          if(size < 50)
          size++;
        }
        try
        {
			Thread.sleep(delay);
        }
        catch(Exception e)
        {
        	
        }
        p.repaint();
    }
  }
  public int getX()
  {
    return(x);
  }
  public int getY()
  {
    return(y);
  }
  public String getname()
  {
	  return(name);
  }
  public int getSize() 
  {
	  return size;
  }
  public int getIndicator() 
  {
	  return indicator;
  }
}
