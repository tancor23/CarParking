package by.htp.carparking.web.action.impl;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;
import static by.htp.carparking.web.util.HttpRequestParamValidator.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;

import javax.servlet.http.HttpServletRequest;
import by.htp.carparking.service.OrderService;
import by.htp.carparking.web.action.BaseAction;

public class OrderCarAction implements BaseAction {
	
	private OrderService orderService;

	@Override
	public String executeAction(HttpServletRequest request) {
		String carId = request.getParameter(REQUEST_PARAM_CAR_ID);
		String userId = request.getParameter(REQUEST_PARAM_USER_ID);
		String startOfRental = request.getParameter(REQUEST_PARAM_START_OF_RENTAL);
		String endtOfRental = request.getParameter(REQUEST_PARAM_END_OF_RENTAL);
		validateRequestParamNotNull(carId, userId, startOfRental, endtOfRental);
		orderService.orderCar(formatStringToInt(userId), formatStringToInt(carId),
				formatStringToLocalDate(startOfRental), formatStringToLocalDate(endtOfRental));
		request.setAttribute(REQUEST_MSG_SUCCESS, "The car ordered successfully");
		return PAGE_USER_MAIN;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

}
