package bca2012.project3.SimulatorFor8085;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

//Main Frame for loading the Homepage
class Application extends JFrame
{
	//constructor for the class Application
	public Application()
	{ 
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		}
		//calling Homepage Panel class
		Homepage homepage= new Homepage(this);
		//adding window listener
		addWindowListener(homepage);
		add(homepage);
		setSize(1366,768);
		setTitle("HomePage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
	}
	//main method
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				Application a= new Application();
				a.setVisible(true);
			}
		});
	}
}