package com.example.pos.controller;


import com.example.pos.beans.RentalDatesDetails;
import com.example.pos.beans.agreement.Agreement;
import com.example.pos.beans.charge.RentalCharge;
import com.example.pos.beans.rate.Rate;
import com.example.pos.beans.request.AgreementCreationRequest;
import com.example.pos.beans.tool.Tool;
import com.example.pos.controllers.AgreementController;
import com.example.pos.mocks.RatesMock;
import com.example.pos.mocks.ToolsMock;
import com.example.pos.services.AgreementGenerationService;
import com.example.pos.services.ChargeCalculationService;
import com.example.pos.services.DateCalculationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AgreementController.class)
public class AgreementControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private AgreementGenerationService agreementGenerationService;
  @MockBean
  private ChargeCalculationService chargeCalculationService;
  @MockBean
  private DateCalculationService dateCalculationService;


  private ChargeCalculationService chargeCalculationServiceMock;

  private DateCalculationService dateCalculationServiceMock;

  private final ObjectMapper objectMapper;

  public AgreementControllerTest() {
    this.objectMapper=new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    chargeCalculationServiceMock = new ChargeCalculationService();
    dateCalculationServiceMock = new DateCalculationService();
  }

  @Test
  public void test0Duration() throws Exception {
    when(agreementGenerationService.getRate("Chainsaw"))
        .thenReturn(RatesMock.getRate("Chainsaw"));

    when(agreementGenerationService.getTool("CHNS"))
        .thenReturn(ToolsMock.getTool("CHNS"));

//    when()
    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post("/getAgreement")
            .content(
                objectMapper.writeValueAsString(
                    new AgreementCreationRequest(
                        "CHNS","09/03/15",0,0)
                )
            )
            .contentType(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andExpect(content().string("Expected more than days. Received 0"));
  }

  @Test
  public void JAKR090315Five101() throws Exception {
    when(agreementGenerationService.getRate("Jackhammer"))
        .thenReturn(RatesMock.getRate("Jackhammer"));

    when(agreementGenerationService.getTool("JAKR"))
        .thenReturn(ToolsMock.getTool("JAKR"));

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post("/getAgreement")
            .content(
                objectMapper.writeValueAsString(
                    new AgreementCreationRequest(
                        "JAKR","09/03/15",5,101)
                )
            )
            .contentType(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andExpect(content().string("Expected discount value between 0-100. Received 101"));
  }
//  @Test
//  @Ignore
//  public void LADW070220Three10() throws Exception {
//    Tool tool = ToolsMock.getTool("LADW");
//    Rate rate = RatesMock.getRate("Ladder");
//    RentalDatesDetails expectedRentalDatesDetails = new RentalDatesDetails();
//    dateCalculationServiceMock
//        .process("07/02/20", 3, rate, expectedRentalDatesDetails);
//    RentalCharge expectedRentalCharge = new RentalCharge();
//    chargeCalculationServiceMock
//        .process(rate.getDailyCharge(), expectedRentalDatesDetails.getDaysCharged(), 10, expectedRentalCharge);
//    Agreement agreement = new Agreement(tool, expectedRentalDatesDetails, expectedRentalCharge);
//
////    System.out.println(objectMapper.writeValueAsString(agreement));
//
//    when(agreementGenerationService.getRate("Ladder"))
//        .thenReturn(RatesMock.getRate("Ladder"));
//
//    when(agreementGenerationService.getTool("LADW"))
//        .thenReturn(ToolsMock.getTool("LADW"));
//
//
//    RentalDatesDetails actualRentalDatesDetails = new RentalDatesDetails();
//    RentalCharge actualRentalCharge = new RentalCharge();
////    when(dateCalculationService.process("07/02/20", 3, rate, rentalDatesDetails));
//    doCallRealMethod().when(dateCalculationService).process("07/02/20)",3,rate,actualRentalDatesDetails);
//    doCallRealMethod().when(chargeCalculationService).process(rate.getDailyCharge(),actualRentalDatesDetails.getDaysCharged(),10,(actualRentalCharge));
//
//    this.mockMvc
//        .perform(MockMvcRequestBuilders
//            .post("/getAgreement")
//            .content(
//                objectMapper.writeValueAsString(
//                    new AgreementCreationRequest(
//                        "LADW","07/02/20",3,10)
//                )
//            )
//            .contentType(MediaType.APPLICATION_JSON)
//        )
//        .andDo(print())
//        .andExpect(status().isOk())
//        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//        .andExpect(content().json(objectMapper.writeValueAsString(agreement)));
//  }

  @Test
  public void CHNS070215Five25() throws Exception {
    when(agreementGenerationService.getRate("Chainsaw"))
        .thenReturn(RatesMock.getRate("Chainsaw"));

    when(agreementGenerationService.getTool("CHNS"))
        .thenReturn(ToolsMock.getTool("CHNS"));

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post("/getAgreement")
            .content(
                objectMapper.writeValueAsString(
                    new AgreementCreationRequest(
                        "CHNS","07/02/15",5,25)
                )
            )
            .contentType(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().isOk());
  }
  @Test
  public void JAKD090315Six0() throws Exception {
    when(agreementGenerationService.getRate("Jackhammer"))
        .thenReturn(RatesMock.getRate("Jackhammer"));

    when(agreementGenerationService.getTool("JAKD"))
        .thenReturn(ToolsMock.getTool("JAKD"));

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post("/getAgreement")
            .content(
                objectMapper.writeValueAsString(
                    new AgreementCreationRequest(
                        "JAKD","09/03/15",6,0)
                )
            )
            .contentType(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().isOk());
  }
  @Test
  public void JAKR070220Four50() throws Exception {
    when(agreementGenerationService.getRate("Jackhammer"))
        .thenReturn(RatesMock.getRate("Jackhammer"));

    when(agreementGenerationService.getTool("JAKR"))
        .thenReturn(ToolsMock.getTool("JAKR"));

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post("/getAgreement")
            .content(
                objectMapper.writeValueAsString(
                    new AgreementCreationRequest(
                        "JAKR","07/02/20",4,50)
                )
            )
            .contentType(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().isOk());
  }
}
