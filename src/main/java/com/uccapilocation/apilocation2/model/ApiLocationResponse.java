package com.uccapilocation.apilocation2.model;

import java.util.ArrayList;

public class ApiLocationResponse {
    public PlusCode plus_code;
    public ArrayList<Result> results;
    public String status;
}

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */




