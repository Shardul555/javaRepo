package com.MagicalArena.app;

import com.MagicalArena.app.service.MagicalArenaService;

public class MagicalArenaGame {
  public static void main(String[] args) {
    MagicalArenaService magicalArenaService = new MagicalArenaService();
    magicalArenaService.processGameInputs();
  }
}