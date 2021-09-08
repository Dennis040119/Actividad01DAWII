package com.empresa.service;

import java.util.List;
import java.util.Optional;


import com.empresa.entity.Medicamentos;





public interface MedicamentoService {

	

	List<Medicamentos> MedicamentoList();
	public abstract Medicamentos insertaActualizaMedicamento(Medicamentos obj);
	
	public abstract Optional<Medicamentos> MedicamentoxID(int Id);
	
	public abstract List<Medicamentos>buscaPorStock(int stock);
	
	public abstract List<Medicamentos>buscarPorNombre(String nombre);

}
