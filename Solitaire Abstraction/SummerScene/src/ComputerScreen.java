import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

public class ComputerScreen extends JPanel
{
	ArrayList<JLabel> visTextLines = new ArrayList<JLabel>();
	ArrayList<String> textLines = new ArrayList<String>();
	public ComputerScreen()
	{
		setLayout(null);
		setBackground(Color.BLACK);
		setOpaque(true);
		addNewLine("", true);
	}
	protected void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		for(int i = 0; i < visTextLines.size(); i ++)
		{
			JLabel jl = visTextLines.get(i);
			jl.setBounds(0,20*i,this.getWidth(),20);
		}
		//consoleDisplay();
		//bug testing
		
	}
	public void backspaceCurrentLine()
	{
		if(!textLines.get(textLines.size()-1).equals(""))
		{
			setLine(textLines.size()-1,textLines.get(textLines.size()-1).substring(0,textLines.get(textLines.size()-1).length()-1),true);
		}
		repaint();
	}
	
	public void paintThis()
	{
		repaint();
	}
	/*---------------------------------FOR DEBUGGING-------------------------------------
	public void consoleDisplay()
	{
		System.out.println("-----" + textLines.size() + " " + visTextLines.size());
		for (int i = 0; i < visTextLines.size(); i ++)
		{
			JLabel jl = visTextLines.get(i);
			System.out.println(i + ": " + jl.getText());
		}
	}
	-----------------------------------------------------------------------------------*/
	public void addToCurrentLine(char c)
	{
		if(c == '\n')
		{
			newLine();
			
		}
		else
		{
			setLine(textLines.size()-1,textLines.get(textLines.size()-1) + c,true);
		}
		repaint();
	}
	public void newLine()
	{
		processCurrentLine();
		addNewLine("",true);
	}
	public void clearScreen()
	{  
		for(int i = 0; i < 15; i ++)
		{
			System.out.println();
		}
	}
	public void setLine(int index, String line, boolean user)
	{
		textLines.set(index, line);
		visTextLines.get(index).setText((user ? "> " : "") + line);
		//System.out.println(index + " " + line + " " + visTextLines.get(index).getText());
	}
	public void addNewLine(String line, boolean user)
	{
		textLines.add(line);
		visTextLines.add(new JLabel(user ? "> " : "" + line));
		JLabel jl = visTextLines.get(visTextLines.size()-1);
		jl.setBounds(0,20*(visTextLines.size()-1),this.getWidth(),20);
		jl.setForeground(Color.WHITE);
		jl.setVisible(true);
		this.add(jl);
	}
	public void processCurrentLine()
	{
		String line = textLines.get(textLines.size()-1);
		switch(line)
		{
			case "Ping":
			case "ping":
				addNewLine("Pong!", false);
				break;
			case "What is love?":
				addNewLine("Baby, don't hurt me.", false);
				break;
			case "Hi!":
			case "hi":
			case "Hi":
			case "Hello":
			case "Hello!":
			case "hello":
				addNewLine("Hi, how are you?", false);
				break;
			case "exit":
				break;
			default:
				addNewLine("Unknown command.", false);
		}
	}
}