package bca2012.project3.SimulatorFor8085;
import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
class Mypanel extends JPanel
{
  private static Name[]  b= new Name[4];
  Name[]  t= new Name[4];
  private static Zoom z;
  private float count= 1;
  Graphics2D g2;
  Ellipse2D e1;
  Mypanel()
  {
    setFocusable(true);
    setBackground(Color.gray);
    for(int i= 0,x= 100,y= 100,delay= 15,direction= 0;i < 3;i++,x+= 300,y+= 500,direction++,delay++)
    {
    	String name = null;
    	String title= null;
    	if(i== 0)
    	{
    		name = "D.Ashok Kumar";
    		title= "Designed by";
    	}
    	else if(i == 1)
    	{
    		name = "G.Umesh";
		    title= "Designed by";
    	}
    	else if(i == 2)
    	{
    		name = "Ajit Padyana Sir";
    		title= "Guided by";
    	}
      if(direction == 4)
        direction= 0;
      t[i]= new Name(title,x,100,delay,direction,this,30);
      b[i]= new Name(name,x,100,delay,direction,this,30);
      t[i].start();
      b[i].start();
    }
    z= new Zoom(this);
    z.start();
  }
  public static void kill()
  {
	  for(int i= 0;i < 3;i++)
	  {
		  System.out.println("killlllllllingggggggggggggggggg");
		  b[i].set();
	  }
	  Zoom.set();
  }
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    drawcircle(g);
  }
  public void drawcircle(Graphics g)
  {
	  //String path= System.getProperty("user.dir") + File.separator + "pics" + File.separator;
	  //System.out.println(path);
	  ImageIcon im= new ImageIcon("pics/4.jpg");
		Image m;
		m= im.getImage();
		g.drawImage(m,0,43,getWidth(),getHeight(),null);
/*		if(count < 50)
		{
			im= new ImageIcon("./screens/"+Integer.toString((int) count)+".png");
			count+= 0.1;
			m= im.getImage();
			g.drawImage(m,0,40,getWidth(),getHeight(),null);
		}*/
    g2= (Graphics2D) g;
    g2.setFont(new Font("",Font.BOLD,z.getSize()));
    g2.setColor(Color.BLUE);
	g2.drawString("WELCOME TO 8085 Simulator",z.getX(),z.getY());
    for(int i= 0;i < 3;i++)
    {
        g2.setColor(Color.green);
        g2.setFont(new Font("",Font.BOLD,b[i].getSize()));
    	g2.drawString(t[i].getname(), t[i].getX()-50, t[i].getY()-50);
    	switch(b[i].getIndicator())
    	{
    	case 0:
            g2.setColor(Color.red);
    		break;
    	case 1:
            g2.setColor(Color.black);
    		break;
    	case 2:
            g2.setColor(Color.yellow);
    		break;
    	case 3:
            g2.setColor(Color.magenta);
    		break;
    	}
    	g2.drawString(b[i].getname(), b[i].getX(), b[i].getY());
    }
  }
}
