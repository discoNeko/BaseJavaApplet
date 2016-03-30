import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/* <applet code="Main.class" width=800 height=600> */

public class Main extends Applet implements  KeyListener,MouseListener,MouseMotionListener,Runnable{
    Graphics db;
    Image buf;
    int w = 800, h = 600; //描画サイズ

    Thread t1;

    public void init() {
    	buf = createImage( w , h );

    	t1 = new Thread(this);
    	t1.start();

    	addKeyListener(this);
    	addMouseListener(this);
    	addMouseMotionListener(this);
    	setBackground(Color.white); // アプレットの背景色を白に設定.
    }

    public void update(Graphics g) {
    	paint(g);
    }

    public void paint(Graphics g) {
    	db = buf.getGraphics();
    	db.setColor(Color.gray);
    	db.fillRect(0 , 0 , w , h);
    	db.setColor(Color.white);
    	db.fillRect(10 , 10 , w-20 , h-20);
    	db.setColor(Color.black);

    	//アンチエイリアス処理
    	/*
    	Graphics2D g2 = (Graphics2D)db;
    	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING ,
    			RenderingHints.VALUE_ANTIALIAS_ON );
    	 */

    	g.drawImage(buf,0,0,this);
    }

    public void run() {
    	try{
    		while(true){
    			repaint();
    			Thread.sleep(20);
    		}
    	}catch(Exception e){
    		System.out.println( e );
    	}
    }

	public void keyTyped(KeyEvent e) {
		//key（文字のみ）が押されたとき実行
		int key = e.getKeyCode();
	}

	public void keyPressed(KeyEvent e) {
		//keyが押されたとき実行
    	int key = e.getKeyCode();
	}

	public void keyReleased(KeyEvent e) {
		//keyが離されたとき実行
    	int key = e.getKeyCode();
	}

	public void mouseDragged(MouseEvent e) {
		//マウスがドラッグされたとき実行
    	int x = e.getX();
    	int y = e.getY();
	}

	public void mouseMoved(MouseEvent e) {
		//マウスが移動したとき実行
    	int x = e.getX();
    	int y = e.getY();
	}

	public void mouseClicked(MouseEvent e) {
		//マウスがクリックされたとき実行
    	int x = e.getX();
    	int y = e.getY();
	}

	public void mousePressed(MouseEvent e) {
		//マウスが押されたとき実行
    	int x = e.getX();
    	int y = e.getY();
	}

	public void mouseReleased(MouseEvent e) {
		//マウスが離されたとき実行
    	int x = e.getX();
    	int y = e.getY();
	}

	public void mouseEntered(MouseEvent e) {
		//マウスがアプレット上に乗ったとき実行
    	int x = e.getX();
    	int y = e.getY();
	}

	public void mouseExited(MouseEvent e) {
		//マウスがアプレット上から離れたとき実行
    	int x = e.getX();
    	int y = e.getY();
	}
}
