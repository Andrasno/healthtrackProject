package br.com.fiap.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Alimentacao;
import br.com.fiap.dao.AlimentacaoDao;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DaoFactory;

/**
 * Servlet implementation class AlimentoServlet
 */
@WebServlet("/AlimentoServlet")
public class AlimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AlimentacaoDao dao;
	
	public void init() throws ServletException{
		super.init();
		dao = DaoFactory.getAlimentacaoDao();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Alimentacao> lista = dao.listar();
		request.setAttribute("alimentacao", lista);
		request.getRequestDispatcher("listarAlimento.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String comida = request.getParameter("alimentacao");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
			Calendar inclusao = Calendar.getInstance();
			inclusao.setTime(format.parse(request.getParameter("datainclusao")));
			Alimentacao alimentacao = new Alimentacao();
			dao.cadastrar(alimentacao);
			
			
		}catch (DBException db) {
			db.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("cadastrarAlimento.jsp").forward(request, response);
	}

}
