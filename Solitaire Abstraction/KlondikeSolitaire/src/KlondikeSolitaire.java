/**
 * @(#)KlondikeSolitaire.java
 *
 * KlondikeSolitaire application
 *
 * @author 
 * @version 1.00 2016/5/4
 */


import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class KlondikeSolitaire {
    
    ///*
    public static void main(String[] args) {
		SolitaireWindow window = new SolitaireWindow();
		window.displayGame();
    }
    
    //*/
	
			//Function Tester
	
	/*
	public static void main(String args[])
	{
		SolitaireGame solitaire = new SolitaireGame();
		Scanner sc = new Scanner(System.in);
		while(!(solitaire.hasWon()))
		{
			System.out.println("CURRENT STATE: ");
			System.out.println("Discard: " + solitaire.getDiscardPile());
			System.out.println();
			for(int i = 0; i < 7; i ++)
			{
				System.out.println("Pile #" + (i+1) + ": " + solitaire.getPiles()[i]);
			}
			System.out.println();
			for(int i = 0; i < 4; i ++)
			{
				System.out.println("Pile #" + (i+1) + ": " + solitaire.getTargets()[i]);
			}
			int i = -1;
			try
			{
				i = sc.nextInt();
			}
			catch(InputMismatchException ex)
			{
				String s = sc.next();
				if(s.equals("restart"))
				{
					solitaire.newGame();
				}
				
			}
			if(i > 0 && i < 8)
			{
				int j = 0;
				boolean isInt = true;
				if(solitaire.getSelectedPile().size() == 0)
				{
					while(true)
					{
						try
						{
							j = sc.nextInt();
						}
						catch(InputMismatchException ex)
						{
							isInt = false;
							sc.next();
						}
						if(isInt)
						{
							break;
						}
					}
				}
				solitaire.clickAlternatingPile(i - 1, j);
			}
			else if(i == 0)
			{
				solitaire.clickDeck();
			}
			else if(i > 10 && i < 15)
			{
				solitaire.clickTargetPile(i%10 - 1);
			}
			else if (i < 0)
			{
				solitaire.clickDiscardPile();
			}
		}
		
	}//*/
}
