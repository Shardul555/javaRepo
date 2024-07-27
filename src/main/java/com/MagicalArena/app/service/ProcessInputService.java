package main.java.com.MagicalArena.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.MagicalArena.app.data.PlayerInformation;

public class ProcessInputService {

  public ProcessInputService() {
  }

  public void processInputString(List <PlayerInformation> playerInformationList) {
    String inputName;
    int input = 0;
    Scanner scn = new Scanner(System.in);
    while (input < 2) {
      System.out.println("Please enter name of player " + (input + 1) + " :");
      inputName = scn.nextLine();
      if (inputName.isEmpty()) {
        System.out.println("Error: Please enter a non-empty name, Try Again");
      } else {
        playerInformationList.get(input).setName(inputName);
        input++;
      }
    }
  }

  public void processInputIntegers(List <PlayerInformation> playerInformationList) {
    Scanner scn = new Scanner(System.in);
    System.out.println("Enter health of first player: ");
    playerInformationList.get(0).setHealth(scn.nextInt());
    System.out.println("Enter health of second player: ");
    playerInformationList.get(1).setHealth(scn.nextInt());
    System.out.println("Enter strength of first player: ");
    playerInformationList.get(0).setStrength(scn.nextInt());
    System.out.println("Enter strength of second player: ");
    playerInformationList.get(1).setStrength(scn.nextInt());
    System.out.println("Enter attack of first player: ");
    playerInformationList.get(0).setAttack(scn.nextInt());
    System.out.println("Enter attack of second player: ");
    playerInformationList.get(0).setAttack(scn.nextInt());
  }
}
