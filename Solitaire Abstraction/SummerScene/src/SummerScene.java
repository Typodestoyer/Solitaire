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
    	frame.setPreferredSize(new Dimension(700, 600));
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	Summer s = new Summer ();
    	frame.add(s);
    	frame.setVisible(true);
	}
}

class Summer extends JComponent
{
	//WINDOW
	private static final int WY = 25;
	private static final int WX = 100;
	private static final int WW = 100;
	private static final int WH = 100;
	
	//DESK
	private static final int DX = 450;
	private static final int DY = 150;
	private static final int DH = 150;
	private static final int DW = 125;
	private static final int DSX = 100;
	private static final int DVO = 10;
	private static final int DLOX = 12;
	private static final int DLOY = 12;
	private static final int DLX = 10;
	private static final double DSLOPE = (double)DH/DSX;
	private static final int DSLY = (int)(DLX*DSLOPE);
	private static final int DLH = 125;
	
	//GENERAL
	private static final int LY = 250;
	private static final int LX = DX + DW;
	
	//COLOR
	private static final int THREE_D_COLOR = 20;
	private static final Color DC = new Color(255,218,185);
	//private static final int 
	protected void paintComponent(Graphics g2)
	{
		Graphics2D g = (Graphics2D)g2;
		int[] x = {};
		int[] y = {};
		//Everything
		g.setColor(new Color(200,200,200));
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		//Walls
		g.setColor(new Color(242,236,148));
		g.fillRect(0,0,this.getWidth(),LY);		
    	x = new int[] {LX, LX, this.getWidth(), this.getWidth()};
    	y = new int[] {LY, 0, 0, (int)(LY + (DSLOPE*(this.getWidth()-LX)))};
    	g.fillPolygon(x,y,4);
		//Behind Window
		g.setColor(Color.CYAN);
		g.fillRect(WX,WY,WW,WH);
		//Window Outline
		g.setColor(Color.GRAY);
		g.setStroke(new BasicStroke(7));
    	g.drawRect(WX,WY,WW,WH);
    	//Window Bars
    	g.setStroke(new BasicStroke(1));
    	g.drawLine(WX + WW/2, WY, WX + WW/2, WY + WH);
    	g.drawLine(WX, WY + WH/2, WX + WW, WY + WH/2);
    	//"Horizon" Line in House
    	g.setColor(Color.BLACK);
    	g.drawLine(0,LY,LX,LY);
    	g.drawLine(LX,0,LX,LY);
    	g.drawLine(LX,LY,this.getWidth(),(int)(LY + (DSLOPE*(this.getWidth()-LX))));
    	
    	//TABLE--------------------------------------------------
    	
    	//LEGS
    	leg(g, DLOX, DLOY);
    	leg(g, DW - DLOX - 2*DLX, DLOY);
    	leg(g, DW + DSX - DLOX - 2*DLX, DH - DLOY - DSLY);
    	leg(g, DSX + DLOX - DLX, DH - DLOY - DSLY);
    	
    	//TABLETOP
    	g.setColor(DC);
    	x = new int[] {DX, DX + DW, DX + DW + DSX, DX + DSX};
    	y = new int[] {DY, DY, DY + DH, DY+ DH};
    	g2.fillPolygon(x, y, 4);
    	
    	//TABLE SIDE
    	g.setColor(br(DC));
   		x = new int[] {DX, DX + DSX, DX + DSX, DX};
   		y = new int[] {DY, DY + DH, DY + DH + DVO, DY + DVO};
    	g2.fillPolygon(x,y,4);
    	
    	//TABLE FRONT
    	g.setColor(d(DC));
    	g.fillRect(DX + DSX, DY + DH, DW, DVO);
    	
	}
	
	private void polygon(Graphics2D g, int[] x, int[] y, Color fill)
	{
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(2));
		g.drawPolygon(x,y,x.length);
		g.setColor(fill);
		g.fillPolygon(x,y,x.length);
	}
	
	private void rect(Graphics2D g, int x, int y, int w, int h, Color fill)
	{
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(2));
		g.drawRect(x,y,w,h);
		g.setColor(fill);
		g.fillRect(x,y,w,h);
	}
	private void leg(Graphics2D g, int x, int y)
	{
    	g.setColor(d(DC));
    	g.fillRect(DX + x + DLX, DY + y + DSLY, DLX, DLH);
		g.setColor(br(DC));
		int[] x2 = {DX + x, DX + x + DLX, DX + x + DLX, DX + x};
    	int[] y2 = {DY + y, DY + y + DSLY, DY + y + DLH + DSLY, DY + y + DLH};
    	g.fillPolygon(x2,y2,4);
	}
	private Color b(Color c)
	{
		return new Color((int)(c.getRed()+THREE_D_COLOR),(int)(c.getGreen()+THREE_D_COLOR),(int)(c.getBlue()+THREE_D_COLOR));
	}
	private Color br(Color c)
	{
		return new Color((int)(c.getRed()),(int)(c.getGreen()+THREE_D_COLOR),(int)(c.getBlue()+THREE_D_COLOR));
	}
	
	private Color d(Color c)
	{
		return new Color((int)(c.getRed()-THREE_D_COLOR),(int)(c.getGreen()-THREE_D_COLOR),(int)(c.getBlue()-THREE_D_COLOR));
	}
}
