public class Protagonist extends Character {
    
    //INSTANCE VARS
    protected String name;

    private int purse = 0;

    protected int maxItemCount = 3; //each class has diff item count? Maybe level system?
    private int itemCount = 0;
    private Item[] itemBag = new Item[3];

    //Constructor with name
    public Protagonist(String name){
        this.name = name;
    }

    //Methods

    //Accesor Methods
    public String getName(){
        return name;
    }
    public int getPurse(){
        return purse;
    }
    public String getItemList(){
        String result = "Item List: ";
        result += "\n\t1: " + itemBag[0].getName();
        result += "\n\t2: " + itemBag[1].getName();
        result += "\n\t3: " + itemBag[2].getName();

        return result;
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

    //Attempts to add item. True if works and false if it doesnt work.
    public boolean addItem( Item itm ){
        if( itemCount > maxItemCount-1){
            System.out.println("\nYour item bag is full!");
            return false;
        }

        //we use Math.max to make sure it doesnt go below 0
        itemBag[itemCount] = itm;
        itemCount++;

        health = Math.max( health + itm.getHealthMod(), 1);
        strength = Math.max( strength + itm.getStrengthMod(), 0);
        defense = Math.max( defense + itm.getDefenseMod(), 0);
        range = Math.max( range + itm.getRangeMod(), 0);

        System.out.println("\nSuccesfully added " + itm.getName() + " to your item bag!");
        return true;
    }

    //Drop item
    public boolean dropItem(int index){
        if( index > 2 || index < 0) return false;
        Item itm = itemBag[index];
        itemBag[index] = null;
        itemCount--;

        health = Math.max( health - itm.getHealthMod(), 1);
        strength = Math.max( strength - itm.getStrengthMod(), 0);
        defense = Math.max( defense - itm.getDefenseMod(), 0);
        range = Math.max( range - itm.getRangeMod(), 0);

        return true;
    }


    //Gives gold to player
    public void changePurse(int amount){
        purse += amount;
        
        if(amount >= 0) System.out.println("\nYou have received " + amount + " gold!" );
        else System.out.println("\nYou have lost " + Math.abs(amount) + " gold!" );
    }

}
