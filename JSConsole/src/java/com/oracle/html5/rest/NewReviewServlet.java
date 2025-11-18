package com.oracle.html5.rest;

import java.io.IOException;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

@WebServlet(name = "NewReviewServlet", urlPatterns = {"/NewReviewServlet"})
public class NewReviewServlet extends HttpServlet {

  @Inject
  private JsonUtil jsonUtil;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    JsonObject parameters = Json.createObjectBuilder()
            .add("text", request.getParameter("text"))
            .add("rating", Integer.parseInt(request.getParameter("rating")))
            .build();
    Client client = ClientBuilder.newClient();
    client.register(AuthenticationFilter.class);
    WebTarget target = client.target("http://localhost:8080/lab_02_01/restaurant-services/restaurants/" + id);
    target.request().post(Entity.json(parameters), JsonObject.class);
    response.sendRedirect("DetailServlet?id=" + id);
  }
}
