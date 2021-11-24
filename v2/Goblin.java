public class Goblin extends Monster{

    public Goblin(){
      
      health =  30 + (int) (Math.random() * 20);
      strength = 17 + (int) (Math.random() * 5); //hard to catch = high defense
      defense = 4 + (int) (Math.random() * 5);
    }
  
  
  }