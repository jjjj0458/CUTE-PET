package FinalProject;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class ShopFrame  extends JFrame implements ActionListener{
	
	ImageIcon a2,a3,a4,a5,a6,a7,a8,a9,a10;
	
	Boolean bbb=true;
	JLabel money1 =new JLabel();
	static NewButton aa=new NewButton(0);
	static int b=0;
	Background temp1;

	
	
	
	private  int price;
	
	NewButton button[]=new NewButton[9];
	Boolean buy[]=new Boolean[9];
	NewButton a1=new NewButton(1);
	
	
	
	ShopFrame(Background a){
		
		
		
		a2=new ImageIcon("shopitem1.png");
		a3=new ImageIcon("shopitem2.png");
		a4=new ImageIcon("shopitem3.png");
		a5=new ImageIcon("shopitem4.png");
		a6=new ImageIcon("shopitem5.png");
		a7=new ImageIcon("shopitem6.png");
		a8=new ImageIcon("shopitem7.png");
		a9=new ImageIcon("shopitem8.png");
		a10=new ImageIcon("shopitem9.png");
		
		Image temp = a2.getImage().getScaledInstance(150,  
				150, a2.getImage().SCALE_DEFAULT);  
        a2 = new ImageIcon(temp); 

		 temp = a3.getImage().getScaledInstance(150,  
				150, a3.getImage().SCALE_DEFAULT);  
        a3 = new ImageIcon(temp); 

		 temp = a4.getImage().getScaledInstance(150,  
				150, a4.getImage().SCALE_DEFAULT);  
        a4 = new ImageIcon(temp); 

		 temp = a5.getImage().getScaledInstance(150,  
				150, a5.getImage().SCALE_DEFAULT);  
        a5 = new ImageIcon(temp); 
        
        temp = a6.getImage().getScaledInstance(150,  
				150, a6.getImage().SCALE_DEFAULT);  
        a6 = new ImageIcon(temp); 
        temp = a7.getImage().getScaledInstance(150,  
				150, a7.getImage().SCALE_DEFAULT);  
        a7 = new ImageIcon(temp); 

		 
		
		
		
		
		
		
		temp1=a;
		JLabel money =new JLabel("     Money");
		//money.setFont(new   java.awt.Font("ITALIC",   1,   20)); 
		//money.setAlignmentX(20);
	money1.setText(String.valueOf(a.money));
		 for(int i=0;i<6;i++)
		    {
		    	button[i]=new NewButton(i/2*1000);
		    	//button[i].setText(String.valueOf(button[i].a));
		    	button[i].b=i;
		    	buy[i]=false;
		    	button[i].addActionListener(this);
		    	//button[i].addActionListener(money1);
		    	add(button[i]);
		    }
		 
		 
			
			
			
			
			
			
        a1.setText("擺放家俱");
		add(money);
		add(money1);
		add(a1);
		
		button[0].setIcon(a8);
		button[0].a=660;
		button[1].setIcon(a9);
		button[1].a=520;
		button[2].setIcon(a4);
		button[2].a=800;
		button[3].setIcon(a5);
		button[3].a=450;
		button[4].setIcon(a6);
		button[4].a=550;
		
		button[5].setIcon(a7);
		button[5].a=660;
	//	button[6].setIcon(a8);
	//	button[6].a=860;
	////	button[7].setIcon(a9);
	//	button[7].a=520;
	//	button[8].setIcon(a10);
	//	button[8].a=1200;
		
	
		a1.addActionListener(this);
		setSize(360,450);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(3,3));
		
		
	
		
	   
	   
		
		
			
	
}


	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		aa=(NewButton)e.getSource();
		
		 if(e.getActionCommand()=="擺放家俱")
		 {
			 for(int i=0;i<9;i++)
			 {
				 temp1.buyed[i]=buy[i];
			 }
			 
			 dispose(); 
		 }
		 else if((temp1.money-aa.a)>=0)
		{	
		//temp=aa.a;
		  MyDiag a=new MyDiag(aa);
			a.setVisible(true);
			  a.setModal(true);
			//temp=temp-aa.a;
			System.out.println(e.getActionCommand());
			
		}
		 else
		{
			JOptionPane.showMessageDialog(this,"錢不夠喔~",
                    "快去玩遊戲吧!", JOptionPane.ERROR_MESSAGE);
		}
			
		
	}
	





 class MyDiag extends JDialog implements ActionListener {
	
	
	 private JButton ok=new JButton("OK");
	 private JButton can=new JButton("Cancel");
	 private JLabel label=new JLabel("Are  You  Sure  To  Buy?") ;
	
	 NewButton mybutt=new NewButton(0);
			 int num=0;
		//static NewButton bb=new NewButton(0);
	
	
	 
	 
	 
	 public MyDiag(NewButton a)
	 {
		 mybutt=a;
		 num=a.a;
		this.setSize(400,400);
		//setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
	    setLayout(null);
	    label.setBounds(100, 20, 200, 200);
	    ok.setBounds(80,150,80,50);
	    can.setBounds(200,150,80,50);
	    add(label);
	    add(can);
	    add(ok);
	    setVisible(true);
	   ok.addActionListener(this);
	   can.addActionListener(this);
	 }

  

	@Override
	public void actionPerformed(ActionEvent e) {
		
		e.getSource();
		//System.out.println(e);
		System.out.println(e.getActionCommand());
		if(e.getActionCommand()=="OK")
		{
			bbb=true;
			 setVisible(false); 
			// b=b+num;
			 temp1.money=temp1.money-num;
			 System.out.println(b);
				System.out.println(temp1.money);
				buy[mybutt.b]=true;
				System.out.println(mybutt.b);
			 money1.setText(String.valueOf(temp1.money));
			 
			 dispose(); 
		}
		else
		{
			
			
			bbb=false;
			setVisible(false); 
			System.out.println(bbb);
			System.out.println(b);
			 
			 dispose(); 
			
		}
		
		
	}

}

}
