package com.example.pos.repository.interfaces;

import com.example.pos.beans.rate.Rate;
import org.springframework.data.repository.CrudRepository;

public interface RateRepository extends CrudRepository<Rate, String> {
}
