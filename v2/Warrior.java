public class Warrior extends Protagonist{

  public Warrior( String name ){

    this.name = name;
    
    health = 150;
    strength = 15;
    defense = 15; 
    
    //range = 5;
  }

  public static String about(){
    return "A powerful melee soldier, the Warrior is quick with a sword and can take quite the hit. Everthing is merely a flesh wound to this brave knight.";
  }
}
