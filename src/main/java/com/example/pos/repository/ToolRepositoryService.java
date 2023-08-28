package com.example.pos.repository;

import com.example.pos.beans.tool.Tool;
import com.example.pos.repository.interfaces.ToolRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ToolRepositoryService implements ToolRepository {
  @Override
  public Iterable<Tool> findAll(Sort sort) {
    return null;
  }

  @Override
  public Page<Tool> findAll(Pageable pageable) {
    return null;
  }

  @Override
  public <S extends Tool> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Tool> Iterable<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<Tool> findById(String s) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(String s) {
    return false;
  }

  @Override
  public Iterable<Tool> findAll() {
    return null;
  }

  @Override
  public Iterable<Tool> findAllById(Iterable<String> strings) {
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
  public void delete(Tool entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends String> strings) {

  }

  @Override
  public void deleteAll(Iterable<? extends Tool> entities) {

  }

  @Override
  public void deleteAll() {

  }
}
