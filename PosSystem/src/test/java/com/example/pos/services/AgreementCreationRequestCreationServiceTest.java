package com.example.pos.services;

import com.example.pos.mocks.RatesMock;
import com.example.pos.mocks.ToolsMock;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class AgreementCreationRequestCreationServiceTest {
  @Autowired
  private AgreementGenerationService agreementService;

  private ObjectMapper objectMapper;

  public AgreementCreationRequestCreationServiceTest() {
  }

  @Before
  public void init() {
    objectMapper=new ObjectMapper();
  }
  @Test
  public void testGettingTool() {
    Assert.assertEquals(ToolsMock.getTool("CHNS").toString(), agreementService.getTool("CHNS").toString());
    Assert.assertEquals(ToolsMock.getTool("LADW").toString(), agreementService.getTool("LADW").toString());
    Assert.assertEquals(ToolsMock.getTool("JAKD").toString(), agreementService.getTool("JAKD").toString());
    Assert.assertEquals(ToolsMock.getTool("JAKR").toString(), agreementService.getTool("JAKR").toString());
  }

  @Test
  public void testGettingRate() {
    Assert.assertEquals(RatesMock.getRate("Ladder").toString(), agreementService.getRate("Ladder").toString());
    Assert.assertEquals(RatesMock.getRate("Chainsaw").toString(), agreementService.getRate("Chainsaw").toString());
    Assert.assertEquals(RatesMock.getRate("Jackhammer").toString(), agreementService.getRate("Jackhammer").toString());
  }
}
