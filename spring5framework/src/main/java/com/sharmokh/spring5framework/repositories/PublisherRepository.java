package com.sharmokh.spring5framework.repositories;

import com.sharmokh.spring5framework.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
}
