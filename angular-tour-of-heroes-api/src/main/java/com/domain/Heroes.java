package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Heroes {

	@Null private int id;
	private String name;
	private String power;
	@Null private String alterEgo;
}
