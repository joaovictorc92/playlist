package com.testeifoodbackend.playlist.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.testeifoodbackend.playlist.dto.LocaleDto;

@FeignClient(name="openWeather" ,url = "${feign.url}")
public interface WeatherClient {
	
	@RequestMapping(method = RequestMethod.GET)
     LocaleDto getInfoWeather(
    		 @RequestParam(required = false) String lat,
    		 @RequestParam(required = false) String lon,@RequestParam String appid);
	
	@RequestMapping(method = RequestMethod.GET)
	LocaleDto getInfoWeather(@RequestParam(required = false) String q, @RequestParam String appid);
}
