package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.ArtworkDTO;

public interface ArtworkService {
	ArrayList< ArtworkDTO > getAllArtworks();
	
	
	void createArtwork(ArtworkDTO artworkDTO);
}
