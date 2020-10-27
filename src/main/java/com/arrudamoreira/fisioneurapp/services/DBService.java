package com.arrudamoreira.fisioneurapp.services;

import com.arrudamoreira.fisioneurapp.domain.Endereco;
import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.domain.enums.TipoPessoa;
import com.arrudamoreira.fisioneurapp.repositories.EnderecoRepository;
import com.arrudamoreira.fisioneurapp.repositories.FisioterapeutaRepository;
import com.arrudamoreira.fisioneurapp.repositories.PacienteRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

/**
 *
 * @author Mario Arruda
 */
@Service
public class DBService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private FisioterapeutaRepository fisioterapeutaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    public void intanciateTestDatabase() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Fisioterapeuta fisio1 = new Fisioterapeuta(null, "Revihery C. Moreira", "04319203725", "revihery@gmail.com", pe.encode("123456Revy"), "1312354F", TipoPessoa.PESSOAFISICA);
        Fisioterapeuta fisio2 = new Fisioterapeuta(null, "Mario Luiz O. Arruda", "03319232188", "mario@gmail.com", pe.encode("123456Mario"), "1319954F", TipoPessoa.PESSOAFISICA);
        
        Paciente pac1 = new Paciente(null, sdf.parse("30/09/2019 10:44"), "08987934871", "992857488", "Luiz Carlos");
        Paciente pac2 = new Paciente(null, sdf.parse("12/08/2018 00:12"), "08987933871", "992857488", "Mario Luiz");
        Paciente pac3 = new Paciente(null, sdf.parse("11/12/2019 05:33"), "08987988871", "992857488", "Revihery Luiza");
        Paciente pac4 = new Paciente(null, sdf.parse("01/07/2020 09:19"), "08999935871", "992857488", "Beatriz Almeida");
        
        Endereco ende1 = new Endereco(null, 79114785, 138, "Rua Belmonte", "Vila Célia", pac1);
        Endereco ende2 = new Endereco(null, 52114785, 1500, "Avenida Mato Grosso", "Centro", pac2);
        Endereco ende3 = new Endereco(null, 79384785, 1321, "Rua florida", "Vila Carvalho", pac3);
        Endereco ende4 = new Endereco(null, 79994785, 897, "Rua Castelo branco", "Bairro Monte Castelo", pac4);

        fisio1.getPacientes().addAll(Arrays.asList(pac1, pac2));
        fisio2.getPacientes().addAll(Arrays.asList(pac3, pac4));
        
        pac1.getFisioterapeutas().add(fisio1);
        pac2.getFisioterapeutas().add(fisio1);
        pac3.getFisioterapeutas().add(fisio2);
        pac4.getFisioterapeutas().add(fisio2);
        
        pac1.getEnderecos().add(ende1);
        pac2.getEnderecos().add(ende2);
        pac3.getEnderecos().add(ende3);
        pac4.getEnderecos().add(ende4);
        
        fisioterapeutaRepository.saveAll(Arrays.asList(fisio1, fisio2));
        pacienteRepository.saveAll(Arrays.asList(pac1, pac2, pac3, pac4));
        enderecoRepository.saveAll(Arrays.asList(ende1,ende2,ende3,ende4));

    }
}
