public class Monster {
    
    //Instance Vars
    private int health = 50;
    private int maxDamage = 20;

    //Check if alive
    public boolean isAlive(){
        return health > 0; 
    }

    //Damage giveth
    public int attack (Protagonist player){
        int damage = (int) (Math.random() * maxDamage);
        player.takeDamage(damage);
        return damage;
    }
    //Damage taketh
    public void takeDamage( int damage){
        health -= damage;
    }


    public String toString(){
        return "Health: " + Integer.toString(health);
    }
}
