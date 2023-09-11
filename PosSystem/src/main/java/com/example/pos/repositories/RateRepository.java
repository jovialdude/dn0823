package com.example.pos.repositories;

import com.example.pos.beans.rate.Rate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class RateRepository {
  private Map<String, Rate> rateBook;

  {
    this.rateBook = new HashMap<>();
    this.rateBook.put("Ladder", new Rate("Ladder", 1.99, true, true, false));
    this.rateBook.put("Chainsaw", new Rate("Chainsaw", 1.49, true, false, true));
    this.rateBook.put("Jackhammer", new Rate("Jackhammer", 2.99, true, false, false));
  }

  public Rate getRate(String id) {
    return this.rateBook.get(id);
  }

}
