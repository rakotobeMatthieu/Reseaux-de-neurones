<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.List"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.util.stream.Stream"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
   <head>
      <title>File Uploading Form</title>
   </head>
   
   <body>
      <h1>Uploader un nouveaux réseaux</h1>
      <br />
      <form action = "UploadServlet" method = "post" enctype = "multipart/form-data">
         <input type = "file" name = "file" size = "50" />
         <br />
         <input type = "submit" value = "Upload File" />
      </form>
      
      <form action = "AccessServlet" method = "post" enctype = "multipart/form-data">
         <input type = "submit" value = "Acceder à tous les reseaux savegardés" />
      </form>
      <br>
   </body>
</html>