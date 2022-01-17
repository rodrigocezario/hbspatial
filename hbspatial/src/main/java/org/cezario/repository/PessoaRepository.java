package org.cezario.repository;

import org.cezario.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	

	
//	String insertPointQuery = "INSERT INTO SPATIALTABLE SET SPOINT = ST_GEOMFROMTEXT(:point, 4326)";
//
//	@Modifying
//	@Transactional
//	@Query(nativeQuery = true, value = insertPointQuery)
//	int savePoint(@Param("point") String point);
	
}
