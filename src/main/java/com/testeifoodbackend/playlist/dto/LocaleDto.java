package com.testeifoodbackend.playlist.dto;

import lombok.Data;

@Data
public class LocaleDto {
	
	private Long id;
	private String name;
	private Long cod;
	private TemperatureDto main;
}
