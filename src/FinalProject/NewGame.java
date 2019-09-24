package FinalProject;

import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class NewGame extends JFrame {
	JButton genderB,nameB,maleB,femaleB,sB,nameCheck,pet1,pet2,pet3,pet4;
	JTextArea genderArea,nameArea;
	String gend;
	String nameS;
	int petFlagNew;
	JPanel jp;
	public NewGame(){
		setBak();
		jp = new JPanel();              //創建個JPanel
		jp.setOpaque(false);            //把JPanel設置為透明 這樣就不會遮住後面的背景 這樣你就能在JPanel隨意加元件了
		jp.setVisible(true);
		jp.setSize(500,800);
		jp.setLayout(null);
		setSize(500,800);
		setTitle("New Game");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(jp);
		//butt
		genderB = new JButton("性別");
		genderB.setBounds(50, 100, 100, 100);
		genderB.setEnabled(false);
		nameB = new JButton("姓名");
		nameB.setBounds(50, 300, 100, 100);
		nameB.setEnabled(false);
		maleB = new JButton("男");
		maleB.setBounds(350, 125, 50, 50);
		femaleB = new JButton("女");
		femaleB.setBounds(400, 125, 50, 50);
		sB = new JButton("START");
		sB.setBounds(150, 600, 200, 100);
		nameCheck = new JButton("SETNAME");
		nameCheck.setBounds(350, 325, 120, 50);
		pet1 = new JButton("楓糖熊");
		pet1.setBounds(100, 500, 75, 75);
		pet2 = new JButton("火柴人");
		pet2.setBounds(200, 500, 75, 75);
		pet3 = new JButton("鼠鼠");
		pet3.setBounds(300, 500, 75, 75);
		pet4 = new JButton("?");
		pet4.setBounds(350, 500, 75, 75);


		jp.add(maleB);
		jp.add(genderB);
		jp.add(nameB);
		jp.add(femaleB);
		jp.add(sB);
		sB.setEnabled(false);

		jp.add(nameCheck);
		jp.add(pet1);
		jp.add(pet2);
		jp.add(pet3);
		//line
		genderArea = new JTextArea("輸入性別");
		genderArea.setBounds(150, 125, 200, 50);
		genderArea.setFont(new Font("輸入性別", Font.BOLD|Font.ITALIC, 30));
		nameArea = new JTextArea("輸入姓名");
		nameArea.setBounds(150, 325, 200, 50);
		nameArea.setFont(new Font("輸入姓名", Font.BOLD|Font.ITALIC, 30));
		jp.add(genderArea);
		jp.add(nameArea);
		//action
        ActionListener genderListen = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if(command.equals("男")){
					
					maleB.setEnabled(false);
					femaleB.setEnabled(true);

					genderArea.setText("男");
					gend="male";
					
				}else if(command.equals("女")){
					maleB.setEnabled(true);
					femaleB.setEnabled(false);

					genderArea.setText("女");
					gend = "female";
				}else{
					nameArea.setText(nameArea.getText());
					nameS = nameArea.getText();
					sB.setEnabled(true);;
				}

			}
		};
        ActionListener startListen = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				Boolean buyS[] = new Boolean[9];

				for(int i=0;i<6;i++)
				{
					buyS[i]=false;
				}
				Background background = new Background(nameS,gend,buyS,petFlagNew,false);
				background.jp.remove(background.btn6);
				myThread thread = new myThread(background);
				thread.start();
				
			}
		};
        ActionListener petListen = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if(e.getSource()== pet1){
					petFlagNew = 1;
					pet1.setEnabled(false);
					pet2.setEnabled(true);
					pet3.setEnabled(true);
					pet4.setEnabled(true);


				}else if(e.getSource()== pet2){
					petFlagNew = 2;
					pet1.setEnabled(true);
					pet2.setEnabled(false);
					pet3.setEnabled(true);
					pet4.setEnabled(true);



				}else if(e.getSource()== pet3){

					petFlagNew = 3;
					pet1.setEnabled(true);
					pet2.setEnabled(true);
					pet3.setEnabled(false);
					pet4.setEnabled(true);

					
				}else if(e.getSource()== pet4){

					petFlagNew = 4;
					pet1.setEnabled(true);
					pet2.setEnabled(true);
					pet3.setEnabled(true);
					pet4.setEnabled(false);

					
				}
			}
		};
		maleB.addActionListener(genderListen);
		femaleB.addActionListener(genderListen);
		sB.addActionListener(startListen);
		nameCheck.addActionListener(genderListen);
		pet1.addActionListener(petListen);
		pet2.addActionListener(petListen);
		pet3.addActionListener(petListen);
		pet4.addActionListener(petListen);

		setVisible(true);
	}
	public void setBak(){
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("newgame.png");
		JLabel background = new JLabel(img);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
}
