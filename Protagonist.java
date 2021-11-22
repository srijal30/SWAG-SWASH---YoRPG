public class Protagonist {
    
    //INSTANCE VARS
    private String name;

    private int health = 100;
    private int maxDamage = 15;
    private int multiplier = 1; //How much extra damage taketh/giveth


    //Constructor with name
    public Protagonist( String name ){
        this.name = name;       
    }


    //Methods
    //Check if alive
    public boolean isAlive(){
        return health > 0;
    }

    //How much damage giveth
    public int attack( Monster mons ){
        int damage = (int) (Math.random() * maxDamage * multiplier);
        mons.takeDamage( damage );
        return damage; 
    }
    //How much damage taketh
    public void takeDamage( int damage ){
        health -= damage;
    }


    //Accesor Methods
    public String getName(){
        return name;
    }

    //Used when protag feels lucky
    public void specialize(){
        multiplier = 2;
    }
    //Used when protag doesnt feel lucky
    public void normalize(){
        multiplier = 
        1;
    }

    public String toString(){
        return "Name: " + name + "\n" +
               "Health: " + Integer.toString(health) + "\n" +
               "Multiplier: " + Integer.toString(multiplier);

    }
}
