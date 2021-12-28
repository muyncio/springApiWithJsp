package com.example.api.repositories;

import com.example.api.model.TestTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestTableRepo extends CrudRepository<TestTable, Long> {
}
