package com.mx.Pokemon.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mx.Pokemon.modelos.dto;

@Service
public class PokeServicio {
	@Autowired
	RestTemplate restTemplate;
	
	public dto buscar(String pokeUrl){
		dto pokemon = restTemplate.getForObject(pokeUrl, dto.class);
		if(pokemon == null) {
			return null;
		} else {
			return pokemon;
		}
	}

}
