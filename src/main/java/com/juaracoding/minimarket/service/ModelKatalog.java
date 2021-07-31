package com.juaracoding.minimarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juaracoding.minimarket.entity.Katalog;
import com.juaracoding.minimarket.repository.KatalogRepository;

@Service
public class ModelKatalog implements ModelKatalogInterface {

	@Autowired
	KatalogRepository katalogRepo;
	
	@Override
	public List<Katalog> getAllKatalog() {
		// TODO Auto-generated method stub
		return this.katalogRepo.findAll();
	}

	@Override
	public String addKatalog(Katalog katalog) {
		// TODO Auto-generated method stub
		this.katalogRepo.save(katalog);
		return "Berhasil Memasukkan Data";
	}

	@Override
	public String updateKatalog(Katalog katalog) {
		// TODO Auto-generated method stub
		this.katalogRepo.save(katalog);
		return "Berhasil Memperbaharui Data";
	}

	@Override
	public Katalog getByIdKatalog(String id) {
		// TODO Auto-generated method stub
		return this.katalogRepo.findById(Long.parseLong(id)).get() ;
	}

	@Override
	public String deleteKatalog(String id) {
		// TODO Auto-generated method stub
		this.katalogRepo.deleteById(Long.parseLong(id));
		return "Berhasil Menghapus Data";
	}

}
