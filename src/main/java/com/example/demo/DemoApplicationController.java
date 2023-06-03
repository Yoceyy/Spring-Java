package com.example.demo;



import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoApplicationController {

    @Autowired
    private ServletContext servletContext;

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



    @RequestMapping(value = "/image/", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE )

    public void getImageAsByteArray(HttpServletResponse response) throws IOException  {
        InputStream in = servletContext.getResourceAsStream("/image/image2.jpg");
        IOUtils.copy(in, response.getOutputStream());
    }




}
  