package com.uga.edu.controller;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import org.rdfhdt.hdt.hdt.HDT;
import org.rdfhdt.hdt.hdt.HDTManager;
import org.rdfhdt.hdtjena.HDTGraph;
import org.springframework.stereotype.Service;

@Service
public class ModelGenerator {
  Model model = null;

  public void generateModel() {

    try {
      HDT hdt = HDTManager.mapIndexedHDT("/Users/radhikabhavsar/eclipse-workspace/SpringBootExample 3/dblp-20170124.hdt", null);
      System.out.println("AIS Project");
      HDTGraph graph = new HDTGraph(hdt);
      model = (Model) ModelFactory.createModelForGraph(graph);

    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public Model retrieveModel() {
    if (model == null) generateModel();
    return model;
  }

}
