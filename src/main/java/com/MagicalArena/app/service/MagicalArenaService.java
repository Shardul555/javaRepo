package main.java.com.MagicalArena.app.service;

public class MagicalArenaService {
  public MagicalArenaService() {
  }
  public void processGameInputs() {
    ProcessInputService processInputService = new ProcessInputService();
    processInputService.processInputString();
    processInputService.processInputIntegers();
  }


}
