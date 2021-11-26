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
  public final static int MAX_ENCOUNTERS = 20;

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
    void playAttack() -- Does an attack turn
    pre: there exists a pat and a smaug. They are both alive.
    post: damage is done to pat and smaug
    =============================================*/
  public void playAttack(){
    int d1, d2;
    int option = 0;
    
    //If player wants to specialize or normalize
    System.out.println( "\nSpecial Attack: " );
    System.out.println( "\t1: Nay.\n\t2: Aye!\n");
    System.out.print("Do you feel lucky?: ");
    //input for specialize or normalize
    try {
      option = Integer.parseInt( in.readLine() );
    }
    catch ( IOException e ) {
      System.out.println("An error has occured, plz try again.");
    }
    //conduct normalize or specialeze
    if ( option == 2 ){
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
    System.out.println( "\n" + "Ye Olde " + smaug.getType() + " smacked " + pat.getName() + " for " + d2 + " points of damage.");
  }

  /*=============================================
    boolean battlePhase() -- Simulates a battle
    pre: there exists a pat and a smaug. They are both alive.
    post: returns wheter the game continues or nto
    =============================================*/
  public void playTurn(){
    int choice = 0; //choice for battle option
    int f2; //calculate damage done when flee attempt fails

    //Options for what the user can do: approach, attack, retreat
    System.out.println("\nChoose Your Action:");
    System.out.println("\t1: Attack!");
    System.out.println("\t2: Approach the beast");
    System.out.println("\t3: Flee, coward!");
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
      this.playAttack();
    } 

    // Choice 2: approach the monster, need to add a restriction that you cant be <1 meters from the monster. Also monster should be able to attack if in range
    else if (choice == 2) {
        smaug.move(-5);
        System.out.println("The beast is now " + smaug.getDistance() + " meters away");
    } 

    //Choice 3: flee. 25% chance at getting away using Math.random
    else if (choice ==3) {
      double chance = Math.random();

      if (chance > 0.75) {
        System.out.println("You have escaped!");
        smaug.destroy();
      } 
      else {
        System.out.println("The " + smaug.getType() + " has pursued you! Fight now or die!");
        f2 = smaug.attack(pat);
        System.out.println( "\n" + "Ye Olde " + smaug.getType() + " smacked " + pat.getName() + " for " + f2 + " points of damage.");
      }
    }
  }

  /*=============================================
    void spawnMonster -- spawns a Monster
    pre:  
    post: Creates a monster of type Ogre, Orc, or Goblin and sets it as smaug
    =============================================*/
  public void spawnMonster(){
    System.out.println( "\nLo, yonder monster approacheth!" );

    // DRIVER MODS: Spawn a Monster
    int distance = (int)(Math.random() * 20); //will be useful later
    int type = (int) (Math.random() * 3);
    String monsterType = "";
    String monsterInfo = "";
    if( type == 0){
      smaug = new Ogre( distance );
      monsterType = "Ogre";
      monsterInfo = Ogre.about();
    }
    else if( type == 1){
      smaug = new Orc( distance );
      monsterType = "Orc";
      monsterInfo = Orc.about();
    }
    else{
      smaug = new Goblin( distance );
      monsterType = "Goblin";
      monsterInfo = Goblin.about();
      System.out.println("It seems you have encountered the " + monsterType + ". It is " + distance + " meters away" + monsterInfo);
    }
  }

  /*=============================================
  void itemPickup -- does stuff with item dropped
  pre: smaug drops an item 
  post: either pick up item or no
  =============================================*/
  public void itemPickup(Item droppedItem){
    System.out.println("\nThe " + smaug.getType() + " has dropped a " + droppedItem.getName());    
    System.out.println("\nWhat to Do: ");
    System.out.println("\t1: Attempt to pick up the item\n" +
                       "\t2: Learn more about the item\n" +
                       "\t3: Ignore the item\n");
    
    System.out.print("How to procced?: ");
    int response = 0;
    //input
    try{
      response = Integer.parseInt( in.readLine() );
    }
    catch(IOException ie){}
    //attempt to pick up item
    if( response == 1 ){
      boolean result = pat.addItem(droppedItem);
      int option = 0;
      if(!result){
        System.out.println("\nRemove an Item:\n\t1: Yes\n\t2: No\n");
        System.out.print("Which item will the hero remove?: ");
        try{
          option = Integer.parseInt( in.readLine() );
        } catch (IOException e){}
        if( option == 1){
          System.out.println( pat.getItemList() );
          
          int itemDropChoice = 0;
          try{
            itemDropChoice = Integer.parseInt( in.readLine() );
          } catch (IOException e){}
          
          boolean worked = pat.dropItem( itemDropChoice - 1);
          //until valid index returned
          while( !worked ){
            System.out.print("\nNot a valid input! Try again: ");
            try{
              itemDropChoice = Integer.parseInt( in.readLine() );
            } catch (IOException e){}
            worked = pat.dropItem( itemDropChoice -1);
          }

          System.out.println("\nYou have succesfully replaced an item in your bag with " + droppedItem.getName());
        }
      }
    }//end of attempt
    //learn more about item
    else if( response == 2){
      System.out.println( "\nItem Name: " + droppedItem.getName() + "\nItem Lore: " + droppedItem.getLore() );
      this.itemPickup( droppedItem );
    }
  }

  /*=============================================
    boolean playTurn -- simulates a round of combat
    pre:  Protagonist pat has been initialized
    post: Returns true if player wins (monster dies).
    Returns false if monster wins (player dies).
    =============================================*/
  public boolean playRound() {

    System.out.println("==================================================================================================="); //barrier

    //checks to see if monster spawns, if not continue to next floor
    if ( Math.random() >= ( difficulty / 3.0 ) ) {
	    System.out.println( "\nPhew! There were no monsters in this floor, let's continue to the next." );
      return true;
    }
    
    //spawns monster
    else {
      this.spawnMonster();
    }

    //continue playing rounds until either pat or smaug dies
    while( smaug.isAlive() && pat.isAlive() ) {
      this.playTurn();
    }

    ///Things that happen after the fight:
	  //option 1: you & the monster perish
	  if ( !smaug.isAlive() && !pat.isAlive() ) {
      System.out.println( "'Twas an epic battle, to be sure... " +
                          "You cut ye olde " + smaug.getType() + " down, but " +
                          "with its dying breath ye olde " + smaug.getType() + " laid a fatal blow upon thy skull." );
      return false;
	  }

	  //option 2: you slay the beast
	  else if ( !smaug.isAlive() ) {
      System.out.println( "HuzzaaH! Ye olde " + smaug.getType() + " hath been slain!" );
      
      //Item and Gold functionality:

      //Returns if item if it is dropped, else null. Also gold is given.
      Item droppedItem = smaug.droppedLoot( pat );

      //Checks if item is dropped
      if( droppedItem == null ){
        System.out.println("\nThe " + smaug.getType() + " didn't drop anything else.");
      }
      else{
        this.itemPickup(droppedItem);
      }
      
      return true;
	  }

	  //option 3: the beast slays you
	  else if ( !pat.isAlive() ) {
      System.out.println( "Ye olde self hath expired. You got dead." );
      return false;
	  }

    return true;
  }//end playTurn()


  public static void main( String[] args ) {
    
    //loading...
    YoRPG game = new YoRPG();

    int encounters = 0;

    //maybe make it infinite
    while( encounters < MAX_ENCOUNTERS ) {
      if ( !game.playRound() ){
        break;
      }
      encounters++;
      System.out.println();
    }

    System.out.println( "\nThy game doth be over. Your score: " + encounters);
    /*================================================
	  ================================================*/
  }//end main

}//end class YoRPG
