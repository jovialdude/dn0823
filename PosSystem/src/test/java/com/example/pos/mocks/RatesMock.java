package com.example.pos.mocks;

import com.example.pos.beans.rate.Rate;

import java.util.HashMap;
import java.util.Map;

public class RatesMock {
  private static Map<String, Rate> rateBook;

  static {
    rateBook = new HashMap<>();
    rateBook.put("Ladder", new Rate("Ladder", 1.99, true, true, false));
    rateBook.put("Chainsaw", new Rate("Chainsaw", 1.49, true, false, true));
    rateBook.put("Jackhammer", new Rate("Jackhammer", 2.99, true, false, false));
  }

  public static Rate getRate (String toolType) {
    return rateBook.getOrDefault(toolType, new Rate());
  }
}
