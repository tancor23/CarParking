package by.htp.carparking.web.controller.util;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class FormUtil {

    public static boolean isPost(HttpServletRequest request){
        return request.getMethod().toUpperCase().equals("POST");
    }

    public static String checkValue(String value, String regex) throws ParseException {
        if (value.matches(regex)) return  value;
        else throw new ParseException("Input ERROR", 1);
    }

    public static int getInt(HttpServletRequest request, String paramName){
        String value = request.getParameter(paramName);
        return Integer.parseInt(value);
    }

    public static double getDouble(HttpServletRequest request, String paramName){
        String value = request.getParameter(paramName);
        return Double.parseDouble(value);
    }

}
