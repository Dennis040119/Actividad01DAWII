package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.empresa.entity.Medicamentos;
import com.empresa.service.MedicamentoService;

@RestController
@RequestMapping("/rest/Medicamento")
public class MedicamentoRestController {
	
	@Autowired
	private MedicamentoService service;
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<List<Medicamentos>> listaAlumno(){
		List<Medicamentos> lista = service.MedicamentoList();

		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Medicamentos> insertaMedicamento(@RequestBody Medicamentos obj){
		if(obj==null) {
			return ResponseEntity.noContent().build();
		}
		else {
			obj.setIdMedicamento(0);
			Medicamentos ObjSalida= service.insertaActualizaMedicamento(obj);
			return ResponseEntity.ok(ObjSalida);
		}		
	}
	
	@GetMapping("/id/{paramId}")
	@ResponseBody
	public ResponseEntity<Medicamentos> buscaPorId(@PathVariable("paramId") int idMedica){
		Optional<Medicamentos> optMedica = service.MedicamentoxID(idMedica);
		if (optMedica.isPresent()) {
			return ResponseEntity.ok(optMedica.get());
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/stock/{paramStock}")
	@ResponseBody
	public ResponseEntity<List<Medicamentos>> buscaPorDni(@PathVariable("paramStock") int stock){

		List<Medicamentos> lista = service.buscaPorStock(stock);

		if (CollectionUtils.isEmpty(lista)) {

			return ResponseEntity.badRequest().build();

		}else {

			return ResponseEntity.ok(lista);

		}

	}
	
	@GetMapping("/nombre/{paramNombre}")
	@ResponseBody
	public ResponseEntity<List<Medicamentos>> buscaPorNombre(@PathVariable("paramNombre") String nombre){

		List<Medicamentos> lista = service.buscarPorNombre(nombre);

		if (CollectionUtils.isEmpty(lista)) {

			return ResponseEntity.badRequest().build();

		}else {

			return ResponseEntity.ok(lista);

		}

	}
	
	
}
