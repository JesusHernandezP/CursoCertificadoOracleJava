package com.oracle.html5.rest;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@WebServlet(name = "NearbyServlet", urlPatterns = {"/NearbyServlet"})
public class NearbyServlet extends HttpServlet {

  @Inject
  private JsonUtil jsonUtil;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    Client client = ClientBuilder.newClient();
    client.register(AuthenticationFilter.class);
    WebTarget target = client.target("http://localhost:8080/lab_02_01/restaurant-services/restaurants");
    JsonArray jsonArray = target
            .queryParam("latitude", 37.617495)
            .queryParam("longitude", -122.406235)
            .request("application/json")
            .get(JsonArray.class);
    List<Restaurant> restaurants = jsonUtil.toRestaurantList(jsonArray);
    request.setAttribute("restaurants", restaurants);
    request.getRequestDispatcher("/nearbyServletView.jsp").forward(request, response);
  }
}
