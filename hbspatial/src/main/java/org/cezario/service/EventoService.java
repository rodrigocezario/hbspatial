package org.cezario.service;

import java.util.Arrays;
import java.util.List;

import org.cezario.modelo.Evento;
import org.cezario.modelo.Pessoa;
import org.cezario.repository.EventoRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.util.GeometricShapeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	public Evento save(Evento evento) {
		return eventoRepository.save(evento);
	}
	
	public List<Evento> findAll(){
		return eventoRepository.findAll();
	}
	
	public Evento findById(long id) {
		return eventoRepository.findById(id).get();
	}
	
	public List<Evento> findAllByLocalicacao(Pessoa pessoa, final double RAIO){
		
		GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 26910);
		
	    GeometricShapeFactory shapeFactory = new GeometricShapeFactory(factory);
	    shapeFactory.setNumPoints(100);
	    shapeFactory.setCentre(new Coordinate(pessoa.getLocalizacao().getX(), pessoa.getLocalizacao().getY()));
	    //shapeFactory.setSize(RAIO * 2); //distancia em metros 10000 = 10km
	    

	    
	 // Length in meters of 1° of latitude = always 111.32 km
	    shapeFactory.setHeight(RAIO/111320d);

	    // Length in meters of 1° of longitude = 40075 km * cos( latitude ) / 360
	    shapeFactory.setWidth(RAIO / (40075000 * Math.cos(Math.toRadians(pessoa.getLocalizacao().getX())) / 360));
	    
//	    Polygon polygon = new GeometryFactory().createPolygon(Arrays.stream(shapeFactory.createEllipse().getCoordinates()).toArray(Coordinate[]::new));
//	    polygon.setSRID(26910);
	    
		return eventoRepository.findAllByLocalicacao(shapeFactory.createCircle());
	    //return eventoRepository.findAllByLocalicacao(polygon);
	}

	
	
}


