package FinalProject;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyNewFrame extends JFrame implements ActionListener {

	ImageIcon a1,a2,a3,a4,a5,a6;
	JPanel p=new JPanel();
	int count=0;
	private int score=0;
	int value=0;
	int moneyCard;
	Boolean check=false;
	Background background;
	//static int tre=0; 
	//static Boolean aaaa=false;
	static NewButton aa=new NewButton(0);
	static NewButton bb=new NewButton(0);
	private int a,b;
	NewButton button[]=new NewButton[12];
	
	
	
	public MyNewFrame(int mon){
		
		moneyCard = mon;
		a1=new ImageIcon("a.jpg");
		a2=new ImageIcon("b.jpg");
		a3=new ImageIcon("c.jpg");
		a4=new ImageIcon("d.png");
		a5=new ImageIcon("e.jpg");
		a6=new ImageIcon("f.jpg");
		//ImageIcon icon = new ImageIcon(file);  
        
		
		int x;
		setSize(800,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(3,3));
		//p.setVisible(true);
		
	
		
	    for(int i=0;i<12;i++)
	    {
	    	button[i]=new NewButton(i/2+1);
	    	//button[i].setText(String.valueOf(button[i].a));
	    	button[i].addActionListener(this);
	    	
	    }
	    
	    Random rd = new Random(); //����Random����
		ArrayList<Integer> al=new ArrayList<>();
		
		
			 
			while(al.size()<=12){ //�`�@10�ӼƦr
					int n=rd.nextInt(12); //����0~9�Ʀr
					if(al.contains(n)) 
						continue;     //���ƪ����[�J
					else
						al.add(n);
					
					
				add(button[n]);
					System.out.println(al.size());
					System.out.println(n);
					
					
					if(al.size()==12)
						break;
					}
			
			
	    
			System.out.println(button[0].getWidth());
	   // button[5].addActionListener(this);
			
			
			Image temp = a1.getImage().getScaledInstance(200,  
					200, a1.getImage().SCALE_DEFAULT);  
	        a1 = new ImageIcon(temp);  
	         temp = a2.getImage().getScaledInstance(200,  
					200, a2.getImage().SCALE_DEFAULT);  
	        a2 = new ImageIcon(temp);  
	        temp = a3.getImage().getScaledInstance(200,  
					200, a3.getImage().SCALE_DEFAULT);  
	        a3 = new ImageIcon(temp);  
	        temp = a4.getImage().getScaledInstance(200,  
					200, a4.getImage().SCALE_DEFAULT);  
	        a4 = new ImageIcon(temp);  
	         temp = a5.getImage().getScaledInstance(200,  
					200, a5.getImage().SCALE_DEFAULT);  
	        a5 = new ImageIcon(temp);  
	         temp = a6.getImage().getScaledInstance(200,  
					200, a6.getImage().SCALE_DEFAULT);  
	        a6 = new ImageIcon(temp);  
	   // button[0].setIcon(a1);
			
			
        p.setVisible(true);
        //
		
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

		            FileInputStream fs = new FileInputStream("d:\\card.ser");
		            ObjectInputStream is = new ObjectInputStream(fs);
		            background = new Background((String)is.readObject(),(String) is.readObject(),(Boolean[]) is.readObject(),(int) is.readObject(),(boolean) is.readObject());
		            background.time = (String)is.readObject();
		            background.age = (int)is.readObject();
		            background.money = (int)is.readObject();
		            background.healthy= (int)is.readObject();
		            background.intimate = (int)is.readObject();
		            background.full = (int)is.readObject();
		            background.money = moneyCard;
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
	
	
	public void newGame(){
		
		for(int i=0;i<12;i++)
	    {
	    	this.remove(button[i]);
	    	//button[i].setText(String.valueOf(button[i].a));
	    	button[i].addActionListener(this);
	    	 button[i].setIcon(null);
	    	
	    }
		
		 Random rd = new Random(); //����Random����
			ArrayList<Integer> al=new ArrayList<>();
			
			
				 
				while(al.size()<=12){ //�`�@10�ӼƦr
						int n=rd.nextInt(12); //����0~9�Ʀr
						if(al.contains(n)) 
							continue;     //���ƪ����[�J
						else
							al.add(n);
						
						
					add(button[n]);
						//System.out.println(al.size());
						System.out.println(n);
						
						if(al.size()==12)
							break;
						}
				
				 value=0;
				 check=false;
		
		//square_num=0;
		count=0;
		//play();
	} 
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		value++;
		//aaaa=true;
		
		if((value%2)==0)
   {
			
			 
			bb=(NewButton)e.getSource();
	   b=bb.a;
	   
		 System.out.println(b);
	      
	     if(a==b)
	     {
	    	// bb.setText(String.valueOf(bb.a));
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 switch(b)
		 		{
		 		case 1:
		 		  bb.setIcon(a1);
		 		    break;
		 		case 2:
		 			bb.setIcon(a2);
		 		    break;
		 		case 3:
		 			bb.setIcon(a3);
		 		    break;
		 		case 4:
		 			bb.setIcon(a4);
		 		    break;
		 		case 5:
		 			bb.setIcon(a5);
		 		    break;
		 		case 6:
		 			bb.setIcon(a6);
		 		    break;
		 		    
		 		  
		 		
		 		}
	    	 
	    	 
	    	 
	    	 
	    	 bb.removeActionListener(this);
	    	 aa.removeActionListener(this);
	    	 score=score+10;
	    	 check=true;
	    	 count++;
	    	 if(count==6)
	    	 {
	    		 moneyCard = moneyCard +500;
	    		 JOptionPane.showMessageDialog(null, "要重玩嗎", "金幣+500，目前金幣有"+moneyCard, JOptionPane.QUESTION_MESSAGE );
	    		 button[1].setIcon(null);
	    		 newGame();
	    	 }
	    }
	     else
	     {
	    	
	    	// bb.setText(String.valueOf(bb.a));
	    	 switch(b)
	 		{
	 		case 1:
	 		  bb.setIcon(a1);
	 		    break;
	 		case 2:
	 			bb.setIcon(a2);
	 		    break;
	 		case 3:
	 			bb.setIcon(a3);
	 		    break;
	 		case 4:
	 			bb.setIcon(a4);
	 		    break;
	 		case 5:
	 			bb.setIcon(a5);
	 		    break;
	 		case 6:
	 			bb.setIcon(a6);
	 		    break;
	 		    
	 		  
	 		
	 		}
	    	
	    	 
	    	 aa.addActionListener(this);
	    	 
	    	 check=false;
	    	
	    	 //aa.setVisible(false);
	    	
	    	// System.out.println("stop");
	    	// aaaa=false;
	    	// aa;
	    	
	    	 
	     }
	      
	   
		//	value=0;
			//Thread.sleep(2000);
			
    }
   else 
   {  
	   if(check==false)
	    {aa.setText("");
	    aa.setIcon(null);
    	bb.setText("");
    	bb.setIcon(null);
	    }
	   aa=(NewButton)e.getSource();
	   a=aa.a;
	  // aa.setText(" ");
	  // aa.setText(String.valueOf(aa.a));
	   
	   
	   switch(a)
		{
		case 1:
		  aa.setIcon(a1);
		    break;
		case 2:
			aa.setIcon(a2);
		    break;
		case 3:
			aa.setIcon(a3);
		    break;
		case 4:
			aa.setIcon(a4);
		    break;
		case 5:
			aa.setIcon(a5);
		    break;
		case 6:
			aa.setIcon(a6);
		    break;
		    
		  
		
		}
	   
	   
	   aa.removeActionListener(this);
	   
	 //  System.out.println(a);
	   //value++;
   }
		
		
		
	}
	
	
	
	
	

}
