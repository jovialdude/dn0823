package com.example.pos.services.interfaces;

import com.example.pos.beans.agreement.Agreement;
import org.springframework.stereotype.Component;

@Component
public interface AgreementService {
  void process(Agreement agreement);
}
