/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Model.Fruit;
import Model.FruitDB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
    String email = request.getParameter("email");
    String pw = request.getParameter("pw");
    String remember = request.getParameter("remember");

    HttpSession session = request.getSession();
    FruitDB fruitDB = new FruitDB();

    // Retrieve or fetch fruit list
    ArrayList<Fruit> listF = (ArrayList<Fruit>) session.getAttribute("listF");
    if (listF == null) {
        listF = fruitDB.listAll();
        session.setAttribute("listF", listF);
    }

    try {
        String pwDB = fruitDB.login(email);

        if (pwDB != null && pwDB.equals(pw)) {
            // Store users in request
            request.setAttribute("lUser", fruitDB.listUser());
            request.setAttribute("listF", listF);
            request.setAttribute("err", "Login thành công!");

            // Handle Remember Me
            int maxAge = remember != null && remember.equals("ON") ? 24 * 60 * 60 : 0;
            response.addCookie(new Cookie("email", email));
            response.addCookie(new Cookie("pw", pw));
            response.addCookie(new Cookie("remember", remember != null ? "ON" : ""));

            // Redirect to login success page
            request.getRequestDispatcher("LoginCustomer.jsp").forward(request, response);
        } else {
            request.setAttribute("err", "Sai tài khoản hoặc mật khẩu!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    } catch (Exception e) {
        request.setAttribute("err", "Lỗi hệ thống, vui lòng thử lại!");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
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
