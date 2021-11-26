public class Protagonist extends Character {
    
    //INSTANCE VARS
    protected String name;

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

}
