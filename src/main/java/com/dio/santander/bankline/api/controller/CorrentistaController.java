package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.NovoCorrentistaDto;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
    //injeta o repositorio
    @Autowired
    private CorrentistaRepository repository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll() {
        return repository.findAll();
    }

    //recebe os dados pelo post
    @PostMapping
    public void save(@RequestBody NovoCorrentistaDto correntista){
        //passa os dados do correntista para o service que vai aplicar a logica e então chamar o repository
        service.save(correntista);

    }
}
