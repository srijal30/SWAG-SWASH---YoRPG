public class Mage extends Protagonist {

  public Mage(String name){

    this.name = name;

    health = 69; //nice
    strength = 10;
    defense = 7;
    //range = 20;

    if( name.equals("Gandalf") ) {
      health = 169; //Very nice
      strength = 35;
      defense = 25;
    }
  }

  public void CastSpell(double s){
    double spell;
    spell = Math.random();
    if(spell < 0.4){
      health = health + 10;
    }
  }
}
