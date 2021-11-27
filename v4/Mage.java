public class Mage extends Protagonist {

    public Mage(String name){

      super(name);

      health = 69; //nice
      strength = 15;
      defense = 20;
      range = 20;


      
       //Gandalf OP Easter Egg
      if( name.equals("Gandalf") ){
        System.out.println("\nSICKO MODE ACTIVATED");
        health = 690; //Very nice
        strength = 100;
        defense = 0; //Gandalf doesnt need defense, he can tank anything
      }
    }

    /*
    public void CastSpell(double s){
      double spell;
      spell = Math.random();
      if(spell < 0.4){
        health = health + 10;
      }
    }*/

    public static String about(){
      return "A wise magician, strong in the ways of magic but with subpar defense. His robes offer little protection against claws or steel.";
    }
  }
