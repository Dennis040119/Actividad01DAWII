package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.empresa.entity.Medicamentos;
import com.empresa.repository.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService{

		@Autowired
		private MedicamentoRepository repository;

		
		
		@Override
		public List<Medicamentos> MedicamentoList() {
			return repository.findAll();
		}



		@Override
		public Medicamentos insertaActualizaMedicamento(Medicamentos obj) {
			// TODO Auto-generated method stub
			return repository.save(obj);
		}



		
		@Override
		public Optional<Medicamentos> MedicamentoxID(int Id) {
			// TODO Auto-generated method stub
			return repository.findById(Id);
		}



		@Override
		public List<Medicamentos> buscaPorStock(int stock) {
			// TODO Auto-generated method stub
			return repository.findBystock(stock);
		}



		@Override
		public List<Medicamentos> buscarPorNombre(String nombre) {
			// TODO Auto-generated method stub
			return repository.findBynombreLike(nombre);
		}

}
