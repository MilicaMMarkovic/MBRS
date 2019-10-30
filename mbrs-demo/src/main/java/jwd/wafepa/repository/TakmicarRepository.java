package jwd.wafepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Takmicar;

@Repository
public interface TakmicarRepository extends JpaRepository<Takmicar, Long> {

	
}
