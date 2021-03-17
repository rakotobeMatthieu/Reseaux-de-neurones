/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.Main_Class;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matthieu
 */
public class Servlet3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet3 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //ASSIGN VALUE
        String nomFichier = request.getParameter("nomFichier");
        String testing = request.getParameter("testing");
        String nomFichier2 = "C:\\Users\\Matthieu\\Desktop\\DESKTOP\\BOSY\\M1\\Réseaux de neurone\\RNA_Project\\dataset\\"+nomFichier;
        System.out.println("Nomfichier actuel ==== "+nomFichier);
        Main_Class main_class = new Main_Class();
        
        //TESTINGCONDITION--------------------------
        if(testing.equals("OK")){
            String nomFichier1 = request.getParameter("nomFichier1");
            String nomFichier21 = request.getParameter("nomFichier2");
            nomFichier1="C:\\Users\\Matthieu\\Desktop\\DESKTOP\\BOSY\\M1\\Réseaux de neurone\\RNA_Project\\dataset\\"+nomFichier1;
            nomFichier21="C:\\Users\\Matthieu\\Desktop\\DESKTOP\\BOSY\\M1\\Réseaux de neurone\\RNA_Project\\testing\\"+nomFichier21;
            String prediction = main_class.newClassification(nomFichier1, nomFichier21);
            
            request.setAttribute("prediction", prediction);
            request.getRequestDispatcher("/prediction.jsp").forward(request, response);
        }else{
                    
        //RNA_PROJECT
        
        String list = main_class.listData(nomFichier2);
        String summary = main_class.summary(nomFichier2);
        String confusion_Matrix = main_class.confusionMatrix(nomFichier2);
        String tree =  main_class.arbreDeVisualisation1(nomFichier2);
        
        //RDIRECT AND SET ATTIBUTE
        request.setAttribute("NomFichier", nomFichier);
        
        request.setAttribute("lisData", list);
        System.out.println(""+list);
        
        request.setAttribute("Sum", summary);
        System.out.println(""+summary);
        
        request.setAttribute("CM", confusion_Matrix);
        System.out.println(""+confusion_Matrix);
        
        request.setAttribute("Tree", tree);
        System.out.println(""+tree);
        
        request.getRequestDispatcher("/summary.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
