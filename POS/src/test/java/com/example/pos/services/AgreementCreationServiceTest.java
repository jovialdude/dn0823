package com.example.pos.services;

import com.example.pos.beans.agreement.Agreement;
import com.example.pos.beans.rate.Rate;
import com.example.pos.beans.tool.Tool;
import com.example.pos.exceptions.InvalidDayCountException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class AgreementCreationServiceTest {
  @Autowired
  private AgreementCreationService agreementService;


  private Map<String, Tool> toolSet;
  private Map<String, Rate> rateBook;


  public AgreementCreationServiceTest() {
  }

  @Before
  public void init() {
    this.toolSet = new HashMap<>();
    this.toolSet.put("CHNS", new Tool("CHNS", "Chainsaw", "Stihl"));
    this.toolSet.put("LADW", new Tool("LADW", "Ladder", "Werner"));
    this.toolSet.put("JAKD", new Tool("JAKD", "Jackhammer", "DeWalt"));
    this.toolSet.put("JAKR", new Tool("JAKR", "Jackhammer", "Ridgid"));

    this.rateBook = new HashMap<>();
    this.rateBook.put("Ladder", new Rate("Ladder", 1.99, true, true, false));
    this.rateBook.put("Chainsaw", new Rate("Chainsaw", 1.49, true, false, true));
    this.rateBook.put("Jackhammer", new Rate("Jackhammer", 2.99, true, false, false));
  }
  @Test
  public void testGettingTool() {
//    Mockito.when(toolRepository.findById("CHNS")).thenReturn(Optional.ofNullable(this.toolSet.get("CHNS")));
//    Mockito.when(rateRepository.findById("Chainsaw")).thenReturn(Optional.ofNullable(this.rateBook.get("Chainsaw")));

//    Mockito.when(dateCalculationService.process("09/03/15", 5)).thenReturn(new RentalDate())
//    Mockito.when(dateCalculationService.process("09/03/15", 5))
//    agreementService.process(new Agreement("CHNS", "09/03/15",;
//    Assert.assertTha
//
    Assert.assertEquals(toolSet.get("CHNS").toString(), agreementService.getTool("CHNS").toString());
    Assert.assertEquals(toolSet.get("LADW").toString(), agreementService.getTool("LADW").toString());
    Assert.assertEquals(toolSet.get("JAKD").toString(), agreementService.getTool("JAKD").toString());
    Assert.assertEquals(toolSet.get("JAKR").toString(), agreementService.getTool("JAKR").toString());
  }

  @Test
  public void testGettingCharge() {
    Assert.assertEquals(rateBook.get("Ladder").toString(), agreementService.getRate("Ladder").toString());
    Assert.assertEquals(rateBook.get("Chainsaw").toString(), agreementService.getRate("Chainsaw").toString());
    Assert.assertEquals(rateBook.get("Jackhammer").toString(), agreementService.getRate("Jackhammer").toString());
  }
  
}
