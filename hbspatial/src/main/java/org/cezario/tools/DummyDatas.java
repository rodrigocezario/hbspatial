package org.cezario.tools;

import java.util.List;

import javax.annotation.PostConstruct;

import org.cezario.modelo.Evento;
import org.cezario.modelo.Pessoa;
import org.cezario.service.EventoService;
import org.cezario.service.PessoaService;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DummyDatas {
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private PessoaService pessoaService;
	
    private final static GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 26910); 

	
	//@PostConstruct
	public void salvarEventos() {
		
		System.out.println("Criando dados de eventos...");
		
		Double latitude, longitude;
		
		Evento evento1 = new Evento();
		evento1.setDescricao("Praia de Laranjeiras");
		latitude  = -26.996723186741505;
		longitude = -48.59081944327175;
		evento1.setLocalizacao(geometryFactory.createPoint(new Coordinate(latitude, longitude))); 
		eventoService.save(evento1);
		System.out.println("Evento criado...\n");

		Evento evento2 = new Evento();
		evento2.setDescricao("Praia de Taquarinhas");
		latitude  = -26.996909731497595;
		longitude = -48.58282743619159;
		evento2.setLocalizacao(geometryFactory.createPoint(new Coordinate(latitude, longitude))); 
		eventoService.save(evento2);
		System.out.println("Evento criado...\n");
		
		
		Evento evento3 = new Evento();
		evento3.setDescricao("Praia de Taquaras");
		latitude  = -27.00552698560108;
		longitude = -48.58187725618915;
		evento3.setLocalizacao(geometryFactory.createPoint(new Coordinate(latitude, longitude))); 
		eventoService.save(evento3);
		System.out.println("Evento criado...\n");
		
		Evento evento4 = new Evento();
		evento4.setDescricao("Praia Central");
		latitude  = -26.9799151762722;
		longitude = -48.634306832969365;
		evento4.setLocalizacao(geometryFactory.createPoint(new Coordinate(latitude, longitude))); 
		eventoService.save(evento4);
		System.out.println("Evento criado...\n");
		
		Evento evento5 = new Evento();
		evento5.setDescricao("Cataratas do Iguaçu");
		latitude  = -25.68394485292541;
		longitude = -54.434105038462604;
		evento5.setLocalizacao(geometryFactory.createPoint(new Coordinate(latitude, longitude))); 
		eventoService.save(evento5);
		System.out.println("Evento criado...\n");
		
		
		Evento evento6 = new Evento();
		evento6.setDescricao("Praia da Joaquina");
		latitude  = -27.629547871558035;
		longitude = -48.44989705539219;
		evento6.setLocalizacao(geometryFactory.createPoint(new Coordinate(latitude, longitude))); 
		eventoService.save(evento6);
		System.out.println("Evento criado...\n");
		
	}
	
	//@PostConstruct
	public void salvarPessoas() {
		
		Double latitude, longitude;
		
		System.out.println("Criando dados de pessoas");
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Rodrigo");
		
		//Atlântico Shopping Balneário
		latitude  = -26.985059045718494;
		longitude = -48.63517972251116;
		pessoa1.setLocalizacao(geometryFactory.createPoint(new Coordinate(latitude, longitude))); 
		pessoaService.save(pessoa1);
		System.out.println("Pessoa criada...\n");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Juliane");
		
		//Colégio Unificado Itapema
		latitude  = -27.143200838520354;
		longitude = -48.596079127464684;
		pessoa2.setLocalizacao(geometryFactory.createPoint(new Coordinate(latitude, longitude))); 
		pessoaService.save(pessoa2);
		System.out.println("Pessoa criada...\n");
		
	}
	
	@PostConstruct
	public void teste() {
		System.out.println("\n\nTestando a distância entre os pontos\n\n");
		
		Pessoa pessoa = pessoaService.findById(2);
		
		System.out.println("Nome: " + pessoa.getNome());
		
		List<Evento> eventos = eventoService.findAllByLocalicacao(pessoa, 110000);
		
		System.out.println(" -- Eventos --");
		eventos.forEach( e -> System.out.println(e.getDescricao()));
		
		
		System.out.println("\n\n == fim ==\n\n");
		
	}
	
}
