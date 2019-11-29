package br.com.br.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Atividade;

import br.com.fiap.bean.Pessoa;
import br.com.fiap.bean.Pressao;
import br.com.fiap.dao.PressaoDao;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.ConectionManager;

public class ImplementaPressao implements PressaoDao{
	
	private Connection connection;
	
	public void cadastrar(Pressao pressao) throws DBException {
	PreparedStatement stmt = null;
		
		try {
			connection = ConectionManager.getInstance().getConnection();
			String sql = "INSERT INTO t_pressao VALUES (SQ_PRESSAO.NEXTVAL, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, pressao.getValor_pressao());
			
			stmt.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	public void atualizar(Pressao pressao) throws DBException {
PreparedStatement stmt = null;
		
		try {
			connection = ConectionManager.getInstance().getConnection();
			String sql = "UPDATE TB_PRESSAO SET COD_PRESSAO = ?, VALOR_PRESSAO = ? WHERE COD_PRESSAO = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, pressao.getValor_pressao());
			
			stmt.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

	
	public void remover(int cod_pressao) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			connection = ConectionManager.getInstance().getConnection();
			String sql = "DELETE FROM TB_PRESSAO WHERE COD_PRESSAO = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, cod_pressao);
			
			stmt.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	public Pessoa buscar(int cod_pressao) {
	PreparedStatement stmt = null;
	ResultSet rs = null;
	Pressao pressao = null;
		try {
			connection = ConectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM TB_PRESSAO WHERE COD_PRESSAO = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, cod_pressao);
			stmt.executeQuery(sql);
			
			if(rs.next()) {
				int codigo = rs.getInt("COD_PRESSAO");
				double valor = rs.getDouble("VALOR_PRESSAO");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
			return pressao;
	}
	public List<Pressao> listar() {
		List<Pressao> lista = new ArrayList<Pressao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = ConectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM TB_PRESSAO");
			rs = stmt.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("cod_pressao");
				double esforco = rs.getDouble("valor_pressao");
				Pressao pressao = new Pressao();
				lista.add(pressao);
				}
					} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						stmt.close();
						rs.close();
						connection.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
		return lista;
	}
	}

