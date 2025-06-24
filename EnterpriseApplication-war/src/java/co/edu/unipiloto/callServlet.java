/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lokci
 */
public class callServlet extends HttpServlet {

    @EJB
    private callBeanLocal callBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String oper1S = request.getParameter("num1");
        String oper2S = request.getParameter("num2");
        String operacion = request.getParameter("action");

        int oper1 = 0;
        int oper2 = 0;
        Integer resultado = null;
        String mensaje = "";

        try {
            oper1 = Integer.parseInt(oper1S);
            if (!operacion.equals("Cuadrado")) {
                oper2 = Integer.parseInt(oper2S);
            }

            switch (operacion) {
                case "Sumar":
                    resultado = callBean.addition(oper1, oper2);
                    mensaje = oper1 + " + " + oper2 + " = " + resultado;
                    break;
                case "Restar":
                    resultado = callBean.subtraction(oper1, oper2);
                    mensaje = oper1 + " - " + oper2 + " = " + resultado;
                    break;
                case "Multiplicar":
                    resultado = callBean.multiplication(oper1, oper2);
                    mensaje = oper1 + " * " + oper2 + " = " + resultado;
                    break;
                case "Dividir":
                    resultado = callBean.division(oper1, oper2);
                    mensaje = (resultado == null) ? "Error: división por cero" : oper1 + " / " + oper2 + " = " + resultado;
                    break;
                case "Modulo":
                    resultado = callBean.modulo(oper1, oper2);
                    mensaje = (resultado == null) ? "Error: módulo por cero" : oper1 + " % " + oper2 + " = " + resultado;
                    break;
                case "Cuadrado":
                    resultado = callBean.square(oper1);
                    mensaje = oper1 + " ^2 = " + resultado;
                    break;
                default:
                    mensaje = "Operación no reconocida";
            }

        } catch (NumberFormatException e) {
            mensaje = "Error: ingrese solo números válidos.";
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html><head><title>Resultado</title></head><body>");
            out.println("<h1>Resultado</h1>");
            out.println("<h2>" + mensaje + "</h2>");
            out.println("<a href='index.jsp'>Volver</a>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Calculadora con operaciones básicas";
    }

}
