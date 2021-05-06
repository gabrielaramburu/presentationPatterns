package controler;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controler
 */
@WebServlet("/Controler")
public class PageControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /** 
     * Default constructor. 
     */
    public PageControler() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pageToShow = request.getParameter("pageToShow");
		if (pageToShow.equals("pageOne")) {
			showPageOne(response);
			
		} else if (pageToShow.equals("pageTwo")) {
			showPageTwo(request, response);
			
		} else if (pageToShow.equals("pageTree")) {
			showPageTree(request, response);
		}
		
		System.out.println("Param:" + pageToShow);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	private void showPageOne(HttpServletResponse response) throws IOException {
		/* Esto es lo que termina sucendiendo cuando el contenedor interpreta una página JSP:
		 * traduce la misma a htmly lo manda en el response*/
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<h1>Page One</h1>");
		writer.println("</html>");
	}

	private void showPageTwo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("PageTwo.jsp");
		/* ¿porque necesito el objeto response para redirigir? 
		 * Por la página a la cual redirijo es la que genera la respuesta al browser  */
		requestDispatcher.forward(request, response);
	}
	
	private void showPageTree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* la diferencia entre include and forward es que el segundo implica que la respuesta la genera el servlet
		 * que invoca, incluyendo la respuesta del invocado*/
		RequestDispatcher rd = request.getRequestDispatcher("Helper");
		response.getWriter().println("<h2>before call Helper</h2>");
		rd.include(request, response);
		response.getWriter().println("<h2>after call Helper</h2>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
