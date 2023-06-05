package com.example.demo;



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class DemoApplicationController {



    @GetMapping("/")
    public String hello() {
        return "Hello, world! c'est moi";
    }
    
    @RequestMapping("/nouvellepage")
    public String nouvellePage() {
        return "nouvellepage";
    }

    @GetMapping("/nouvellepage/{id}")
    public String getEmployeesById(@PathVariable String id) {
        return "bonsoir"+ id;
    }



    @RequestMapping(value="/image", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImageAsByteArray(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        ClassPathResource resource = new ClassPathResource("/image/image2.jpg");
        InputStream in = resource.getInputStream();
        IOUtils.copy(in, response.getOutputStream());
    }

@RestController
public class MonControleur {
    
    @GetMapping(value="/JSON", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getListeJson() {
        List<Integer> liste = new ArrayList<>();
        // la liste
        liste.add(5);
        liste.add(6);
        
        // Sérialiser la liste en JSON
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(liste);
            return json;   
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Erreur lors de la sérialisation JSON";
        }
    }
}


    



}
  