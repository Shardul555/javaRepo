package com.MagicalArena.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.MagicalArena.app.data.PlayerInformation;


public class MagicalArenaController {
  List<PlayerInformation> playerInformationList;
  ProcessInputService processInputService;
  int numOfPlayers;
  public MagicalArenaController() {
    processInputService = new ProcessInputService();
    playerInformationList = new ArrayList<>();
    numOfPlayers = 2;
    for (int i = 0; i < numOfPlayers; i++) {
      playerInformationList.add(new PlayerInformation());
    }
  }
  public String processGameInputs() {
    MagicalArenaService magicalArenaService = new MagicalArenaService();
    processInputService.processInputString(playerInformationList);
    processInputService.processInputIntegers(playerInformationList);
    return magicalArenaService.simulateGame(playerInformationList);
  }
}
