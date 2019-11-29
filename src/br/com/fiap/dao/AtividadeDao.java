package br.com.fiap.dao;

import java.util.List;


import br.com.fiap.bean.Atividade;
import br.com.fiap.bean.Pessoa;
import br.com.fiap.exception.DBException;

public interface AtividadeDao {
	void cadastrar(Atividade atividade) throws DBException;
	void cadastrar(String atividade) throws DBException;
	void atualizar(Atividade atividade) throws DBException;
	void atualizar(String atividade) throws DBException;
	void remover(int cod_atividade) throws DBException;
	Pessoa buscar(int cod_atividade);
	List<Atividade> listar();

}
