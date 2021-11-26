//Framework for an item

public class Item {

    //Instance Vars
    private int healthModifier;
    private int strengthModifier;
    private int defenseModifier;
    private int rangeModifier;

    private String name;
    private String lore;
    

    //Only Way to Construct an ITEM
    public Item(int hp, int stren, int def, int range, String name, String lore){
        healthModifier = hp;
        strengthModifier = stren;
        defenseModifier = def;
        rangeModifier = range;

        this.name = name;
        this.lore = lore;
    }

    //METHODS
    //getter methods
    public int getHealthMod() {
        return healthModifier;
    }

    public int getStrengthMod() {
        return strengthModifier;
    }

    public int getDefenseMod() {
        return defenseModifier;
    }

    public int getRangeMod() {
        return rangeModifier;
    }

    //get name of certain item
    public String getName(){
        return name;
    }
    //get the lore of certain item
    public String getLore(){
        return lore;
    }
    //get item at specific index
    public Item getItem(int index){

        return itemList[index];

    }

    //ITEM LIST
    /*USE THIS TO HELP MAKE MORE ITEMS:
            
        //Index+Name
        new Item(
            0, //health modifier
            0, //strength modifier
            0, //defense modifier
            0, //range modifier
            "", //name
            ""  //lore
        ),
    
    */

    //List of Items
    Item[] itemList = {

        //0 Weak Locket of Life
        new Item(
            10, //health modifier
            0, //strength modifier
            0, //defense modifier
            0, //range modifier
            "Weak Locket of Life", //name
            "Made by an amateur craftsman for their school project. They probably didnt get a good grade."  //lore
        ),

        //1 Gandalf's Hat
        new Item(
            0, //health modifier
            5, //strength modifier
            0, //defense modifier
            10, //range modifier
            "Gandalf's Hat", //name
            "Defintely not a fake."  //lore
        ),

        //2 Iron Chestplate
        new Item(
            0, //health modifier
            -5, //strength modifier
            10, //defense modifier
            0, //range modifier
            "Iron Chestplate", //name
            "Made by a respectable blacksmith. While it increaes your defense, it limits your striking power."  //lore
        ),

    };

    
}
