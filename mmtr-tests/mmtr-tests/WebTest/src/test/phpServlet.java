package test;

import java.io.IOException;

import javax.servlet.ServletContext;

import php.java.servlet.RemoteHttpServletContextFactory;

/**
 * Servlet implementation class phpServlet
 */
@WebServlet("/phpServlet")
public class phpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public phpServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().write("php is running!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RemoteHttpServletContextFactory ctx = new RemoteHttpServletContextFactory(this,
				  getServletContext(), request, request, response);

				response.setHeader("X_JAVABRIDGE_CONTEXT", ctx.getId());
				response.setHeader("Pragma", "no-cache");
				response.setHeader("Cache-Control", "no-cache");

				try {
				  ctx.handleRequests(request.getInputStream(), response.getOutputStream());
				} finally {
				  ctx.destroy();
				}
	}

	private ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
