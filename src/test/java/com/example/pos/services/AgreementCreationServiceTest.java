package com.example.pos.services;

import com.example.pos.beans.agreement.Agreement;
import com.example.pos.beans.tool.Tool;
import com.example.pos.repository.interfaces.ToolRepository;
import com.example.pos.services.interfaces.AgreementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class AgreementCreationServiceTest {
//  @Autowired
  @InjectMocks
  AgreementService agreementService=new AgreementCreationService();

  @Mock
  ToolRepository toolRepository;

  @Mock
  DateCalculationService dateCalculationService;

  private Map<String, Tool> toolSet;

  @Before
  public void init() {
    this.toolSet = new HashMap<>();
    this.toolSet.put("CHNS", new Tool("CHNS", "Chainsaw", "Stihl"));
    this.toolSet.put("LADW", new Tool("LADW", "Ladder", "Werner"));
    this.toolSet.put("JAKD", new Tool("JAKD", "Jackhammer", "DeWalt"));
    this.toolSet.put("CHNS", new Tool("JAKR", "Jackhammer", "Ridgid"));
  }
  @Test
  public void testGettingTool() {
    Mockito.when(toolRepository.findById("CHNS")).thenReturn(Optional.ofNullable(this.toolSet.get("CHNS")));
    agreementService.process(new Agreement("CHNS", "09/03/15", 5));


  }
}
