package com.MagicalArena.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.MagicalArena.app.data.PlayerInformation;


public class ProcessInputServiceTest {
  private ProcessInputService processInputService;
  private List<PlayerInformation> playerInformationList;

  @BeforeEach
  public void setUp() {
    processInputService = spy(new ProcessInputService());
    playerInformationList = new ArrayList<>();
    playerInformationList.add(new PlayerInformation());
    playerInformationList.add(new PlayerInformation());
  }

  @Test
  public void testInputString() {
    String input = "Player1\nPlayer2";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    processInputService.processInputString(playerInformationList);
    assertEquals("Player1", playerInformationList.get(0).getName());
    assertEquals("Player2", playerInformationList.get(1).getName());
  }

  @Test
  public void testInputStringWithEmptyPrefix() {
    String input = "\n\nPlayer1\nPlayer2";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    processInputService.processInputString(playerInformationList);

    assertEquals("Player1", playerInformationList.get(0).getName());
    assertEquals("Player2", playerInformationList.get(1).getName());
  }

  @Test
  void processInputIntegers() {
    String input = "10\n100\n1\n10\n10\n10\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    processInputService.processInputIntegers(playerInformationList);

    assertEquals(10, playerInformationList.get(0).getHealth());
    assertEquals(100, playerInformationList.get(1).getHealth());
    assertEquals(1, playerInformationList.get(0).getStrength());
    assertEquals(10, playerInformationList.get(1).getStrength());
    assertEquals(10, playerInformationList.get(0).getAttack());
    assertEquals(10, playerInformationList.get(1).getAttack());
  }
}
