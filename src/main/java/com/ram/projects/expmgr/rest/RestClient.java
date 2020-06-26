package com.ram.projects.expmgr.rest;

import com.ram.projects.expmgr.rest.dto.Expense;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class RestClient {

  public static void main(String[] args) {
    Client client = ClientBuilder.newClient();

    /*   HttpAuthenticationFeature authenticator =
        HttpAuthenticationFeature.basic("mtiqasyner", "789xy321");
    client.register(authenticator);*/
    String basePath = "http://localhost:1111/expmgr";

    //    builder.header("one", "header");
    String resourceExpense = "/expense/add";
    WebTarget wt = client.target(basePath).path(resourceExpense);

    Invocation.Builder builder = wt.request(MediaType.APPLICATION_JSON);
    Response response =
        builder.post(
            Entity.entity(
                "{\n"
                    + "  \"closingBalance\": 0,\n"
                    + "  \"expenseCategory\": \"MORTGAGE_OR_RENT\",\n"
                    + "  \"expenseName\": \"CLOTHING_ADULT_CLOTHS\",\n"
                    + "  \"openingBalance\": 0,\n"
                    + "  \"transactionAmount\": 0,\n"
                    + "  \"transactionDate\": \"2020-06-26T03:08:59.946Z\",\n"
                    + "  \"transactionSource\": \"CREDIT_CARD\",\n"
                    + "  \"transactionType\": \"DEBT\"\n"
                    + "}",
                MediaType.APPLICATION_JSON));
    System.out.println("Added expense id" + response.readEntity(String.class));

    getMethodImpl(basePath);
  }

  private static void getMethodImpl( String basePath) {
    Client client = ClientBuilder.newClient();
    String resourceExpenseGet = "/expense/getAllExpenses";
    WebTarget targetGet = client.target(basePath).path(resourceExpenseGet);

    Invocation.Builder builderGet = targetGet.request(MediaType.APPLICATION_JSON);
    Response responseGet = builderGet.get();

    List<Expense> list = responseGet.readEntity(List.class);
    System.out.println("Response " + list);
  }

  private static void getMethodImpl(Invocation.Builder builder) {}
}
