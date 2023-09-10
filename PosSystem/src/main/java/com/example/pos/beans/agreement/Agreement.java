package com.example.pos.beans.agreement;

import com.example.pos.beans.charge.RentalCharge;
import com.example.pos.beans.RentalDatesDetails;
import com.example.pos.beans.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class Agreement {
    Tool tool;
    RentalDatesDetails rentalDatesDetails;
    RentalCharge rentalCharge;

    public Agreement(){}

    public Agreement(Tool tool, RentalDatesDetails rentalDatesDetails, RentalCharge rentalCharge) {
        this.tool = tool;
        this.rentalDatesDetails = rentalDatesDetails;
        this.rentalCharge = rentalCharge;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public RentalDatesDetails getRentalDatesDetails() {
        return rentalDatesDetails;
    }

    public void setRentalDatesDetails(RentalDatesDetails rentalDatesDetails) {
        this.rentalDatesDetails = rentalDatesDetails;
    }

    public void setRentalCharge(RentalCharge rentalCharge) {
        this.rentalCharge = rentalCharge;
    }

    public RentalCharge getCharge() {
        return rentalCharge;
    }

}
