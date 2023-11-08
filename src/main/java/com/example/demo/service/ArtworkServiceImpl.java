package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ArtworkCreationException;
import com.example.demo.model.ArtistDTO;
import com.example.demo.model.ArtworkDTO;

@Service
public class ArtworkServiceImpl implements ArtworkService {
	
	@Autowired
	ArtistService artistService;
	
	ArrayList<ArtworkDTO> obras = new ArrayList<>();

	ArtworkDTO ar = new ArtworkDTO(1, "Titulo1", "hola soy la descripción uno", 1);

	ArtworkDTO ar2 = new ArtworkDTO(2, "Titulo2", "hola soy la descripción dos", 2);

	ArtworkDTO ar3 = new ArtworkDTO(3, "Titulo3", "hola soy la descripción tres", 1);

	ArtworkDTO ar4 = new ArtworkDTO(4,"Titulo4", "hola soy la descripción cuatro",3);

	public ArtworkServiceImpl() {

	obras.add(ar);

	obras.add(ar2);

	
	obras.add(ar3);

	obras.add(ar4);

	}

	@Override
	public ArrayList<ArtworkDTO> getAllArtworks() {
		// TODO Auto-generated method stub
		return obras;
	}

	@Override
	public void createArtwork(ArtworkDTO artworkDTO) {
		ArtistDTO a = artistService.getArtistaById(artworkDTO.getArtistId());

        if(a.getId() == artworkDTO.getArtistId()) {
            obras.add(artworkDTO);
        

    }else {
	
		throw new ArtworkCreationException(
				" El artista introducido no esta autorizado ");
	}
	
}}
