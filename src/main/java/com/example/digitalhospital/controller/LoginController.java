package com.example.digitalhospital.controller;
import com.example.digitalhospital.entities.Admin;
import com.example.digitalhospital.entities.Docteur;
import com.example.digitalhospital.entities.Personne;
import com.example.digitalhospital.service.AdminService;
import com.example.digitalhospital.service.AuthService;
import com.example.digitalhospital.service.DocteurService;
import com.example.digitalhospital.service.interfacesService.IAdminService;
import com.example.digitalhospital.service.interfacesService.IAuthService;
import com.example.digitalhospital.service.interfacesService.IDocteurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private IAuthService authService;
    private IAdminService adminService;
    private IDocteurService docteurService;

    public LoginController()
    {
        this.authService = new AuthService();
        this.adminService = new AdminService();
        this.docteurService = new DocteurService();
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

            Admin admin = adminService.findById(personne.getId());

            if(admin == null)
            {
                request.setAttribute("errorMessage", "You are not an admin");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
            request.getSession().setAttribute("userEmail", email);

            request.getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);

        } else if ("docteur".equals(typeRole)) {
            if (personne == null)
            {
                request.setAttribute("errorMessage", "No doctor with this informations");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);


            } else if (!personne.getMotDePasse().equals(password)) {
                request.setAttribute("errorMessage", "Password is inccorect");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

            }


            Docteur docteur = docteurService.getDocteurById(personne.getId());

            if(docteur == null)
            {
                request.setAttribute("errorMessage", "You are not an doctor");
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
