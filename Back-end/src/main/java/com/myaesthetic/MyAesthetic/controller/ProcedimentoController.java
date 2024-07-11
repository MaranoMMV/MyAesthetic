package com.myaesthetic.MyAesthetic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myaesthetic.MyAesthetic.entity.Procedimento;
import com.myaesthetic.MyAesthetic.services.ProcedimentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/procedimentos")
@RequiredArgsConstructor
public class ProcedimentoController {

	private final ProcedimentoService procedimentoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Procedimento postProcedimento( @RequestBody Procedimento procedimento) {
		return this.procedimentoService.salvarProcedimento(procedimento);
	}
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Procedimento getProcedimentoPorId(@PathVariable Long id) {
		return this.procedimentoService.buscarProcedimentoPorId(id);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Procedimento> getProcedimentos(){
		return this.procedimentoService.buscarTodosProcedimentos();
	}
	
	@GetMapping("procurar-nome")
	@ResponseStatus(HttpStatus.OK)
	public Optional<List<Procedimento>> getProcedimentoPorNome(@RequestParam String nome) {
		return this.procedimentoService.buscarProcedimentoPeloNome(nome);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProcedimento(@PathVariable Long id) {
		this.procedimentoService.deletarProcedimento(id);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void putProcedimento(Long id, Procedimento procedimento) {
		this.procedimentoService.modificarProcedimento(id, procedimento);
	}
}
