package com.example.digitalhospital.controller.Admin;

import com.example.digitalhospital.entities.Docteur;
import com.example.digitalhospital.service.DocteurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin/doctors/new")
public class AddDoctorController extends HttpServlet {

    private DocteurService docteurService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.docteurService = new DocteurService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addDoctor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");

        String email = req.getParameter("email");
        String motDePasse = req.getParameter("motDePasse");
        String specialite = req.getParameter("specialite");
        String departementIdStr = req.getParameter("departementId");

        Long departementId = Long.parseLong(departementIdStr);

        Docteur docteur = docteurService.registerDocteur(
                nom,
                prenom,
                email,
                motDePasse,
                specialite,
                departementId
        );

        HttpSession session = req.getSession();

        session.setAttribute("successMessage", "Doctor " + docteur.getPrenom() + " " + docteur.getNom() + " has been successfully registered!");

        req.getRequestDispatcher("/WEB-INF/addDoctor.jsp").forward(req, resp);
    }
}