package com.mx.Pokemon.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class dto {
	private int id;
	private String name;
	private double weight;
	private double height;
	private double base_experience;

}
