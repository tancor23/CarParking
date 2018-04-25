package by.htp.carparking.web.action.impl;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;
import by.htp.carparking.web.action.BaseAction;
import by.htp.carparking.web.util.HttpRequestParamFormatter;
import by.htp.carparking.web.util.HttpRequestParamValidator;
import by.htp.carparking.web.util.ValidateNullParamException;

public class AvailableCarListViewAction implements BaseAction{
	
	private CarService carService;

	@Override
	public String executeAction(HttpServletRequest request) {
		String startOfRentalString = request.getParameter(REQUEST_PARAM_START_OF_RENTAL);
		String endtOfRentalString = request.getParameter(REQUEST_PARAM_END_OF_RENTAL);
		try {
			HttpRequestParamValidator.validateRequestParamNotNull(startOfRentalString, endtOfRentalString);
		} catch (ValidateNullParamException e) {
			return PAGE_USER_AVALIABLE_CARS_LIST;
		}
		LocalDate startOfRental = HttpRequestParamFormatter.formatStringToLocalDate(startOfRentalString);
		LocalDate endtOfRental = HttpRequestParamFormatter.formatStringToLocalDate(endtOfRentalString);
		List<Car> cars = carService.getAvaliableCarsList(startOfRental, endtOfRental);
		request.setAttribute(REQUEST_PARAM_START_OF_RENTAL, startOfRentalString);
		request.setAttribute(REQUEST_PARAM_END_OF_RENTAL, endtOfRentalString);
		request.setAttribute(REQUEST_PARAM_AVALIABLE_CAR_LIST, cars);
		return PAGE_USER_AVALIABLE_CARS_LIST;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

}