public class Goblin extends Monster{

    public Goblin(){
      
      health =  30 + (int) (Math.random() * 20);
      strength = 17 + (int) (Math.random() * 5); //hard to catch = high defense
      defense = 4 + (int) (Math.random() * 5);
    }
  
    public static String about(){
      return ". Prooced with caution, the goblin is a sneaky theif, they do love their gold. Be careful to not underestimate them, for it will cause your doom.";
    }
  
  }
