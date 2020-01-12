package com.uga.edu.controller;

import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class RelationshipController {

  public Set<String> getRelationship(String firstName, String lastname, Model model) {
    firstName = "\"" + firstName + "\"";
    lastname = "\"" + lastname + "\"";


    String str = firstName;
    String str1 = lastname;


    String req = "" + "Select ?q " + " Where {" + "?q	<http://purl.org/dc/elements/1.1/creator> ?x ." + " ?x " +
      "<http://xmlns.com/foaf/0.1/name>" + str + "}";
    com.hp.hpl.jena.query.Query query = QueryFactory.create(req);

    QueryExecution qe = QueryExecutionFactory.create(query, model);
    com.hp.hpl.jena.query.ResultSet res = qe.execSelect();
    ArrayList<String> arr = new ArrayList<String>();
    ArrayList<String> arr1 = new ArrayList<String>();
    while (res.hasNext()) {
      QuerySolution qs = res.next();
      RDFNode rdfNode = qs.get("q");
      arr.add(rdfNode.toString());
      System.out.println(rdfNode.toString());
    }


    String req1 = "" + "Select ?q " + " Where {" + "?q	<http://purl.org/dc/elements/1.1/creator> ?x ." + " ?x <http://xmlns.com/foaf/0.1/name>" + str1 + "}";
    com.hp.hpl.jena.query.Query query1 = QueryFactory.create(req1);

    QueryExecution qe1 = QueryExecutionFactory.create(query1, model);
    com.hp.hpl.jena.query.ResultSet res1 = qe1.execSelect();

    while (res1.hasNext()) {
      QuerySolution qs = res1.next();
      RDFNode rdfNode = qs.get("q");
      arr1.add(rdfNode.toString());
      System.out.println(rdfNode.toString());
    }


    String asText = ResultSetFormatter.asText(res);
    System.out.println("Anhg");
    System.out.println(asText);
    System.out.println("dhgfuh");
    int count = 0;
    Set<String> arraySet = new HashSet<>(arr);
    Set<String> result = new HashSet<>();
    for (String str3 : arr1) {
      if (arraySet.contains(str3)) {
        System.out.println(str3);
        result.add(str3);
        count++;
      }
    }

    System.out.println(count);
    System.out.println("Anhg");
    return result;
  }

}
