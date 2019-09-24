package FinalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.UIDefaults.ProxyLazyValue;


public class Ox extends JFrame implements ActionListener,Serializable{

	JButton[] square;
	Background background ;
	boolean you;
	boolean pet;
	int moneyOX;
	int square_num;
	int count;
	int[] flag;
	boolean gameOver;		
	public Ox(int mon){
		setTitle("Play OOXX with your pet");
		setSize(480,640);
		setLayout(null);
		int re = WindowConstants.DISPOSE_ON_CLOSE;
		setDefaultCloseOperation(re);
		
		square = new JButton[9];
		flag = new int[9];
		square_num = 0;
		count = 0;
		moneyOX= mon;
		for(int i = 0;i < 3;i++){
			for(int j = 0;j<3;j++){
				square[square_num]= new JButton();
				square[square_num].setBounds(160*i, 160*j, 160, 160);
				add(square[square_num]);
				square[square_num].addActionListener(this);
				square_num++;
			}
		}
		play();
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				try {

		            FileInputStream fs = new FileInputStream("d:\\ox.ser");
		            ObjectInputStream is = new ObjectInputStream(fs);
		            background = new Background((String)is.readObject(),(String) is.readObject(),(Boolean[]) is.readObject(),(int) is.readObject(),(boolean) is.readObject());
		            background.time = (String)is.readObject();
		            background.age = (int)is.readObject();
		            background.money = (int)is.readObject();
		            background.healthy= (int)is.readObject();
		            background.intimate = (int)is.readObject();
		            background.full = (int)is.readObject();
		            background.money = moneyOX;
					myThread thread = new myThread(background);
					if(background.age<3&&background.tranExist==false){
						background.jp.remove(background.btn6);
					}
					thread.start();

		            is.close();
		            fs.close();
		            dispose();
		        }
		        catch (Exception ex) {
		            ex.printStackTrace();
		           
		        }
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void play(){
		int prior = (int) (Math.random()*2);
		if(prior == 0){
			you=true;
			
		}else{
			pet=true;
			pet();
		}
	}
	public void you(ActionEvent e){
		for(int i = 0;i<9;i++){
			if(square[i].isEnabled()&& e.getSource()==square[i]){
				square[i].setText("O");
				square[i].setFont(new Font("O", Font.BOLD|Font.ITALIC, 130));
				square[i].setEnabled(false);
				flag[i]=1;
				pet=true;
				you=false;
				count++;

			}
			
		}

		winOrNot();

			pet();


	}
	public void pet(){

		while(pet){
			int petflag = (int) (Math.random()*9);
			if(square[petflag].isEnabled()){
				square[petflag].setText("X");
				square[petflag].setFont(new Font("X", Font.BOLD|Font.ITALIC, 130));
				square[petflag].setEnabled(false);
				flag[petflag]=2;
				pet=false;
				you=true;
				count++;
				winOrNot();

			}else {
				
			}
		}

	}
	public void winOrNot(){
		if((flag[0] == 1 && flag[1] == 1 && flag[2] == 1)||
		   (flag[3] == 1 && flag[4] == 1 && flag[5] == 1)||
		   (flag[6] == 1 && flag[7] == 1 && flag[8] == 1)||
		   (flag[0] == 1 && flag[4] == 1 && flag[8] == 1)||
		   (flag[2] == 1 && flag[4] == 1 && flag[6] == 1)||
		   (flag[0] == 1 && flag[3] == 1 && flag[6] == 1)||
	       (flag[1] == 1 && flag[4] == 1 && flag[7] == 1)||
	       (flag[2] == 1 && flag[5] == 1 && flag[8] == 1)){
			moneyOX = moneyOX+200;
			JOptionPane.showMessageDialog(null, "得到200金幣，現在擁有"+moneyOX, "You win", JOptionPane.PLAIN_MESSAGE );

			System.out.println(moneyOX);
			newGame();
			
		}else if((flag[0] == 2 && flag[1] == 2 && flag[2] == 2)||
				 (flag[3] == 2 && flag[4] == 2 && flag[5] == 2)||
				 (flag[6] == 2 && flag[7] == 2 && flag[8] == 2)||
				 (flag[0] == 2 && flag[3] == 2 && flag[6] == 2)||
				 (flag[1] == 2 && flag[4] == 2 && flag[7] == 2)||
				 (flag[2] == 2 && flag[5] == 2 && flag[8] == 2)||
			     (flag[0] == 2 && flag[4] == 2 && flag[8] == 2)||
			     (flag[2] == 2 && flag[4] == 2 && flag[6] == 2)){
			
			JOptionPane.showMessageDialog(null, "再玩一次嗎?", "You lose", JOptionPane.QUESTION_MESSAGE );
			newGame();
			
		}else if(count==9){
			JOptionPane.showMessageDialog(null, "再玩一次嗎?", "draw", JOptionPane.QUESTION_MESSAGE );
			newGame();
		}else{
			
		}
		

	}
	public void newGame(){
		for(int i = 0;i<9;i++){
			square[i].setText("");
			square[i].setEnabled(true);
			flag[i]=0;
		}
		you=false;
		pet=false;
		square_num=0;
		count=0;
		play();
	} 
	public void actionPerformed(ActionEvent e){

		you(e);

	}
	
	
}
