import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SummerScene
{
	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
    	frame.setTitle("My Summer Scene");
    	frame.setSize(700, 600);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	Summer s = new Summer ();
    	frame.add(s);
    	frame.setVisible(true);
	}
}

class Summer extends JComponent
{
	private static final int WY = 25;
	private static final int WX = 100;
	private static final int WW = 100;
	private static final int WH = 100;
	private static final int DX = 450;
	private static final int DY = 205;
	private static final int DH = 100;
	private static final int DW = 100;
	private static final int DSX = 100;
	private static final int HY = 250;
	private static final int DVO = 10;
	private static final int DLOX = 10;
	private static final int DLOY = 10;
	private static final int DSLY = 7;
	private static final int DLX = 7;
	private static final int DLH = 125;
	private static final double CC = 1.2;
	private static final Color DC = new Color(165,42,42);
	//private static final int 
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g.setColor(Color.BLUE);
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		g.setColor(Color.GRAY);
		g2.setStroke(new BasicStroke(7));
    	g2.drawRect(WX,WY,WW,WH);
    	g.drawLine(WX + WW/2, WY, WX + WW/2, WY + WH);
    	g.drawLine(WX, WY + WH/2, WX + WW, WY + WH/2);
    	g.setColor(Color.BLACK);
    	g2.setStroke(new BasicStroke(1));
    	g.drawLine(0,HY,this.getWidth(),HY);
    	g.setColor(Color.CYAN);
    	g.fillRect(WX+1,WY+1,WW/2-1,WH/2-1);
    	g.fillRect(WX+WW/2+1,WY+1,WW/2-1,WH/2-1);
    	g.fillRect(WX+1,WY+WH/2+1,WW/2-1,WH/2-1);
    	g.fillRect(WX+WW/2+1,WY+WH/2+1,WW/2-1,WH/2-1);
    	
    	//START-OF-LEGS----------------------------------------------
    	leg(g2, DLOX, DLOY);
    	leg(g2, DW - DLOX, DLOY);
    	leg(g2, DW + DSX - 2*DLOX, DH - DLOY);
    	leg(g2, DSX - DLOX, DH - DLOY);
    	//END-OF-LEGS---------------------------------------------
    	
    	
    	g2.setColor(DC);
    	if(true)
    	{
    		int[] x = {DX, DX + DW, DX + DW + DSX, DX + DSX};
    		int[] y = {DY, DY, DY + DH, DY+ DH};
    		g2.fillPolygon(x, y, 4);
    	}
    	g2.setColor(b(DC));
    	if(true)
    	{
    		int[] x = {DX, DX + DSX, DX + DSX, DX};
    		int[] y = {DY, DY + DH, DY + DH + DVO, DY + DVO};
    		g2.fillPolygon(x,y,4);
    	}
    	g2.setColor(d(DC));
    	g2.fillRect(DX + DSX, DY + DH, DW, DVO);
	}
	private void rect(Graphics2D g2, int x, int y, int w, int h, Color fill)
	{
		g2.drawRect(x,y,w,h);
		g2.setColor(fill);
		g2.fillRect(x,y,w,h);
	}
	private void leg(Graphics2D g2, int x, int y)
	{
    	g2.setColor(d(DC));
    	g2.fillRect(DX + x + DLX, DY + y + DSLY, DLX, DLH);
		g2.setColor(b(DC));
    	if(true)
    	{
    		int[] x2 = {DX + x, DX + x + DLX, DX + x + DLX, DX + x};
    		int[] y2 = {DY + y, DY + y + DSLY, DY + y + DLH + DSLY, DY + y + DLH};
    		g2.fillPolygon(x2,y2,4);
    	}
	}
	private Color b(Color c)
	{
		return new Color((int)(c.getRed()*CC),(int)(c.getGreen()*CC),(int)(c.getBlue()*CC));
	}
	private Color d(Color c)
	{
		return new Color((int)(c.getRed()/CC),(int)(c.getGreen()/CC),(int)(c.getBlue()/CC));
	}
}
