package com.oracle.html5.rest;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@WebServlet(name = "RemoveReviewServlet", urlPatterns = {"/RemoveReviewServlet"})
public class RemoveReviewServlet extends HttpServlet {

  @Inject
  private JsonUtil jsonUtil;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    int reviewId = Integer.parseInt(request.getParameter("reviewId"));
    Client client = ClientBuilder.newClient();
    client.register(AuthenticationFilter.class);
    WebTarget target = client.target("http://localhost:8080/lab_02_01/restaurant-services/restaurants/" + id + "/" + reviewId);
    target.request().delete();
    response.sendRedirect("DetailServlet?id=" + id);
  }
}
