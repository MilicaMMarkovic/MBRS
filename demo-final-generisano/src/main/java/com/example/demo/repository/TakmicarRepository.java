package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Takmicar;


@Repository
public interface TakmicarRepository extends JpaRepository<Takmicar, Long> {

	List<Takmicar> findByTrkaId(Long id);
	

}
