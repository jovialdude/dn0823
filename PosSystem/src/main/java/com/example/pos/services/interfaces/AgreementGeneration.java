package com.example.pos.services.interfaces;

import com.example.pos.beans.request.AgreementCreationRequest;
import com.example.pos.beans.agreement.Agreement;
import org.springframework.stereotype.Component;

@Component
public interface AgreementGeneration {
  void process(AgreementCreationRequest agreementCreationRequest, Agreement agreement);
}
