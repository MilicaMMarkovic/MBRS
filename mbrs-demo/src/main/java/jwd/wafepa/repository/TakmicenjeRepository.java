package jwd.wafepa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Takmicenje;

@Repository
public interface TakmicenjeRepository extends JpaRepository<Takmicenje, Long>{

	List<Takmicenje> findByNaziv(String naziv);
}
