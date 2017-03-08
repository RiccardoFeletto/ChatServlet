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
 * Servlet implementation class AddMessage
 */
@WebServlet(description = "Add a message to the chat", urlPatterns = { "/AddMessage" })
public class AddMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("author").isEmpty() || request.getParameter("text").isEmpty())
		{
			response.setContentType("text/html");
			response.getWriter().println("<b>Errore parametro mancante</b>");
		}
		else
		{
			synchronized(this)
			{
				ServletContext context = getServletContext();
				ArrayList<Pair<String,String>> MessageList = (ArrayList<Pair<String,String>>)context.getAttribute("listamess");
		
				if( MessageList == null )
				{
					MessageList = new ArrayList<Pair<String,String>>();
					context.setAttribute("listamess", MessageList);
				}
			
				Pair<String ,String> Message = new Pair<String,String>();
				Message.setAuthor(request.getParameter("author"));
				Message.setMessage(request.getParameter("text"));
			
				MessageList.add(Message);
			
			}
			
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
