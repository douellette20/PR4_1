import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.net.URL.*;
import java.util.Random;


public class Yahtzee extends JFrame implements ActionListener{
	public static final Image[] sides = new Image[6];
	public static final Random rando = new Random();
	Roller[] rs = new Roller[5];
	//JLabel sum = new JLabel();
	
	public Yahtzee(){
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		try{
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			URL imgUrl = getClass().getResource("/resources/one.png");
			sides[0] = toolkit.getImage(imgUrl).getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			imgUrl = getClass().getResource("/resources/two.png");
			sides[1] = toolkit.getImage(imgUrl).getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			imgUrl = getClass().getResource("/resources/three.png");
			sides[2] = toolkit.getImage(imgUrl).getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			imgUrl = getClass().getResource("/resources/four.png");
			sides[3] = toolkit.getImage(imgUrl).getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			imgUrl = getClass().getResource("/resources/five.png");
			sides[4] = toolkit.getImage(imgUrl).getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			imgUrl = getClass().getResource("/resources/six.png");
			sides[5] = toolkit.getImage(imgUrl).getScaledInstance(100, 100, Image.SCALE_SMOOTH);			
		}
		catch(Exception ex){;}
		
		
		for (int i = 0; i<rs.length; i++){
			JLabel l = new JLabel();
			l.setBorder(BorderFactory.createEtchedBorder());
			rs[i] = new Roller(l);
			this.add(l);
		}
		
		JButton roll = new JButton("Roll!");
		roll.addActionListener(this);
		this.add(roll);
		
		//this.add(sum);
		
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		Yahtzee yahtzee = new Yahtzee();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < rs.length; i++){
			Thread t = new Thread(rs[i]);
			t.start();
			try{
				Thread.sleep(20);
			}
			catch (InterruptedException ex){;}
		}
/*		int val = 0;
		for (int i = 0; i < rs.length; i++)
			val += rs[i].getValue();
		sum.setText("Total: "+ val);
*/		
	}

}
