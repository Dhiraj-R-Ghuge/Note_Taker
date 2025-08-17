package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.Factory_Provider;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			int noteId=Integer.parseInt(request.getParameter("noteId").trim());
			Session s=Factory_Provider.getFactory().openSession();
			Note note=s.get(Note.class, noteId);
			note.setTitle(title);
			note.setContent(content);
			note.setAddedDate(new Date());
			Transaction tx=s.beginTransaction();
			tx.commit();
			
			
			
			
			s.close();
			response.sendRedirect("allnotes.jsp");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
