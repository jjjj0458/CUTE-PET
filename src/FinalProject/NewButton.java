package FinalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class NewButton extends JButton implements ActionListener {
	 int a;
	 public int b;
	public  NewButton(int a){
		
		this.a=a;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//setText(String.valueOf(this.a));
		System.out.println("a");
		
	}
	
	

}

