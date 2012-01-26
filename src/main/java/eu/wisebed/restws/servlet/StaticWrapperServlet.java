package eu.wisebed.restws.servlet;

import com.google.inject.Singleton;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
public class StaticWrapperServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getNamedDispatcher("default");
		HttpServletRequest wrapped = new HttpServletRequestWrapper(req) {
			public String getPathInfo() {
				return null;
			}
		};
		rd.forward(wrapped, resp);
	}
}