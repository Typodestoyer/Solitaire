import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class FontTester extends KeyAdapter
{
	public static int i;
	public static String[] fonts;
	public static JLabel jl;
	public static JFrame frame;
	public static void main(String[] a) {
		i = 0;
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fonts = e.getAvailableFontFamilyNames(); // Get the fonts
		frame = new JFrame();
		jl = new JLabel("This is the font " + fonts[0]);
		jl.setFont(new Font(fonts[0],0,12));
		frame.addKeyListener(new FontTester());
		frame.add(jl);
		frame.setTitle("Font Tester");
		frame.setSize(700, 600);
		frame.setPreferredSize(new Dimension(700, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);  	
  }
  @Override
  public void keyTyped(KeyEvent e)
  {
  	System.out.println("Typed!");
  	FontTester.i ++;
  	if(FontTester.i == FontTester.fonts.length)
  	{
  		i = 0;
  	}
	jl.setFont(new Font(fonts[FontTester.i],0,12));
	jl.setText("This is the font " + fonts[i]);
	FontTester.frame.repaint();
  }
}