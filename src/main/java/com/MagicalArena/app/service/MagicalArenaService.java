package com.MagicalArena.app.service;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.MagicalArena.app.data.PlayerInformation;


public class MagicalArenaService {
  List<PlayerInformation> playerInformationList;
  public MagicalArenaService() {
    playerInformationList = new ArrayList<>();
    for (int i = 0; i < 2; i++) {
      playerInformationList.add(new PlayerInformation());
    }
  }
  public void processGameInputs() {
    ProcessInputService processInputService = new ProcessInputService();
    processInputService.processInputString(playerInformationList);
    processInputService.processInputIntegers(playerInformationList);
    playGame();
  }

  private void playGame() {
    Random rand = new Random();
    List<PlayerInformation> playersList = getAttackerAndDefender();
    PlayerInformation attacker = playersList.get(0);
    PlayerInformation defender = playersList.get(1);
    while (attacker.getHealth() > 0 && defender.getHealth() > 0) {
      int attackDice = rand.nextInt(1, 7);
      int defendDice = rand.nextInt(1, 7);
      int finalHealth = defender.getHealth() + min(0, defendDice * defender.getStrength() - attackDice * attacker.getAttack()); //take minimum with 0 as health cannot be increased in this operation
      defender.setHealth(finalHealth);
      PlayerInformation nextDefender = attacker;
      attacker = defender;
      defender = nextDefender;
    }
    if (attacker.getHealth() <= 0) {
      DisplayManager.displayResults(defender.getName());
    } else {
      DisplayManager.displayResults(attacker.getName());
    }
  }

  private List<PlayerInformation> getAttackerAndDefender() {
    int attackIndex = -1;  //index of attacking player
    int defendIndex = -1; //index of defending player
    Random rand = new Random();
    if (playerInformationList.get(0).getHealth() < playerInformationList.get(1).getHealth()) {
      attackIndex = 0;
      defendIndex = 1;
    } else if (playerInformationList.get(1).getHealth() < playerInformationList.get(0).getHealth()) {
      attackIndex = 1;
      defendIndex = 0;
    } else {
      int randomIndex = rand.nextInt(2); //piece of code for randomly assigning initial attacking player
      if (randomIndex == 0) {
        attackIndex = 0;
        defendIndex = 1;
      } else {
        attackIndex = 1;
        defendIndex = 0;
      }
    }
    return Arrays.asList(playerInformationList.get(attackIndex), playerInformationList.get(defendIndex));
  }

}
