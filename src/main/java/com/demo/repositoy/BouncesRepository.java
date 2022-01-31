package com.demo.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Bounces;

@Repository
public interface BouncesRepository extends JpaRepository<Bounces, Integer> {

}
