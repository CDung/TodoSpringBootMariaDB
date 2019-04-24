package com.example.demo.repo;

import org.springframework.stereotype.Repository;
import com.example.demo.model.Item;
import org.springframework.data.repository.CrudRepository;
@Repository
public interface ItemRepository extends CrudRepository<Item, String> {
}
