package com.example.demoRestApi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demoRestApi.models.WorldClockResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FechaService {

  private final RestTemplate restTemplate;

  public FechaService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public String obtenerFecha() {
    String url = "http://worldclockapi.com/api/json/utc/now";
    try {
      WorldClockResponse response = restTemplate.getForObject(url, WorldClockResponse.class);
      return response.getCurrentDateTime();
    } catch (Exception e) {
      // En caso de fallo del servicio, devuelve la fecha actual como una alternativa
      return obtenerFechaLocal();
    }
  }

  // Método para obtener la fecha local en caso de fallo del servicio
  private String obtenerFechaLocal() {
    LocalDateTime fechaLocal = LocalDateTime.now();
    // Formatear la fecha local en el formato deseado
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    return fechaLocal.format(formatter);
  }
}
