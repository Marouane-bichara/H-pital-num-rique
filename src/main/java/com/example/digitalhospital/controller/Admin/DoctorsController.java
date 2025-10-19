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
import java.util.List;

@WebServlet("/admin/doctors")
public class DoctorsController extends HttpServlet {

    private DocteurService docteurService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.docteurService = new DocteurService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Docteur> docteurs = docteurService.getallDocteurs();
        long totalDoctors = docteurService.getTotalDocteurs();

        req.setAttribute("docteurs", docteurs);
        req.setAttribute("totalDoctors", totalDoctors);

        req.getRequestDispatcher("/WEB-INF/doctorsAdmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            handleDelete(req, resp);
        }
    }

    private void handleDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idStr = req.getParameter("id");
        HttpSession session = req.getSession();

        Long id = Long.parseLong(idStr);
        docteurService.deleteDocteur(id);

        session.setAttribute("successMessage", "Doctor has been successfully deleted!");
        resp.sendRedirect(req.getContextPath() + "/admin/doctors");
    }
}