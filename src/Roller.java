

import javax.swing.*;

public class Roller implements Runnable{
	private JLabel _label;
	private int value;
	
	public Roller(JLabel label){
		_label = label;
		_label.setIcon(new ImageIcon(Yahtzee.sides[Yahtzee.rando.nextInt(6)]));
	}
	
	public void run(){
		for (int i = 0; i < 7 + Yahtzee.rando.nextInt(5); i++) {
			int num = Yahtzee.rando.nextInt(6);
			value = num +1;
			_label.setIcon(new ImageIcon(Yahtzee.sides[num]));
			try{
				Thread.sleep(100);
			}
			catch (InterruptedException ex){;}
		}
	}
	
//	public int getValue(){
//		return this.value;
//	}
	
}
