package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.bean.Peso;
import br.com.fiap.bean.Pessoa;

import br.com.fiap.exception.DBException;

public interface PesoDao {
	void cadastrar(Peso peso) throws DBException;
	void atualizar(double peso) throws DBException;
	void remover(int cod_peso) throws DBException;
	Pessoa buscar(int cod_peso);
	List<Peso> listar();

}
