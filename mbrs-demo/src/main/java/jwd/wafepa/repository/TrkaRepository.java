package jwd.wafepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Trka;

@Repository
public interface TrkaRepository extends JpaRepository<Trka, Long> {

}
