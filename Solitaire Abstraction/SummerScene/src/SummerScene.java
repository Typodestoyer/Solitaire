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

class Summer extends JPanel
{
	//WINDOW
	private static final int WY = 25;	//Y OF UPPER LEFT
	private static final int WX = 100;	//X ""
	private static final int WW = 100;	//WIDTH
	private static final int WH = 100;	//HEIGHT
	
	//DESK
	private static final int DX = 450;	//X OF UPPER LEFT
	private static final int DY = 150;	//Y ""
	private static final int DH = 150;	//HEIGHT
	private static final int DW = 125;	//WIDTH
	private static final int DSX = 100;	//HORIZONTAL SLOPE DISTANCE
	private static final int DVO = 10;	//VERTICAL 3D OFFSET
	private static final int DLOX = 12;	//HOW FAR IN LEG IS X
	private static final int DLOY = 12;	//"" Y
	private static final int DLW = 10;	//LEG WIDTH
	private static final double DSLOPE = (double)DH/DSX;//SLOPE OF TABLE 3DNESS
	private static final int DSLY = (int)(DLW*DSLOPE);	//VERTICAL LEG SLOPE
	private static final int DLH = 150;	//DESK LEG HEIGHT
	
	//CHAIR
	private static final int CX = 440;	//CHAIR X
	private static final int CY = 275;	//CHAIR Y
	private static final int CW = 75;	//CHAIR WIDTH
	private static final int CH = 50;	//CHAIR HEIGHT
	private static final int CLH = 70;	//CHAIR LEG HEIGHT
	private static final int CLOX = 0;	//CHAIR LEG OFFSET X
	private static final int CLOY = 0;	//CHAIR LEG OFFSET Y
	private static final int CSX = (int)(1/DSLOPE * CH);	//CHAIR SLOPE X
	private static final int CLW = 7;	//CHAIR LEG WIDTH
	private static final int CSLY = (int)(CLW*DSLOPE);	//CHAIR SLOPE LEG Y
	private static final int CBH = 50;	//CHAIR BACK HEIGHT
	private static final double CBWF = 0.75;	//CHAIR BACK WIDTH FACTOR
	
	//PERSON
	private static final int PTSX = 20;
	private static final int PTW = 20;
	private static final int PYO = 60;
	private static final int PXO = (CSX-(PTSX/2))/2;
	private static final int PTX = CX + PXO;
	private static final int PTY = CY - CBH - PYO + (int)(PXO * DSLOPE);
	private static final int PTH = CBH + PYO;
	private static final int PTSY = (int)(PTSX*DSLOPE);
	
	//PERSON LEGS
	private static final int PLH = 20;
	private static final int PLW = 65;
	private static final int PLSX = 20;
	private static final int PLX = PTX + PTSX;
	private static final int PLY = PTY + PTH - PLH;
	private static final int PLSY = (int)(PLSX*DSLOPE);
	
	//PERSON LEGS BELOW KNEES
	private static final int PLKH = 90;
	private static final int PLKW = PLH;
	private static final int PLKX = PLX + PLW;
	private static final int PLKY = PLY;
	
	//PERSON HEAD
	private static final int PHW = PTW;
	private static final int PHH = 30;
	private static final int PHXO = 0;
	private static final int PHYO = -(int)(PHXO*DSLOPE);
	private static final int PHWO = 5;
	private static final int PHHO = (int)(PHWO * DSLOPE);
	private static final int PHSX = 10;
	private static final int PHSY = (int)(PHSX*DSLOPE);
	private static final int PHX = PTX + PHWO + PHXO;
	private static final int PHY = PTY - 30 + PHHO + PHYO;
	
	//PERSON ARMS
	private static final int PARX = PTX;
	
	//GENERAL
	private static final int LY = 250;
	private static final int LX = DX + DW;
	
	//COLOR
	private static final Color CC = new Color(161,80,8);
	private static final Color FC = new Color(200,200,200);
	private static final Color WLC = new Color(222,216,128);
	private static final int THREE_D_COLOR = 20;
	private static final Color DC = new Color(255,218,185);
	private static final Color PC = new Color(30,30,150);
	private static final Color SKINCOLOR = new Color(222,171,127);
	
	//private static final int 
	
	//FUNCTIONS------------------------------------------------------------------------------
	
	protected void paintComponent(Graphics g2)
	{
		Graphics2D g = (Graphics2D)g2;
		int[] x = {};
		int[] y = {};
		//Everything
		g.setColor(FC);
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
    	
    	//RECTANGLES!--------------------------------------------------------------------------------------
    	
    	//LEGS
    	chairLeg(g, CLOX, CLOY);
    	chairLeg(g, CW - CLOX - 2*DLW, CLOY);
    	
    	deskLeg(g, DLOX, DLOY);
    	deskLeg(g, DW - DLOX - 2*DLW, DLOY);
    	
    	rectPrism(g,PLKX,PLKY,PLKW,PLKH,PLSX,PLSY,SKINCOLOR,d(SKINCOLOR),b(SKINCOLOR));
    	
    	
    	chairLeg(g, CW + CSX - CLOX - 2*CLW, CH - CLOY - CSLY);
    	chairLeg(g, CSX + CLOX - CLW, CH - CLOY - CSLY);
    	
    	//CHAIR BASE
    	rectPrism(g,CX,CY,CW,DVO,CSX,CH,CC,d2(CC),b(CC));
    	
    	//PERSON UNDER TABLE
    	
    	rectPrism(g,PLX,PLY,PLW,PLH,PLSX,PLSY,PC,d(PC),b(PC));
    	g.setColor(Color.BLACK);
    	g.setStroke(new BasicStroke(2));
    	g.drawLine(PLX+PLW/2,PLY+(int)((PLSX/2)*DSLOPE),PLX+PLW,PLY+(int)((PLSX/2)*DSLOPE));
    	
    	//TABLE LEGS
    	deskLeg(g, DW + DSX - DLOX - 2*DLW, DH - DLOY - DSLY);
    	deskLeg(g, DSX + DLOX - DLW, DH - DLOY - DSLY);
    	
    	//TABLETOP
    	rectPrism(g,DX,DY,DW,DVO,DSX,DH,DC,d(DC),br(DC));
    	
    	//PERSON
    	
    	rectPrism(g,PTX,PTY,PTW,PTH,PTSX,PTSY,PC,d(PC),b(PC));

		//EDGE OF CHAIR
		
    	rectPrism(g,CX,CY,CLW,DVO,CSX,CH,CC,d2(CC),b(CC));
		
		//HEAD
		
		rectPrism(g,PHX,PHY,PHW,PHH,PHSX,PHSY,SKINCOLOR,d(SKINCOLOR),b(SKINCOLOR));		

    	//BACK OF CHAIR
    	    	
    	rectPrism(g,0+CX,-CLH+CY,CLW,CLH,CLW,CSLY,CC,d2(CC),b(CC));
    	rectPrism(g,(CSX-CLW)/2+CX,-CLH+(CH-DVO)/2+CY,CLW,CLH,CLW,CSLY,CC,d2(CC),b(CC));
    	rectPrism(g,CSX-CLW+CX,CH-CLH-DVO+CY,CLW,CLH,CLW,CSLY,CC,d2(CC),b(CC));
		rectPrism(g,CX,CY-CLH,CLW,DVO,CSX,CH,CC,d2(CC),b(CC));
		
		/*
		 *
		 *  rectPrism(g,CX,CY-CLH,CLW,DVO,CSX,CH,CC,d2(CC),b(CC));    	    	//TOP OF BACK
    		rectPrism(g,CX,-CLH+CY,(int)(CLW*CBWF),CLH,(int)(CLW*CBWF),(int)(CSLY*CBWF),CC,d2(CC),b(CC));
    		rectPrism(g,(CSX-(int)(CLW*CBWF))/2+CX,-CLH+(CH-DVO)/2+CY,(int)(CLW*CBWF),CLH,(int)(CLW*CBWF),(int)(CSLY*CBWF),CC,d2(CC),b(CC));
    		rectPrism(g,CSX-(int)(CLW*CBWF)+CX,CH-CLH-DVO+CY,(int)(CLW*CBWF),CLH,(int)(CLW*CBWF),(int)(CSLY*CBWF),CC,d2(CC),b(CC));
		 *
		 *
		 **/
		 	
    	
    	
	}
	private void deskLeg(Graphics2D g, int x, int y)
	{
		rectPrism(g,x+DX,y+DY,DLW,DLH,DLW,DSLY,DC,d(DC),br(DC));
	}
	private void chairLeg(Graphics2D g, int x, int y)
	{
		rectPrism(g,x+CX,y+CY,CLW,CLH,CLW,CSLY,CC,d2(CC),b(CC));
	}
	
	private void rectPrism(Graphics2D g, int x, int y, int width, int height, int xslope, int yslope, Color topColor, Color frontColor, Color sideColor)
	{
		g.setColor(frontColor);
    	g.fillRect(x + xslope, y+yslope, width, height);
		g.setColor(sideColor);
		int[] x2 = {x, x + xslope, x + xslope, x};
    	int[] y2 = {y, y + yslope, y + height + yslope, y + height};
    	g.fillPolygon(x2,y2,4);
    	g.setColor(topColor);
    	x2 = new int[] {x,x+width,x+width+xslope,x+xslope};
    	y2 = new int[] {y,y,y+yslope,y+yslope};
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
	private Color d2(Color c)
	{
		return new Color((int)(c.getRed()-THREE_D_COLOR),(int)(c.getGreen()-THREE_D_COLOR),(int)(c.getBlue()));
	}
}

/*CODE ARCHIVES
 *
 *
 *
	
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
 *
 *
 *
 *
 *
    	
    //CURL AT BACK
    int slope = (int)((double)-1/(DSLOPE));
    int midX = (int)(CX + (double)CSX/2);
    int midY = (int)(CY + CLH - (double)CH/2);
    int midL = (int)Math.sqrt(Math.pow(CSX/2,2) + Math.pow(CH/2,2));
    int radius = 100;
    int lDist = (int)Math.sqrt(radius * radius - midL * midL);
    int xCenter = midX - lDist*1;
 *
 *
 *
 *
 **/ 