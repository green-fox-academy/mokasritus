package aircraftcarrier;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
  private List<Aircraft> aircrafts;
  private int storeOfAmmo;
  private int healthPoint;

  public Carrier(int storeOfAmmo, int healthPoint) {
    aircrafts = new ArrayList<>();
    this.storeOfAmmo = storeOfAmmo;
    this.healthPoint = healthPoint;
  }

  public void addNewAircraft(Aircraft aircraft) {
    aircrafts.add(aircraft);
  }

  public void fill() throws Exception {
    int sumNeededAmmo = 0;
    for (Aircraft aircraft : aircrafts) {
      sumNeededAmmo += aircraft.maxAmmo - aircraft.ammo;
    }
    if (storeOfAmmo > sumNeededAmmo) {
      for (Aircraft aircraft : aircrafts) {
        aircraft.ammo += aircraft.maxAmmo - aircraft.ammo;
        storeOfAmmo -= aircraft.refill(storeOfAmmo);
      }
    } else if (storeOfAmmo < sumNeededAmmo) {
      for (Aircraft aircraft : aircrafts) {
        if (aircraft.isPriority()) {
          aircraft.ammo += aircraft.maxAmmo - aircraft.ammo;
          storeOfAmmo -= aircraft.refill(storeOfAmmo);
        } else if (storeOfAmmo == 0) {
          throw new Exception("There is no Ammo");
        }
      }
    }
  }

  public void fight(Carrier refereceCarrier) {
    int sumAllDamage = 0;
    for (Aircraft aircraft : aircrafts) {
      sumAllDamage += aircraft.fight();
    }
    refereceCarrier.healthPoint -= sumAllDamage;
    if (healthPoint == 0) {
      System.out.println("It's dead Jim :(");
    }
  }

  private int getSumAllDamage() {
    int sumAllDamage = 0;
    for (Aircraft aircraft : aircrafts) {
      sumAllDamage += aircraft.getDamage();
    }
    return sumAllDamage;
  }

  public int sumAmmoInCarrier() {
    int sumAmmoInAircrafts = 0;
    for (Aircraft aircraft : aircrafts) {
      sumAmmoInAircrafts += aircraft.ammo;
    }
    return sumAmmoInAircrafts;
  }

  public String getStatus() {
    String status =
        "HP: " + healthPoint + ", Aircraft count: " + aircrafts.size() + ", Ammo Storage: " +
            storeOfAmmo + ", Total Damage: " + getSumAllDamage() + '\n' + "Aircrafts:";
    for (Aircraft aircraft : aircrafts) {
      status += '\n';
      status = status.concat(aircraft.getStatus());
    }
    return status;
  }
}
