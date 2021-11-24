public class Orc extends Monster{

  public Orc(){
    health =  40 + (int) (Math.random() * 20);
    strength = 25 + (int) (Math.random() * 5);
    defense = 15 + (int) (Math.random() * 5);
  }
}
