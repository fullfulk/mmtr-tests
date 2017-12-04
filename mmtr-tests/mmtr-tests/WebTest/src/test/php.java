package test;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import php.java.servlet.RemoteHttpServletContextFactory;

/**
 * Servlet implementation class php
 */
@WebServlet("/php")
public class php extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public php() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().write("php is running!");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RemoteHttpServletContextFactory ctx = new RemoteHttpServletContextFactory(this, getContext(), request,
				request, response);

		response.setHeader("X_JAVABRIDGE_CONTEXT", ctx.getId());
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");

		try {
			ctx.handleRequests(request.getInputStream(), response.getOutputStream());
		} finally {
			ctx.destroy();
		}
	}

	private ServletContext getContext() {
		// TODO Auto-generated method stub
		return null;
	}

}
