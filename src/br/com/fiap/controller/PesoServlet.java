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
import br.com.fiap.dao.PesoDao;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DaoFactory;


@WebServlet("/peso")
public class PesoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private PesoDao dao;
   
	public void init() throws ServletException{
		super.init();
		dao = DaoFactory.getPesoDao();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Peso> lista = dao.listar();
		request.setAttribute("peso", lista);
		request.getRequestDispatcher("listarPeso.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int valor_peso = Integer.parseInt(request.getParameter("valor"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar fabricacao = Calendar.getInstance();
			fabricacao.setTime(format.parse(request.getParameter("inclusao")));
			Peso peso = new Peso();
			dao.cadastrar(peso);
			
			request.setAttribute("msg", "Peso registrado!");
			
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar!");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("CadastrarPeso.jsp").forward(request, response);
	}

}
