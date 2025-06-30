/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lasalle.services.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.lasalle.services.controller.ControllerUsuario;
import org.lasalle.services.model.Usuario;

/**
 *
 * @author alexc
 */
@Path("usuario")
public class RestUsuario {

    @Path("login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response validar(@FormParam("user") String user,
            @FormParam("password") String password) {
        String out = "";
        try {
            ControllerUsuario CU = new ControllerUsuario();
            Usuario usurio = CU.validarUsuario(user, password);
            if (usurio != null) {
                int idUsuario = usurio.getIdUsuario(); // Suponiendo que tienes un método getId() para obtener el ID del usuario
                out = "(\"idUsuario\" = \"" + idUsuario + "\")";
                return Response.ok(out).build();

            } else {
                out = """
                     ("idUsuario" = "0")
                     """;
                return Response.status(401).build();
            }
        } catch (Exception e) {
            out = """
                 ("error" = %)
                 """;
            out = String.format(out, e.getMessage());
            System.out.println(out);
            return Response.serverError().build();
        }

    }

    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        String out = "";
        List<Usuario> listUsers = null;
        Gson gson = new Gson();
        try {
            ControllerUsuario cu = new ControllerUsuario();
            listUsers = cu.getAll();
            out = gson.toJson(listUsers);
            return Response.ok(out).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @Path("getOne")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByID(@QueryParam("username") String username,@QueryParam("password") String password) {
        String out = "";
        List<Usuario> listUsers = null;
        Gson gson = new Gson();
        try {
            ControllerUsuario cu = new ControllerUsuario();
            listUsers = cu.getAll();
            for (Usuario user : listUsers) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    out = gson.toJson(user.getIdUsuario());
                    return Response.ok(out).build();
                }
            }

            return Response.status(404).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
