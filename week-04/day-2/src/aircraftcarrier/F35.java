package aircraftcarrier;

public class F35 extends Aircraft {

  public F35() {
    baseDamage = 50;
    maxAmmo = 12;
  }

  @Override
  public String getType() {
    return "F35";
  }
}
