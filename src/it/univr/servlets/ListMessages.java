package it.univr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.univr.classes.ListaMess;
import it.univr.classes.Pair;

/**
 * Servlet implementation class ListMessages
 */
@WebServlet(description = "Get list of all message", urlPatterns = { "/ListMessages" })
public class ListMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMessages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		int n = Integer.parseInt(request.getParameter("howmany").trim());
		if(n>0)
		{
			synchronized (this) 
			{
				ServletContext context = getServletContext();
			
				ArrayList<Pair<String,String>> MessageList = (ArrayList<Pair<String,String>>)context.getAttribute("listamess");
			
				PrintWriter out = response.getWriter();
				for(int i=0; i<n; i++)
				{
					out.println("<b>"+MessageList.get(i).getAuthor()+": "+MessageList.get(i).getMessage()+"</b><br>");
				}
			}
		}
		else
		{
			response.getWriter().println("<b>Errore parametro</b>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
