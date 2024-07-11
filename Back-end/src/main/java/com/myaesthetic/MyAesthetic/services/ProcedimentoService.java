package com.myaesthetic.MyAesthetic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.myaesthetic.MyAesthetic.entity.Procedimento;
import com.myaesthetic.MyAesthetic.repository.ProcedimentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProcedimentoService {
	
	private final ProcedimentoRepository procedimentoRepository;
	
	public Procedimento salvarProcedimento(Procedimento procedimento) {
		return this.procedimentoRepository.save(procedimento);
	}
	
	public Procedimento buscarProcedimentoPorId(Long id) {
		return this.procedimentoRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id do procedimento não encontrado"));
	}
	
	public List<Procedimento> buscarTodosProcedimentos(){
		return this.procedimentoRepository.findAll();
	}
	
	public void modificarProcedimento( Long id, Procedimento procedimento) {
		this.procedimentoRepository.findById(id).map( procedimentoAlterado -> {
			procedimentoAlterado.setDescricao(procedimento.getDescricao());
			procedimentoAlterado.setNome(procedimento.getNome());
			procedimentoAlterado.setPreco(procedimento.getPreco());
			procedimentoAlterado.setStatus(procedimento.getStatus());
			return this.procedimentoRepository.save(procedimentoAlterado);
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não encontrado para ser alterado"));
	}
	
	public void deletarProcedimento( Long id ) {
		this.procedimentoRepository.findById(id).map(procedimento -> {
			this.procedimentoRepository.delete(procedimento);
			return Void.TYPE;
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado"));
	}
	
	public Optional<List<Procedimento>> buscarProcedimentoPeloNome(String nome){
		return this.buscarProcedimentoPeloNome(nome);
	}

}
