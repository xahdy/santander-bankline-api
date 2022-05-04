package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.NovoCorrentistaDto;
import com.dio.santander.bankline.api.model.Conta;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {

    @Autowired
    private CorrentistaRepository repository;

    //recebe os dados passados pelo controller e usa para criar um novo correntista
    public void save(NovoCorrentistaDto novoCorrentistaDto){
        Correntista correntista = new Correntista();
        //o correntista que vamos criar vai receber os dados que vierem através do controller
        correntista.setCpf(novoCorrentistaDto.getCpf());
        correntista.setNome(novoCorrentistaDto.getNome());
        //a cada novo correntista, cria uma nova conta.
        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());
        //adiciona a conta ao correntista.
        correntista.setConta(conta);
        //o repository salva o correntista recem criado com os dados que vieram do controller
        repository.save(correntista);

    }
}
