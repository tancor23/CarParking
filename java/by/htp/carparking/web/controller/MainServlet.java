package by.htp.carparking.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.carparking.dao.DAO;
import by.htp.carparking.domain.Car;
import by.htp.carparking.web.controller.util.FormUtil;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet(name = "MainServlet", urlPatterns = "/MainServlet")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = -7457847603523604817L;

	public MainServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (FormUtil.isPost(request)) {
			if (request.getParameter("action").equals("create")) {
				String brand = request.getParameter("brand");
				String model = request.getParameter("model");
				Car car = new Car(brand, model);
				DAO.getDAO().carDAO.create(car);
			}
			if (request.getParameter("action").equals("update")) {
				int id = FormUtil.getInt(request, "id");
				String brand = request.getParameter("brand");
				String model = request.getParameter("model");
				Car car = new Car(id, brand, model);
				DAO.getDAO().carDAO.update(car);
			}

		}
		if (request.getParameter("delete") != null) {
			DAO.getDAO().carDAO.delete(FormUtil.getInt(request, "delete"));
		}
		List<Car> cars = DAO.getDAO().carDAO.readAll();
		request.setAttribute("cars", cars);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/editcars.jsp");
		dispatcher.forward(request, response);

	}
}
