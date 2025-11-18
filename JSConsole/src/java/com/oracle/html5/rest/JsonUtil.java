package com.oracle.html5.rest;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

@ApplicationScoped
public class JsonUtil {

  public Restaurant toRestaurant(JsonObject jsonObject) {
    Restaurant restaurant = new Restaurant();
    restaurant.setId(jsonObject.getInt("id"));
    restaurant.setLatitude(jsonObject.getJsonNumber("latitude").doubleValue());
    restaurant.setLongitude(jsonObject.getJsonNumber("longitude").doubleValue());
    restaurant.setName(jsonObject.getString("name"));
    JsonArray tagsArray = jsonObject.getJsonArray("tags");
    for (int i = 0; i < tagsArray.size(); i++) {
      restaurant.getTags().add(tagsArray.getString(i));
    }
    JsonArray reviewArray = jsonObject.getJsonArray("reviews");
    for (int i = 0; i < reviewArray.size(); i++) {
      restaurant.getReviews().add(toReview(reviewArray.getJsonObject(i)));
    }
    return restaurant;
  }

  public Review toReview(JsonObject jsonObject) {
    final Review review = new Review();
    review.setId(jsonObject.getInt("id"));
    review.setRating(jsonObject.getInt("rating"));
    review.setText(jsonObject.getString("text"));
    return review;
  }

  public List<Restaurant> toRestaurantList(JsonArray array) {
    List<Restaurant> restaurants = new ArrayList<>();
    for (int i = 0; i < array.size(); i++) {
      restaurants.add(toRestaurant(array.getJsonObject(i)));
    }
    return restaurants;
  }

  public JsonArray toJsonArray(List<Restaurant> restaurants) {
    JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
    for (Restaurant restaurant : restaurants) {
      arrayBuilder.add(toJsonObject(restaurant));
    }
    return arrayBuilder.build();
  }

  public JsonObject toJsonObject(Restaurant restaurant) {
    JsonArrayBuilder tagsBuilder = Json.createArrayBuilder();
    for (String tag : restaurant.getTags()) {
      tagsBuilder.add(tag);
    }
    JsonArrayBuilder reviewsBuilder = Json.createArrayBuilder();
    for (Review review : restaurant.getReviews()) {
      reviewsBuilder.add(toJsonObject(review));
    }
    return Json.createObjectBuilder()
            .add("id", restaurant.getId())
            .add("latitude", restaurant.getLatitude())
            .add("longitude", restaurant.getLongitude())
            .add("name", restaurant.getName())
            .add("tags", tagsBuilder)
            .add("reviews", reviewsBuilder)
            .build();
  }

  public JsonObject toJsonObject(Review review) {
    return Json.createObjectBuilder()
            .add("id", review.getId())
            .add("rating", review.getRating())
            .add("text", review.getText())
            .build();
  }
}
