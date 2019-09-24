import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Calculator2 extends JFrame implements ActionListener{
	private JTextArea inputlines;
	int a = 0 ;
	public static void main(String[] args) {
	Calculator2 frame = new Calculator2();
	frame.setVisible(true);
	}
	public Calculator2(){
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JButton add = new JButton("+");
		add.setLocation(100,400);
		add.setSize(add.getPreferredSize());
		add.addActionListener( this);
		add(add);
		JButton sub = new JButton("-");
		sub.setLocation(150,400);
		sub.setSize(add.getPreferredSize());
		sub.addActionListener(this);
		add(sub);
		JButton re = new JButton("reset");
		re.setLocation(200,400);
		re.setSize(re.getPreferredSize());
		re.addActionListener(this);
		add(re);
		inputlines = new JTextArea(1,800);
		inputlines.setLocation(0,0);
		inputlines.setSize(inputlines.getPreferredSize());
		inputlines.setText("<Enter numbers here>");
		add(inputlines);
		}

		public void actionPerformed(ActionEvent e){
			String command = e.getActionCommand();
			if(command.equals("+")){
				 a= a+Integer.parseInt(inputlines.getText()) ;
				 inputlines.setText(Integer.toString(a));

			}else if(command.equals("-")){
				 a= a-Integer.parseInt(inputlines.getText()) ;
				 inputlines.setText(Integer.toString(a));
			}else if(command.equals("reset")){
			inputlines.setText(null);
			a = 0 ;
			}
		}

}