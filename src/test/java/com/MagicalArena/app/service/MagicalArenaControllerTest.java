package com.MagicalArena.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class MagicalArenaControllerTest {
  @Test
  void processGameInputsforUnequalHealth() {
    MagicalArenaController magicalArenaController = spy(new MagicalArenaController());
    magicalArenaController.processInputService = mock(ProcessInputService.class);
    magicalArenaController.playerInformationList.get(0).setName("player1");
    magicalArenaController.playerInformationList.get(1).setName("player2");
    magicalArenaController.playerInformationList.get(0).setHealth(100);
    magicalArenaController.playerInformationList.get(1).setHealth(10);
    magicalArenaController.playerInformationList.get(0).setStrength(10);
    magicalArenaController.playerInformationList.get(1).setStrength(10);
    magicalArenaController.playerInformationList.get(0).setAttack(10);
    magicalArenaController.playerInformationList.get(1).setAttack(10);
    Random random = mock(Random.class);
    when(random.nextInt(1, 7)).thenReturn(1);
    doNothing().when(magicalArenaController.processInputService).processInputString(magicalArenaController.playerInformationList);
    doNothing().when(magicalArenaController.processInputService).processInputIntegers(magicalArenaController.playerInformationList);
    assertEquals(magicalArenaController.processGameInputs(), "player1");
  }

  @Test
  void processGameInputsRandomIndexas0() {
    MagicalArenaController magicalArenaController = spy(new MagicalArenaController());
    magicalArenaController.processInputService = mock(ProcessInputService.class);
    magicalArenaController.playerInformationList.get(0).setName("player1");
    magicalArenaController.playerInformationList.get(1).setName("player2");
    magicalArenaController.playerInformationList.get(0).setHealth(100);
    magicalArenaController.playerInformationList.get(1).setHealth(100);
    magicalArenaController.playerInformationList.get(0).setStrength(11);
    magicalArenaController.playerInformationList.get(1).setStrength(100);
    magicalArenaController.playerInformationList.get(0).setAttack(10);
    magicalArenaController.playerInformationList.get(1).setAttack(110);
    Random random = mock(Random.class);
    when(random.nextInt(1, 7)).thenReturn(1);
    when(random.nextInt(2)).thenReturn(0);
    doNothing().when(magicalArenaController.processInputService).processInputString(magicalArenaController.playerInformationList);
    doNothing().when(magicalArenaController.processInputService).processInputIntegers(magicalArenaController.playerInformationList);
    magicalArenaController.processGameInputs();
    assertEquals(magicalArenaController.processGameInputs(), "player2");
  }

  @Test
  void processGameInputsforRandomIndex1() {
    MagicalArenaController magicalArenaController = spy(new MagicalArenaController());
    magicalArenaController.processInputService = mock(ProcessInputService.class);
    magicalArenaController.playerInformationList.get(0).setName("player1");
    magicalArenaController.playerInformationList.get(1).setName("player2");
    magicalArenaController.playerInformationList.get(0).setHealth(100);
    magicalArenaController.playerInformationList.get(1).setHealth(100);
    magicalArenaController.playerInformationList.get(0).setStrength(11);
    magicalArenaController.playerInformationList.get(1).setStrength(100);
    magicalArenaController.playerInformationList.get(0).setAttack(10);
    magicalArenaController.playerInformationList.get(1).setAttack(110);
    Random random = mock(Random.class);
    when(random.nextInt(1, 7)).thenReturn(1);
    when(random.nextInt(2)).thenReturn(1);
    doNothing().when(magicalArenaController.processInputService).processInputString(magicalArenaController.playerInformationList);
    doNothing().when(magicalArenaController.processInputService).processInputIntegers(magicalArenaController.playerInformationList);
    magicalArenaController.processGameInputs();
    assertEquals(magicalArenaController.processGameInputs(), "player2");
  }

}
