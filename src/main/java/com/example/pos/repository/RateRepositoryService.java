package com.example.pos.repository;

import com.example.pos.beans.rate.Rate;
import com.example.pos.repository.interfaces.RateRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RateRepositoryService implements RateRepository {
  public RateRepositoryService() {}

  @Override
  public <S extends Rate> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Rate> Iterable<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<Rate> findById(String s) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(String s) {
    return false;
  }

  @Override
  public Iterable<Rate> findAll() {
    return null;
  }

  @Override
  public Iterable<Rate> findAllById(Iterable<String> strings) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(String s) {

  }

  @Override
  public void delete(Rate entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends String> strings) {

  }

  @Override
  public void deleteAll(Iterable<? extends Rate> entities) {

  }

  @Override
  public void deleteAll() {

  }
}
