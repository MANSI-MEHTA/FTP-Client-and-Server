package com.uga.edu.controller;

import com.hp.hpl.jena.rdf.model.Model;
import com.uga.edu.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    private ModelGenerator modelGenerator;

    @Autowired
    private RelationshipController relationshipController;

    @GetMapping({"/", "/generateModel"})
    public String showWelcomePage() {
        modelGenerator.generateModel();
        return "hello";
    }

    @GetMapping("/home")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping("/get-author-names")
    public String getAuthorNames(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @PostMapping("/find-author-relationship")
    public String findAuthorRelationship(@ModelAttribute Author author, BindingResult bindingResult, HttpServletRequest request) {
        Model model = modelGenerator.retrieveModel();
        Set<String> relations = relationshipController.getRelationship(author.getFirst_author(), author.getSecond_author(),
                model);
        String degreeOfCOI = getDegreeOfCOI(relations.size());
        request.setAttribute("relations", relations);
        request.setAttribute("degreeOfCOI", degreeOfCOI);
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

	private String getDegreeOfCOI(int size) {
		if(size > 0 && size <= 5) return "LOW";
		else if (size > 5 && size <=10) return "MEDIUM";
		else if (size > 10) return "HIGH";
		else return "NONE";
	}

}
