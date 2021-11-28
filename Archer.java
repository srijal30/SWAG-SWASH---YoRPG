public class Archer extends Protagonist{
  
  public Archer(String name){

    super(name);
    
    //character attributes
    health = 75;
    strength = 40;
    defense = 5;
    //range = 50;

  }

  public static String about(){
    return "Trained in the ways of the elves, the nimble Archer's arrows fly straight and true. Don't let him be caught by surprise, as his armor won't hold for long in a melee encounter.";
  }
}
