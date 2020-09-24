package com.greenfox.foxclub.services;

import com.greenfox.foxclub.models.Drink;
import com.greenfox.foxclub.models.Food;
import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.models.Trick;
import com.greenfox.foxclub.repository.FoxRepository;
import com.greenfox.foxclub.repository.TrickRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //ezen keresztül használjuk a repot, classokat, manipulál
public class FoxService {
  private FoxRepository repository;
  private TrickService trickService;

@Autowired
  public FoxService(FoxRepository repository, TrickService trickService) {
  this.repository=repository;
  this.trickService=trickService;
  }

  public List<Fox> getAllFoxes() {
    return repository.findAll();
  }

  public void addFox(Fox newFox){
    if (!repository.existsFoxByName(newFox.getName()))
      repository.save(newFox);
  }

  public void chooseFoodAndDrink(String name, String food, String drink) {
  Fox fox=repository.findFoxByName(name);
    fox.setFood(Food.valueOf(food));
    fox.setDrink(Drink.valueOf(drink));
    repository.save(fox);
    //enum értékének beállítása, DE a food-nak pontosan egyeznie kell az enum egyik értékével
  }

 public void addTrick(String name, Trick trickToLearn) {
  Fox fox = repository.findFoxByName(name);
  if (!fox.getTricks().contains(trickToLearn)){
    fox.getTricks().add(trickToLearn);
    repository.save(fox);
    }
  }


  public Fox searchFoxWithName(String name) {
      return repository.findFoxByName(name);  }

  public void deleteFoxWithoutName() {
  Fox nullNameFox = repository.findFoxByNameIsNull();
  repository.delete(nullNameFox);
  }
}
