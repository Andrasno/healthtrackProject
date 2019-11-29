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

import br.com.fiap.bean.Peso;
import br.com.fiap.bean.Pressao;
import br.com.fiap.dao.PressaoDao;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DaoFactory;

/**
 * Servlet implementation class PressaoServlet
 */
@WebServlet("/PressaoServlet")
public class PressaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private PressaoDao dao;
 public void init() throws ServletException{
	 super.init();
	 dao = DaoFactory.getPressaoDao();
 }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pressao> lista = dao.listar();
		request.setAttribute("pressao", lista);
		request.getRequestDispatcher("listarPressao.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		double valor_pressao = Double.parseDouble(request.getParameter("valor"));
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar fabricacao = Calendar.getInstance();
		fabricacao.setTime(format.parse(request.getParameter("datainclusao")));
		Pressao pressao = new Pressao();
		dao.cadastrar(pressao);
		
		request.setAttribute("msg", "Pressão registrada!");
		
	}catch (DBException db) {
		db.printStackTrace();
		request.setAttribute("erro", "Erro ao cadastrar!");
	}catch(Exception e) {
		e.printStackTrace();
		request.setAttribute("erro", "Por favor, valide os dados");
	}
	request.getRequestDispatcher("cadastrarPressao.jsp").forward(request, response);
}

}
