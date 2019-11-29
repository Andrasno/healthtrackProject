package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.bean.Pessoa;
import br.com.fiap.exception.DBException;


public interface PessoaDao {
	
	
	
		void cadastrar(Pessoa pessoa) throws DBException;
		void atualizar(Pessoa pessoa) throws DBException;
		void remover(int codigo) throws DBException;
		Pessoa buscar(int id);
		List<Pessoa> listar();
	}

