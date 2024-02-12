package com.example.demoRestApi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoRestApi.service.FechaService;

@RestController
public class FechaController {

  private final FechaService fechaService;

  public FechaController(FechaService fechaService) {
    this.fechaService = fechaService;
  }

  @GetMapping("/fecha")
  public String obtenerFecha() {
    return fechaService.obtenerFecha();
  }
}
