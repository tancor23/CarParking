package by.htp.carparking.web.action.impl;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;
import static by.htp.carparking.web.util.HttpRequestParamValidator.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;

import javax.servlet.http.HttpServletRequest;
import by.htp.carparking.service.OrderService;
import by.htp.carparking.service.impl.OrderServiceImpl;
import by.htp.carparking.web.action.BaseAction;

public class OrderCarAction implements BaseAction {

	// TODO to IoC
	private OrderService orderService = new OrderServiceImpl();

	@Override
	public String executeAction(HttpServletRequest request) {

		String carId = request.getParameter(REQUEST_PARAM_CAR_ID);
		String userId = request.getParameter(REQUEST_PARAM_USER_ID);

		validateRequestParamNotNull(carId, userId);
		orderService.orderCar(formatString(userId), formatString(carId));

		request.setAttribute(REQUEST_MSG_SUCCES, "The car was ordered successfully");
		return PAGE_USER_MAIN;
	}

}
