<%-- 
    Document   : summary
    Created on : 5 sept. 2020, 09:12:16
    Author     : Matthieu
--%>
<%
    String nomFichier = null;
    if(request.getAttribute("NomFichier")!=null) nomFichier = (String)request.getAttribute("NomFichier");
    
    String summary = null;
    if(request.getAttribute("Sum")!=null) summary = (String)request.getAttribute("Sum");
    summary = summary.replace("\n", "<br>");
    summary = summary.replace(" ", "&nbsp;");
    
    String confMatrix = null;
    if(request.getAttribute("CM")!=null) confMatrix = (String)request.getAttribute("CM");
    confMatrix = confMatrix.replace("\n", "<br>");
    confMatrix = confMatrix.replace(" ", "&nbsp;&nbsp;&nbsp;");
    
    String tree = null;
    if(request.getAttribute("Tree")!=null) tree = (String)request.getAttribute("Tree");
    tree = tree.replace("\n", "<br>");
    tree = tree.replace(" ", "&nbsp;&nbsp;&nbsp;");
    
    String lisData = null;
    if(request.getAttribute("lisData")!=null) lisData = (String)request.getAttribute("lisData");
    lisData = lisData.replace("\n", "<br>");
    lisData = lisData.replace(",", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nomfichier : </h1>
        <% 
            out.print(nomFichier); 
        %>
        <br>
        
         <h1>Liste des elements</h1>
        <% 
            out.print(lisData); 
        %>
        <br>
        
        <h1>Summary :</h1>
        <% 
            out.print(summary); 
        %>
        <br>
        
        <h1>Confusion Matrix :</h1>
        <% 
            out.print(confMatrix); 
        %>
        <br>
        
        <h1>Arbre de Visualisation :</h1>
        <% 
            out.print(tree); 
        %>
        <br>
    </body>
</html>
