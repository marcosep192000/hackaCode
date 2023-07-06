package com.hackacode.marveland.service.impl;

import com.hackacode.marveland.model.entity.TiketB;
import com.hackacode.marveland.repository.TiketBRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TiketBService {

	@Autowired
	TiketBRepository repositoryTiket;


	public List<TiketB> getAll(){
		return repositoryTiket.findAll();
	}


	public TiketB getById(Long id) {
		Optional<TiketB> game = repositoryTiket.findById(id);
		return game.get();
	}

	@Transactional
	public void  create(TiketB request) {
		TiketB tiketB = new TiketB();
		tiketB.setGame(request.getGame());
		tiketB.setCustomer(request.getCustomer());
		repositoryTiket.save(tiketB);
	}


//	@Override
//	public void delete(Long id) {
//		gameRepository.deleteById(id);
//	}






}
