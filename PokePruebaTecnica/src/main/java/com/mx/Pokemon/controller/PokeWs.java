package com.mx.Pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mx.Pokemon.modelos.dto;
import com.mx.Pokemon.service.PokeServicio;

@RestController
@RequestMapping("/pokemones")
@CrossOrigin()
public class PokeWs {
	
	public static final String pokeUrl = "https://pokeapi.co/api/v2/pokemon/";

	@Autowired
	PokeServicio servicio;
	
	@GetMapping("/{parametro}")
	public ResponseEntity<?> buscar(@PathVariable("parametro") String parametro)  {
		dto pokemon = servicio.buscar(pokeUrl + parametro);
		if (pokemon == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo obtener la informacion del Pokemon");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(pokemon);
		}
	}
	
	
}
