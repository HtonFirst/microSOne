package com.alkozlov.microSOne.repository;

import com.alkozlov.microSOne.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepo extends JpaRepository<Cat, Long> {
}
