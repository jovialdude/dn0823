package com.example.pos.beans;

import com.example.pos.beans.rate.Rate;
import com.example.pos.beans.tool.Type;

public class RatesBook {
  private static final Rate LADDER_RATE;
  private static final Rate CHAINSAW_RATE;
  private static final Rate JACKHAMMER_RATE;

  static {
    LADDER_RATE= new Rate("Ladder", 1.99, true, false);
    CHAINSAW_RATE = new Rate("Chainsaw", 1.49, false, true);
    JACKHAMMER_RATE = new Rate("Jackhammer", 2.99, false, false);
  }

  public static Rate getRate (Type type) {
    Rate res;
    switch (type) {
      case Ladder:
        res = LADDER_RATE;
        break;
      case Chainsaw:
        res = CHAINSAW_RATE;
        break;
      case Jackhammer:
        res = JACKHAMMER_RATE;
        break;
      default:
        res= new Rate();
        break;
    }

    return res;
  }
}
