package com.testeifoodbackend.playlist.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testeifoodbackend.playlist.client.WeatherClient;
import com.testeifoodbackend.playlist.dto.LocaleDto;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {
	
	@Value("${api.key}")
	private String apiKey;
	@Autowired
	private WeatherClient client;
	
	@GetMapping("/")
	public ResponseEntity<?> getWeather(@RequestParam(required = false) Optional<String> city, 
			@RequestParam(required = false) Optional<String> lat, @RequestParam(required = false) Optional<String> lon) {
		LocaleDto locale = city.isPresent() ? client.getInfoWeather(city.get(),apiKey) : client.getInfoWeather(lat.get(), lon.get(), apiKey);
		
		return ResponseEntity.ok(locale);
	}

}
