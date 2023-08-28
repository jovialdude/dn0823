package com.example.pos.services.interfaces;

import com.example.pos.beans.agreement.Agreement;
import org.springframework.stereotype.Component;

@Component
public interface AgreementService {
  public void process(Agreement agreement);
}
