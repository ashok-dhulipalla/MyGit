package bca2012.project3.SimulatorFor8085;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//class for creating the Homepage  and implementing Action Listener and Window Listener
class Homepage extends JPanel implements ActionListener ,WindowListener
{
	Application a;
	int x= 500,y= 40,count= 0;
	public Homepage()
	{
	}
	//parameterized constructor
	public Homepage(Application a)
	{
		this.a= a;
		setLayout(new BorderLayout());
		clickbutton();
	}
	//method for creating button "Start Programming " in south of panel
	private void clickbutton() 
	{
		//panel for creating button
		JPanel buttonpanel= new JPanel();
		buttonpanel.setLayout(new FlowLayout());
		buttonpanel.setBackground(Color.gray);
		//creating button 
		JButton click= new JButton("Start Programming");
		click.setForeground(Color.red);
		click.addActionListener(this);
		buttonpanel.add(click);
		//adding button for the panel
		add(buttonpanel,BorderLayout.SOUTH);
		//add Mypanel class and calling the class
		add(new Mypanel());
	}
	//paint component for drawing
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
	//paint method for repainting and validating
	public void paint()
	{
		validate();
		repaint();
	}
	//method for action to be done when button is clicked
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
			//case for button "Start Programming"
			case "Start Programming":
			{
				//calling .. invoking another class
				new Application2();
				a.dispose();
				Mypanel.kill();
				repaint();
				break;
			}

		}
	}
	// window listener methods for the Application class
	public void windowOpened(WindowEvent e)
	{
	}
	public void windowClosing(WindowEvent e)
	{
		JOptionPane.showMessageDialog(null, "You Cannot Use 8085 Simulator .. Since you are Closing, \n \n Please Run the Program Again and Click Start Programming Button","Closing Window", JOptionPane.WARNING_MESSAGE);
	}
	public void windowIconified(WindowEvent e)
	{
		JOptionPane.showMessageDialog(null,"Window Minimized","Window Minimized",JOptionPane.INFORMATION_MESSAGE);
	}
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
// class for Simulator panel .. invoked when button is clicked
class Application2 extends JFrame
{
	private static final long serialVersionUID = 1L;

	public Application2()
	{ 
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		        	UIManager.put("Table.showGrid",true);
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		}
		//calling another panel ie; Simulator class
		Simulator simulator= new Simulator();
		add(simulator);
		simulator.simulate();
		simulator.repaint();
		//adding window Listener
		addWindowListener(simulator);
		setSize(1366,770);
		setTitle("8085 Simulator");
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);
		//setting menubar 
		setJMenuBar(simulator.getMenuBar());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}