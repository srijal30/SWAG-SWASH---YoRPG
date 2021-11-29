public class Ogre extends Monster{

  public Ogre(int distance){
    super(distance);

    health =  60 + (int) (Math.random() * 20);
    strength = 15 + (int) (Math.random() * 5);
    defense = 5 + (int) (Math.random() * 5);

    type = "Ogre";

    lootMultiplier = 3;
  }

  public static String about(){
    return ". Experts recommend that you run away in the opposite direction. Ogres are massive creatures, built like a tank. If you proceed, you are a brave one indeed!";
  }

}
