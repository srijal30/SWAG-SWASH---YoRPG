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
 *
 *
 * DRIVER MODS ARE LINES 111 and 171
 *
 *
 * DISCO:
 * You can create subclass by using "extends" keyword.
 *
 * When we extended protagonist and still only had one constructor, the
 * overloaded one, so we had to create default constuctor in protagonist and change the name from
 * the subclass instead.
 *
 * The protected keyword is very helpful becasue it allows us to access
 *
 * QCC:
 * How exactly do constructors for subclasses work?
 *
 * What is a better way to construct a subclass using an overloaded constructor?
 *
 * How can we make the game fun by balancing the classes?
 *
 * How to spice up the output? It is looking very bland at the moment.
 *
 * What is the point of moveCount and gameOver?
 *
 * How can we make about() so that it is only in a superclass.
 *
 *
 * Time: 1.2 hours + 1 hour + 2 hours = 4.2 hours
 **********************************************/

import java.io.*;
import java.util.*; //useless

public class YoRPG {

  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

  //change this constant to set number of encounters in a game
  public final static int MAX_ENCOUNTERS = 10;

  //each round, a Protagonist and a Monster will be instantiated...
  private Protagonist pat;
  private Monster smaug;

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
    moveCount = 0; //why
    gameOver = false; //why
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
    String name = "";
    String s = ""; //Screen
    int trade = 0;

    s = "~~~ Welcome to Ye Olde RPG! ~~~\n";
    s += "\nChoose your difficulty: \n";
    s += "\t1: Easy\n";
    s += "\t2: Not so easy\n";
    s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
    s += "\nSelection: ";

    System.out.print( s ); //Print Screen



    //input for difficulty
    try {
	    difficulty = Integer.parseInt( in.readLine() ); //Checks if this causes error
    }
    catch ( IOException e ) { //If error is caught
      System.out.println("An error has occured, plz try again.");
    }

    //OUR DRIVER MODS

    //instantiate the player's character

    //choose name
    s = "\nIntrepid protagonist, what doth thy call thyself? (State your name): ";
    System.out.print( s );

    try {
	    name = in.readLine();
      //If Gandalf inputed, creates an overpowerd character. This is to help testing, as it is annoying if you die before testing game.
      if( name.equals("Gandalf") ){
      System.out.println("\nGood choice");
    }
    }
    catch ( IOException e ) {
      System.out.println("An error has occured, plz try again.");
    }

    //choose class
    s = "\nChoose a Class:\n\t1: Warrior\n\t" + Warrior.about() + "\n\n\t";
    s += "2: Mage\n\t" + Mage.about() + "\n\n\t";
    s += "3: Archer\n\t" + Archer.about() + "\n\n";
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

    //warning
    s = "\nThy is about to enter the dungeon, becareful as there will be Goblins, Orcs, and Ogres.\n";
    System.out.println(s);
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
    int f2;

    System.out.println("==================================================================================================="); //barrier
    if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nPhew! There were no monsters in this floor, let's continue to the next." );

      else {
	    System.out.println( "\nLo, yonder monster approacheth!" );

      // DRIVER MODS
      int distance = (int)(Math.random() * 20);
      int type = (int) (Math.random() * 3);
      int choice = 0;
      String monsterType = "";
      String monsterInfo = "";

      if( type == 0){
        smaug = new Ogre();
        monsterType = "Ogre";
        monsterInfo = Ogre.about();
      }
      else if( type == 1){
        smaug = new Orc();
        monsterType = "Orc";
        monsterInfo = Orc.about();
      }
      else{
        smaug = new Goblin();
        monsterType = "Goblin";
        monsterInfo = Goblin.about();
      }

      System.out.println("It seems you have encountered the " + monsterType + ". It is " + distance + " meters away" + monsterInfo);

	    while( smaug.isAlive() && pat.isAlive() ) {

        //Options for what the user can do: approach, attack, retreat
        System.out.println("\nChoose Your Action:");
        System.out.println("1: Attack!");
        System.out.println("2: Approach the beast");
        System.out.println("3: Flee, coward!");
        System.out.print("\nHow will our hero proceed?: ");
        
        //Input for options
        try {
          choice = Integer.parseInt(in.readLine());
        }
        catch (IOException e){
          System.out.println("An error has occured, plz try again.");
        }

        //Attack option: working on integrating range into this, might have to do it in one of the classes if I want the monsters to be limited by range too
        if (choice == 1) {
          //If player wants to specialize or normalize
          System.out.println( "\nSpecial Attack: " );
          System.out.println( "\t1: Nay.\n\t2: Aye!\n");
          System.out.print("Do you feel lucky?: ");
          //input for specialize or normalize
          try {
            i = Integer.parseInt( in.readLine() );
          }
          catch ( IOException e ) {
            System.out.println("An error has occured, plz try again.");
          }
          //conduct normalize or specialeze
          if ( i == 2 ){
            pat.specialize();
          }
          else{
            pat.normalize();
          }
          //calculate damage
          d1 = pat.attack( smaug );
          d2 = smaug.attack( pat );
          //show damage player did
          System.out.println( "\n" + pat.getName() + " dealt " + d1 +
                              " points of damage.");
          //show damage monster did
          System.out.println( "\n" + "Ye Olde " + monsterType + " smacked " + pat.getName() + " for " + d2 + " points of damage.");
        } 

        // Choice 2: approach the monster, need to add a restriction that you cant be <1 meters from the monster. Also monster should be able to attack if in range
        else if (choice == 2) {
            distance = distance - 5;
            System.out.println("The beast is now " + distance + " meters away");
        } 

        //Choice 3: flee. 25% chance at getting away using Math.random
        else if (choice ==3) {
          double chance = Math.random();

          if (chance > 0.75) {
            System.out.println("You have escaped!");
            return true;
          } 
          else {
            System.out.println("The " + monsterType + " has pursued you! Fight now or die!");
            f2 = smaug.attack(pat);
            System.out.println( "\n" + "Ye Olde " + monsterType + " smacked " + pat.getName() + " for " + f2 + " points of damage.");
          }

        }
      
      }//end while

      ///Things that happen after the fight:

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
        System.out.println( "'Twas an epic battle, to be sure... " +
                            "You cut ye olde " + monsterType + " down, but " +
                            "with its dying breath ye olde " + monsterType + " laid a fatal blow upon thy skull." );
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


  public static void main( String[] args ) {
    
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
