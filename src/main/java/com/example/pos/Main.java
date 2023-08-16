package com.example.pos;


import com.example.pos.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
  //
  //for test purpose we create a static list of tools
  //eventually this list should be pulling data from the db/upstream
  //also, input should eventually come from the UI
  //


  //
  // this is a bit of a primitive way to set up the map
  // eventually, I think there will be 3 tables
  // 1 for type/acronym, 1 for brand/acronym
  // code seems like its built from those 2 acronyms
  //

  public static void main (String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Bean
  @Autowired
  public CommandLineRunner commandLineRunner(CheckoutService checkoutService) {
    return runner-> {
      checkoutService.process("JAKR", "09/03/15", 5);
    };
  }

}


