package com.greenfoxacademy.basicwebshop.controllers;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

import com.greenfoxacademy.basicwebshop.models.ShopItem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasicWebshopController {
  private List<ShopItem> shopItems = new ArrayList<>();

  public BasicWebshopController() {
    shopItems.add(new ShopItem("Running shoes", "Nike running shoes for every day sport", 1000.0, 5));
    shopItems.add(new ShopItem("Printer", "Some HP printer that will print pages", 3000.0, 2));
    shopItems.add(new ShopItem("Coca cola", "0.5l standard coke", 25.0, 0));
    shopItems.add(new ShopItem("Wokin", "Chicken with fried rice and WOKIN souce", 119.0, 100));
    shopItems.add(new ShopItem("T-shirt", "Blue with a corgi on a bike", 300.0, 1));
  }

  @RequestMapping("/webshop")
  public String getShopItems(Model model) {
    model.addAttribute("shopItems", shopItems);
    return "index";
  }

  @GetMapping("/only-available")
  public String getOnlyAvailable(Model model){
    model.addAttribute("shopItems", findOnlyAvailable());
    return "index";
  }

  @GetMapping("/cheapest-first")
  public String getCheapestFirst(Model model){
    model.addAttribute("shopItems", putCheapestFirst());
    return "index";
  }

  @GetMapping("/contains-nike")
  public String getContainsNike(Model model){
    model.addAttribute("shopItems", filterNike());
    return "index";
  }

  @GetMapping("/average-stock")
  public String getAverageStock(Model model){
    model.addAttribute("average", calculateAverage());
    return "averagestock";
  }

  @GetMapping("/most-expensive")
  public String getMostExpensive(Model model){
    model.addAttribute("mostExpensive", searchMostExpensiveItem() );
    return "averagestock";
  }

  @GetMapping("/search")
  public String searchItem(Model model, @RequestParam String search){
    model.addAttribute("shopItems", searchedItemsContainsSearch(search));
        return "index";
  }

  private List<ShopItem> searchedItemsContainsSearch(String search) {
    return shopItems.stream().filter(shopItem -> shopItem.getName().toLowerCase().contains(search.toLowerCase()) || shopItem.getDescription().toLowerCase().contains(search.toLowerCase())).collect(
        Collectors.toList());
  }

  private ShopItem searchMostExpensiveItem() {
   return shopItems.stream()
        .max(Comparator.comparingDouble(ShopItem::getPrice))
        .get();

   // shopItems.stream()
    //           .mapToDouble(ShopItem::getPrice)
    //           .reduce(1, Double::max);
  }


  private Double calculateAverage() {
    return shopItems.stream()
    .mapToDouble(shopItem -> shopItem.getQuantityOfStock())
    .average()
    .getAsDouble();
  }

  private List<ShopItem> filterNike() {
    return shopItems.stream()
    .filter(shopItem -> shopItem.getDescription().toLowerCase().contains("nike")|shopItem.getName().toLowerCase().contains("nike"))
    .collect(Collectors.toList());
  }

  private List<ShopItem> putCheapestFirst() {
    return shopItems.stream()
    .sorted(Comparator.comparingDouble(ShopItem::getPrice))
    .collect(Collectors.toList());
  }

  private List<ShopItem> findOnlyAvailable() {
    return shopItems.stream().filter(shopItem -> shopItem.getQuantityOfStock()>0).collect(
        Collectors.toList());
  }
}
