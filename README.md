# SWAG-SWASH---YoRPG: Salaj Rijal, Michael Kamela, Ariel Fuchs
Latest Version with no extra features: 2

Latest Version: 4

Based. 

## New Classes:

### Character
All characters. 

**Contains vars:**
* health
* strength
* defense
* attackRating

**Contains methods:**
* getDefense(): returns the defense stat.
* isAlive(): returns true if character is alive, else false.
* attack( Character ): calculates damage done, applies damage to character given, returns damage.
* lowerHP( int ): lowers health by the damage given.

### Protagonist
A player character, the protagonist. 

**Contains var:**
* name

**Contains methods:**
* getName(): returns name of protagonist.
* specialize(): multiples attackRating by 2, but divides defense by 2.
* normalize(): divides attackRating by 2, defense multiplies by 2.

#### Archer
You should not choose to be an archer, they are cowards.
* Medium Health
* Medium Strength
* Low Defense

#### Mage
This class is respectable, and if you choose your name wisely you shall be rewarded.
* Medium Health
* High Strength
* Low Defense

#### Warrior
You shall be rewarded for your bravery.
* High Health
* Medium Strength
* High Defense

### Monster
For nonplayer characters, the enemy of the player.

#### Goblin
Weakest monster.
* Low Health
* Low Strength
* Low Defense

#### Orc
Medium tier monster.
* Medium Health
* High Strength
* Medium Defense

#### Ogre
Arguably the strongest monster.
* High Health
* Medium Strength
* Medium Defense

## Modification Timeline

### v0
Made YoRPG compilable by adding classes Monster and Protagonist.

### v1
Made superclass Character, which the classes Monster and Protaginist stem from. This was becasue
similar vars and methods were in both Monster and Protaginist.

### v2
Further diversified classes by adding 3 new Monsters and 3 new Protaginists. Each subclass has different stats, promoting different playstyles. This is the version that has no extra features other than the ones we were required to add.

### v3
Added ability to choose what to do during battle (attack, flee, or approach).


**--Work in Progress Versions--**

### v4
Started work on items.

### v5
Started working on movemnet and range system.

## Future Hopes

* Range System --adding
* Linear Movement Mechanic --adding
* Add Items --adding
* Different Options During Battle --added
* Multiplayer
* Graphics
* Shop and Economy
