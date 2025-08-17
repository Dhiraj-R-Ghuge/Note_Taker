<%@page import="com.helper.Factory_Provider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.*,org.hibernate.*,com.entities.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <%@include file="all_js.jsp" %>
</head>
<body>
<div class="container">
   <%@include file="Navbar.jsp" %>
   <h1>edit your note</h1>
   <br>
  
  <%
  int noteId=Integer.parseInt(request.getParameter("note_id").trim());
  Session s=Factory_Provider.getFactory().openSession();
	
	Note note=(Note)s.get(Note.class,noteId);

  %>
    <form action="UpdateServlet" method="post">
    
    <input  value="<%=note.getId()%> " name="noteId" type="hidden"/>
    
    
  <div class="form-group">
    <label for="title" class="form-label">Note title</label>
    <input 
    name="title"
    required 
    type="text"
     class="form-control" 
     id="title" 
    aria-describedby="emailHelp"
    placeholder="Enter here"
    value="<%=note.getTitle() %>"
    
    />
     </div>
  <div class="form-group">
  <label for="exampleInputPassword1" class="form-label">Note Content</label>
  <textarea  
    name="content"
    required
    id="content"
    placeholder="Enter your content here" 
    class="form-control"
    style="height:300px;"><%=note.getContent()%>
  </textarea>
</div>
  
  <div class="container text-center">
   <button type="submit" class="btn btn-success">Save your note </button>
  
  </div>
  
 
 
</form>
 
  
  
  
  
  
   </div>
</body>
</html>