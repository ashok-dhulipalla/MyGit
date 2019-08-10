package multiUsers;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.text.BadLocationException;


public class Swing {
	private JFrame f1;
	
	private JTabbedPane pane;//main panel added to the frame.
	
	private JScrollPane s1;//scroll panel for the basic panel.
	
	private JPanel[] p1= new JPanel[20];// basic panel added to the JTabbedPane.
	
	private JTextArea[] t1= new JTextArea[20];//text area added to the basic panel.
	
	private JPanel[] p2= new JPanel[20];// panel added to the basic panel.
	
	private JButton[] b1= new JButton[20];//panel added to the panel p2.
	
	private JTextField[] f= new JTextField[20];//text field added to the basic panel.
	
	public Swing() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		}
		this.swing();
	}
	private void swing()
	{
		//tabbedPane
		pane= new JTabbedPane();
		
		//frame
		f1= new JFrame();
		f1.setSize(500, 500);
		f1.add(pane);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
	}
	public void setClientText(String str,int count)
	{
		t1[count].append("\n     "+str);
		try {
			t1[count].setCaretPosition(t1[count].getLineEndOffset(t1[count].getLineCount()-1));
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setListeners(Object o,int count)
	{
		f[count].addActionListener((ActionListener) o);
	}
	public void setLine(String str,int count)
	{
		f[count].setText(str);
	}
	public String getLine(int count)
	{
		return(f[count].getText());
	}
	public void setLine1(String str,int count)
	{
		t1[count].append("\n"+str);
		try {
			t1[count].setCaretPosition(t1[count].getLineEndOffset(t1[count].getLineCount()-1));
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addNewTab(String str,int count)
	{
		//textArea
		t1[count]= new JTextArea();
		t1[count].setBackground(Color.GREEN);
		t1[count].setForeground(Color.black);
		t1[count].setFont(new Font("", 10, 15));
		t1[count].setLineWrap(true);
		t1[count].setEditable(false);
		//t1[count].setAutoscrolls(true);
		int v= ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h= ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		s1= new JScrollPane(t1[count],v,h);
		
		//textField
		f[count]= new JTextField();
		f[count].setActionCommand(Integer.toString(count));
		f[count].setFont(new Font("", 2, 25));
		
		
		//panel1
		p1[count]= new JPanel();
		p1[count].setLayout(new BorderLayout());
		//p1[count].add(f[count],BorderLayout.AFTER_LAST_LINE);
		p1[count].add(f[count],BorderLayout.AFTER_LAST_LINE);
		p1[count].add(s1,BorderLayout.CENTER);
		
		//tabbedPane
		pane.addTab(str, p1[count]);
	}
	public void removeTab(int tab)
	{
		pane.remove(p1[tab]);
	}
	public void setName(String str)
	{
		f1.setTitle(str);
	}
	public boolean isSelected(int index)
	{
		if(pane.getSelectedComponent() == p1[index])
			return true;
		return false;
	}
	public static void main(String[] args)
	{
		new Swing();
	}
	public void alert(String string) {
		// TODO Auto-generated method stub
		for(int i= 0;i < 20;i++)
		{
			if(pane.getSelectedComponent() == p1[i])
			{
				t1[i].append("\n\t"+string);
				break;
			}
		}
		
	}
}