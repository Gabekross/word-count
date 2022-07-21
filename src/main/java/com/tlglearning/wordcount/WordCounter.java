package com.tlglearning.wordcount;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordCounter {

  private final Map<String, Integer> counts = new HashMap<>();

  private  int totalWords;


//  public WordCounter(String text) {
//   String [] words = splitWords(text);
//    counts = Collections.unmodifiableMap(countWords(words)); //Makes counts unmodifiable
//
//    }

  public Set<String> words (){
    return counts.keySet();
  }

  public int get(String word){
    return counts.getOrDefault(word ,0);
  }

  public Map<String, Integer> getCounts() {
    return Collections.unmodifiableMap(counts);
  }

  public void add (String text){
    String trimmedLine = text.trim();
    if (!trimmedLine.isEmpty()) {
      String [] words = splitWords(trimmedLine);
      countWords(words);
    }
  }

  public int size() {
    return counts.size();
  }

  public int total(){
    return totalWords;
  }

  String[] splitWords(String text) {

    return text.toLowerCase().split("[\\W_]+");
  }

  @Override
  public String toString() {
    return "WordCounter{" +
        "counts=" + counts +
        '}';
  }

  //Business/Helper Methods
  //Method to countWords
 void countWords(String[] words) {
    for (String word : words){

      //DONE CHECK if word is already present as a key in counts
      // if its not presnet, add it to counts with a value of 1;
      // otherwise, get the current value, add 1 to it , and update the map with the new value
      counts.put(word, get(word) +1);
      totalWords++;
    }
  }
//Method to split words and regenerate expressions

}
