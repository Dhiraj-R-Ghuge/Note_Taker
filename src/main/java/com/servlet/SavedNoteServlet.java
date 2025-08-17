package com.servlet;

import java.awt.datatransfer.Transferable;
import java.io.IOException;
import java.io.PrintWriter;
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

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;


@WebServlet("/SavedNoteServlet")
public class SavedNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SavedNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			//title ,content fetech
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			Note note=new Note(0, title,content,new Date());
			//System.out.println(note.getId()+" : " + note.getTitle());
			
			//hibernate:save()
			Session s=Factory_Provider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			s.save(note);
			tx.commit();
			s.close();
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<h1 style='text-align:center;'> note is added successfully</h1>");
			out.println("<h1 style='text-align:center;'><a href='allnotes.jsp'/a>view all notes</h1>");

			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
