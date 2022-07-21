package com.tlglearning.wordcount;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class WordCounter {

  private final Map<String, Integer> counts;


  public WordCounter(String text) {
   String [] words = splitWords(text);
    counts = Collections.unmodifiableMap(countWords(words)); //Makes counts unmodifiable

    }

  public Set<String> words (){
    return counts.keySet();
  }

  public int getCount(String word){
    return counts.getOrDefault(word ,0);
  }

  public Map<String, Integer> getCounts() {
    return counts;
  }

  //Business/Helper Methods
  //Method to countWords
  Map<String, Integer> countWords(String[] words) {
    Map<String, Integer> counts = new HashMap<>();
    for (String word : words){

      //DONE CHECK if word is already present as a key in counts
      // if its not presnet, add it to counts with a value of 1;
      // otherwise, get the current value, add 1 to it , and update the map with the new value
      if (!counts.containsKey(word)){
        counts.put(word, 1);
      }else{
        int previousCount = counts.get(word);
        counts.put(word, previousCount +1);
      }
    }
    return counts;
  }
//Method to split words and regenerate expressions
  String[] splitWords(String text) {
    return text.toLowerCase().split("[\\W_]+");
  }

  @Override
  public String toString() {
    return "WordCounter{" +
        "counts=" + counts +
        '}';
  }
}
