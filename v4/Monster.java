public class Monster extends Character {
  
  protected int lootMultiplier;
  protected String type;

  //should distance be public or private?
  private int distance; //not sure if distance is the best approach... we should do coord plane

  public Monster(int distance){
    this.distance = distance;
    
  }

  //ACCESORS
  public String getType(){
    return type;
  }
  public int getDistance(){
    return distance;
  }
  
  //FUNCTIONALITY
  
  //destroy the monster
  public void destroy(){
    health -= health;
  }

  //the monster moving (might have to add this to )
  public void move(int travelDistance){
    distance += travelDistance;
  }

  //When monster dies, the drops are calclulated
  public Item droppedLoot(Protagonist pro){
    //gold drop
    int goldDropped = (int) (Math.random() * lootMultiplier * 10) + 1;
    pro.changePurse( goldDropped );
    //is item dropped check
    boolean itemDrop = 8 > (int) (Math.random() * 10 + lootMultiplier);
    //what do if dropped
    if(itemDrop){
      int itemIndex = (int) (Math.random() * Item.itemListCount);
      return Item.itemList[itemIndex];
    }
    //if not dropped, return null
    return null;
  }


}
