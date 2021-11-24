/**********************************************
 * class YoRPG -- Driver file for Ye Olde Role Playing Game.
 * Simulates monster encounters of a wandering adventurer.
 * Required classes: Protagonist, Monster
 *
 * USAGE:
 * Compile. Note messages generated.
 * Devise a plan of attack with your trio.
 * Code incrementally, testing each bit of new functionality as you go.
 * The only modification you should make to this driver file is moving comment bar down in main method, and filling in DISCO/QCC
 * (If you feel other changes are merited, note what and why, so that we may discuss on the 'morrow.)
 *
 * DISCO:
 * You can create subclass by using "extends" keyword
 * When we extended protagonist and still only had one constructor, the
 * overloaded one, so we had to create default constuctor and change name using this
 *
 *
 * QCC:
 *
 **********************************************/

import java.io.*;
import java.util.*; //useless

public class YoRPG {

  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

  //change this constant to set number of encounters in a game
  public final static int MAX_ENCOUNTERS = 5;

  //each round, a Protagonist and a Monster will be instantiated...
  private Protagonist pat;
  private Monster smaug;
  private String name = ""; //Name

  //Game Vars
  private int moveCount; //useless
  private boolean gameOver; //useless
  private int difficulty;

  //Input Readers
  private InputStreamReader isr;
  private BufferedReader in;
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
  public YoRPG() {
    moveCount = 0;
    gameOver = false;
    isr = new InputStreamReader( System.in );
    in = new BufferedReader( isr );
    newGame();
  }
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

  /*=============================================
    void newGame() -- gathers info to begin a new game
    pre:
    post: according to user input, modifies instance var for difficulty
    and instantiates a Protagonist
    =============================================*/
  public void newGame() {
    String s = ""; //Screen
    int trade = 0;

    s = "~~~ Welcome to Ye Olde RPG! ~~~\n";
    s += "\nChoose your difficulty: \n";
    s += "\t1: Easy\n";
    s += "\t2: Not so easy\n";
    s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
    s += "Selection: ";

    System.out.print( s ); //Print Screen

    

    //input for difficulty
    try {
	    difficulty = Integer.parseInt( in.readLine() ); //Checks if this causes error
    }
    catch ( IOException e ) { //If error is caught
      System.out.println("An error has occured, plz try again.");
    }

    //instantiate the player's character
    s = "1: Warrior\nA powerful melee soldier, the Warrior is quick with a sword and can take quite the hit. Everthing is merely a flesh wound to this brave knight. t\n";
    s += "2: Mage\nA wise magician, strong in the ways of magic but with subpar health. His robes offer little protection against claws or steel.\n";
    s += "3: Archer\nTrained in the ways of the elves, the nimble Archer's arrows fly straight and true. Don't let him be caught by surprise, as his armor won't hold for long in a melee encounter.\n";
    s += "What is your background?: ";
    System.out.print(s);

    try {
      trade = Integer.parseInt( in.readLine() );
    }
    catch (IOException e ){
      
    }
    
    if( trade == 1 ){
      pat = new Warrior(name);
    }
    else if (trade == 2 ){
      pat = new Mage(name);
    }
    else{
      pat = new Archer(name);
    }
    
    s = "Intrepid protagonist, what doth thy call thyself? (State your name): ";
    System.out.print( s );

    //input for name
    try {
	    name = in.readLine();
      if( name.equals("Gandalf") ){
      System.out.println("\nGood choice");
    }
    }
    catch ( IOException e ) {
      System.out.println("An error has occured, plz try again.");
    }

  }//end newGame()


  /*=============================================
    boolean playTurn -- simulates a round of combat
    pre:  Protagonist pat has been initialized
    post: Returns true if player wins (monster dies).
    Returns false if monster wins (player dies).
    =============================================*/
  public boolean playTurn() {
    int i = 1;
    int d1, d2;

    if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );

      else {
	    System.out.println( "\nLo, yonder monster approacheth!" );


      int type = (int) (Math.random() * 3);
      String monsterType = "";

      if( type == 0){
        smaug = new Goblin();
        monsterType = "Goblin";
      }
      if( type == 1){
        smaug = new Orc();
        monsterType = "Orc";
      }
      if( type == 2){
        smaug = new Ogre();
        monsterType = "Orc";
      }

	    while( smaug.isAlive() && pat.isAlive() ) {

        // Give user the option of using a special attack:
        // If you land a hit, you incur greater damage,
        // ...but if you get hit, you take more damage.
        try {
          System.out.println( "\nDo you feel lucky?" );
          System.out.println( "\t1: Nay.\n\t2: Aye!" );
          i = Integer.parseInt( in.readLine() );
        }
        catch ( IOException e ) {
          System.out.println("An error has occured, plz try again.");
        }

        if ( i == 2 )
          pat.specialize();
        else
          pat.normalize();

        d1 = pat.attack( smaug );
        d2 = smaug.attack( pat );

        System.out.println( "\n" + name + " dealt " + d1 +
                            " points of damage.");

        System.out.println( "\n" + "Ye Olde " + monsterType + " smacked " + name + " for " + d2 + " points of damage.");
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
        System.out.println( "'Twas an epic battle, to be sure... " +
                            "You cut ye olde " + monsterType + " down, but " +
                            "with its dying breath ye olde " + monsterType + "laid a fatal blow upon thy skull." );
        return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
        System.out.println( "HuzzaaH! Ye olde " + monsterType + " hath been slain!" );
        return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
        System.out.println( "Ye olde self hath expired. You got dead." );
        return false;
	    }
    }//end else

    return true;
  }//end playTurn()
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  public static void main( String[] args ) {
    //As usual, move the begin-comment bar down as you progressively
    //test each new bit of functionality...
    //loading...
    YoRPG game = new YoRPG();

    int encounters = 0;

    while( encounters < MAX_ENCOUNTERS ) {
      if ( !game.playTurn() ){
        break;
      }
      encounters++;
      System.out.println();
    }

    System.out.println( "Thy game doth be over." );
    /*================================================
	  ================================================*/
  }//end main

}//end class YoRPG
