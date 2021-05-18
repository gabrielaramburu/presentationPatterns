package servletsFilters.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.JSFexample.model.User;



@WebFilter(
		filterName="Autentication",
		description="This is an autentication filter",
		urlPatterns = "/secure/*"
)

public class AutenticationFilter implements Filter{
	private static final String LOGIN_PAGE = "/loginJSF.xhtml";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Pasando por filtro. ID");
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
				
		System.out.println("sesionId client:" + httpRequest.getRequestedSessionId());
		
		
		//obtengo de la sesion, el managedBean Login
		//es posibl que la session no exista
		HttpSession session = httpRequest.getSession(false);
		
		if (session!=null ) {
			User user = (User) session.getAttribute("login");
			System.out.println("sesionId Sesion:"+ httpRequest.getSession().getId());
			
			if (user != null) {
				chain.doFilter(request, response);
			} else {
				redirectLoginPage(request, response);
			}
			
		} else {
			redirectLoginPage(request, response);
		}
	}
	
	private void redirectLoginPage(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("No hay objeto login asociado a la session");
		/* no hay usuario en la sessión, se hacer forward a la página de login.*/
		RequestDispatcher rDispather = request.getRequestDispatcher(LOGIN_PAGE);
		rDispather.forward(request, response);
		
		//se podría usar un redirect tambien. 
		//Redirect, envía el control al browser
		//Forward, la nevegación se hacer dento del mismo servidor
		//httpResponse.sendRedirect(httpRequest.getContextPath()+LOGIN_PAGE);
	}

}
