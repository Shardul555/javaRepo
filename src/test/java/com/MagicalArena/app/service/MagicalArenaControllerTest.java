package com.MagicalArena.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MagicalArenaControllerTest {
  @Test
  void processGameInputsforUnequalHealth() {
    MagicalArenaController magicalArenaController = Mockito.spy(new MagicalArenaController());
    magicalArenaController.processInputService = mock(ProcessInputService.class);
    magicalArenaController.magicalArenaService = mock(MagicalArenaService.class);
    magicalArenaController.playerInformationList.get(0).setName("player1");
    magicalArenaController.playerInformationList.get(1).setName("player2");
    magicalArenaController.playerInformationList.get(0).setHealth(100);
    magicalArenaController.playerInformationList.get(1).setHealth(10);
    magicalArenaController.playerInformationList.get(0).setStrength(10);
    magicalArenaController.playerInformationList.get(1).setStrength(10);
    magicalArenaController.playerInformationList.get(0).setAttack(10);
    magicalArenaController.playerInformationList.get(1).setAttack(10);
    doNothing().when(magicalArenaController.processInputService).processInputString(magicalArenaController.playerInformationList);
    doNothing().when(magicalArenaController.processInputService).processInputIntegers(magicalArenaController.playerInformationList);
    magicalArenaController.processGameInputs();
    assertEquals(magicalArenaController.processGameInputs(), "player1");
  }

  @Test
  void processGameInputsforEqualHealth() {
    MagicalArenaController magicalArenaController = Mockito.spy(new MagicalArenaController());
    magicalArenaController.processInputService = mock(ProcessInputService.class);
    magicalArenaController.magicalArenaService = mock(MagicalArenaService.class);
    magicalArenaController.playerInformationList.get(0).setName("player1");
    magicalArenaController.playerInformationList.get(1).setName("player2");
    magicalArenaController.playerInformationList.get(0).setHealth(100);
    magicalArenaController.playerInformationList.get(1).setHealth(100);
    magicalArenaController.playerInformationList.get(0).setStrength(11);
    magicalArenaController.playerInformationList.get(1).setStrength(100);
    magicalArenaController.playerInformationList.get(0).setAttack(10);
    magicalArenaController.playerInformationList.get(1).setAttack(110);
    doNothing().when(magicalArenaController.processInputService).processInputString(magicalArenaController.playerInformationList);
    doNothing().when(magicalArenaController.processInputService).processInputIntegers(magicalArenaController.playerInformationList);
    magicalArenaController.processGameInputs();
    assertEquals(magicalArenaController.processGameInputs(), "player2");
  }



}
