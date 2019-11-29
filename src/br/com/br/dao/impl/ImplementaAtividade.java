package br.com.br.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.bean.Atividade;
import br.com.fiap.bean.Pessoa;
import br.com.fiap.dao.AtividadeDao;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.ConectionManager;

public class ImplementaAtividade implements AtividadeDao{
	
	private Connection connection;
	
	public void cadastrar(String atividade) throws DBException {
	PreparedStatement stmt = null;
		
		try {
			connection = ConectionManager.getInstance().getConnection();
			String sql = "INSERT INTO TB_ATIVIDADE VALUES (SQ_ATIVIDADE.NEXTVAL, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, atividade);	
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

	
	public void atualizar(String atividade) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			connection = ConectionManager.getInstance().getConnection();
			String sql = "UPDATE TB_ATIVIDADE SET COD_ATIVIDADE = ?, ATIVIDADE_REALIZADA = ? WHERE COD_ATIVIDADE = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, atividade);
			
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

	
	public void remover(int cod_atividade) throws DBException {
	PreparedStatement stmt = null;
		
		try {
			connection = ConectionManager.getInstance().getConnection();
			String sql = "DELETE FROM TB_ATIVIDADE WHERE COD_ATIVIDADE = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, cod_atividade);
			
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

	
	public Pessoa buscar(int cod_atividade) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Atividade atividade = null;
			try {
				connection = ConectionManager.getInstance().getConnection();
				String sql = "SELECT * FROM TB_ATIVIDADE WHERE COD_ATIVIDADE = ?";
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, cod_atividade);
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
				return atividade;
	
	}


	
	public List<Atividade> listar() {
		List<Atividade> lista = new ArrayList<Atividade>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = ConectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM TB_PRESSAO");
			rs = stmt.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("cod_atividade");
				String ativ = rs.getString("atividade_realizada");
				Atividade atividade= new Atividade();
				lista.add(atividade);
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


	@Override
	public void cadastrar(Atividade atividade) throws DBException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void atualizar(Atividade atividade) throws DBException {
		// TODO Auto-generated method stub
		
	}
}
