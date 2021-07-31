package com.juaracoding.minimarket.service;

import java.util.List;

import com.juaracoding.minimarket.entity.Katalog;

public interface ModelKatalogInterface {
	
	public List<Katalog> getAllKatalog();
	public String addKatalog (Katalog katalog);
	public String updateKatalog (Katalog katalog);
	public Katalog getByIdKatalog (String id);
	public String deleteKatalog (String id);
	

}
