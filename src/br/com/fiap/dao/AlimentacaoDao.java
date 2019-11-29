package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.bean.Alimentacao;
import br.com.fiap.bean.Pessoa;
import br.com.fiap.exception.DBException;

public interface AlimentacaoDao {
	void cadastrar(Alimentacao alimentacao) throws DBException;
	void cadastrar(String alimentacao) throws DBException;
	void atualizar(Alimentacao alimentacao) throws DBException;
	void atualizar(String alimentacao) throws DBException;
	void remover(int cod_alimentacao) throws DBException;
	Pessoa buscar(int cod_alimentacao);
	List<Alimentacao> listar();
}
