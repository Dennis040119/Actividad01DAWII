package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.empresa.entity.Medicamentos;

public interface MedicamentoRepository extends JpaRepository<Medicamentos, Integer> {

	public List<Medicamentos> findBystock(int stock);
	
	public List<Medicamentos> findBynombreLike(String nombre);
	
}
