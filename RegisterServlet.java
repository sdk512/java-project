package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.dao.RegistrationDao;
import com.mydata.dao.RegistrationDaoImpl;
import com.mydata.model.Registration;


/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		
		String un=request.getParameter("uname");
		String pwd=request.getParameter("pass");
		int phno=Integer.parseInt(request.getParameter("pno"));
		String country=request.getParameter("country");
		
		Registration r=new Registration(un, pwd, phno, country);
		RegistrationDao rd=new RegistrationDaoImpl();
		int res=rd.saveRegistration(r);
		
		if(res>0)
		{
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		else
		{
			out.print("Pls try again!!!!");
			request.getRequestDispatcher("Registration.jsp").include(request, response);
		}
		
	}

}
