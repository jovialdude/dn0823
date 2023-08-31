package com.example.api.controller;

import com.example.api.bean.Rate;
import com.example.api.bean.Tool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/")
public class ToolDetailsController {
  private Map<String, Tool> toolSet;
  private Map<String, Rate> rateBook;
  private final Logger logger = LoggerFactory.getLogger(ToolDetailsController.class);

  public ToolDetailsController() {
    this.toolSet = new HashMap<>();
    this.toolSet.put("CHNS", new Tool("CHNS", "Chainsaw", "Stihl"));
    this.toolSet.put("LADW", new Tool("LADW", "Ladder", "Werner"));
    this.toolSet.put("JAKD", new Tool("JAKD", "Jackhammer", "DeWalt"));
    this.toolSet.put("JAKR", new Tool("JAKR", "Jackhammer", "Ridgid"));

    this.rateBook = new HashMap<>();
    this.rateBook.put("ladder", new Rate("Ladder", 1.99, true, true, false));
    this.rateBook.put("chainsaw", new Rate("Chainsaw", 1.49, true, false, true));
    this.rateBook.put("jackhammer", new Rate("Jackhammer", 2.99, true, false, false));
  }

  @GetMapping("/getTool/{id}")
  public Tool getTool(@PathVariable String id) throws IOException {
    logger.info(this.toolSet.get(id.toUpperCase()).toString());
    return this.toolSet.get(id);
  }

  @GetMapping("/getRate/{id}")
  public Rate getRate(@PathVariable String id) throws IOException {
    logger.info(this.rateBook.get(id.toLowerCase()).toString());
    return this.rateBook.get(id);
  }
}
