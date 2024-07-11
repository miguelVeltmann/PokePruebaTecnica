package com.mx.Pokemon.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.mx.Pokemon.modelos.dto;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServicioPrueba {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Test
	public void prueba() {
		ResponseEntity<dto> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/pokemones/pikachu", dto.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		dto pokemon = responseEntity.getBody();
        assertEquals("pikachu", pokemon.getName());
	}
}
