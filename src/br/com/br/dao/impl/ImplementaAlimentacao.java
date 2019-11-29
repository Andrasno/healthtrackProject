package br.com.br.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Alimentacao;
import br.com.fiap.bean.Atividade;
import br.com.fiap.bean.Pessoa;
import br.com.fiap.dao.AlimentacaoDao;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.ConectionManager;

public class ImplementaAlimentacao  implements AlimentacaoDao{
	
	private Connection connection;
	
	public void cadastrar(String alimentacao) throws DBException {
	PreparedStatement stmt = null;
		
		try {
			connection = ConectionManager.getInstance().getConnection();
			String sql = "INSERT INTO TB_ALIMENTO VALUES (SQ_ALIMENTO.NEXTVAL, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, alimentacao);	
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

	
	public void atualizar(String alimentacao) throws DBException {
	PreparedStatement stmt = null;
		
		try {
			connection = ConectionManager.getInstance().getConnection();
			String sql = "UPDATE TB_ALIMENTO SET COD_ALIMENTO = ?, ALIMENTO_INGERIDO = ? WHERE COD_ALIMENTO = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, alimentacao);
			
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

	
	public void remover(int cod_alimentacao) throws DBException {
	PreparedStatement stmt = null;
		
		try {
			connection = ConectionManager.getInstance().getConnection();
			String sql = "DELETE FROM TB_ALIMENTO WHERE COD_ALIMENTACAO = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, cod_alimentacao);
			
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

	
	public Pessoa buscar(int cod_alimentacao) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Alimentacao alimentacao = null;
			try {
				connection = ConectionManager.getInstance().getConnection();
				String sql = "SELECT * FROM TB_ALIMENTO WHERE COD_ALIMENTO = ?";
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, cod_alimentacao);
				stmt.executeQuery(sql);
				
				if(rs.next()) {
					int codigo = rs.getInt("COD_ALIMENTO");
					String valor = rs.getString("ALIMENTO_INGERIDO");
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
				return alimentacao;
	
       }

	
	public List<Alimentacao> listar() {
		List<Alimentacao> lista = new ArrayList<Alimentacao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = ConectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM TB_ALIMENTO");
			rs = stmt.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("cod_alimento");
				String ativ = rs.getString("alimento_ingerido");
				Alimentacao alimentacao= new Alimentacao();
				lista.add(alimentacao);
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
	public void cadastrar(Alimentacao alimentacao) throws DBException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void atualizar(Alimentacao alimentacao) throws DBException {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
