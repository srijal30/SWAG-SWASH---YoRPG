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
    public static Item[] itemList = {

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

        //3 Over-Bearing Neckalace
        new Item(
            20, //health modifier
            0, //strength modifier
            10, //defense modifier
            -10, //range modifier
            "Over-Bearing Neckalace", //name
            "This neckalace will help keep you safe. Maybe a little bit too safe."  //lore
        ),

        //4 Godly Life Totem
        new Item(
            100, //health modifier
            0, //strength modifier
            0, //defense modifier
            0, //range modifier
            "Godly Life Totem", //name
            "Forged by the gods and dropped into Earth. Let's say you wont be dying for a while."  //lore
        ),

        //5 Family Picture
        new Item(
            0, //health modifier
            25, //strength modifier
            -10, //defense modifier
            0, //range modifier
            "Family Picture", //name
            "A picture of your family. While it gives you the strength to continue, lets say you drop your guard down a bit too."  //lore
        ),

        //6 Keys To Success
        new Item(
            10, //health modifier
            10, //strength modifier
            10, //defense modifier
            0, //range modifier
            "Keys To Success", //name
            "Be sure to use your keys whenever you can."  //lore
        ),

        //7 Rusty Sheild
        new Item(
            0, //health modifier
            0, //strength modifier
            10, //defense modifier
            0, //range modifier
            "Rusty Sheild", //name
            "It's clearly been through alot."  //lore
        ),

        //8 Whey Protein
        new Item(
            30, //health modifier
            25, //strength modifier
            0, //defense modifier
            0, //range modifier
            "Whey Protein", //name
            "Gains, Gains, GAINS!"  //lore
        ),

        //9 Cellphone
        new Item(
            0, //health modifier
            -5, //strength modifier
            -10, //defense modifier
            10, //range modifier
            "Cellphone", //name
            "Very Distracting"  //lore
        )
	//Good Grade
	new item(
	69,
	69,
	69,
	69,
	"Good Grade"
	"Nothing is better then a good grade"
	)
    };

    public static int itemListCount = itemList.length;

    
}
