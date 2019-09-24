package FinalProject;

public class myThread extends Thread{
	Background tBackground ;
	public myThread(Background background) {
		this.tBackground = background;
	}
	public void run(){
		tBackground.move();
	}
}
