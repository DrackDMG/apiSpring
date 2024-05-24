package com.demo.controller;

import com.demo.entity.Nota;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/notas")
public class ControllerRest {

    private final String token = "eyJhbGci";

    @GetMapping("/all")
    public ModelAndView all() {
        ModelAndView mav = new ModelAndView("template");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Nota[]> notasEntity = restTemplate.exchange("http://localhost:8080/v1/nota", HttpMethod.GET, entity, Nota[].class);
        Nota[] notas = notasEntity.getBody();

        mav.addObject("notas", notas);
        return mav;
    }
    

    //lo mismo que el anterior pero sin el token
    @GetMapping("/all2")
    public ModelAndView all2() {
        ModelAndView mav = new ModelAndView("template");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Nota[]> notasEntity = restTemplate.exchange("http://localhost:8080/v1/nota", HttpMethod.GET, null, Nota[].class);
        Nota[] notas = notasEntity.getBody();

        mav.addObject("notas", notas);
        return mav;
    }

}
