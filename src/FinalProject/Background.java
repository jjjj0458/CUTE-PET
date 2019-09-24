package FinalProject;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.omg.CORBA.PUBLIC_MEMBER;


public class Background extends JFrame implements ActionListener{
	JPanel jp;
	JButton btnshit,btnani,btnrilakkumaball,btn6;
	JLabel heaLb100,heaLb80,heaLb20,heaLb0,intLb100,intLb80,intLb20,intLb0,fullLb100,fullLb80,fullLb20,fullLb0,die,runaway;
	JPopupMenu menu1,menu2,menu3;
	JMenuItem mf1,mf2,mf3,mf4,mf5;
	JMenuItem mh1,mh2,mh3,mh4,mh5;
	JMenuItem mp1,mp2,mp3;
	String gender,name,time,petImage,petEv,petgif;
	Boolean transfer=false;
	int money,petFlag;
	int age;
	int healthy, intimate, full;
	int food1_p,food2_p,food3_p,food4_p,food5_p;
	int heal1_p,heal2_p,heal3_p,heal4_p,heal5_p;
	int controlnum = 0;
	int ballx = 200;
	int bally = 500;
	boolean tranExist = false;
	boolean loopRun = true;
	boolean shitexist = false;
	boolean shitminus = false;
	boolean rilakkumaballmove = false;

	private JTextArea timelines;
	private JTextArea healthylines;
	private JTextArea intimatelines;
	private JTextArea fulllines;
	private JTextArea conditionlines;
	private JTextArea moneylines;
	private JTextArea agelines;
	int control2=0;
	Font f1 = new Font("Arial Bold",Font.BOLD,25);
	Font f2 = new Font("Arial Bold",Font.BOLD,20);
	Font f3 = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	Boolean buyed[] =new Boolean[9]; 
	Boolean buyedFlag[] =new Boolean[9]; 
	public Background(String nameB,String gendB,Boolean[] buy,int flag,boolean ex) {
		petFlag = flag;
		tranExist = ex;
		if(petFlag ==1){
			petImage = "fatty.png";
			petgif = "trans.gif";
			petEv = "rila.png";
		}else if (petFlag==2) {
			petImage = "rock.png";
			petgif = "rockgif2.gif";
			petEv = "rocket.png";
		}else if (petFlag==3) {
			petImage = "pet1.png";
			petgif ="petgif2.gif";
			petEv = "petty1.png";
		}
		
		for(int i=0;i<6;i++)
		{
			buyed[i]=false;
		}
		for(int i=0;i<6;i++)
		{
			buyedFlag[i]=false;
		}
		setBak();                       //調用背景方法
		Container c = getContentPane(); //獲取JFrame面板
		jp = new JPanel();              //創建個JPanel
		jp.setOpaque(false);            //把JPanel設置為透明 這樣就不會遮住後面的背景 這樣你就能在JPanel隨意加元件了
		jp.setVisible(true);
		jp.setSize(1366,740);
		jp.setLayout(null);
		setSize(1366,740);              //frame size
		add(jp);
		setTitle("My Cute Pet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// condition
		conditionlines = new JTextArea(1,8);
    	conditionlines.setLocation(1111,24);
    	conditionlines.setSize(96,25);       
		jp.add(conditionlines);

		// time
		time = getDateTime();
		timelines = new JTextArea(1,5);
		timelines.setLocation(1242,20);
		timelines.setSize(85,28);       
		jp.add(timelines);
		
		//money
		money = 30000;
		moneylines = new JTextArea(1,8);
		moneylines.setLocation(1242,635);
    	moneylines.setSize(96,25);       
		jp.add(moneylines);
		
		//age
		age = 0;
		agelines = new JTextArea(3,5);
		agelines.setLocation(258,12);
		agelines.setSize(60,33);
        jp.add(agelines);
		  
		healthy = 100;
		intimate = 100;
		full = 100;	
		healthylines = new JTextArea(1,5);
		intimatelines = new JTextArea(1,5);
		fulllines =	 new JTextArea(1,5);
		healthylines.setLocation(530,45);
		intimatelines.setLocation(770,45);
		fulllines.setLocation(1010,45);
		healthylines.setSize(60,30); 
		intimatelines.setSize(60,30); 
		fulllines.setSize(60,30); 
		jp.add(healthylines);
		jp.add(intimatelines);
		jp.add(fulllines);

		
		//gender + name
		gender=gendB;
		name = nameB;
		icon();
		//tran
		ImageIcon mega = new ImageIcon("evo.png");
		btn6 = new JButton("EVO",mega);
		btn6.addActionListener(this);
        btn6.setContentAreaFilled(false);
        btn6.setBorderPainted(false);
		btn6.setLocation(0, 80);
		btn6.setSize(180, 110);
		btn6.setVerticalAlignment(SwingConstants.BOTTOM);
		if(tranExist==false){


				jp.add(btn6);

			
			
		}

		
		//ID Card icon
		ImageIcon icon1 = new ImageIcon("save.png");
		JButton save = new JButton(icon1);
		save.setText("save");
		save.addActionListener(this);
		save.setLocation(1175, 75);
		save.setSize(175, 100);
		setLayout(null);
		jp.add(save);
		//save load			
		ActionListener saveListener = new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						loopRun=false;
						int result = JOptionPane.showConfirmDialog(null, "存檔嗎?", "Save Game ?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if (result==JOptionPane.NO_OPTION) {
							loopRun=true;
							myThread thread = new myThread(Background.this);
							thread.start();
						}else if (result==JOptionPane.YES_OPTION){
							try {
					            FileOutputStream fs = new FileOutputStream("d:\\pet.ser");
					            ObjectOutputStream os = new ObjectOutputStream(fs);
					            os.writeObject(name);
					            os.writeObject(gender);
					            os.writeObject(buyedFlag);
					            os.writeObject(petFlag);
					            os.writeObject(tranExist);

					            os.writeObject(time);
					            os.writeObject(age);
					            os.writeObject(money);
					            os.writeObject(healthy);
					            os.writeObject(intimate);
					            os.writeObject(full);
					            os.close();
					            fs.close();
					            System.out.println(tranExist);
					           
					        }
					        catch (Exception ex) {
					            ex.printStackTrace();
					        }
							loopRun = true;
							myThread thread = new myThread(Background.this);
							thread.start();
						}
						System.out.println(this.toString());
						
					}
				};
				save.addActionListener(saveListener);	
		//Feed icon
		ImageIcon icon2 = new ImageIcon("feed.png");
		JButton btn2 = new JButton(icon2);
		btn2.setText("Feed");
		ActionListener mblistener2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pop2(e);
			}
		};
		btn2.addActionListener(mblistener2);
		btn2.setLocation(1175, 175);
		btn2.setSize(175, 100);
		setLayout(null);
		jp.add(btn2);
		
		//feed menu
		food1_p=100; food2_p=200; food3_p=300; food4_p=400;	food5_p=500;
		menu2 = new JPopupMenu();
		menu2.setLayout(new BoxLayout(menu2, BoxLayout.LINE_AXIS));
		Color m2_c = new Color(186,216,215);
		ImageIcon food1 = new ImageIcon("food1.png");
		ImageIcon food2 = new ImageIcon("food2.png");
		ImageIcon food3 = new ImageIcon("food3.png");
		ImageIcon food4 = new ImageIcon("food4.png");
		ImageIcon food5 = new ImageIcon("food5.png");
		mf1 = new JMenuItem("$"+String.valueOf(food1_p),food1);
		mf1.setBackground(m2_c);
		mf2 = new JMenuItem("$"+String.valueOf(food2_p),food2);
		mf2.setBackground(m2_c);
		mf3 = new JMenuItem("$"+String.valueOf(food3_p),food3);
		mf3.setBackground(m2_c);
		mf4 = new JMenuItem("$"+String.valueOf(food4_p),food4);
		mf4.setBackground(m2_c);
		mf5 = new JMenuItem("$"+String.valueOf(food5_p),food5);
		mf5.setBackground(m2_c);
		mf1.addActionListener(this);
		mf2.addActionListener(this);
		mf3.addActionListener(this);
		mf4.addActionListener(this);
		mf5.addActionListener(this);
		menu2.add(mf1);
		menu2.add(mf2);
		menu2.add(mf3);
		menu2.add(mf4);
		menu2.add(mf5);
		
		//Play icon
		ImageIcon icon3 = new ImageIcon("play.png");
		JButton btn3 = new JButton(icon3);
		btn3.setText("Play");
		ActionListener mblistener1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pop(e);
			}
		};
		btn3.addActionListener(mblistener1);
		btn3.setLocation(1175, 275);
		btn3.setSize(175, 100);
		setLayout(null);
		jp.add(btn3);				
		
		//play menu 
		menu1 = new JPopupMenu();
		menu1.setLayout(new BoxLayout(menu1, BoxLayout.LINE_AXIS));
		Color m1_c = new Color(255, 255, 168);
		ImageIcon icon6 = new ImageIcon("ooxx.png");
		ImageIcon icon7 = new ImageIcon("FlipCard.png");
		ImageIcon icon8 = new ImageIcon("PaperScissor.png");
		mp1 = new JMenuItem(icon6);
		mp1.setBackground(m1_c);
		mp2 = new JMenuItem(icon7);
		mp2.setBackground(m1_c);
		mp3 = new JMenuItem(icon8);
		mp3.setBackground(m1_c);
		mp1.addActionListener(this);
		mp2.addActionListener(this);
		mp3.addActionListener(this);
		menu1.add(mp1);
		menu1.add(mp2);
		menu1.add(mp3);
		
		//Heal icon
		ImageIcon icon4 = new ImageIcon("heal.png");
		JButton btn4 = new JButton(icon4);
		btn4.setText("Heal");
		ActionListener mblistener3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pop3(e);
			}
		};
		btn4.addActionListener(mblistener3);
		btn4.setLocation(1175, 375);
		btn4.setSize(175, 100);
		setLayout(null);
		jp.add(btn4);
		
		//heal menu
		heal1_p=100; heal2_p=200; heal3_p=300; heal4_p=400;	heal5_p=500;
		menu3 = new JPopupMenu();
		menu3.setLayout(new BoxLayout(menu3, BoxLayout.LINE_AXIS));
		Color m3_c = new Color(189,242,220);
		ImageIcon heal1 = new ImageIcon("heal1.png");
		ImageIcon heal2 = new ImageIcon("heal2.png");
		ImageIcon heal3 = new ImageIcon("heal3.png");
		ImageIcon heal4 = new ImageIcon("heal4.png");
		ImageIcon heal5 = new ImageIcon("heal5.png");
		mh1 = new JMenuItem("$"+String.valueOf(heal1_p),heal1);
		mh1.setBackground(m3_c);
		mh2 = new JMenuItem("$"+String.valueOf(heal2_p),heal2);
		mh2.setBackground(m3_c);
		mh3 = new JMenuItem("$"+String.valueOf(heal3_p),heal3);
		mh3.setBackground(m3_c);
		mh4 = new JMenuItem("$"+String.valueOf(heal4_p),heal4);
		mh4.setBackground(m3_c);
		mh5 = new JMenuItem("$"+String.valueOf(heal5_p),heal5);
		mh5.setBackground(m3_c);
		mh1.addActionListener(this);
		mh2.addActionListener(this);
		mh3.addActionListener(this);
		mh4.addActionListener(this);
		mh5.addActionListener(this);
		menu3.add(mh1);
		menu3.add(mh2);
		menu3.add(mh3);
		menu3.add(mh4);
		menu3.add(mh5);
		
		//Shop icon
		ImageIcon icon5 = new ImageIcon("shop.png");
		JButton btn5 = new JButton(icon5);
		btn5.setText("Shop");
		btn5.addActionListener(this);
		btn5.setLocation(1175, 475);
		btn5.setSize(175, 100);
		setLayout(null);
		jp.add(btn5);
								
		//animal icon 
		if (tranExist ==true) {
			ImageIcon animal = new ImageIcon(petEv);
		    btnani = new JButton(animal);
	        btnani.setSize(200, 200);
	        btnani.setContentAreaFilled(false);
	        btnani.addActionListener(this);
	        btnani.setBorderPainted(false);
	        jp.add(btnani);
		}else {
			ImageIcon animal = new ImageIcon(petImage);
		    btnani = new JButton(animal);
	        btnani.setSize(200, 200);
	        btnani.setContentAreaFilled(false);
	        btnani.addActionListener(this);
	        btnani.setBorderPainted(false);
	        jp.add(btnani);
		}
		
		
        //shit icon
		ImageIcon shit = new ImageIcon("shit.png");
		btnshit = new JButton(shit);
		btnshit.addActionListener(this);
		btnshit.setSize(60, 60);  
        btnshit.setContentAreaFilled(false);
        btnshit.setBorderPainted(false);
        setLayout(null);
		setVisible(true);
		
		//rilakkumaball
		ImageIcon rilakkumaball = new ImageIcon("rilakkumaball.png");
		btnrilakkumaball = new JButton(rilakkumaball);
		btnrilakkumaball.addActionListener(this);
		btnrilakkumaball.setSize(69, 70); 
		btnrilakkumaball.setContentAreaFilled(false);
		btnrilakkumaball.setBorderPainted(false);
        setLayout(null);
        setVisible(true);
		
		// bottle picture
		heaLb100 = new JLabel(new ImageIcon("healthy100.png"));
	    heaLb80 = new JLabel(new ImageIcon("healthy80.png"));							
		heaLb20 = new JLabel(new ImageIcon("healthy20.png"));
		heaLb0 = new JLabel(new ImageIcon("empty.png"));
		heaLb100.setLocation(480, 5);
		heaLb100.setSize(150,100);
		heaLb80.setLocation(480, 5);
		heaLb80.setSize(150,100);
		heaLb20.setLocation(480, 5);
		heaLb20.setSize(150,100);
		heaLb0.setLocation(480, 5);
		heaLb0.setSize(150,100);
		intLb100 = new JLabel(new ImageIcon("intimate100.png"));
		intLb80 = new JLabel(new ImageIcon("intimate80.png"));
		intLb20 = new JLabel(new ImageIcon("intimate20.png"));
		intLb0 = new JLabel(new ImageIcon("empty.png"));
		intLb100.setLocation(720, 5);
		intLb100.setSize(150,100);
		intLb80.setLocation(720, 5);
		intLb80.setSize(150,100);
		intLb20.setLocation(720, 5);
		intLb20.setSize(150,100);
		intLb0.setLocation(720, 5);
		intLb0.setSize(150,100);	
		fullLb100 = new JLabel(new ImageIcon("full100.png"));
		fullLb80 = new JLabel(new ImageIcon("full80.png"));
		fullLb20 = new JLabel(new ImageIcon("full20.png"));
		fullLb0 = new JLabel(new ImageIcon("empty.png"));
		fullLb100.setLocation(960, 5);
		fullLb100.setSize(150,100);
		fullLb80.setLocation(960, 5);
		fullLb80.setSize(150,100);
		fullLb20.setLocation(960, 5);
		fullLb20.setSize(150,100);
		fullLb0.setLocation(960, 5);
		fullLb0.setSize(150,100);
		
		// pet die or run away
		die = new JLabel(new ImageIcon("die.png"));
	   	die.setLocation(540, 350);
		die.setSize(200,400);
		runaway = new JLabel(new ImageIcon("runaway.png"));
		runaway.setLocation(650, 430);
		runaway.setSize(300,400);
		//save desk

		//buyflag
		if(buy[0]==true){
			
			//ImageIcon icon12 = 
			  JLabel clock = new JLabel(new ImageIcon("clock.png"));
			
			//fan.setText("ID Card");
			
			clock.setLocation(800, 100);
			clock.setSize(250, 250);
			//setLayout(null);
			jp.add(clock);
			buyedFlag[0]=true;
			}

if(buy[1]==true){

//ImageIcon icon12 = 
	JLabel hang = new JLabel(new ImageIcon("hang.png"));

//fan.setText("ID Card");

hang.setLocation(600, 80);
hang.setSize(145, 231);
//setLayout(null);
jp.add(hang);
buyedFlag[1]=true;

}


		
		
		
		
		
		if(buy[3]==true){
			
			//ImageIcon icon12 = 
			 JLabel tree = new JLabel(new ImageIcon("homeitem4.png"));
			
			//fan.setText("ID Card");
			
			tree.setLocation(350, 450);
			tree.setSize(145, 231);
			//setLayout(null);
			jp.add(tree);
			buyedFlag[3]=true;

			}
		
		
		
if(buy[5]==true){
			
			//ImageIcon icon12 = 
JLabel table = new JLabel(new ImageIcon("homeitem6.png"));
			
			//fan.setText("ID Card");
			
			table.setLocation(650, 470);
			table.setSize(250, 231);
			//setLayout(null);
			jp.add(table);
			buyedFlag[5]=true;

			}

if(buy[4]==true){

//ImageIcon icon12 = 
	JLabel  desk = new JLabel(new ImageIcon("homeitem5.png"));

//fan.setText("ID Card");

desk.setLocation(500, 450);
desk.setSize(145, 231);
//setLayout(null);
jp.add(desk);
buyedFlag[4]=true;

}
		
		
		
		if(buy[2]==true){
		
		//ImageIcon icon12 = 
			JLabel  fan = new JLabel(new ImageIcon("homeitem3.png"));
		
		//fan.setText("ID Card");
		
		fan.setLocation(1000, 400);
		fan.setSize(145, 231);
		//setLayout(null);
		jp.add(fan);
		buyedFlag[2]=true;

		}
		
	

		
		
		
		
		setLayout(null);
		setVisible(true);	
		
	}
	//backgrounddown
	
	public void move(){
		
		//time & condition & location
		int i =0,j=500;
		int ageCount=0;
			
		while(loopRun==true){
			int xx = (int)(Math.random()*5+1);
			int reduce = (int)(Math.random()*5+1);
			if(xx==3){
		    	healthy -=reduce;		    	
		    }
		    if(xx==4){		    	
		    	full -=reduce;		    	
		    }
		    if(xx==2){		    	
		    	intimate -=reduce;
		    }
		    //System.out.println("full:"+full+"healthy:"+healthy+"intimate:"+intimate);
			String time = getDateTime();
			
			//rilakkumaball location
			jp.add(btnrilakkumaball);
			btnrilakkumaball.setLocation(200, 500);
			
			int ballset = (int)(Math.random()*4+1);
			
			int rilakkumadiffx = Math.abs(ballx-i);
			int rilakkumadiffy = Math.abs(bally-j);

			//System.out.println(rilakkumadiffx);
			if(rilakkumadiffx<75&rilakkumadiffy<75){
				if(ballx>500){
					ballx -=75;
				}
				if(bally >300){
					bally -=75;
				}
				ballx +=75;
				bally +=75;
			}
			if(ballx<0){ballx=0;}
			if(bally>600){bally=600;}
			if(ballx>1000){ballx=1000;}
			if(bally<500){bally=500;}
			btnrilakkumaball.setLocation(ballx, bally);
			if(rilakkumaballmove==true){
			for(int q = 0;q<10;q++){
				if(ballset==1){
					ballx  -=5;		    	
			    }
			    if(ballset==2){		    	
			    	ballx  +=5;		    	
			    }
			    if(ballset==3){		    	
			    	bally -=5;
			    }
			    if(ballset==4){		    	
			    	bally +=5;
			    }
			    
				btnrilakkumaball.setLocation(ballx, bally);

			}
			rilakkumaballmove = false;
			}
		
			//shit location			
			if(time.substring(6,7).equals("5")&controlnum ==0){
				controlnum +=1;
	            int shitx = (int)(Math.random()*200+500);
				jp.add(btnshit);			
		        btnshit.setLocation(shitx, 600);
			}
			if(time.substring(6,7).equals("0")){
				controlnum =0;            
			}
			if(shitexist==true){				
	            jp.remove(btnshit);
			}
			
			if(shitminus == true&time.substring(7,8).equals("0")){		    	
		    	healthy -=1;
		    }
			shitminus = true;
			
			// 1.set bottle picture first
			// healthy icon
			if(healthy>=80){
				jp.remove(heaLb80);
				jp.add(heaLb100);
			}else if(healthy>50){
				jp.remove(heaLb100);
				jp.remove(heaLb20);
				jp.add(heaLb80);
			}else if(healthy>20){
				jp.remove(heaLb80);
				jp.remove(heaLb0);
				jp.add(heaLb20);
			}else{
				jp.remove(heaLb20);		
				jp.add(heaLb0);
		
				if(healthy<=0){    // die & game over
					healthylines.setText(0+"%");
					jp.remove(btnani);
					jp.add(die);
					setBak();
					loopRun=false;
					int result = JOptionPane.showConfirmDialog(null, "Oh...你的寵物生病死掉了,要重玩嗎?", "Game over!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (result==JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null,"Bye bye ~","離開", JOptionPane.QUESTION_MESSAGE);
						System.exit(0);
					}else if (result==JOptionPane.YES_OPTION){
						dispose();
						StartMenu playAgain = new StartMenu();	
					}
				}
			}
			// intimate icon
			if(intimate>=80){
				jp.remove(intLb80);
				jp.add(intLb100);
			}else if(intimate>50){
				jp.remove(intLb100);
				jp.remove(intLb20);
				jp.add(intLb80);
			}else if(intimate>20){
				jp.remove(intLb80);
				jp.remove(intLb0);
				jp.add(intLb20);
			}else{
				jp.remove(intLb20);		
				jp.add(intLb0);

				if(intimate<=0){   // run away & game over
					intimatelines.setText(0+"%");
					jp.remove(btnani);
					jp.add(runaway);
					setBak();
					loopRun=false;
					int result = JOptionPane.showConfirmDialog(null, "Oh...你的寵物離家出走了,要重玩嗎?", "Game over!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (result==JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null,"Bye bye ~","離開", JOptionPane.QUESTION_MESSAGE);
						System.exit(0);
					}else if (result==JOptionPane.YES_OPTION){
						dispose();
						StartMenu playAgain = new StartMenu();						
					}
				}
			}
			// full icon
			if(full>=80){
				jp.remove(fullLb80);
				jp.add(fullLb100);
			}else if(full>50){
				jp.remove(fullLb20);
				jp.remove(fullLb100);
				jp.add(fullLb80);
			}else if(full>20){
				jp.remove(fullLb0);
				jp.remove(fullLb80);
				jp.add(fullLb20);
			}else{
				jp.remove(fullLb20);		
				jp.add(fullLb0);

				if(full<=0){       // die & game over
					fulllines.setText(0+"%");
					jp.remove(btnani);
					jp.add(die);
					setBak();
					loopRun=false;
					int result = JOptionPane.showConfirmDialog(null, "Oh...你的寵物餓死了,要重玩嗎?", "Game over!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (result==JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null,"Bye bye ~","離開", JOptionPane.QUESTION_MESSAGE);
						System.exit(0);
					}else if (result==JOptionPane.YES_OPTION){
						dispose();
						StartMenu playAgain = new StartMenu();	
					}
				}
			}

			// 2.show values on the bottle 
			
			healthylines.setText(healthy+"%");
			healthylines.setFont(f1);
			healthylines.setOpaque(false);	
			intimatelines.setText(intimate+"%");
			intimatelines.setFont(f1);
			intimatelines.setOpaque(false);	
			fulllines.setText(full+"%");
			fulllines.setFont(f1);
			fulllines.setOpaque(false);	
			
			// show initial values of the other text area
			conditionlines.setText("正常");
			conditionlines.setOpaque(false);	
			timelines.setText(time);
			timelines.setFont(f2);
			timelines.setOpaque(false);	
			agelines.setText(String.valueOf(age));
			agelines.setFont(f3);
		    agelines.setOpaque(false);
			moneylines.setText(String.valueOf(money));
			moneylines.setFont(f1);
			moneylines.setOpaque(false);
			
			//grow up (age)
			ageCount+=1;
			if(ageCount%10==0){
				age+=1;
			}
			agelines.setText(String.valueOf(age));
			
			//condition
			if(healthy<50){
				conditionlines.setText("生病了");
			}
			if(full<50){
				conditionlines.setText("餓了");
			}
			if(intimate<50){
				conditionlines.setText("孤單寂寞覺得冷");
			}
			if(intimate<50&full<50){
				conditionlines.setText("又餓又冷QQ");
			}
			if(intimate<50&healthy<50){
				conditionlines.setText("帶我看醫生");
			}
			if(full<50&healthy<50){
				conditionlines.setText("餓到快死了");
			}
			if(intimate<50&full<50&healthy<50){
				conditionlines.setText("主人不要我了嗎");
			}			
			
			// pet location
			int x =(int)(Math.random()*6+1);
			if(x==1|x==5){
				i+=50;
			}
			if(x==2){
				i-=50;
			}
			if(x==3){
				j+=50;
			}
			if(x==4){
				j-=50;
			}
			if(i<0){i=0;}
			if(j>550){j=550;}
			if(i>1000){i=1000;}
			if(j<450){j=450;}
			btnani.setLocation(i,j);
			
			//shop
		//	JLabel desk  = new JLabel(new ImageIcon("homeitem2.png"));
			
			if(age==3)
			{
                control2 +=1;
                if(control2 ==1){
				jp.add(btn6);
                }
			}

			
			
			if(transfer==true)
			{
				
				 ImageIcon animal = new ImageIcon(petgif);
				    btnani.setIcon(animal);
					jp.remove(btn6);

			            repaint();
			            try {
			                Thread.sleep(4000);
			            } catch (InterruptedException e) {
			                // TODO Auto-generated catch block
			                e.printStackTrace();
			            }
			            ImageIcon aaa = new ImageIcon(petEv);
			            btnani.setIcon(aaa);

			            transfer=false;
			            
			            
			}


			
			
			
			
			
if(buyed[0]==true){
				
				//ImageIcon icon12 = 
				  JLabel clock = new JLabel(new ImageIcon("clock.png"));
				
				//fan.setText("ID Card");
				
				clock.setLocation(800, 100);
				clock.setSize(250, 250);
				//setLayout(null);
				jp.add(clock);
				buyed[0]=false;
				buyedFlag[0]=true;
				}

if(buyed[1]==true){
	
	//ImageIcon icon12 = 
	  JLabel hang = new JLabel(new ImageIcon("hang.png"));
	
	//fan.setText("ID Card");
	
	hang.setLocation(600, 80);
	hang.setSize(145, 231);
	//setLayout(null);
	jp.add(hang);
	buyed[1]=false;
	buyedFlag[1]=true;

	}

	
			
			
			
			
			
			if(buyed[3]==true){
				
				//ImageIcon icon12 = 
				 JLabel tree = new JLabel(new ImageIcon("homeitem4.png"));
				
				//fan.setText("ID Card");
				
				tree.setLocation(350, 450);
				tree.setSize(145, 231);
				//setLayout(null);
				jp.add(tree);
				buyed[3]=false;
				buyedFlag[3]=true;

				}
			
			
			
if(buyed[5]==true){
				
				//ImageIcon icon12 = 
	JLabel table = new JLabel(new ImageIcon("homeitem6.png"));
				
				//fan.setText("ID Card");
				
				table.setLocation(650, 470);
				table.setSize(250, 231);
				//setLayout(null);
				jp.add(table);
				buyed[5]=false;
				buyedFlag[5]=true;

				}

if(buyed[4]==true){
	
	//ImageIcon icon12 = 
		JLabel  desk = new JLabel(new ImageIcon("homeitem5.png"));
	
	//fan.setText("ID Card");
	
	desk.setLocation(500, 450);
	desk.setSize(145, 231);
	//setLayout(null);
	jp.add(desk);
	buyed[4]=false;
	buyedFlag[4]=true;

	}
			
			
			
			if(buyed[2]==true){
			
			//ImageIcon icon12 = 
				JLabel  fan = new JLabel(new ImageIcon("homeitem3.png"));
			
			//fan.setText("ID Card");
			
			fan.setLocation(1000, 400);
			fan.setSize(145, 231);
			//setLayout(null);
			jp.add(fan);
			buyed[2]=false;
			buyedFlag[2]=true;

			}

			
			try {	
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}
	

	
	public void setBak(){
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("living_room.png");
		JLabel background = new JLabel(img);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
	
	// play
	public void pop(ActionEvent e){
		Component click = (Component) e.getSource();
		Point location = click.getLocationOnScreen();
		menu1.show(this, 175, 100);
		menu1.setLocation(location.x-click.getWidth()*2-20,location.y);
	}
	// feed
	public void pop2(ActionEvent e){
		Component click = (Component) e.getSource();
		Point location = click.getLocationOnScreen();
		menu2.show(this, 175, 100);
		menu2.setLocation(location.x-click.getWidth()*4-76,location.y);
	}
	// heal
	public void pop3(ActionEvent e){
		Component click = (Component) e.getSource();
		Point location = click.getLocationOnScreen();
		menu3.show(this, 175, 100);
		menu3.setLocation(location.x-click.getWidth()*4-76,location.y);
	}
	
	
	public void actionPerformed(ActionEvent e){		
		//play
		if(e.getSource()==mp1){
			loopRun = false;
			Ox ox = new Ox(money);
			ox.setVisible(true);
			try {
	            FileOutputStream fs = new FileOutputStream("d:\\ox.ser");
	            ObjectOutputStream os = new ObjectOutputStream(fs);
	            os.writeObject(name);
	            os.writeObject(gender);
	            os.writeObject(buyedFlag);
	            os.writeObject(petFlag);
	            os.writeObject(tranExist);


	            
	            os.writeObject(time);
	            os.writeObject(age);
	            os.writeObject(money);
	            os.writeObject(healthy);
	            os.writeObject(intimate);
	            os.writeObject(full);

	            os.close();
	            fs.close();
	           
	        }
	        catch (Exception ex) {
	            ex.printStackTrace();

	        }
			dispose();
		}else if(e.getSource()==mp2){
			loopRun = false;
			MyNewFrame myNewFrame = new MyNewFrame(money);
			myNewFrame.setVisible(true);
			try {
	            FileOutputStream fs = new FileOutputStream("d:\\card.ser");
	            ObjectOutputStream os = new ObjectOutputStream(fs);
	            os.writeObject(name);
	            os.writeObject(gender);
	            os.writeObject(buyedFlag);
	            os.writeObject(petFlag);
	            os.writeObject(tranExist);



	            os.writeObject(time);
	            os.writeObject(age);
	            os.writeObject(money);
	            os.writeObject(healthy);
	            os.writeObject(intimate);
	            os.writeObject(full);

	            os.close();
	            fs.close();
	           
	        }
	        catch (Exception ex) {
	            ex.printStackTrace();

	        }
			dispose();

		}else if(e.getSource()==mp3){
			loopRun = false;
			Paper2 paper2 = new Paper2(money);
			paper2.setVisible(true);
			try {
	            FileOutputStream fs = new FileOutputStream("d:\\paper.ser");
	            ObjectOutputStream os = new ObjectOutputStream(fs);
	            os.writeObject(name);
	            os.writeObject(gender);
	            os.writeObject(buyedFlag);
	            os.writeObject(petFlag);
	            os.writeObject(tranExist);


	            
	            os.writeObject(time);
	            os.writeObject(age);
	            os.writeObject(money);
	            os.writeObject(healthy);
	            os.writeObject(intimate);
	            os.writeObject(full);

	            os.close();
	            fs.close();
	           
	        }
	        catch (Exception ex) {
	            ex.printStackTrace();

	        }
			dispose();
		}
		
		//feed
		if(e.getSource()==mf1){
			if(money-food1_p<0){
				JOptionPane.showMessageDialog(this,"錢不夠喔~",
	            "快去玩遊戲吧!", JOptionPane.ERROR_MESSAGE);
			}else {
				money=money-food1_p;
				full=full+10;
			}
			
			
		}else if(e.getSource()==mf2){
			if(money-food2_p<0){
				JOptionPane.showMessageDialog(this,"錢不夠喔~",
	            "快去玩遊戲吧!", JOptionPane.ERROR_MESSAGE);
			}else {
			   money=money-food2_p;
			   full=full+15;
			}
			
		}else if(e.getSource()==mf3){
			if(money-food3_p<0){
				JOptionPane.showMessageDialog(this,"錢不夠喔~",
	            "快去玩遊戲吧!", JOptionPane.ERROR_MESSAGE);
			}else {
				money=money-food3_p;
				full=full+20;
			}
			
		}else if(e.getSource()==mf4){
			if(money-food4_p<0){
				JOptionPane.showMessageDialog(this,"錢不夠喔~",
	            "快去玩遊戲吧!", JOptionPane.ERROR_MESSAGE);
			}else {
				money=money-food4_p;
				full=full+25;
			}
			
		}else if(e.getSource()==mf5){
			if(money-food5_p<0){
				JOptionPane.showMessageDialog(this,"錢不夠喔~",
	            "快去玩遊戲吧!", JOptionPane.ERROR_MESSAGE);
			}else {
				money=money-food5_p;
				full=full+30;
			}

		}
		if(full>100){
			full=100;
		}
		
		//heal
		if(e.getSource()==mh1){
			if (money-heal1_p<0) {
				JOptionPane.showMessageDialog(this,"錢不夠喔~",
	            "快去玩遊戲吧!", JOptionPane.ERROR_MESSAGE);
			}else {
				money=money-heal1_p;
				healthy=healthy+10;
			}

		}else if(e.getSource()==mh2){
			if (money-heal2_p<0) {
				JOptionPane.showMessageDialog(this,"錢不夠喔~",
	            "快去玩遊戲吧!", JOptionPane.ERROR_MESSAGE);
			}else {
				money=money-heal2_p;
				healthy=healthy+15;
			}

		}else if(e.getSource()==mh3){
			if (money-heal3_p<0) {
				JOptionPane.showMessageDialog(this,"錢不夠喔~",
	            "快去玩遊戲吧!", JOptionPane.ERROR_MESSAGE);
			}else {
				money=money-heal3_p;
				healthy=healthy+20;
			}

		}else if(e.getSource()==mh4){
			if (money-heal4_p<0) {
				JOptionPane.showMessageDialog(this,"錢不夠喔~",
	            "快去玩遊戲吧!", JOptionPane.ERROR_MESSAGE);
			}else {
				money=money-heal4_p;
				healthy=healthy+25;
			}

		}else if(e.getSource()==mh5){
			if (money-heal5_p<0) {
				JOptionPane.showMessageDialog(this,"錢不夠喔~",
	            "快去玩遊戲吧!", JOptionPane.ERROR_MESSAGE);
			}else {
				money=money-heal5_p;
				healthy=healthy+30;
			}

		}else if (e.getSource()==btnani){
			System.out.println("You pressed btnani");
			intimate +=5;			
		}else if (e.getSource()==btnrilakkumaball){
			System.out.println("You pressed rilakkumaball");
			rilakkumaballmove=true;
		}else if (e.getSource()==btnshit){
			System.out.println("You pressed Shit");
			shitexist = true;
		}
		if(intimate>=100){
			intimate=100;
		}
		if(healthy>100){
			healthy=100;
		}
		
		
		String command = e.getActionCommand();
	 if(command.equals("Shop")){
			ShopFrame frame=new ShopFrame(this);
			frame.setVisible(true);
			
			System.out.println("You pressed Shop");		}
	 
	 
	 
	 if(e.getSource()==btn6){
		 transfer=true;
		 tranExist=true;

		 ;
		    
			
				}
	 
	 
	}
	
	//time
	public String getDateTime(){
		SimpleDateFormat sdFormat = new SimpleDateFormat("hh:mm:ss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		//System.out.println(strDate);
		return strDate;
		
		}

	public void icon(){
		try {
			//gender			
			if(gender.equals("male")){
				ImageIcon iconSex = new ImageIcon("male.png");
				JLabel lb2 = new JLabel(iconSex);
				lb2.setLocation(5, 5);
				lb2.setSize(50, 50);
				jp.add(lb2);
			}else if(gender.equals("female")){
				ImageIcon iconSex = new ImageIcon("female.png");
				JLabel lb2 = new JLabel(iconSex);
				lb2.setLocation(5, 5);
				lb2.setSize(50, 50);
				jp.add(lb2);
			}
			
			//name
			JLabel lb =new JLabel(name);
			Font font2 = new Font(Font.SANS_SERIF, Font.BOLD, 30);
			lb.setFont(font2);
			lb.setLocation(70, 5);
			lb.setSize(150, 50);
			jp.add(lb);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}