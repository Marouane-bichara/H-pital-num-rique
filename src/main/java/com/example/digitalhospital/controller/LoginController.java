package com.example.digitalhospital.controller;
import com.example.digitalhospital.entities.Personne;
import com.example.digitalhospital.service.AuthService;
import com.example.digitalhospital.service.interfacesService.IAuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private IAuthService authService;

    public LoginController()
    {
        this.authService = new AuthService();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String typeRole = request.getParameter("typeRole");

        Personne personne = authService.authPersone(email);
        
        
        if("admin".equals(typeRole))
        {
            if (personne == null)
            {

                request.setAttribute("errorMessage", "No Admin with this informations");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);


            } else if (!personne.getMotDePasse().equals(password)) {
                request.setAttribute("errorMessage", "Password is inccorect");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
            request.getSession().setAttribute("userEmail", email);

            request.getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);

        } else if ("docteur".equals(typeRole)) {
            if (personne == null)
            {
                request.setAttribute("errorMessage", "No docteur with this informations");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);


            } else if (!personne.getMotDePasse().equals(password)) {
                request.setAttribute("errorMessage", "Password is inccorect");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

            }
            request.getSession().setAttribute("userEmail", email);

            request.getRequestDispatcher("/WEB-INF/docteurHome.jsp").forward(request, response);
            
        } else if ("patient".equals(typeRole)) {
            if (personne == null)
            {
                request.setAttribute("errorMessage", "No patient with this informations");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);


            } else if (!personne.getMotDePasse().equals(password)) {
                request.setAttribute("errorMessage", "Password is inccorect");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

            }
            request.getSession().setAttribute("userEmail", email);

            request.getRequestDispatcher("/WEB-INF/patientHome.jsp").forward(request, response);
        }

    }

}
