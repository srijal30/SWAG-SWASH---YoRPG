public class Character{
    //Instance Variables
    private int health = 100;
    private int strength = 10; //values initialized in their classes
    private int defense = 10; //values initialized in their classes
  
    private double attackRating = 1;
    
    //Methods
  
    //Accesor Methods
    //Return defense stat
    public int getDefense(){
      return defense;
    }
    //set AR
    public void setAttackRating( double rating){
      attackRating = rating;
    }
    //set health
    public void setHealth( int rating){
      attackRating = rating;
    }
    //set defense
    public void setDefense( int rating){
      attackRating = rating;
    }
    //set strength
    public void setStrength( int rating){
      attackRating = rating;
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