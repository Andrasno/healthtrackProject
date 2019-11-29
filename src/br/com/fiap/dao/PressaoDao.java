package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.bean.Atividade;
import br.com.fiap.bean.Pessoa;
import br.com.fiap.bean.Pressao;
import br.com.fiap.exception.DBException;

public interface PressaoDao {
	void cadastrar(Pressao pressao) throws DBException;
	void atualizar(Pressao Pressao) throws DBException;
	void remover(int cod_pressao) throws DBException;
	Pessoa buscar(int cod_pressao);
	List<Pressao> listar();
}
