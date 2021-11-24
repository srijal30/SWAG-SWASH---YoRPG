public class Ogre extends Monster{

  public Ogre(){
    health =  60 + (int) (Math.random() * 20);
    strength = 15 + (int) (Math.random() * 5);
    defense = 15 + (int) (Math.random() * 5);
  }


}