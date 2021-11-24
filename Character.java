public class Character{
  //Instance Variables
  protected int health;
  protected int strength; //values initialized in their classes
  protected int defense; //values initialized in their classes

  protected double attackRating = 1;
  
  //Methods

  //Accesor Methods
  //Return defense stat
  public int getDefense(){
    return defense;
  }

  //Functioning Methods
  //Check if alive
  public boolean isAlive(){
      return health > 0;
  }
  //How much damage giveth
  public int attack( Character opp ){
      int damage = (int) (strength * attackRating) - opp.getDefense();
      if (damage < 0){
        damage = 0;
      }
      opp.lowerHP( damage );
      return damage; 
  }
  //How much damage taketh
  public void lowerHP( int damage ){
      health -= damage;
  } 
}