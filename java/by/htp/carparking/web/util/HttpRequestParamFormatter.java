package by.htp.carparking.web.util;

public class HttpRequestParamFormatter {

	private HttpRequestParamFormatter() {
	}

	public static int formatString(String param) {
		return Integer.parseInt(param);
	}
}
