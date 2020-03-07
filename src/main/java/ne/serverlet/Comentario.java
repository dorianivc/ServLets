/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ne.serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dorianivc
 */
public class Comentario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1. Recibimos los parametros del formulario
       String name= req.getParameter("name");
       String perfil= req.getParameter("perfil");
       String id= req.getParameter("id");
       
      // 2. Aplicamos las reglas del negocio de la informacion del usuario
        System.out.println("Name: "+ name);
        System.out.println("Perfil: "+ perfil);        
        System.out.println("ID: "+ id);
        
       
       // 3. Siempre regresamos una repsuesta al cliente. En este caso un documento HTML
       if (perfil.equals("admin")){
           resp.setContentType("text/html;charset=UTF-8");
           try(PrintWriter out= resp.getWriter()){
               out.println("<!DOCTYPE html>");
               out.println("<html>");
               out.println("<head>");
               out.println("<title>Comentarios</title>");
               out.println("</head>");
               out.println("<body");
               out.println("<h3> Acceso Concedido </h3>");
               out.println("</body>");
               out.println("</html>");
               
               
           }
       } else{
           resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1. Recibimos los parametros del formulario
       String nombreParam= req.getParameter("nombre");
       String emailParam= req.getParameter("email");
       String gradoParam= req.getParameter("grado");
       String comentarioParam= req.getParameter("comentarios");
       //2. Aplicamos las reglas de negocio con la infromacion del formulario enviada por el usuario
        System.out.println("Nombre: "+ nombreParam);
        System.out.println("Email: "+ emailParam);
        System.out.println("Grado: "+ gradoParam);
        System.out.println("Comentarios "+ comentarioParam);
        
        //3. Siempre regreasmos una respuesta al cliente. En este caso un documento HTML
         resp.setContentType("text/html;charset=UTF-8");
           try(PrintWriter out= resp.getWriter()){
               out.println("<!DOCTYPE html>");
               out.println("<html>");
               out.println("<head>");
               out.println("<title>Comentarios</title>");
               out.println("</head>");
               out.println("<body");
               out.println("<h3> Gracias por tus comentarios" + nombreParam+ "</h3>");
               out.println("<h4> En breve nos comunicaremos contigo</h4>");
               out.println("</body>");
               out.println("</html>");
               
       
           }
    }



}
