package br.com.br.dao.impl;

import java.sql.Connection;
import java.util.*;

import br.com.fiap.bean.Pessoa;
import br.com.fiap.dao.PessoaDao;
import br.com.fiap.exception.DBException;

public class ImplementaPessoa implements PessoaDao {
	
	

		private Connection connection;
		
		public void cadastrar(Pessoa pessoa) throws DBException {
			
		}

		
		public void atualizar(Pessoa pessoa) throws DBException {

		}

		
		public void remover(int codigo) throws DBException {
			
		}

		
		public Pessoa buscar(int id) {
			return null;
		
	       }

		
		public List<Pessoa> listar() {
			return null;
			
		}

	}


