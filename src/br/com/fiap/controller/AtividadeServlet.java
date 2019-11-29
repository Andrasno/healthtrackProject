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

import br.com.fiap.bean.Atividade;
import br.com.fiap.dao.AtividadeDao;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DaoFactory;

/**
 * Servlet implementation class AtividadeServlet
 */
@WebServlet("/atividade")
public class AtividadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private AtividadeDao dao;
   
   public void init() throws ServletException {
	   super.init();
	   dao = DaoFactory.getAtividadeDao();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Atividade> lista = dao.listar();
		request.setAttribute("atividade", lista);
		request.getRequestDispatcher("listarAtividade.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String ativ = request.getParameter("atividade");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar inclusao = Calendar.getInstance();
		inclusao.setTime(format.parse(request.getParameter("datainclusao")));
		Atividade atividade = new Atividade();
		dao.cadastrar(atividade);
		
	}catch (DBException db) {
		db.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
		request.getRequestDispatcher("cadastrarAtividade.jsp").forward(request, response);
	}
}
