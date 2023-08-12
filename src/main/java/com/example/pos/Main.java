package com.example.pos;


import com.example.pos.beans.tools.Brands;
import com.example.pos.beans.tools.Tool;
import com.example.pos.beans.tools.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Type;

@SpringBootApplication
public class Main {
  //
  //for test purpose we create a static list of tools
  //eventually this list should be pulling data from the db/upstream
  //also, input should eventually come from the UI
  //


  public static void main (String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Bean
  @Autowired
  public CommandLineRunner commandLineRunner(Brands brand, Types types, Tool tool) {
    return runner-> {
      mockUpCheckoutProcess();
    };
  }

  public void mockUpCheckoutProcess () {

  }
}


