package jwd.wafepa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Trka;

@Repository
public interface TrkaRepository extends JpaRepository<Trka, Long> {

	List<Trka> findByDuzinaKm(double duzinaKm);
}
