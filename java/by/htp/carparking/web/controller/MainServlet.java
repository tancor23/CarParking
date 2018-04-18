package by.htp.carparking.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import by.htp.carparking.dao.DAOSingletonOfCar;
import by.htp.carparking.domain.Car;
import by.htp.carparking.web.configuration.WebConfig;
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
	public void init() throws ServletException {
		super.init();
		ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
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
		
		ServletContext servletContext = request.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		
		if (FormUtil.isPost(request)) {
			if (request.getParameter("action").equals("create")) {
				String brand = request.getParameter("brand");
				String model = request.getParameter("model");
				Car car = new Car(brand, model);
				DAOSingletonOfCar.getDAO().carDAO.create(car);
			}
			System.out.println(request.getParameter("action").equals("update"));
			if (request.getParameter("action").equals("update")) {
				int id = FormUtil.getInt(request, "id");
				System.out.println(id);
				String brand = request.getParameter("brand");
				String model = request.getParameter("model");
				System.out.println(brand);
				System.out.println(model);
				Car car = new Car(id, brand, model);
				DAOSingletonOfCar.getDAO().carDAO.update(car);
			}
			System.out.println(request.getParameter("action").equals("update"));
		}
		if (request.getParameter("delete") != null) {
			DAOSingletonOfCar.getDAO().carDAO.delete(FormUtil.getInt(request, "delete"));
		}
		List<Car> cars = DAOSingletonOfCar.getDAO().carDAO.readAll();
		request.setAttribute("cars", cars);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/editcars.jsp");
		dispatcher.forward(request, response);

	}
}
