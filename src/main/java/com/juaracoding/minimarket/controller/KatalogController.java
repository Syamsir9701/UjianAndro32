package com.juaracoding.minimarket.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.minimarket.entity.Katalog;
import com.juaracoding.minimarket.entity.Response;
import com.juaracoding.minimarket.service.ModelKatalog;

@RestController
@RequestMapping("/katalog")

public class KatalogController {
	
	@Autowired
	ModelKatalog modelKatalog;
	
	
	@GetMapping("/")
	public ResponseEntity<Response> getAll(){
		
		Response response = new Response();
		
		response.setStatusCode(200);
		response.setMessage("Berhasil Mendapatkan Data");
		response.setData(this.modelKatalog.getAllKatalog());
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Response> addData(@RequestBody Katalog katalog){
		
		Response response = new Response();
		
		response.setStatusCode(200);
		response.setMessage("Berhasil Menambahkan Data");
		response.setData(this.modelKatalog.addKatalog(katalog));
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}
		
	
	@PostMapping("/update{id}")
	public ResponseEntity<Response> updateData(@RequestBody Katalog katalog, @PathVariable String id){
		
		Response response = new Response();
		
		response.setStatusCode(200);
		response.setMessage("Berhasil Update Data");
		katalog.setId(Long.parseLong(id));
		response.setData(this.modelKatalog.updateKatalog(katalog));
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}
	
	@DeleteMapping("/add")
	public ResponseEntity<Response> deleteData(@PathVariable String id){
		
		Response response = new Response();
		
		response.setStatusCode(200);
		response.setMessage("Berhasil Menghapus Data");
		response.setData(this.modelKatalog.deleteKatalog(id));
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}
	
	@GetMapping("/{id}")
	public Katalog getDataById(@PathVariable String id) {
		return this.modelKatalog.getByIdKatalog(id);
	}
		
	

		
	
	

}
