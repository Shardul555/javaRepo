# Magical Arena Game

* Conditions of Game
    * Every Player is defined by a “health” attribute, “strength” attribute and an “attack” attribute - all positive integers. The player dies if his health attribute touches 0. 
    * Any two player can fight a match in the arena. Players attack in turns. Attacking player rolls the attacking dice and the defending player rolls the defending dice. The “attack”  value multiplied by the outcome of the  attacking dice roll is the damage created by the attacker. The defender “strength” value, multiplied by the outcome of the defending dice is the damage defended by the defender. Whatever damage created by attacker which is in excess of the damage defended by the defender will reduce the “health” of the defender. Game ends when any players health reaches 0
    * Player with lower health attacks first at the start of a match. 
    * ADDED CONDITIONS:
      * IMPORTANT: User will give input themselves for all the attributes along with one "name" attribute which will be their userName, also other attributes should be POSITIVE integers only for current implementation, this condition can change with requirements.
      * In case of same health of both user, user to attack first is randomly selected with equal probability.