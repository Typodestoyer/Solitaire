import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;
public class SummerScene extends KeyAdapter implements MouseListener, MouseMotionListener
{
	public static void main (String[] args)
	{
		SummerScene s = new SummerScene();
	}
	
	public enum Scene
	{
		SUMMER, SCREEN
	}
	
	String line;
	JFrame frame;
	ComputerScreen screen;
	Summer summer;
	Scene s = Scene.SUMMER;
	
	public SummerScene()
	{
		frame = new JFrame();
    	frame.setTitle("My Summer Scene");
    	frame.setSize(700, 600);
    	frame.setPreferredSize(new Dimension(700, 600));
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.addKeyListener(this);
    	frame.addMouseListener(this);
    	frame.addMouseMotionListener(this);
    	screen = new ComputerScreen();
    	summer = new Summer();
    	
    	frame.getContentPane().add(summer);
    	frame.setVisible(true);
    	
	}
	
	public void keyTyped(KeyEvent e)
	{
		if(s == Scene.SUMMER)
		{
			
		}
		else if(e.getKeyChar() == '\b')
		{
			screen.backspaceCurrentLine();
		}
		else if((int)e.getKeyChar() == KeyEvent.VK_ESCAPE)
		{
			if(s == Scene.SCREEN)
			{
				s = Scene.SUMMER;
				frame.remove(screen);
				frame.add(summer);
				frame.repaint();
				summer.repaint();
			}
		}
		else
		{
			screen.addToCurrentLine(e.getKeyChar());
		}
		frame.validate();
	}
	
	
	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}
	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(s==Scene.SUMMER && summer.getComputer().contains(e.getX()-8,e.getY()-30))
		{
			summer.unhighlight();
			s = Scene.SCREEN;
			frame.remove(summer);
			frame.add(screen);
			frame.repaint();
			screen.repaint();
			frame.validate();
		}
	}
	@Override
	public void mousePressed(MouseEvent e)
	{
		
	}
	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e)
	{
		if(s==Scene.SUMMER && summer.getComputer().contains(e.getX()-8,e.getY()-30))
		{
			summer.highlight();
		}
		else if(s==Scene.SUMMER)
		{
			summer.unhighlight();
		}
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		
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
 		/*
		 *
		 *  rectPrism(g,CX,CY-CLH,CLW,DVO,CSX,CH,CC,d2(CC),b(CC));    	    	//TOP OF BACK
    		rectPrism(g,CX,-CLH+CY,(int)(CLW*CBWF),CLH,(int)(CLW*CBWF),(int)(CSLY*CBWF),CC,d2(CC),b(CC));
    		rectPrism(g,(CSX-(int)(CLW*CBWF))/2+CX,-CLH+(CH-DVO)/2+CY,(int)(CLW*CBWF),CLH,(int)(CLW*CBWF),(int)(CSLY*CBWF),CC,d2(CC),b(CC));
    		rectPrism(g,CSX-(int)(CLW*CBWF)+CX,CH-CLH-DVO+CY,(int)(CLW*CBWF),CLH,(int)(CLW*CBWF),(int)(CSLY*CBWF),CC,d2(CC),b(CC));
		 *
		 *
		 **/