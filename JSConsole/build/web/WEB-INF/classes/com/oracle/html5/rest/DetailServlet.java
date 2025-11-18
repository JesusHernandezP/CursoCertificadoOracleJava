package com.oracle.html5.rest;

import java.io.IOException;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@WebServlet(name = "DetailServlet", urlPatterns = {"/DetailServlet"})
public class DetailServlet extends HttpServlet {

  @Inject
  private JsonUtil jsonUtil;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    Client client = ClientBuilder.newClient();
    client.register(AuthenticationFilter.class);
    WebTarget target = client.target("http://localhost:8080/lab_02_01/restaurant-services/restaurants/" + id);
    JsonObject jsonObject = target
            .request("application/json")
            .get(JsonObject.class);
    Restaurant restaurant = jsonUtil.toRestaurant(jsonObject);
    request.setAttribute("restaurant", restaurant);
    request.getRequestDispatcher("/detailServletView.jsp").forward(request, response);
  }
}
