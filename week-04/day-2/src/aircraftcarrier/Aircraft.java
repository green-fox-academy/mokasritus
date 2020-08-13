package aircraftcarrier;

//Create a class that represents an aircraft
//There are 2 types of aircrafts: F16 and F35
//Both aircrafts should keep track of their ammunition
//All aircrafts should be created with an empty ammo storage

public class Aircraft {
  protected int ammo;
  protected int baseDamage;
  private int allDamage;
  protected int maxAmmo;

  public Aircraft() {
    this.ammo = 0;
    this.baseDamage = baseDamage;
    this.allDamage = allDamage;
    this.maxAmmo = maxAmmo;
  }

  //fight
  //It should use all the ammo (set it to 0)
  //and it should return the damage it deals
  //The damage dealt is calculated by multiplying
  //the base damage by the ammunition

  public int fight() {
    allDamage = baseDamage * ammo;
    ammo = 0;
    return allDamage;
  }

  public int refill(int forRefill) {
    return forRefill = forRefill - (maxAmmo - ammo);
  }

  public String getType() {
    return getClass().getName();
  }

  public String getStatus() {
    return "Type " + getType() + ", Ammo: " + ammo + ", Base Damage: " + baseDamage +
        ", All Damage: " + allDamage;
  }

  public boolean isPriority() {
    if (getType().equals("F35")) {
      return true;
    } else {
      return false;
    }
  }

  public int getDamage() {
    return allDamage;
  }
}
