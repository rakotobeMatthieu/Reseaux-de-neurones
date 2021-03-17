<%-- 
    Document   : home
    Created on : 2 sept. 2020, 14:23:04
    Author     : Matthieu
--%>
<%@page import="java.util.List"%>
<%
List<String> result = null; 
if(request.getAttribute("liste")!=null) result = (List<String>)request.getAttribute("liste");

String nomFichier1 = null; 
if(request.getAttribute("nomFichier")!=null) nomFichier1 = (String)request.getAttribute("nomFichier");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <h1>List des tests</h1>
    <body>
        <% for(int i=0;i<result.size();i++){
            String[] sp = result.get(i).split("testing");
            
            out.print(result.get(i)); 
            
        %>
        <br>
        <br>
         <form id="form2" action="Servlet3" metho="get">
             <input type="hidden" name="testing" value="OK">
             <input type="hidden" name="nomFichier1" value="<% out.print(nomFichier1) ;%>">
             <input type="hidden" name="nomFichier2" value="<% out.print(sp[1].substring(1));  %>">
             <input type="submit" class="login100-form-btn" value="Prediction"/>
         </form>
             <br>
         <hr>  
        <%
            }
        %>    
    </body>
</html>
