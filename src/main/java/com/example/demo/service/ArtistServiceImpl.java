package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.model.ArtistDTO;

@Service
public class ArtistServiceImpl implements ArtistService {
	ArrayList<ArtistDTO> artists = new ArrayList<>();

	ArtistDTO ar = new ArtistDTO(1, "Goya");

	ArtistDTO ar2 = new ArtistDTO(2, "Picasso");

	ArtistDTO ar3 = new ArtistDTO(3, "Dalí");

	ArtistDTO ar4 = new ArtistDTO(4, "Miró");

	public ArtistServiceImpl(){

	artists.add(ar);

	artists.add(ar2);

	artists.add(ar3);

	artists.add(ar4);
	}



	@Override
	public ArtistDTO getArtistaById(Integer id) {
		for (ArtistDTO a : artists) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}
}

