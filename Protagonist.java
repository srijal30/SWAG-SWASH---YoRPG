public class Protagonist extends Character {
    
    //INSTANCE VARS
    private String name;

    //Constructor with name
    public Protagonist( String name ){
        this.name = name;
        setHealth( 100 );
        setStrength( 25 );
        setDefense( 20 );       
    }


    //Methods

    //Accesor Methods
    public String getName(){
        return name;
    }

    //Function Methods
    
    //Used when protag feels lucky
    public void specialize(){
        setAttackRating(2);
        setDefense( getDefense()/2 );
    }
    //Used when protag doesnt feel lucky
    public void normalize(){
        setAttackRating(1);
        setDefense( getDefense()*2 );
    }

}
