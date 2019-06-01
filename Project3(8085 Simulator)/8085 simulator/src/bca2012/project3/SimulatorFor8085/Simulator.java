package bca2012.project3.SimulatorFor8085;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.text.BadLocationException;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.CaretListener;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
//class for creating the Frontend of 8085-Simulator
public class Simulator extends JPanel implements ActionListener,CaretListener, WindowListener
{
	//declaration statements
	ListSelectionModel listSelectionModel;
	private static Map<String,Integer> pointer= new HashMap<String,Integer>();
	private static Registers reg= new Registers();
	private static OpcodeTable  opTab= new OpcodeTable("opcode1s8085.txt");
	private static Hextodec h= new Hextodec();
	private static Flags f= new Flags();
	private static String pc;
	//private static MemoryPanel m= new MemoryPanel();
	private static Memory memory= new Memory();
	private static boolean first= true;
	private String[] instructions= {"MOV","MVI","LDA","STA","LHLD","SHLD","LXI","XCHG","LDAX","STAX","IN","OUT","ADD","ADI","ADC","ACI","SUB","SUI","SBB","SBI","INR","DCR","INX","DCX","DAA","DAD","ANA","ANI","XRA","XRI","CMA","ORA","ORI","CMP","CPI","CMC","RLC","RRC","RAL","RAR","STC","JMP","JC","JNC","JP","JM","JPE","JPO","JZ","JNZ","CALL","CNZ","CZ","CPE","CNC","CC","CPO","RET","RNZ","RZ","RPE","RNC","RC","RPO","POP","PUSH","PCHL","XTHL","SPHL","EI","DI","RST","RIM","SIM","NOP","HLT","A","B","C","D","E","H","L","M","SP","PSW","0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	private JButton b[]= new JButton[102];
	private boolean instructionSelectionFlag= false;
	private JButton label;
	private int i=0,indicate= 3,size= 0,regcount= 0;
	private static long delay = 0;
	private String opcode;
	private static boolean isopcode= true,clear1= false,inc1= false;
	private static boolean stopped= false;

	private static JTextField[] ftext= new JTextField[5];
	private static JTextField[] rtext= new JTextField[10];
	private static JTextField[] otext= new JTextField[3];
	JPanel panel1;
	JPanel panel2;
	JPanel temppanel;
	JPanel Registerspanel;
	JPanel Flagspanel;
	JPanel dummy2;
	JPanel outputpanel;
	JPanel instructionpanel;
	JPanel Arithmeticpanel;
	JPanel Datatransferpanel;
	JPanel Logicalpanel;
	JPanel Branchpanel;
	JPanel Machinepanel;
	JPanel Registerpanel;
	JPanel Hexcodepanel;
	JPanel hexpanel;
	JPanel address1;
	private static JTextArea editor;
	private static JTable table;
	private static JTable Hextable;
	//private static MemoryTableModel model;
	JPanel title2;
	JPanel group;
	JButton enter= new JButton();
	private static JButton start= new JButton();
	private static JButton Stepbystep= new JButton();
	private static JButton stop= new JButton();
	private static JButton run= new JButton();
	private static JButton clear= new JButton();
	private static JButton increment= new JButton();
	private javax.swing.Timer t,t1;
	public Simulator()
	{
	}
	//method where all related methods in this class are called
	public void simulate()
	{
		//t= new javax.swing.Timer(0,this);
		//t.start();

		//setting BorderLayout for bggest panel ie; JPanel
		setLayout(new BorderLayout());
		//printing Heading label on Biggest panel in North position and setting Font and colour
		JLabel heading= new JLabel("8085 Simulator",JLabel.CENTER);
		setBackground(Color.red);
		Font f= new Font("Times New Roman",1,50);
		heading.setForeground(Color.BLACK);
		heading.setFont(f);
		//adding heading label to biggestpanel
		add(heading,BorderLayout.NORTH);

		//creating another panel ie; bigpanel on Biggest panel and setting Grid layout for panel
		JPanel bigpanel= new JPanel();
		bigpanel.setLayout(new GridLayout(1,2));
		add(bigpanel);

		//creating the first panel among 2 panels & adding it to big panel
		panel1= new JPanel();
		panel1.setLayout(new BorderLayout());
		bigpanel.add(panel1);
		//calling methods so that they are added on to first panel 
		simulationbuttons();
		textarea();
		Flags();
		Registers();
		Output();
		Memorytable();
		//creating the second panel among 2 panels & adding it to big panel
		panel2= new JPanel();
		panel2.setLayout(new BorderLayout());
		bigpanel.add(panel2);
		//calling methods so that they are added on to second panel 
		extrabuttons();
		Datatransferinstructions();
		Arithmeticinstructions();
		Logicalinstructions();
		Branchinstructions();
		Machineinstructions();
		Hexcodekeypad();
		Registerskeypad();
		Hexcodetable();
	}
	//first half of my simulator (panel1)
	//method for creating buttons which are added in panel1 at North position
	public void simulationbuttons()
	{
		JPanel buttons= new JPanel();
		buttons.setBackground(Color.blue);
		buttons.setLayout(new FlowLayout());
		start= new JButton("Start");
		start.addActionListener(this);
		start.setToolTipText("start");
		buttons.add(start);

		Stepbystep= new JButton("Step By Step");
		Stepbystep.addActionListener(this);
		Stepbystep.setToolTipText("next step");
		buttons.add(Stepbystep);

		run= new JButton("Run");
		run.addActionListener(this);
		run.setToolTipText("Run");
		buttons.add(run);

		stop= new JButton("Stop");
		stop.addActionListener(this);
		stop.setToolTipText("stop");
		buttons.add(stop);

		increment= new JButton("increment");
		increment.addActionListener(this);
		increment.setToolTipText("set increment mode");
		buttons.add(increment);

		clear= new JButton("clear");
		clear.addActionListener(this);
		clear.setToolTipText("set clear mode");
		buttons.add(clear);

		Stepbystep.setEnabled(false);
		run.setEnabled(false);
		stop.setEnabled(false);

		panel1.add(buttons,BorderLayout.NORTH);
	}

	//adding textarea in the center of panel1
	public void textarea()
	{
		editor= new JTextArea(25,10);
		Font f= new Font("FreeSerif",1,20);
		editor.setFont(f);
		int v= ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h= ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		JScrollPane s= new JScrollPane(editor,v,h);
		panel1.add(s,BorderLayout.CENTER);	
	}
	//creating a table for taking address and data by user 
	public void Memorytable()
	{
		//showing label for memory table
		JLabel memory= new JLabel("MEMORY",JLabel.CENTER);
		memory.setFont(new Font("FreeSerif",1,20));
		memory.setForeground(Color.RED);
		//creating memory panel and adding it to panel1 at East and setting border
		JPanel memorypanel= new JPanel()
		{
			//paint component for setting and adjusting the size of table
			public void paintComponent (Graphics g)
			{
				super.paintComponent(g);
				JPanel parent= (JPanel) getParent();
				Dimension parentSize= parent.getSize();
				setPreferredSize(new Dimension((int)(parentSize.getWidth() * 0.23), (int)(parentSize.getHeight()*0.88)) );
				setSize(getPreferredSize());
			}
		};
		memorypanel.setLayout(new BorderLayout());
		table= new JTable(100,2);
		table.removeColumn(table.getColumn("A"));
		table.removeColumn(table.getColumn("B"));
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		TableColumn column1= new TableColumn(0);
		column1.setHeaderValue("Address");
		table.addColumn(column1);
		TableColumn column2= new TableColumn(1);
		column2.setHeaderValue("Data");
		table.addColumn(column2);
		table.setDragEnabled(false);
		table.setDropMode(DropMode.INSERT_ROWS);

		listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
		table.setSelectionModel(listSelectionModel);

		table.setGridColor(Color.BLACK);
		JScrollPane s1= new JScrollPane(table);
		memorypanel.add(s1);
		memorypanel.add(memory,BorderLayout.NORTH);
		panel1.add(memorypanel,BorderLayout.EAST);
		repaint();
	}
	//getter and setter method for table ie; Memory table
	public String getValue(int row,int column)
	{
		return((String)table.getValueAt(row,column));
	}
	public void setValue(String str,int row,int column)
	{
		table.setValueAt(str,row,column);
	}
	public int rowsNumber()
	{
		return(table.getRowCount());
	}
	public void setValuehex(String str,int row,int column)
	{
		Hextable.setValueAt(str,row,column);
	}
	public void put(String address,int i)
	{
		pointer.put(address,i);
		System.out.println(pointer);
	}
	//method for creating Flags Label
	public void Flags()
	{
		//creating another panel(temp panel)and adding it to panel1 for flags at west
		temppanel= new JPanel() {
			public void paintComponent (Graphics g) {
				JPanel parent= (JPanel) getParent();
				Dimension parentSize= parent.getSize();
				setPreferredSize(new Dimension((int)(parentSize.getWidth() * 0.20), (int)(parentSize.getHeight())) );
				setSize(getPreferredSize());
				super.paintComponent(g);
			}
		};
		temppanel.setLayout(new GridLayout(2,1));
		panel1.add(temppanel,BorderLayout.WEST);

		//adding flags panel to temp panel
		Flagspanel=new JPanel();
		Flagspanel.setLayout(new GridLayout(6,2));
		JPanel dummy1= new JPanel();
		dummy1.setLayout(new BorderLayout());
		JLabel flagslable= new JLabel("Flags",JLabel.CENTER);
		flagslable.setFont(new Font("FreeSerif",1,20));
		dummy1.add(Flagspanel);
		dummy1.add(flagslable, BorderLayout.NORTH);
		temppanel.add(dummy1);

		Font f= new Font("",1,30);
		flagslable.setForeground(Color.RED);
		JLabel flag0= new JLabel("S",JLabel.CENTER);
		ftext[0]= new JTextField();
		ftext[0].setFont(f);
		ftext[0].setDisabledTextColor(Color.blue);
		ftext[0].setEnabled(false);
		Flagspanel.add(flag0);
		Flagspanel.add(ftext[0]);
		JLabel flag1= new JLabel("Z",JLabel.CENTER);
		ftext[1]= new JTextField();
		ftext[1].setFont(f);
		ftext[1].setDisabledTextColor(Color.blue);
		ftext[1].setEnabled(false);
		Flagspanel.add(flag1);
		Flagspanel.add(ftext[1]);
		JLabel flag2= new JLabel("AC",JLabel.CENTER);
		ftext[2]= new JTextField();
		ftext[2].setFont(f);
		ftext[2].setDisabledTextColor(Color.blue);
		ftext[2].setEnabled(false);
		Flagspanel.add(flag2);
		Flagspanel.add(ftext[2]);
		JLabel flag3= new JLabel("P",JLabel.CENTER);
		ftext[3]= new JTextField();
		ftext[3].setFont(f);
		ftext[3].setDisabledTextColor(Color.blue);
		ftext[3].setEnabled(false);
		Flagspanel.add(flag3);
		Flagspanel.add(ftext[3]);
		JLabel flag4= new JLabel("CY",JLabel.CENTER);
		ftext[4]= new JTextField();
		ftext[4].setFont(f);
		ftext[4].setDisabledTextColor(Color.blue);
		ftext[4].setEnabled(false);
		Flagspanel.add(flag4);
		Flagspanel.add(ftext[4]);
	}
	//method for changing color in Registers when program runs
	public void changeColor(int i)
	{
		rtext[i].setDisabledTextColor(Color.red);
	}
	//method for setting color in Registers when program runs
	public void setColor()
	{
		for(int i= 0;i < 10;i++)
			rtext[i].setDisabledTextColor(Color.blue);
	}
	//method for creating Registers labels
	public void Registers()
	{
		//adding Registers panel to temp panel
		Registerspanel = new JPanel();
		Registerspanel.setLayout(new GridLayout(10,2));
		dummy2= new JPanel();
		dummy2.setLayout(new BorderLayout());
		dummy2.add(Registerspanel);
		JLabel registerlable= new JLabel("Registers",JLabel.CENTER);
		registerlable.setFont(new Font("FreeSerif",1,20));
		dummy2.add(registerlable, BorderLayout.NORTH);
		temppanel.add(dummy2);

		Font f= new Font("",1,15);
		registerlable.setForeground(Color.RED);
		JLabel register0= new JLabel("A",JLabel.CENTER);
		rtext[0]= new JTextField();
		rtext[0].setFont(f);
		rtext[0].setDisabledTextColor(Color.blue);
		rtext[0].setEnabled(false);
		Registerspanel.add(register0);
		Registerspanel.add(rtext[0]);
		JLabel register1= new JLabel("B",JLabel.CENTER);
		rtext[1]= new JTextField();
		rtext[1].setFont(f);
		rtext[1].setDisabledTextColor(Color.blue);
		rtext[1].setEnabled(false);
		Registerspanel.add(register1);
		Registerspanel.add(rtext[1]);
		JLabel register2= new JLabel("C",JLabel.CENTER);
		rtext[2]= new JTextField();
		rtext[2].setFont(f);
		rtext[2].setDisabledTextColor(Color.blue);
		rtext[2].setEnabled(false);
		Registerspanel.add(register2);
		Registerspanel.add(rtext[2]);
		JLabel register3= new JLabel("D",JLabel.CENTER);
		rtext[3]= new JTextField();
		rtext[3].setFont(f);
		rtext[3].setDisabledTextColor(Color.blue);
		rtext[3].setEnabled(false);
		Registerspanel.add(register3);
		Registerspanel.add(rtext[3]);
		JLabel register4= new JLabel("E",JLabel.CENTER);
		rtext[4]= new JTextField();
		rtext[4].setFont(f);
		rtext[4].setDisabledTextColor(Color.blue);
		rtext[4].setEnabled(false);
		Registerspanel.add(register4);
		Registerspanel.add(rtext[4]);
		JLabel register5= new JLabel("H",JLabel.CENTER);
		rtext[5]= new JTextField();
		rtext[5].setFont(f);
		rtext[5].setDisabledTextColor(Color.blue);
		rtext[5].setEnabled(false);
		Registerspanel.add(register5);
		Registerspanel.add(rtext[5]);
		JLabel register6= new JLabel("L",JLabel.CENTER);
		rtext[6]= new JTextField();
		rtext[6].setFont(f);
		rtext[6].setDisabledTextColor(Color.blue);
		rtext[6].setEnabled(false);
		Registerspanel.add(register6);
		Registerspanel.add(rtext[6]);
		JLabel register7= new JLabel("M",JLabel.CENTER);
		rtext[7]= new JTextField();
		rtext[7].setFont(f);
		rtext[7].setDisabledTextColor(Color.blue);
		rtext[7].setEnabled(false);
		Registerspanel.add(register7);
		Registerspanel.add(rtext[7]);
		JLabel register8= new JLabel("SP",JLabel.CENTER);
		rtext[8]= new JTextField();
		rtext[8].setFont(f);
		rtext[8].setDisabledTextColor(Color.blue);
		rtext[8].setEnabled(false);
		Registerspanel.add(register8);
		Registerspanel.add(rtext[8]);
		JLabel register9= new JLabel("PC",JLabel.CENTER);
		rtext[9]= new JTextField();
		rtext[9].setFont(f);
		rtext[9].setDisabledTextColor(Color.blue);
		rtext[9].setEnabled(false);
		Registerspanel.add(register9);
		Registerspanel.add(rtext[9]);
	}
	//method for creating Output labels
	public void Output()
	{
		//adding outputpanel to first panel ie; panel1 at south
		outputpanel= new JPanel();
		outputpanel.setLayout(new FlowLayout());
		panel1.add(outputpanel,BorderLayout.SOUTH);
		JLabel outlable= new JLabel("O/p I/p");
		outlable.setFont(new Font("FreeSerif",1,20));
		outputpanel.add(outlable);
		outlable.setForeground(Color.RED);
		JLabel output1= new JLabel("1");
		otext[0]= new JTextField(4);
		otext[0].setFont(new Font("",Font.BOLD,10));
		outputpanel.add(output1);
		outputpanel.add(otext[0]);
		JLabel output2= new JLabel("2");
		otext[1]= new JTextField(4);
		otext[1].setFont(new Font("",Font.BOLD,10));
		outputpanel.add(output2);
		outputpanel.add(otext[1]);
		JLabel output3= new JLabel("3");
		otext[2]= new JTextField(4);
		otext[2].setFont(new Font("",Font.BOLD,10));
		outputpanel.add(output3);
		outputpanel.add(otext[2]);
	}
	//end of First half of the Simulator

	//second half of my simulator

	//method for creating table for showing Hexcode of program
	public void Hexcodetable()
	{
		//showing label for Hexcode table
		JLabel Hexcode= new JLabel("HexCode",JLabel.CENTER);
		Hexcode.setFont(new Font("FreeSerif",1,20));
		Hexcode.setForeground(Color.RED);
		//creating Hexcode panel and adding it to secondpanel at West
		hexpanel= new JPanel()
		{
			//paint component for setting and adjusting the size of table
			public void paintComponent (Graphics g)
			{
				super.paintComponent(g);
				JPanel parent= (JPanel) getParent();
				Dimension parentSize= parent.getSize();
				setPreferredSize(new Dimension((int)(parentSize.getWidth() * 0.23), (int)(parentSize.getHeight() * 0.94)) );
				setSize(getPreferredSize());
			}
		};
		hexpanel.setLayout(new BorderLayout());
		Hextable= new JTable(100,2);
		TableColumn column1= new TableColumn(0);
		column1.setHeaderValue("Address");
		Hextable.addColumn(column1);
		TableColumn column2= new TableColumn(1);
		column2.setHeaderValue("Data");
		Hextable.addColumn(column2);
		Hextable.removeColumn(Hextable.getColumn("A"));
		Hextable.removeColumn(Hextable.getColumn("B"));
		Hextable.getTableHeader().setReorderingAllowed(false);
		Hextable.getTableHeader().setResizingAllowed(false);

		Hextable.setGridColor(Color.BLACK);
		Hextable.setEnabled(false);
		JScrollPane scroll= new JScrollPane(Hextable) {
			public void paintComponent (Graphics g) {
				super.paintComponent(g);
				JPanel parent= (JPanel) getParent();
				Dimension parentSize= parent.getSize();
				setPreferredSize(new Dimension((int)(parentSize.getWidth()), (int)(parentSize.getHeight() * 0.94)) );
				setSize(getPreferredSize());
			}
		};
		hexpanel.add(scroll,BorderLayout.WEST);
		hexpanel.add(Hexcode,BorderLayout.NORTH);
		//adding hexpanel to panel2
		panel2.add(hexpanel,BorderLayout.WEST);
		repaint();
	}
	//method for creating button "cancel " 
	public void extrabuttons()
	{
		JPanel button= new JPanel();
		button.setBackground(Color.blue);
		button.setLayout(new FlowLayout());
		enter= new JButton("Cancel");
		enter.setEnabled(false);
		enter.addActionListener(this);
		button.add(enter);
		panel2.add(button,BorderLayout.NORTH);
	}
	//method for creating Data Transfer instructions buttons
	public void Datatransferinstructions()
	{
		//creating another panel ie; Instruction panel in second half with grid layout
		instructionpanel= new JPanel();
		instructionpanel.setLayout(new GridLayout(5,1));
		panel2.add(instructionpanel,BorderLayout.CENTER);

		//creating DataTransfer instruction panel and adding to Instruction panel
		Datatransferpanel= new JPanel();
		Datatransferpanel.setLayout(new BorderLayout());
		JPanel title= new JPanel();
		JLabel dtlabel= new JLabel("Data Transfer Instructions",JLabel.CENTER);
		dtlabel.setFont(new Font("FreeSerif",1,20));
		dtlabel.setForeground(Color.RED);
		title.add(dtlabel);
		Datatransferpanel.add(title,BorderLayout.NORTH);
		JPanel group1= new JPanel();
		group1.setLayout(new GridLayout(3,4));

		for(int i= 0;i < 12;i++)
		{
			b[i]= new JButton(instructions[i]);
			b[i].setForeground(Color.BLACK);
			b[i].addActionListener(this);
			group1.add(b[i]);
		}
		Datatransferpanel.add(group1);
		instructionpanel.add(Datatransferpanel);
	}
	//method for creating Arithmetic instructions buttons
	public void Arithmeticinstructions()
	{
		//creating Arithmetic instruction panel and adding to Instruction panel
		Arithmeticpanel= new JPanel();
		Arithmeticpanel.setLayout(new BorderLayout());
		title2= new JPanel();
		JLabel ailabel= new JLabel("Arithmetic Instruction",JLabel.CENTER);
		ailabel.setFont(new Font("FreeSerif",1,20));
		ailabel.setForeground(Color.RED);
		title2.add(ailabel);
		Arithmeticpanel.add(title2,BorderLayout.NORTH);
		group= new JPanel();
		group.setLayout(new GridLayout(2,7));
		for(int i= 12;i < 26;i++)
		{
			b[i]= new JButton(instructions[i]);
			b[i].setForeground(Color.BLACK);
			b[i].addActionListener(this);
			group.add(b[i]);
		}
		Arithmeticpanel.add(group);
		instructionpanel.add(Arithmeticpanel);
	}
	//method for creating Logical instructions buttons
	public void Logicalinstructions()
	{
		//creating Logical instruction panel and adding to Instruction panel
		Logicalpanel= new JPanel();
		Logicalpanel.setLayout(new BorderLayout());
		JPanel heading= new JPanel();
		JLabel lilabel= new JLabel("Logical Instructions",JLabel.CENTER);
		lilabel.setFont(new Font("FreeSerif",1,20));
		lilabel.setForeground(Color.RED);
		heading.add(lilabel);
		Logicalpanel.add(heading,BorderLayout.NORTH);
		JPanel group2= new JPanel();
		group2.setLayout(new GridLayout(3,4));
		for(int i= 26;i < 41;i++)
		{
			b[i]= new JButton(instructions[i]);
			b[i].setForeground(Color.BLACK);
			b[i].addActionListener(this);
			group2.add(b[i]);
		}
		Logicalpanel.add(group2);
		instructionpanel.add(Logicalpanel);
	}
	//method for creating Branch instructions buttons
	public void Branchinstructions()
	{
		//creating Branch panel instructions panel and adding it to Instruction Panel
		Branchpanel= new JPanel();
		Branchpanel.setLayout(new BorderLayout());
		JPanel head= new JPanel();
		JLabel bilabel= new JLabel("Branch Instructions",JLabel.CENTER);
		bilabel.setFont(new Font("FreeSerif",1,20));
		bilabel.setForeground(Color.RED);
		head.add(bilabel,BorderLayout.NORTH);
		Branchpanel.add(head,BorderLayout.NORTH);
		JPanel group3= new JPanel();
		group3.setLayout(new GridLayout(4,7));
		for(int i= 41;i < 69;i++)
		{
			b[i]= new JButton(instructions[i]);
			b[i].setForeground(Color.BLACK);
			b[i].addActionListener(this);
			group3.add(b[i]);
		}
		Branchpanel.add(group3);
		instructionpanel.add(Branchpanel);
	}
	//method for creating Machine instructions buttons
	public void Machineinstructions()
	{
		//creating Machine control instructions panel and adding it to Instruction panel
		Machinepanel= new JPanel();
		Machinepanel.setLayout(new BorderLayout());
		JPanel head1= new JPanel();
		JLabel milabel= new JLabel("Machine Instructions",JLabel.CENTER);
		milabel.setFont(new Font("FreeSerif",1,20));
		milabel.setForeground(Color.RED);
		head1.add(milabel,BorderLayout.NORTH);
		Machinepanel.add(head1,BorderLayout.NORTH);
		JPanel group4= new JPanel();
		group4.setLayout(new GridLayout(2,4));
		for(int i= 69;i < 76;i++)
		{
			b[i]= new JButton(instructions[i]);
			b[i].setForeground(Color.BLACK);
			b[i].addActionListener(this);
			group4.add(b[i]);
		}
		Machinepanel.add(group4);
		instructionpanel.add(Machinepanel);
	}
	//method for creating Registers buttons
	public void Registerskeypad()
	{
		//creating Registers panel 
		Registerpanel= new JPanel();
		Registerpanel.setLayout(new BorderLayout());
		JPanel head111= new JPanel();
		JLabel rk= new JLabel("Registers Keypad",JLabel.CENTER);
		rk.setFont(new Font("FreeSerif",1,20));
		rk.setForeground(Color.RED);
		head111.add(rk,BorderLayout.NORTH);
		Registerpanel.add(rk,BorderLayout.NORTH);
		JPanel group41= new JPanel();
		group41.setLayout(new GridLayout(2,5));
		for(int i= 76;i < 86;i++)
		{
			b[i]= new JButton(instructions[i]);
			b[i].setForeground(Color.BLACK);
			b[i].addActionListener(this);
			group41.add(b[i]);
		}
		Registerpanel.add(group41);
	}
	//method for creating Hexcode keypad buttons
	public void Hexcodekeypad()
	{
		//creating Hex Code keypad panel 
		JPanel temp= new JPanel();
		temp.setLayout(new BorderLayout());
		panel2.add(temp,BorderLayout.SOUTH);
		Hexcodepanel= new JPanel();
		Hexcodepanel.setLayout(new BorderLayout());
		JPanel hex= new JPanel();
		JLabel hk= new JLabel("HexCode Keypad",JLabel.CENTER);
		hk.setFont(new Font("FreeSerif",1,20));
		hk.setForeground(Color.RED);
		hex.add(hk,BorderLayout.NORTH);
		Hexcodepanel.add(hex,BorderLayout.NORTH);
		JPanel group5= new JPanel();
		group5.setLayout(new GridLayout(2,8));
		for(int i= 86;i < 102;i++)
		{
			b[i]= new JButton(instructions[i]);
			b[i].setForeground(Color.BLACK);
			b[i].addActionListener(this);
			group5.add(b[i]);
		}
		Hexcodepanel.add(group5);
	}

	//creating MenuBar for the Frame 
	public JMenuBar getMenuBar() 
	{
		//File Menu
		JMenuBar menubar= new JMenuBar();
		JMenu File= new JMenu("File");
		JMenuItem New= new JMenuItem("New",KeyEvent.VK_N);
		New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		JMenuItem Open= new JMenuItem("Open",KeyEvent.VK_O);
		Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		JMenuItem Save= new JMenuItem("Save",KeyEvent.VK_S);
		Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		JMenuItem Exit= new JMenuItem("Exit",KeyEvent.VK_F4);
		Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4 ,InputEvent.CTRL_MASK));
		File.add(New);
		New.addActionListener(this);
		File.add(Open);
		Open.addActionListener(this);
		File.add(Save);
		Save.addActionListener(this);
		File.add(Exit);
		Exit.addActionListener(this);
		menubar.add(File);

		//Edit Menu
		JMenu Edit= new JMenu("Edit");
		JMenuItem Cut= new JMenuItem("Cut",KeyEvent.VK_X);
		Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
		JMenuItem Copy= new JMenuItem("Copy",KeyEvent.VK_C);
		Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		JMenuItem Paste= new JMenuItem("Paste",KeyEvent.VK_V);
		Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
		JMenuItem Delete= new JMenuItem("Delete",KeyEvent.VK_DELETE);
		Delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,InputEvent.CTRL_MASK));
		Edit.add(Cut);
		Cut.addActionListener(this);
		Edit.add(Copy);
		Copy.addActionListener(this);
		Edit.add(Paste);
		Paste.addActionListener(this);
		Edit.add(Delete);
		Delete.addActionListener(this);
		menubar.add(Edit);

		//SPeed Menu
		JMenu Simulate= new JMenu("Speed");
		JMenuItem Slow= new JMenuItem("Slow",KeyEvent.VK_F5);
		Slow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,InputEvent.CTRL_MASK));
		JMenuItem Medium= new JMenuItem("Medium",KeyEvent.VK_F6);
		Medium.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6,InputEvent.CTRL_MASK));
		JMenuItem Fast= new JMenuItem("Fast",KeyEvent.VK_F7);
		Fast.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7,InputEvent.CTRL_MASK));
		Simulate.add(Slow);
		Slow.addActionListener(this);
		Simulate.add(Medium);
		Medium.addActionListener(this);
		Simulate.add(Fast);
		Fast.addActionListener(this);
		menubar.add(Simulate);

		//Who "About us " menu
		JMenu Help = new JMenu("Who");
		JMenuItem Aboutus = new JMenuItem("About Us");
		Help.add(Aboutus);
		Aboutus.addActionListener(this);
		menubar.add(Help);
		return menubar;
	}
	//method for updating the Registers
	public void update()
	{
		String address,data;

		rtext[0].setText(reg.getA());
		rtext[1].setText(reg.getB());
		rtext[2].setText(reg.getC());
		rtext[3].setText(reg.getD());
		rtext[4].setText(reg.getE());
		rtext[5].setText(reg.getH());
		rtext[6].setText(reg.getL());
		rtext[7].setText(reg.getM());
		rtext[8].setText(reg.getSP());
		rtext[9].setText(reg.getPC());

		ftext[0].setText(Integer.toString(f.getS()));
		ftext[1].setText(Integer.toString(f.getZ()));
		ftext[2].setText(Integer.toString(f.getAC()));
		ftext[3].setText(Integer.toString(f.getP()));
		ftext[4].setText(Integer.toString(f.getCY()));
		System.out.println(reg.getPort1()+"......ashok"+reg.getPort2()+"........."+reg.getPort3());
		otext[0].setText(reg.getPort1());
		otext[1].setText(reg.getPort2());
		otext[2].setText(reg.getPort3());
		for(int i= 0;i < rowsNumber();i++)
		{
			if((address= getValue(i,0)) != null)
			{
				if(!address.equals(""))
				{
					data= memory.getData(address);
					setValue(data,i,1);
				}
			}
		}
	}
	public void caretUpdate(CaretEvent e)
	{
		editor= (JTextArea) e.getSource();
		String str= editor.getText();
		str= str.toUpperCase();
		editor.setText(str);
	}
	//Action performed method for all the actions performed by buttons or menus
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
		//case for Selecting "New File" and Saving the Old File
		case "New":
		{
			int response= JOptionPane.showConfirmDialog(getComponent(0),"Do You Want A New File");
			if(response == JOptionPane.YES_OPTION)
			{
				if(editor.getText() == null);
				else
				{
					try
					{
						JFileChooser fc1= new JFileChooser("programs");
						int value1= fc1.showSaveDialog(Simulator.this);
						if(value1 == JFileChooser.APPROVE_OPTION)
						{
							File file1= fc1.getSelectedFile();
							BufferedWriter out2= new BufferedWriter(new FileWriter(file1));
							out2.write(editor.getText());
							out2.flush();
						}
						editor.setText("");
					}
					catch(FileNotFoundException f)
					{
					}
					catch(IOException f)
					{
					}
				}

			}
			if(response == JOptionPane.NO_OPTION)
			{
				return;
			}
			break;
		}
		//case for Opening the File and printing text on to Textarea
		case "Open":
		{
			String l;
			try
			{
				JFileChooser fc= new JFileChooser("programs");
				int value= fc.showOpenDialog(Simulator.this);
				if(value == JFileChooser.APPROVE_OPTION)
				{
					File file= fc.getSelectedFile();
					BufferedReader input= new BufferedReader(new FileReader(file));
					editor.setText("");
					while((l= input.readLine()) != null)
						editor.setText(editor.getText()+l+"\n");
				}
			}
			catch(FileNotFoundException f)
			{
			}
			catch(IOException f)
			{
			}
			reg.setPC("-1");
			setdef();
			repaint();
			break;
		}
		//Case for Saving the file
		case "Save":
		{
			try
			{
				JFileChooser fc= new JFileChooser("programs");
				int value= fc.showSaveDialog(Simulator.this);
				if(value == JFileChooser.APPROVE_OPTION)
				{
					File file= fc.getSelectedFile();
					BufferedWriter out1= new BufferedWriter(new FileWriter(file));
					out1.write(editor.getText());
					out1.flush();
				}
			}
			catch(FileNotFoundException f)
			{
			}
			catch(IOException f)
			{
			}
			break;
		}
		//case for while Exiting the Screen .. and saving the file before Exit
		case "Exit":
		{

			int response= JOptionPane.showConfirmDialog(getComponent(0),"Do You Really Want To Quit");
			if(response == JOptionPane.YES_OPTION)
			{
				if(editor.getText() != null)
				{
					try
					{
						JFileChooser fc1= new JFileChooser("programs");
						int value1= fc1.showSaveDialog(Simulator.this);
						if(value1 == JFileChooser.APPROVE_OPTION)
						{
							File file1= fc1.getSelectedFile();
							BufferedWriter out2= new BufferedWriter(new FileWriter(file1));
							out2.write(editor.getText());
							out2.flush();
						}
					}
					catch(FileNotFoundException f)
					{
					}
					catch(IOException f)
					{
					}
					System.exit(0);
				}
			}
			else if(response == JOptionPane.NO_OPTION);
			break;
		}
		//case for CUT option
		case "Cut":
		{
			editor.cut();
			break;
		}
		//case for COPY option
		case "Copy":
		{
			editor.copy();
			break;
		}
		//case for PASTE option
		case "Paste":
		{
			editor.paste();
			break;
		}
		//case for DELETE option
		case "Delete":
		{
			editor.setText("");
			break;
		}
		//case for CANCEL option
		case "Cancel":
		{
			//calling method "paintInst"
			paintInst();
			break;
		}
		//case for CLEARing values in the Memory table 
		case "clear":
		{
			if(clear1)
			{
				clear1= false;
				clear.setToolTipText("set clear mode");
			}
			else
			{
				clear1= true;
				clear.setToolTipText("reset clear mode");
				inc1= false;
				increment.setToolTipText("set increment mode");
			}
			break;
		}
		//case for Increment values in the Memory table
		case "increment":
		{
			if(inc1)
			{
				inc1= false;
				increment.setToolTipText("set increment mode");
			}
			else
			{
				inc1= true;
				increment.setToolTipText("reset increment mode");
				//				incA.setEnabled(true);
				clear1= false;
				clear.setToolTipText("set clear mode");
				//			clearA.setEnabled(false);
			}
			break;
		}
		//case for Starting the program
		case "Start":
		{
			for(int i= 0;i < Hextable.getRowCount();i++)
			{
				Hextable.setValueAt("",i,0);
				Hextable.setValueAt("",i,1);
			}
			f.initialise();
			Loader.resetError();
			stopped= true;
			setColor();
			editor.setCaretColor(Color.magenta);
			editor.getCaret().setBlinkRate(10);
			pointer.clear();
			Loader.zero();
			String l,pre="";
			try
			{
				BufferedWriter out= new BufferedWriter(new FileWriter("temp.txt"));
				BufferedReader input1= new BufferedReader(new FileReader("temp.txt"));
				String str= editor.getText();
				str= str.toUpperCase();
				editor.setText(str);
				System.out.println(str);
				out.write(str);
				out.flush();
				String[] file={"temp.txt"};
				while((l= input1.readLine()) != null)
				{
					if(!l.equals(""))
						pre= l;
				}
				pre= pre.trim();
				if(!pre.equals("HLT"))
				{
					editor.setText(editor.getText()+"\n"+"HLT");
					str= editor.getText();
					out= new BufferedWriter(new FileWriter("temp.txt"));
					out.write(str);
					out.flush();
				}
				Loader.main(file);
			}
			catch(IOException f)
			{
				System.out.println(f);
			}
			if(!Loader.getError())
			{
				update();
				Loader.resetError();
				Stepbystep.setEnabled(true);
				run.setEnabled(true);
			}
			else
			{
				Stepbystep.setEnabled(false);
				run.setEnabled(false);
				stop.setEnabled(false);
			}
			Loader.resetError();
			break;
		}
		//case for Step by step execution of the program and select the current line which is executed.
		case "Step By Step":
		{
			setColor();
			if(!reg.getPC().equals("-1"))
			{
				try
				{
					Loader.executer();

					if(!reg.getPC().equals("-1"))
					{
						editor.grabFocus();
						Integer line;
						if((line= pointer.get(reg.getPC())) != null)
						{
							editor.select(editor.getLineStartOffset(line),editor.getLineEndOffset(line));
						}
						else
						{
							JOptionPane.showMessageDialog(null,"not in the scope of programme", "alert", JOptionPane.ERROR_MESSAGE);
							Loader.setError();
							Stepbystep.setEnabled(false);
							run.setEnabled(false);
						}
					}
				}
				catch(BadLocationException b)
				{
				}
			}
			else
			{
				reg.setPC(Loader.getAddress());
				rtext[9].setText(reg.getPC());
			}
			break;
		}
		//case for Running program at One Shot
		case "Run":
		{
			Thread thread1= new Thread(new Run());
			thread1.start();
			break;
		}
		//case for stopping the program
		case "Stop":
		{
			stopped= true;
			Stepbystep.setEnabled(true);
			run.setEnabled(true);
			break;
		}
		//case for showing a panel about the Creators
		case "About Us":
		{
			new Application1();
			break;
		}
		//case for unimplemented methods
		case "RIM":case "EI": case "DI": case "SIM": case "RST":
		{
			JOptionPane.showMessageDialog(null,"Sorry not yet Implemented","Unimplemented",JOptionPane.ERROR_MESSAGE);
			break;
		}
		//case for running program in slow motion
		case "Slow":
		{
			delay= 500;
			break;
		}
		//case for running program in Medium motion
		case "Medium":
		{
			delay= 250;
			break;
		}
		//case for running program in Fast motion
		case "Fast":
		{
			delay= 0;
			break;
		}
		//default method for removing panels and adding panels according to instruction size
		default:
		{
			instructionpanel.removeAll();
			instructionpanel.validate();
			if(indicate == 3)
			{
				editor.insert(e.getActionCommand()+" ",editor.getCaretPosition());
				opcode= e.getActionCommand();
				System.out.println(opcode+"ashok");
				if(isopcode)
				{
					size= opTab.getSize(opcode);
					if(size == 3)
						size= 4;
					isopcode= false;
					switch(opcode)//disabling buttons of opcodes which are not neccesary.
					{				//telling register count it takes.
					case "IN": case "OUT":
						size--;
						b[86].setEnabled(false);
						for(int j= 90;j < 102;j++)
						{
							b[j].setEnabled(false);
						}
						break;
					case "MOV":
						regcount= 2;
						b[84].setEnabled(false);
						b[85].setEnabled(false);
						break;
					case "ADD":case "SUB":case "ADC":case "ANA":case "CMP":case "ORA":case "SBB":case "XRA":
						regcount= 1;
						b[84].setEnabled(false);
						b[85].setEnabled(false);
						break;
					case "DAD":case "DCX":case "INX":case "LXI":
						regcount= 1;
						for(int j= 76;j < 86;j+= 2)
						{
							b[j].setEnabled(false);
							if(j == 82)
								j--;
						}
						break;
					case "LDAX":case "STAX":
						regcount= 1;
						for(int j= 76;j < 86;j++)
						{
							b[j].setEnabled(false);
							if(j == 76 || j == 78)
								j++;
						}
						break;
					case "PUSH":case "POP":
						regcount= 1;
						for(int j= 76;j < 86;j+= 2)
						{
							b[j].setEnabled(false);
							if(j >= 82)
								j--;
							if(j == 83)
								j++;
						}
						break;
					case "DCR":case "INR":case "MVI":
						regcount= 1;
						b[84].setEnabled(false);
						b[85].setEnabled(false);
						break;
					}
				}
				if(regcount == 0 &&(opcode.equals("IN") || opcode.equals("OUT") || size == 2 || size == 4))
				{
					instructionpanel.add(new JPanel());
					instructionpanel.add(new JPanel());
					instructionpanel.add(Hexcodepanel);//showing hexacode panel
					instructionpanel.add(new JPanel());
					instructionpanel.add(new JPanel());
					enter.setEnabled(true);
					instructionpanel.validate();
					indicate= 1;
				}
				else
				{
					if(size != 1)
						indicate= 2;
					else if(regcount != -1)
					{
						indicate= 3;
						regcount--;
					}
					if(regcount == -1)
					{
						paintInst();
						if(size == 2 || size == 4)
							indicate= 2;
					}
					else
					{
						instructionpanel.add(new JPanel());
						instructionpanel.add(new JPanel());
						instructionpanel.add(Registerpanel);
						instructionpanel.add(new JPanel());
						instructionpanel.add(new JPanel());
						enter.setEnabled(true);
						instructionpanel.validate();
					}
				}
			}
			else if(indicate == 2)
			{
				editor.insert(e.getActionCommand()+" ",editor.getCaretPosition());
				instructionpanel.add(new JPanel());
				instructionpanel.add(new JPanel());
				instructionpanel.add(Hexcodepanel);
				instructionpanel.add(new JPanel());
				instructionpanel.add(new JPanel());
				enter.setEnabled(true);
				instructionpanel.validate();
				indicate= 1;
			}
			else if(indicate == 1)
			{
				editor.insert(e.getActionCommand(),editor.getCaretPosition());
				if(size != 0)
				{
					indicate= 1;
					size--;
					instructionpanel.add(new JPanel());
					instructionpanel.add(new JPanel());
					instructionpanel.add(Hexcodepanel);
					instructionpanel.add(new JPanel());
					instructionpanel.add(new JPanel());
					enter.setEnabled(true);
					instructionpanel.validate();
				}
				if(size == 0)
				{
					paintInst();
				}
			}
		}
		break;
		}
		repaint();
	}
	//method for adding the removed panels when Instruction is completed or Cancel button is pressed
	public void paintInst()//adding all opcode panels.
	{
		editor.insert("\n",editor.getCaretPosition());
		indicate= 3;
		regcount= 0;
		isopcode= true;
		instructionpanel.removeAll();
		instructionpanel.add(Datatransferpanel);
		instructionpanel.add(Arithmeticpanel);
		instructionpanel.add(Logicalpanel);
		instructionpanel.add(Branchpanel);
		instructionpanel.add(Machinepanel);
		instructionpanel.validate();
		for(int j= 76;j < 102;j++)
		{
			b[j].setEnabled(true);
		}
		enter.setEnabled(false);
	}
	//method for Run "another thread"
	public void startRun()
	{
		stopped= false;
		start.setEnabled(false);
		Stepbystep.setEnabled(false);
		run.setEnabled(false);
		stop.setEnabled(true);
		int count= 0;
		while(!reg.getPC().equals("-1"))
		{
			if(stopped)
				break;
			setColor();
			try
			{
				Loader.executer();
				count++;
				if(!reg.getPC().equals("-1"))
				{
					editor.grabFocus();
					Integer line;
					if((line= pointer.get(reg.getPC())) != null)
					{
						editor.select(editor.getLineStartOffset(line),editor.getLineEndOffset(line));
					}
					else
					{
						JOptionPane.showMessageDialog(null,"address is not in the scope of programme "+reg.getPC(), "alert", JOptionPane.ERROR_MESSAGE);
						Loader.setError();
						stopped= true;
						Stepbystep.setEnabled(false);
						run.setEnabled(false);
					}
				}
				Thread.sleep(delay);
			}
			catch(BadLocationException b1)
			{
			}
			catch(InterruptedException e)
			{
			}

		}
		start.setEnabled(true);
		if(!Loader.getError())
		{
			Stepbystep.setEnabled(true);
			run.setEnabled(true);
			stop.setEnabled(false);
		}
	}
	//getter and setter methods for Clear and Increment
	public boolean getclear() 
	{
		return clear1;
	}
	public void setclear() 
	{
		clear1= true;
		inc1= false;
	}
	public boolean getinc() 
	{
		return inc1;
	}
	public void setinc() 
	{
		inc1= true;
		clear1= false;
	}
	//method for enabling buttons ie; StepbyStep and Run 
	public void setdef() 
	{
		Stepbystep.setEnabled(false);
		run.setEnabled(false);
		repaint();
	}
	//methods for Window Listener when invoked
	public void windowOpened(WindowEvent e)
	{
	}
	//method when window is closing
	public void windowClosing(WindowEvent e)
	{
		int response= JOptionPane.showConfirmDialog(null,"Your are Closing Window.. Your Program will not be Saved\n\n       Do You Want To SAVE","Closing Window",JOptionPane.YES_NO_OPTION);
		if(response == JOptionPane.YES_OPTION)
		{
			try
			{
				JFileChooser fc= new JFileChooser();
				fc.setCurrentDirectory(new File("/home/bca3/workspace/8085 simulator/bin/programs"));
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int value= fc.showSaveDialog(Simulator.this);
				if(value == JFileChooser.APPROVE_OPTION)
				{
					File file= fc.getSelectedFile();
					BufferedWriter out1= new BufferedWriter(new FileWriter(file));
					out1.write(editor.getText());
					out1.flush();
				}
			}
			catch(FileNotFoundException f)
			{
			}
			catch(IOException f)
			{
			}
			return;
		}
		if(response == JOptionPane.NO_OPTION)
		{
			System.exit(0);
		}
	}
	//method when window is minimized
	public void windowIconified(WindowEvent e)
	{
		JOptionPane.showMessageDialog(null,"You Minimized the 8085 Simulator Programming Window","Window Minimized",JOptionPane.INFORMATION_MESSAGE);
	}
	//method when window is restored back
	public void windowDeiconified(WindowEvent e)
	{
		JOptionPane.showMessageDialog(null,"You Maximized the 8085 Simulator Programming Window","Window Maximized",JOptionPane.INFORMATION_MESSAGE);
	}
	public void windowActivated(WindowEvent e)
	{

	}
	public void windowDeactivated(WindowEvent e)
	{
	}
	public void windowClosed(WindowEvent e)
	{
	}
	public String getIn1() 
	{
		return(otext[0].getText());
	}
	public String getIn2() {
		return(otext[1].getText());
	}
	public String getIn3() {
		return(otext[2].getText());
	}

}

class SharedListSelectionHandler implements ListSelectionListener 
{
	public void valueChanged(ListSelectionEvent e) 
	{
		System.out.println("entered");
		Hextodec h= new Hextodec();
		Simulator s= new Simulator();
		int value;
		String str;
		ListSelectionModel lsm = (ListSelectionModel)e.getSource();

		int firstIndex = e.getFirstIndex();
		int lastIndex = e.getLastIndex();
		boolean isAdjusting = e.getValueIsAdjusting();
		if (lsm.isSelectionEmpty()) 
		{
			System.out.println("none");
		} 
		else 
		{
			// Find out which indexes are selected.
			int minIndex = lsm.getMinSelectionIndex();
			int maxIndex = lsm.getMaxSelectionIndex();
			for (int i = minIndex; i <= maxIndex; i++) 
			{
				if (lsm.isSelectedIndex(i) && i >= 0) 
				{
					if(s.getinc())   //Increments the address in address column as selected
					{
						if(i > 0)
						{
							str= s.getValue(i-1,0);
							if(str != null && !str.equals(""))
							{
								value= h.getDecimalNum(str);
								value++;
								str= Integer.toHexString(value);
								while(str.length() < 4)
									str="0" + str;
								s.setValue(str,i,0);
							}
						}
					}
					else if(s.getclear())  //clear the cells which are selected
					{
						s.setValue("",i,0);
						s.setValue("",i,1);
					}
				}
			}
		}
	}
}
class Run implements Runnable 
{
	public void run()
	{
		new Simulator().startRun();
	}

}
//class for About Us panel
class Application1 extends JFrame 
{

	public Application1()
	{ 
		//setting Nimbus look and Feel
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
		}
		//involing and calling Aboutus class
		Aboutus aboutus= new Aboutus();
		addWindowListener(aboutus);
		add(aboutus);
		setSize(830,680);
		setTitle("Aboutus");
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
}
//class that extends Jpanel and where all information is drawn using Paint , Graphics
class Aboutus extends JPanel implements ActionListener , WindowListener 
{
	ImageIcon im= new ImageIcon("pics/emblem.jpg");
	Image m;
	ImageIcon im1= new ImageIcon("pics/3.jpg");
	Image m1;
	ImageIcon im2= new ImageIcon("pics/animation1.gif");
	Image m2;
	private int x= 70,y= 10,count= 0,w1= 140,w2= 140,h1= 140,h2= 140;
	private javax.swing.Timer t;
	private int count1,count2,count3,count4,count5;
	boolean image= false;
	private int x1= 280,y1= 80,x2= 280,y2= 100,x3= 660,y3= 490,x4= 280,y4= 400,x5= 160,y5= 440,x6= 30,y6= 490,x7= 350,y7= 490;
	//constructor where Border is Set
	public Aboutus()
	{
		setBorder(BorderFactory.createLineBorder(Color.PINK,13));
		t= new javax.swing.Timer(30, this);
		t.start();
	}
	//paintcomponent for drawing Text and Images
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawText(g);
		if(image)
			loadImage();
		g.drawImage(m1,x6,y6,w2,h2,null);
		g.drawImage(m,x3,y3,w1,h1,null);
		g.drawImage(m2,x7,y7,w1,h1,null);
	}
	//method for loading images
	private void loadImage()
	{
		m= im.getImage();
		m1= im1.getImage();
		m2= im2.getImage();
	}
	//method for drawing text
	private void drawText(Graphics g)
	{
		Graphics2D g1= (Graphics2D)g;
		Graphics2D g2= (Graphics2D)g;
		Graphics2D g3= (Graphics2D)g;
		Graphics2D g4= (Graphics2D)g;
		Graphics2D g5= (Graphics2D)g;
		setBackground(Color.black);
		g1.setColor(Color.RED);
		g1.setFont(new Font("verdana",Font.BOLD,count));
		g1.drawString("Programmed and Designed By",x,y);
		g2.setColor(Color.WHITE);
		g3.setColor(Color.WHITE);
		g2.setFont(new Font("Rekha",1,count1));
		g2.drawString("Umesh.G",x1,y1);
		g2.drawString("&",x1+ 90,y1+30);
		g2.drawString("Ashok Kumar.D",x1-60,y1+70);
		g3.setFont(new Font("Rekha",1,count2));
		g3.drawString("Batch: 2012 - 2015",x2-10,y2+110);
		g3.drawString("Sri Sathya Sai Institute Of Higher Learning",x2-180,y2+160);
		g3.drawString("Muddhenahalli Campus",x2-30,y2+200);
		g4.setFont(new Font("Rekha",1,count3));
		g4.setColor(Color.GREEN);
		g4.drawString("Send Feedback To",x4,y4);
		g5.setFont(new Font("Rekha",1,count3));
		g5.setColor(Color.YELLOW);
		g5.drawString("--> umeshparents1994@gmail.com",x5,y5);
		g5.drawString("--> dhulipallaashokumar@gmail.com",x5,y5+40);
	}
	//method for animating the text
	public void actionPerformed(ActionEvent e)
	{
		{
			if(count < 40)
			{
				count++;
				y++;
			}
			else if(count1 < 50)
			{
				count1++;
				y1++;
			}
			else if(count2 < 30)
			{
				count2++;
				y2++;
			}
			else if(count3 < 30)
			{
				count3++;
			}
			else if(count4 < 30)
			{
				count4++;
			}
			else
				image= true;
			if(count5 < 20)
			{
				count5++;
			}
			repaint();
		}
	}
	//methd for Window Listener according to conditions
	public void windowOpened(WindowEvent e)
	{
	}
	//method when window is closing
	public void windowClosing(WindowEvent e)
	{
		JOptionPane.showMessageDialog(null, "You are Closing Window ","Closing Window", JOptionPane.WARNING_MESSAGE);
	}
	//method when window is minimized
	public void windowIconified(WindowEvent e)
	{
		JOptionPane.showMessageDialog(null,"Window Minimized","Window Minimized",JOptionPane.INFORMATION_MESSAGE);
	}
	//method when window is restored back
	public void windowDeiconified(WindowEvent e)
	{
		JOptionPane.showMessageDialog(null,"Window Restored","Window Maximized",JOptionPane.INFORMATION_MESSAGE);
	}
	public void windowActivated(WindowEvent e)
	{
	}
	public void windowDeactivated(WindowEvent e)
	{
	}
	public void windowClosed(WindowEvent e)
	{
	}
}
