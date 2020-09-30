package com.greenfoxacademy.frontend.services;


import com.greenfoxacademy.frontend.models.sith.Response;

import org.springframework.stereotype.Service;

@Service
public class SithService {

  public Response createResponse(String sentence) {
    String[] sentences = sentence.split("\\. ");
    for (int i = 0; i < sentences.length; i++) {
      String temp = "";
      int counter = 0;
      String[] words = sentences[i].toLowerCase().split(" ");
      for (int j = 0; j < (words.length / 2); j++) {
        temp = words[counter];
        words[counter] = words[counter + 1];
        words[counter + 1] = temp;
        counter = counter + 2;
      }
      words[0] = capitalize(words[0]);
      sentences[i] = String.join(" ", words);
    }
    String yodaSentence =
        String.join(". " + "Arrgh. Uhmm. ", sentences);
    return new Response(yodaSentence);
  }

  private String capitalize(String word) {
    return Character.toUpperCase(word.charAt(0)) + word.substring(1);
  }
}