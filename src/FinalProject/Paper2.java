package FinalProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Paper2 extends JFrame implements ActionListener,Serializable{
	private JTextArea resultlines;
	private JTextArea gamelines;
	Background background;
	JButton scissor,paper,stone;
	int moneyPaper;
	int a = 0 ;
	int player = 0,comp = 0,freq=0,due=0;//勝利數

	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.BLUE);
		Font f = new Font("Arial Bold",Font.BOLD|Font.ITALIC,30);
		g.setFont(f);
		g.drawString("welcome to paper scissor stone !!", 100, 100);
		}
	public void Paper(){
		
		}

	public Paper2(int mon){
		setSize(800, 600);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLayout(null);
		moneyPaper = mon;
		ImageIcon pap = new ImageIcon("rilapaper.png");
		paper = new JButton(pap);
		paper.setLocation(100,400);
		paper.setSize(paper.getPreferredSize());
		paper.addActionListener(this);
		
		add(paper);
		ImageIcon sis = new ImageIcon("rilasis.png");

		scissor = new JButton(sis);
		scissor.setLocation(300,400);
		scissor.setSize(scissor.getPreferredSize());
		scissor.addActionListener(this);
		add(scissor);
		ImageIcon st = new ImageIcon("stone.png");

		stone = new JButton(st);
		stone.setLocation(410,400);
		stone.setSize(stone.getPreferredSize());
		stone.addActionListener(this);
		add(stone);
		
		JButton re = new JButton("reset");
		re.setLocation(320,350);
		re.setSize(re.getPreferredSize());
		re.addActionListener(this);
		add(re);
		/*inputlines = new JTextArea(1,800);
		inputlines.setLocation(100,200);
		inputlines.setSize(inputlines.getPreferredSize());
		inputlines.setText("result");
		add(inputlines);*/
		resultlines = new JTextArea(1,800);
		resultlines.setLocation(100,200);
		resultlines.setSize(resultlines.getPreferredSize());
		resultlines.setText("寵物獲勝:"+player+"電腦獲勝:"+comp+"平手:"+due+"總共玩了"+freq+"場"+"目前金幣"+moneyPaper);
		add(resultlines);		
		gamelines = new JTextArea(1,800);
	    gamelines.setLocation(100,300);
	    gamelines.setSize(gamelines.getPreferredSize());
	    add(gamelines);
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

		            FileInputStream fs = new FileInputStream("d:\\paper.ser");
		            ObjectInputStream is = new ObjectInputStream(fs);
		            background = new Background((String)is.readObject(),(String) is.readObject(),(Boolean[]) is.readObject(),(int) is.readObject(),(boolean) is.readObject());
		            background.time = (String)is.readObject();
		            background.age = (int)is.readObject();
		            background.money = (int)is.readObject();
		            background.healthy= (int)is.readObject();
		            background.intimate = (int)is.readObject();
		            background.full = (int)is.readObject();
		            background.money = moneyPaper;
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
	    
		public void actionPerformed(ActionEvent e){
			
			
			
			String command = e.getActionCommand();
			if(e.getSource()==paper){
				 a= 1 ;
				 //inputlines.setText(Integer.toString(a));
				//resultlines.setText("寵物獲勝:"+player+"電腦獲勝:"+comp+"平手:"+due+"總共玩了"+freq+"場");


			}else if(e.getSource()==scissor){
				 a=2 ;
				 //inputlines.setText(Integer.toString(a));
			     //resultlines.setText("寵物獲勝:"+player+"電腦獲勝:"+comp+"平手:"+due+"總共玩了"+freq+"場");

			}else if(e.getSource()==stone){
				 a=3 ;
				 //inputlines.setText(Integer.toString(a));
			     //resultlines.setText("寵物獲勝:"+player+"電腦獲勝:"+comp+"平手:"+due+"總共玩了"+freq+"場");

			}else if(command.equals("reset")){
			//inputlines.setText(null);
				a=4;
				player=0;comp=0;due=0;freq=0;
				//resultlines.setText("寵物獲勝:"+player+"電腦獲勝:"+comp+"平手:"+due+"總共玩了"+freq+"場");
				resultlines.setText("寵物獲勝:"+player+"電腦獲勝:"+comp+"平手:"+due+"總共玩了"+freq+"場"+"目前金幣"+moneyPaper);
				gamelines.setText("");

			}
				int x =(int)(Math.random()*3+1);//電腦出拳
				//System.out.println(x);
				//System.out.println("寵物獲勝:"+player+"電腦獲勝:"+comp+"總共玩了"+freq+"場")
				String[] all = {"","paper","scissor","stone"};//出拳名稱
				int result = a-x;//猜拳結果
				//System.out.println(result);
				if(a>0&&a<=3){
					if (result==0){
						/*gamelines = new JTextArea(1,800);
						gamelines.setLocation(300,300);
						gamelines.setSize(gamelines.getPreferredSize());*/
						gamelines.setText("寵物出"+all[a]+"電腦出"+all[x]+"平手，再繼續努力喔");
						//add(gamelines);
						//System.out.println("寵物出"+all[a]+"電腦出"+all[x]+"平手，再繼續努力喔");
						freq+=1;
						due+=1;
						resultlines.setText("寵物獲勝:"+player+"電腦獲勝:"+comp+"平手:"+due+"總共玩了"+freq+"場"+"目前金幣"+moneyPaper);

					
					}else if (result==-1|result==2){
						/*gamelines = new JTextArea(1,800);
						gamelines.setLocation(300,300);
						gamelines.setSize(gamelines.getPreferredSize());*/
						gamelines.setText("寵物出"+all[a]+"電腦出"+all[x]+" 您輸了,繼續努力");

						//add(gamelines);
						//System.out.println("寵物出"+all[a]+"電腦出"+all[x]+" 您輸了,繼續努力");
					    comp +=1;
						freq+=1;
						resultlines.setText("寵物獲勝:"+player+"電腦獲勝:"+comp+"平手:"+due+"總共玩了"+freq+"場"+"目前金幣"+moneyPaper);


					}else if (result==1|result==-2){
						/*gamelines = new JTextArea(1,800);
						gamelines.setLocation(300,300);
						gamelines.setSize(gamelines.getPreferredSize());*/
						moneyPaper = moneyPaper +50;
						gamelines.setText("寵物出"+all[a]+"電腦出"+all[x]+" 您贏了,好厲害喔,得到金幣"+50);
						//System.out.println("寵物出"+all[a]+"電腦出"+all[x]+" 您贏了,好厲害喔");
						//add(gamelines);
						player +=1;
						freq+=1;
						resultlines.setText("寵物獲勝:"+player+"電腦獲勝:"+comp+"平手:"+due+"總共玩了"+freq+"場"+"目前金幣"+moneyPaper);


		  
					}
				}
			
		}

}

