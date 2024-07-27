package main.java.com.MagicalArena.app;

import main.java.com.MagicalArena.app.service.MagicalArenaService;

public class MagicalArenaGame {
  public static void main(String[] args) {
    MagicalArenaService magicalArenaService = new MagicalArenaService();
    magicalArenaService.processGameInputs();
  }
}