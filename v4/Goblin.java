public class Goblin extends Monster{

    //mayble goblins should be able to steal your items/gold
    
    public Goblin(int distance){
      super(distance);
      
      health =  30 + (int) (Math.random() * 20);
      strength = 17 + (int) (Math.random() * 5); //hard to catch = high defense
      defense = 4 + (int) (Math.random() * 5);

      type = "Goblin";

      lootMultiplier = 1;
    }
  
    public static String about(){
      return ". Prooced with caution, as the goblin is a sneaky theif (they do love their gold). Be careful to not underestimate it, for it will cause your doom.";
    }
  
  }
