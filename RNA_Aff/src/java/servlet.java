// Import required java libraries
import java.io.*;
import java.util.*;
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

public class servlet extends HttpServlet {
   
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
       request.setAttribute("test", "valeur");
       System.out.println("doPOST");
      }
      
      public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, java.io.IOException {
          System.out.println("doGet");
          request.setAttribute("test", "valeur");
          RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
      }
   }
