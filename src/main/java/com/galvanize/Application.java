package com.galvanize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.ArrayList;

class Address{
  private String street;
  private String city;
  private String state;
  private String zip;

  public Address(String s, String c, String st, String z) {
    street = s;
    city = c;
    state = st;
    zip = z;
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getZip() {
    return zip;
  }

  public void setStreet(String s) {
    street = s;
  }

  public void setCity(String c) {
    city = c;
  }

  public void setState(String st) {
    state = st;
  }

  public void setZip(String z) {
    zip = z;
  }

  @Override public String toString() {
    return street+", "+city+", "+state+" "+zip;
  }
}

interface Addressable {

  List<Address> getAddresses();
  void addAddress(Address a);
}

class Business implements Addressable {
  private String name;
  private ArrayList<Address> addresses;

  public Business(String n) {
    name = n;
    addresses = new ArrayList<Address>();
  }

  public String getName() {
    return name;
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public void addAddress(Address a) {
    addresses.add(a);
  }
}

public class Application {

    public static void main(String[] args) {
        Gson builder = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        JsonObject object = new JsonObject();

        System.getProperties().stringPropertyNames().iterator().forEachRemaining(propertyName ->
                object.addProperty(propertyName, System.getProperty(propertyName))
        );

        System.out.println(builder.toJson(object));
    }

}
