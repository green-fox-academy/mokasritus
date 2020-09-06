package com.greenfox.foxclub.services;

import com.greenfox.foxclub.models.Drink;
import com.greenfox.foxclub.models.Food;
import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.repository.FoxRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //ezen keresztül használjuk a repot, classokat, manipulál
public class ServiceFox{
  private FoxRepository repository;

@Autowired
  public ServiceFox(FoxRepository repository) {
  this.repository=repository;
  }

  public List<Fox> getAllFoxes() {
    return repository.getFoxes();
  }



  public void addFox(Fox newFox){
    if (!checkFoxIsExist(newFox))
      repository.save(newFox);
  }

  public void chooseFoodAndDrink(String name,String food, String drink) {
    searchFoxWithName(name).setFood(Food.valueOf(food));
    searchFoxWithName(name).setDrink(Drink.valueOf(drink));
    //enum értékének beállítása, DE a food-nak pontosan egyeznie kell az enum egyik értékével
  }

  public Fox searchFoxWithName(String name) {
      return repository.findFoxByName(name);
  }


  public Boolean checkFoxIsExist(Fox newFox) {
    return getAllFoxes().stream().anyMatch(fox -> fox.getName().equals(newFox.getName()));
  }



}
