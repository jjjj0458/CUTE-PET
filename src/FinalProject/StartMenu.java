package FinalProject;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



public class StartMenu extends JFrame{


    Background background;
	
	JButton startB,loadB;
	
	public StartMenu(){
		//start

		setSize(500,800);
		setTitle("Start Menu");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon icon1 = new ImageIcon("startmenu2.png");
		JLabel kJLabel =new JLabel(icon1);
		kJLabel.setSize(500, 800);
		add(kJLabel);
		startB = new JButton("New Game");
		startB.setBounds(125,225 , 125, 125);

		loadB = new JButton("Load Game");
		loadB.setBounds(250,225 , 125, 125);

		
		add(startB);
		add(loadB);
		//action
		ActionListener startListen = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				NewGame newGame = new NewGame();
				newGame.setVisible(true);
				dispose();
			}
		};
		startB.addActionListener(startListen);
		setVisible(true);

		//new game
		class LoadListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        	System.err.println("load");
	        	try {
		            FileInputStream fs = new FileInputStream("d:\\pet.ser");
		            ObjectInputStream is = new ObjectInputStream(fs);
		            background = new Background((String)is.readObject(),(String) is.readObject(),(Boolean[]) is.readObject(),(int) is.readObject(),(boolean) is.readObject());
		            background.time = (String)is.readObject();
		            background.age = (int)is.readObject();
		            background.money = (int)is.readObject();
		            background.healthy= (int)is.readObject();
		            background.intimate = (int)is.readObject();
		            background.full = (int)is.readObject();
					myThread thread = new myThread(background);
					if(background.age<3&&background.tranExist==false){
						background.jp.remove(background.btn6);
					}
					thread.start();

		            is.close();
		            fs.close();
		            dispose();
		            System.out.println(background.tranExist);
		            System.out.println(background.age);
		            System.out.println(background.tranExist==false&background.age>1);

		        }
		        catch (Exception ex) {
		            ex.printStackTrace();
		           
		        }
				
	        }
	    }
		loadB.addActionListener(new LoadListener());
		
		
		
		
		
		
		
		
		
		
	}

}
