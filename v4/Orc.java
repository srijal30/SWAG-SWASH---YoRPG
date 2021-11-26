public class Orc extends Monster{

    public Orc(){
      health =  40 + (int) (Math.random() * 20);
      strength = 25 + (int) (Math.random() * 5);
      defense = 15 + (int) (Math.random() * 5);
    }

    public static String about(){
      return ". Orcs are evil creatures, they seek utter destruction of all living creatures in their path for no reason. They are known for the heavy blows they give out, make sure to stay vigilant.";
    }
  }
