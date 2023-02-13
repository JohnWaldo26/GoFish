 //********************************************************************
//  CardDriver.java       Author: Lewis and Loftus
//
//  Solution to Programming Project 7.7 
//********************************************************************
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class GoFish
{
   //-----------------------------------------------------------------
   //  Creates a deck, shuffles the deck and deals the cards.
   //-----------------------------------------------------------------
   public static void main (String args[])
   {
	 Scanner sc = new Scanner(System.in);  
     DeckOfCards deck=new DeckOfCards();
     deck.shuffle();
     ArrayList<Card> Player1Deck= new ArrayList<Card>(7);
     ArrayList<Integer> Player1DeckNumbers= new ArrayList<Integer>(7);
     for (int x=0; x<7;x++)
     {
    	 Card t=deck.deal();
    	 int a=t.getFace();
    	 Player1DeckNumbers.add(a);
    	 Player1Deck.add(t);
     }
     ArrayList<Card> Player2Deck= new ArrayList<Card>(7);
     ArrayList<Integer> Player2DeckNumbers= new ArrayList<Integer>(7);
     for (int x=0; x<7;x++)
     {
    	 Card t=deck.deal();
    	 int a=t.getFace();
    	 Player2DeckNumbers.add(a);
    	 Player2Deck.add(t);
     }
     int Player1Points=0;
     int Player2Points=0;
     int PlayerTurn;
     
     System.out.println("Original Lists: ");
     System.out.println("");
     System.out.println(Player1DeckNumbers);
     System.out.println(Player2DeckNumbers);
     System.out.println("");
     System.out.println("Deck for Player 1: "+Player1Deck);
     System.out.println("Deck for Player 2: "+Player2Deck);
     
     String Player1Name=JOptionPane.showInputDialog(null,"Type the Name for Player 1",null,1); 
     String Player2Name=JOptionPane.showInputDialog(null,"Type the Name for Player 2",null,1);   
 
     
     
     
     
     
     // Main Game Code Begins
    	 PlayerTurn=0;  
         Player1Points=MatchCheck(Player1DeckNumbers,PlayerTurn,Player1Points);
         PlayerTurn=1;
         Player2Points=MatchCheck(Player2DeckNumbers,PlayerTurn,Player2Points);   
         boolean deck_length_check=true;
     while (deck_length_check==true)
     {      
     for (int y=0;y<2;y++)
     {
    	 
    	 
    	 if (y==0&&deck_length_check==true)
    	 {
    	 String CardOptionsMenu="Type Which Card You Want to Ask "+ Player2Name +" For: "
    				 +"\n" + "Type 1 for an Ace of any suit"
    				 +"\n" + "Type 2 for 2 of any suit"
    				 +"\n" + "Type 3 for 3 of any suit"
    				 +"\n" + "Type 4 for 4 of any suit"
    				 +"\n" + "Type 5 for 5 of any suit"
    				 +"\n" + "Type 6 for 6 of any suit"
    				 +"\n" + "Type 7 for 7 of any suit"
    				 +"\n" + "Type 8 for 8 of any suit"
    				 +"\n" + "Type 9 for 9 of any suit"
    				 +"\n" + "Type 10 for 10 of any suit"
    				 +"\n" + "Type 11 for a Joker of any suit"
    				 +"\n" + "Type 12 for a Queen of any suit"
    				 +"\n" + "Type 13 for a King of any suit"
    				 +"\n";
    	 PlayerTurn=0;  
    	 
    	 String pointstatement;
		 if (Player1Points==1)
    		 pointstatement="You Have "+ Player1Points+ " Point";
    	 else
    		 pointstatement="You Have "+ Player1Points+ " Points";
		 JOptionPane.showMessageDialog(null, "Your deck is: "+"\n"+ Player1DeckNumbers+"\n"+"\n"+pointstatement, Player1Name+"'s Turn: ", JOptionPane.INFORMATION_MESSAGE);
		 String Player1ChoiceString=JOptionPane.showInputDialog(null,CardOptionsMenu,"Your Deck:"+Player1DeckNumbers,1); 
    	 int Player1Choice = Integer.parseInt(Player1ChoiceString);
    	 Player1Points=MatchCheck(Player1DeckNumbers,PlayerTurn,Player1Points);
    	 /// The Following Code Will See Whether Or Not Player 2 Has The Chosen Code
    	 boolean CardPossession=false;
    	 CardPossession=CardCheck(Player2DeckNumbers,Player1Choice,CardPossession);
    	 System.out.println(CardPossession);
    	 // m determines the number of cards lost(number of matches) after CardCheck
    	 if (CardPossession==true)
    	 {
    		 Player1DeckNumbers.add(Player1DeckNumbers.size(),Player1Choice);
    	 }
    	// if m=0 (no matches are found), Player1 draws a card from the deck
    	 else
    	 {
    		 Card dcard=deck.deal();
    		 int drawncard=dcard.getFace();
    		 JOptionPane.showMessageDialog(null,"You drew a "+drawncard, Player1Name+"'s Turn: ", JOptionPane.INFORMATION_MESSAGE);
    		 Player1DeckNumbers.add(drawncard);
    	 }
    	 Player1Points=MatchCheck(Player1DeckNumbers,PlayerTurn,Player1Points);
    	 
    	 
    	 if (Player1Points==1)
    		 JOptionPane.showMessageDialog(null, "You Have "+ Player1Points+ " Point", Player1Name+"'s Turn: ", JOptionPane.INFORMATION_MESSAGE);
    	 else
    		 JOptionPane.showMessageDialog(null, "You Have "+ Player1Points+ " Points", Player1Name+"'s Turn: ", JOptionPane.INFORMATION_MESSAGE);
    	 }
    	 int x=Player1DeckNumbers.size();
    	 if (x==0)
    	 {
    		 deck_length_check=false; 
    	 }
    	 
    	 else
    	 {	 
    	 if (y==1&&deck_length_check==true)// Else Player 2 plays
    	 {
    		 String CardOptionsMenu="Type Which Card You Want to Ask "+ Player1Name +" For: "
    				 +"\n" + "Type 1 for an Ace of any suit"
    				 +"\n" + "Type 2 for 2 of any suit"
    				 +"\n" + "Type 3 for 3 of any suit"
    				 +"\n" + "Type 4 for 4 of any suit"
    				 +"\n" + "Type 5 for 5 of any suit"
    				 +"\n" + "Type 6 for 6 of any suit"
    				 +"\n" + "Type 7 for 7 of any suit"
    				 +"\n" + "Type 8 for 8 of any suit"
    				 +"\n" + "Type 9 for 9 of any suit"
    				 +"\n" + "Type 10 for 10 of any suit"
    				 +"\n" + "Type 11 for a Joker of any suit"
    				 +"\n" + "Type 12 for a Queen of any suit"
    				 +"\n" + "Type 13 for a King of any suit"
    				 +"\n";
    		 PlayerTurn=1;  
        	 
        	 String pointstatement;
    		 if (Player2Points==1)
        		 pointstatement="You Have "+ Player2Points+ " Point";
        	 else
        		 pointstatement="You Have "+ Player2Points+ " Points";
    		 JOptionPane.showMessageDialog(null, "Your deck is: "+"\n"+ Player2DeckNumbers+"\n"+"\n"+pointstatement, Player2Name+"'s Turn: ", JOptionPane.INFORMATION_MESSAGE);
    		 String Player2ChoiceString=JOptionPane.showInputDialog(null,CardOptionsMenu,"Your Deck:"+Player2DeckNumbers,1); 
        	 int Player2Choice = Integer.parseInt(Player2ChoiceString);
        	 Player2Points=MatchCheck(Player2DeckNumbers,PlayerTurn,Player2Points);
        	 /// The Following Code Will See Whether Or Not Player 2 Has The Chosen Code
        	 boolean CardPossession=false;
        	 CardPossession=CardCheck(Player1DeckNumbers,Player2Choice,CardPossession);
        	 // m determines the number of cards lost(number of matches) after CardCheck
        	 if (CardPossession==true)
        	 {
        		 Player2DeckNumbers.add(Player2DeckNumbers.size(),Player2Choice);
        	 }
        	// if m=0 (no matches are found), Player1 draws a card from the deck
        	 else
        	 {
        		 Card dcard=deck.deal();
        		 int drawncard=dcard.getFace();
        		 JOptionPane.showMessageDialog(null,"You drew a "+drawncard, Player2Name+"'s Turn: ", JOptionPane.INFORMATION_MESSAGE);
        		 Player2DeckNumbers.add(drawncard);
        	 }
        	 Player2Points=MatchCheck(Player2DeckNumbers,PlayerTurn,Player2Points);
        	 
        	 
        	 if (Player2Points==1)
        		 JOptionPane.showMessageDialog(null, "You Have "+ Player2Points+ " Point", Player2Name+"'s Turn: ", JOptionPane.INFORMATION_MESSAGE);
        	 else
        		 JOptionPane.showMessageDialog(null, "You Have "+ Player2Points+ " Points", Player2Name+"'s Turn: ", JOptionPane.INFORMATION_MESSAGE);
        	 }
    	 int Player2DeckNumbers_length=Player2DeckNumbers.size();
    	 if (Player2DeckNumbers_length==0)
    	 {
    		 deck_length_check=false; 
    	 }
    	 } 
         }
     }     
     if (Player2Points>Player1Points)
     {
    	 JOptionPane.showMessageDialog(null, "The winner of the game was "+Player2Name+"." 
    			 +"\n" 
    			 +"\n" +Player2Name+"--"+Player2Points+" pairs" 
				 +"\n" + Player1Name+"--"+Player1Points+" pairs"); 
     }
     if (Player1Points>Player2Points)
     {
    	 JOptionPane.showMessageDialog(null, "The winner of the game was "+Player1Name+"." 
    	 +"\n" 
		 +"\n" +Player1Name+"--"+Player1Points+" pairs" 
		 +"\n" + Player2Name+"--"+Player2Points+" pairs"); 
     }
     if (Player1Points==Player2Points)
     {
    	 JOptionPane.showMessageDialog(null, "It was a tie. " 
    	 +"\n" 
    	 +"\n" +Player1Name+"--"+Player1Points+" pairs" 
    	 +"\n" + Player2Name+"--"+Player2Points+" pairs");  
     }
     
   }

     public static int MatchCheck(ArrayList<Integer> Player2DeckNumbers, int PlayerTurn,int PlayerPoints) 
     {

    	 for (int i=0;i<Player2DeckNumbers.size();i++)
    	 {
    	 for (int j=i+1;j<Player2DeckNumbers.size();j++)	 
    	 {
    	 int number1=Player2DeckNumbers.get(i);
    	 int number2=Player2DeckNumbers.get(j);
    	 if (number1==number2)	
    	 {
    		 Player2DeckNumbers.remove(j);
    		 Player2DeckNumbers.remove(i);	
    		 i=i-1;
    		 j=Player2DeckNumbers.size();
    		 PlayerPoints=PlayerPoints+1;
    	 }
    	 
    	 }
    	 
    	 }
    	 return PlayerPoints;

     }
     public static boolean CardCheck(ArrayList<Integer> Player2DeckNumbers, int PlayerChoice, boolean CardPossession) 
     {

    	 for (int i=0;i<Player2DeckNumbers.size();i++)
    	 {

    	 if (Player2DeckNumbers.get(i)==PlayerChoice)	
    	 {
    		 Player2DeckNumbers.remove(i);	
    		 CardPossession=true;
    	 }
    	 
    	 }
    	 return CardPossession;
     }
}




























