<%-- 
    Document   : prediction
    Created on : 5 sept. 2020, 16:26:13
    Author     : Matthieu
--%>
<%
    String nomFichier = null;
    if(request.getAttribute("NomFichier")!=null) nomFichier = (String)request.getAttribute("NomFichier");
    
    String prediction = null;
    if(request.getAttribute("prediction")!=null) prediction = (String)request.getAttribute("prediction");
    prediction = prediction.replace("\n", "<br>");
    prediction = prediction.replace(",", "&nbsp;&nbsp;,&nbsp;&nbsp;");
    
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Prediction par rapport au données du fichier : <% out.print(nomFichier) ; %></h1>
        <h3>Existant , Prédiction</h3>
                <% out.print(prediction); %>
    </body>
</html>
