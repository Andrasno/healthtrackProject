package br.com.br.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.fiap.bean.Peso;
import br.com.fiap.bean.Pessoa;
import br.com.fiap.bean.Pressao;
import br.com.fiap.dao.PesoDao;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.ConectionManager;

public class ImplementaPeso implements PesoDao {
	private Connection connection;
	
	public void cadastrar(Peso peso) throws DBException {
	PreparedStatement stmt = null;
		
		try {
			connection = ConectionManager.getInstance().getConnection();
			String sql = "INSERT INTO TB_peso VALUES (SQ_PESO.NEXTVAL, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, peso.getValor_peso());
			
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	public void atualizar(double peso) throws DBException {
PreparedStatement stmt = null;
		
		try {
			connection = ConectionManager.getInstance().getConnection();
			String sql = "UPDATE TB_PESO SET COD_PESO = ?, VALOR_PESO = ? WHERE COD_PESO = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, peso);
			
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

	
	public void remover(int cod_peso) throws DBException {
		PreparedStatement stmt = null;
		try {
			connection = ConectionManager.getInstance().getConnection();
			String sql = "DELETE FROM TB_PESO WHERE COD_PESO = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, cod_peso);
			
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

	
	public Pessoa buscar(int cod_peso) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Peso peso = null;
			try {
				connection = ConectionManager.getInstance().getConnection();
				String sql = "SELECT * FROM TB_PESO WHERE COD_PESO = ?";
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, cod_peso);
				stmt.executeQuery(sql);
				
				if(rs.next()) {
					int codigo = rs.getInt("COD_PESO");
					double valor = rs.getDouble("VALOR_PESO");
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
				return peso;
	
	}
	public List<Peso> listar() {
		List<Peso> lista = new ArrayList<Peso>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = ConectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM TB_PESO");
			rs = stmt.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("cod_peso");
				double esforco = rs.getDouble("valor_peso");
				Peso peso = new Peso();
				lista.add(peso);
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
