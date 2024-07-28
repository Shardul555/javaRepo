package com.MagicalArena.app;

import com.MagicalArena.app.service.MagicalArenaController;

public class MagicalArenaGame {
  public static void main(String[] args) {
    MagicalArenaController magicalArenaController = new MagicalArenaController();
    magicalArenaController.processGameInputs();
  }
}