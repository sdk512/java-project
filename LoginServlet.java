package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.dao.LoginDao;
import com.mydata.dao.LoginDaoImpl;
import com.mydata.model.Login;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//get response writer
		PrintWriter out=response.getWriter();
		
		String un=request.getParameter("uname");
		String pas=request.getParameter("pwd");
		Login u=new Login(un, pas);
		LoginDao ud=new LoginDaoImpl();
		
		String res=ud.validUser(u);
		if(res.equals("valid"))
		{
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		else
		{
			out.print("Invalid username or password");
			request.getRequestDispatcher("Login.html").include(request, response);
		}
	}

}
