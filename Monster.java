public class Monster extends Character {
    public Monster(){
      setHealth( 40 + (int) (Math.random() * 30)) ; 
      setStrength( 25 + (int) (Math.random() * 10)) ;
      setDefense( 10 + (int) (Math.random() * 5)) ;
    }
  }
  