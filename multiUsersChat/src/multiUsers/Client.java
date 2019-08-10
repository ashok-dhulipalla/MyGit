package multiUsers;
import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javafx.stage.DirectoryChooser;

import javax.swing.JFileChooser;
public class Client implements ActionListener{
	static Socket client= null;
	static BufferedReader stdin= null;
	static BufferedReader in= null;
	static PrintWriter out= null;
	static String name;
	private static Swing s1= new Swing();
	public Client() {
		// TODO Auto-generated constructor stub
		s1.addNewTab("client", 0);
		s1.setListeners(this,0);
	}
	//add new tab to the tabbedpane
	public void addTab(String name,int id)
	{
		s1.addNewTab(name, id);
		s1.setListeners(this,id);
	}
	public static void main(String[] args) throws IOException
	{
		Client c= new Client();
		String msg;
		client= new Socket("localhost",4444);
		stdin= new BufferedReader(new InputStreamReader(System.in));
		in= new BufferedReader(new InputStreamReader(client.getInputStream()));
		out= new PrintWriter(client.getOutputStream(),true);
		String[] arr;
		String str;
		while(true)
		{
			msg= in.readLine();
			if(msg.startsWith("TAB"))
			{
				//System.out.println(Integer.valueOf(msg.substring(3, 4)));
				c.addTab(msg.substring(4),Integer.valueOf(msg.substring(3, 4)));
			}
			else if(msg.startsWith("REMOVE"))
			{
				s1.removeTab(Integer.valueOf(msg.substring(6)));
			}
			else if(msg.startsWith("MESSAGE"))
			{
				arr = msg.split(":", 4);
				s1.setLine1("          "+arr[3],Integer.valueOf(arr[1]));
				if(!s1.isSelected(Integer.valueOf(arr[1])))
				{
					//s1.setName("New message from "+arr[2]);
					s1.alert("NEW MESSAGE FROM "+arr[2]);
				}
				else
					s1.setName(name);
			}
			else if(msg.startsWith("NAMEACCEPTED"))
			{
				s1.removeTab(0);
				s1.setName(msg.substring(12));
				name= msg.substring(12);
			}
			else
			{
				s1.setLine1("          "+msg, 0);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command= e.getActionCommand();
		String[] arr= command.split(":");
		String str;
		char c1;
		int c2;
		System.out.println(command);
		int c= Integer.valueOf(command);
		out.println(c+":"+s1.getLine(c));
		s1.setLine1(s1.getLine(c),c);
		s1.setLine("",c);
	}
}