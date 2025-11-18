package com.oracle.html5.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("restaurants")
@RequestScoped
public class RestaurantsResource {

  @Inject
  private RestaurantService restaurantService;
  @Inject
  private JsonUtil jsonUtil;

  public RestaurantsResource() {
  }

  @GET
  @Produces("application/json")
  public JsonArray getAllRestaurants(
          @QueryParam("latitude") double latitude,
          @QueryParam("longitude") double longitude) {
    List<Restaurant> restaurants = restaurantService.getNearbyRestaurants(longitude, latitude);
    JsonArray jsonRestaurants = jsonUtil.toJsonArray(restaurants);
    return jsonRestaurants;
  }

  @GET
  @Path("/{restaurantId}")
  @Produces("application/json")
  public JsonObject getRestaurant(@PathParam("restaurantId") int restaurantId) {
    Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
    JsonObject jsonRestaurant = jsonUtil.toJsonObject(restaurant);
    return jsonRestaurant;
  }

  @POST
  @Path("/{restaurantId}")
  @Consumes("application/json")
  public void addReview(@PathParam("restaurantId") int restaurantId, JsonObject content) {
    Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
    Review review = new Review();
    review.setText(content.getString("text"));
    try {
      review.setRating(content.getInt("rating"));
    } catch (Exception e) {
      review.setRating(Integer.parseInt(content.getString("rating")));
    }
    restaurant.addReview(review);
  }

  @DELETE
  @Path("/{restaurantId}/{reviewId}")
  public void deleteReview(@PathParam("restaurantId") int restaurantId, @PathParam("reviewId") int reviewId) {
    Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
    restaurant.removeReview(reviewId);
  }
}
