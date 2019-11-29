package br.com.fiap.factory;

import br.com.br.dao.impl.ImplementaAlimentacao;
import br.com.br.dao.impl.ImplementaAtividade;
import br.com.br.dao.impl.ImplementaPeso;
import br.com.br.dao.impl.ImplementaPressao;
import br.com.fiap.bean.Peso;
import br.com.fiap.dao.AlimentacaoDao;
import br.com.fiap.dao.AtividadeDao;
import br.com.fiap.dao.PesoDao;
import br.com.fiap.dao.PressaoDao;

public class DaoFactory {
	
	public static PesoDao getPesoDao() {
		return new ImplementaPeso();
	}
	
	public static PressaoDao getPressaoDao() {
		return new ImplementaPressao();
	}
	
	public static AlimentacaoDao getAlimentacaoDao() {
		return new ImplementaAlimentacao();
	}
	public static AtividadeDao getAtividadeDao() {
		return new ImplementaAtividade();
	}
}
