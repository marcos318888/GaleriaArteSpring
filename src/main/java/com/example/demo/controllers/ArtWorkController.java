package com.example.demo.controllers;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.ArtworkDTO;
import com.example.demo.service.ArtworkService;

@RestController
@RequestMapping("/Artwork")
public class ArtWorkController {


	@Autowired
	ArtworkService ArtworkService;
	
		 
		public  ArtWorkController (ArtworkService servicio) {
		        this.ArtworkService=servicio;
		}
		    @GetMapping
		    public ResponseEntity<ArrayList<?>> VerObras(){
		        ArrayList<ArtworkDTO> array = ArtworkService.getAllArtworks();
		        return ResponseEntity.ok(array);
		    }
		    @PostMapping
		    public ResponseEntity<ArtworkDTO> CrearObra(@RequestBody @Validated ArtworkDTO obraCreada){
		    	ArtworkService.createArtwork(obraCreada);
		        URI s = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obraCreada.getId()).toUri(); 
		        return ResponseEntity.created(s).build();


		    }
		

	
	
}
