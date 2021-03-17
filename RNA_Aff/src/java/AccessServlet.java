// Import required java libraries
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.RequestDispatcher;
 
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

public class AccessServlet extends HttpServlet {
   
   private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 50 * 1024;
   private int maxMemSize = 4 * 1024;
   private File file ;

   public void init( ){
      // Get the file location where it would be stored.
      filePath = getServletContext().getInitParameter("file-upload"); 
   }
   
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {
               Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\Matthieu\\Desktop\\DESKTOP\\BOSY\\M1\\Réseaux de neurone\\RNA_Project\\dataset"));
               List<String> result = walk.filter(Files::isRegularFile)
                 .map(x -> x.toString()).collect(Collectors.toList());
               
               
                request.setAttribute("liste", result);
                RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                dispatcher.forward(request, response);
                String redirectURL = "home.jsp";
                response.sendRedirect(redirectURL);
      }
      
      public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, java.io.IOException {
          
                String nomFichier = request.getParameter("nomFichier");
                String testing = request.getParameter("testing");
                String nomFichier2 = "C:\\Users\\Matthieu\\Desktop\\DESKTOP\\BOSY\\M1\\Réseaux de neurone\\RNA_Project\\dataset\\"+nomFichier;
                System.out.println("Nomfichier actuel ==== "+nomFichier);

                Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\Matthieu\\Desktop\\DESKTOP\\BOSY\\M1\\Réseaux de neurone\\RNA_Project\\testing"));
                List<String> result = walk.filter(Files::isRegularFile)
                 .map(x -> x.toString()).collect(Collectors.toList());              
                request.setAttribute("nomFichier", nomFichier);
                request.setAttribute("liste", result);
            
            //Redirect and sending Attributes    
                /*RequestDispatcher dispatcher = request.getRequestDispatcher("testList.jsp");
                dispatcher.forward(request, response);*/
                request.getRequestDispatcher("testList.jsp").forward(request, response);
      }
   }
