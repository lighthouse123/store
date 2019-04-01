package server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServer
 */
//@WebServlet("/LoginServer")
public class LoginServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServer() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("fdsaffffffff");
		String username = request.getParameter("username");
		//System.out.println(username+"00000000000");
		request.getSession().setAttribute("username", username);
		response.sendRedirect("chat.jsp");
		//request.getRequestDispatcher("chat.jps").forward(request, response);
	
	}

}















