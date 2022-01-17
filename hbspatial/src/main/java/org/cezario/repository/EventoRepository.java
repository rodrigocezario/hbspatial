package org.cezario.repository;

import java.util.List;

import org.cezario.modelo.Evento;
import org.locationtech.jts.geom.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
	
	//ST_Distance_Sphere = não implementado
	
	//within = Retorna verdadeiro se as geometrias estiverem dentro da distância especificada uma da outra
	@Query(value = "select e from Evento e where within(e.localizacao, :circle) = true", nativeQuery = false)
	List<Evento> findAllByLocalicacao(@Param("circle") Geometry circle);

	
}
