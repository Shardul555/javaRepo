package main.java.com.MagicalArena.app.service;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.java.com.MagicalArena.app.data.PlayerInformation;

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
    boolean flag = true;  //simulataneous chances of players
    Random rand = new Random();
    int startPos = -1;  //index of attacking player
    int followUpPos = -1; //index of attacking player
    if (playerInformationList.get(0).getHealth() < playerInformationList.get(1).getHealth()) {
      startPos = 0;
      followUpPos = 1;
    } else if (playerInformationList.get(1).getHealth() < playerInformationList.get(0).getHealth()) {
      startPos = 1;
      followUpPos = 0;
    } else {
      int randomIndex = rand.nextInt(2); //piece of code for randomly assigning initial attacking player
      if (randomIndex == 0) {
        startPos = 0;
        followUpPos = 1;
      } else {
        startPos = 1;
        followUpPos = 0;
      }
    }

    while (playerInformationList.get(startPos).getHealth() > 0 && playerInformationList.get(followUpPos).getHealth() > 0) {
      int attackDice = rand.nextInt(1, 7);
      int defendDice = rand.nextInt(1, 7);
      if (flag) {
        int finalHealth = playerInformationList.get(followUpPos).getHealth() + min(0, defendDice * playerInformationList.get(followUpPos).getStrength() - attackDice * playerInformationList.get(startPos).getAttack());
        playerInformationList.get(followUpPos).setHealth(finalHealth);
        flag = false;
      } else {
        int finalHealth = playerInformationList.get(startPos).getHealth() + min(0, defendDice * playerInformationList.get(startPos).getStrength() - attackDice * playerInformationList.get(followUpPos).getAttack());
        playerInformationList.get(startPos).setHealth(finalHealth);
        flag = true;
      }
    }

    if (playerInformationList.get(startPos).getHealth() <= 0) {
      System.out.println(playerInformationList.get(followUpPos).getName() + " has won the game");
    } else {
      System.out.println(playerInformationList.get(startPos).getName() + " has won the game");
    }
  }

}
