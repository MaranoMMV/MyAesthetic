package com.myaesthetic.MyAesthetic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myaesthetic.MyAesthetic.entity.Procedimento;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long>{
	
	Optional<List<Procedimento>> findByNome(String nome);
	
}