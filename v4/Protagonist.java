public class Protagonist extends Character {
    
    //INSTANCE VARS
    protected String name;

    protected int maxItemCount = 3; //each class has diff item count? Maybe level system?
    private int itemCount = 0;

    //Constructor with name
    public Protagonist(String name){
        this.name = name;
    }

    //Methods

    //Accesor Methods
    public String getName(){
        return name;
    }

    //Function Methods
    //Used when protag feels lucky
    public void specialize(){
        attackRating = 2;
        defense /= 2;
    }
    //Used when protag doesnt feel lucky
    public void normalize(){
        attackRating = 1;
        defense *= 2;
    }

    //Adds item if you can hold it and returns a statement saying wheter succesful or not
    public String addItem( Item itm ){
        if( itemCount >= maxItemCount){
            return "You do not have enough space for this item.";
        }

        //we use Math.max to make sure it doesnt go below 0
        health = Math.max( health + itm.getHealthMod(), 0);
        strength = Math.max( strength + itm.getStrengthMod(), 0);
        defense = Math.max( defense + itm.getDefenseMod(), 0);
        range = Math.max( range + itm.getRangeMod(), 0);

        return "You were able to succesfully add " + itm.getName() + " to your item bag.";
    }

}
