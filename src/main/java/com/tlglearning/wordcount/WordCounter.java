package com.tlglearning.wordcount;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordCounter {


  private static final Set<String> BORING_WORDS = Set.of("and", "of", "the", "in",
      "on", "i", "then", "than", "out", "a", "if");

  private final Map<String, Integer> counts = new HashMap<>();

  private int totalWords;


  public Set<String> words() {
    return counts.keySet();
  }

  public int get(String word) {
    return counts.getOrDefault(word, 0);
  }

  public Map<String, Integer> getCounts() {
    return Collections.unmodifiableMap(counts);
  }

  public void add(String text) {
    String trimmedLine = text.trim();
    if (!trimmedLine.isEmpty()) {
      String[] words = splitWords(trimmedLine);
      countWords(words);
    }
  }

  public int size() {
    return counts.size();
  }

  public int total() {
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

    Arrays
        .stream(words)
        .map(String::trim)
        .filter((s) -> !s.isEmpty())
        .filter((word) -> word.length() > 5)
        .filter((s) -> !BORING_WORDS.contains(s))
//        .filter(Predicate.not(String::isEmpty))
        .forEach((word) -> counts.put(word, 1 + counts.getOrDefault(word, 0)));

//    for (String word : words){
//
//      //DONE CHECK if word is already present as a key in counts
//      // if its not presnet, add it to counts with a value of 1;
//      // otherwise, get the current value, add 1 to it , and update the map with the new value
//      counts.put(word, get(word) +1);
//      totalWords++;
  }
}
//Method to split words and regenerate expressions


