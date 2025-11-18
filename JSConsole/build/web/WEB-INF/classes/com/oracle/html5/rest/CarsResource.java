package com.oracle.html5.rest;

import java.util.HashMap;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("cars")
public class CarsResource {

  private final static Map<String, Car> cars = new HashMap<>();

  @GET
  @Produces("application/json")
  public JsonArray getAll() {
    delay();
    JsonArrayBuilder arrayBld = Json.createArrayBuilder();
    for (Car car : cars.values()) {
      arrayBld.add(car.getName());
    }
    return arrayBld.build();
  }

  @GET
  @Path("/{carId}")
  @Produces("application/json")
  public JsonObject getRestaurant(@PathParam("carId") String id) {
    delay();
    Car car = cars.get(id);
    JsonObjectBuilder objBld = Json.createObjectBuilder();
    objBld.add("name", car.getName());
    objBld.add("color", car.getColor());
    objBld.add("model", car.getModel());
    objBld.add("year", car.getYear());
    return objBld.build();
  }

  @POST
  @Consumes("application/json")
  public void addReview(JsonObject content) {
    delay();
    Car car = new Car();
    car.setName(content.getString("name"));
    car.setModel(content.getString("model"));
    car.setColor(content.getString("color"));
    car.setYear(Integer.parseInt(content.getString("year")));
    cars.put(car.getName(), car);
  }

  @PUT
  @Path("/{carId}")
  @Consumes("application/json")
  public void addReview(@PathParam("carId") String carId, JsonObject content) {
    delay();
    Car car = cars.get(carId);
    car.setModel(content.getString("model"));
    car.setColor(content.getString("color"));
    car.setYear(Integer.parseInt(content.getString("year")));
  }

  @DELETE
  @Path("/{carId}")
  public void deleteReview(@PathParam("carId") String carId) {
    delay();
    cars.remove(carId);
  }

  private void delay() {
    try {
      Thread.sleep(500 + (long)(Math.random() * 2000));
    } catch (Exception e) {
    }
  }

}
