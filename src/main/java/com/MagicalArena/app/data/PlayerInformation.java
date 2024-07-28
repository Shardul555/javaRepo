package com.MagicalArena.app.data;

public class PlayerInformation {
  private String name;
  private int health;
  private int strength;
  private int attack;

  public PlayerInformation(String name, int health, int strength, int attack) {
    this.name = name;
    this.health = health;
    this.strength = strength;
    this.attack = attack;
  }

  public PlayerInformation() {
  }

  public void setName(String name) {
    this.name = name;
  }
  public void setHealth(int health) {
    this.health = health;
  }
  public void setStrength(int strength) {
    this.strength = strength;
  }
  public void setAttack(int attack) {
    this.attack = attack;
  }
  public String getName() {
    return name;
  }
  public int getHealth() {
    return health;
  }
  public int getStrength() {
    return strength;
  }
  public int getAttack() {
    return attack;
  }
}
