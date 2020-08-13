package aircraftcarrier;

public class F16 extends Aircraft{

  public F16(){
    baseDamage = 30;
    maxAmmo = 8;
  }
  @Override
  public String getType() {
    return "F16";
  }
}
