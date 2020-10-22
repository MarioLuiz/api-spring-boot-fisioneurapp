package com.arrudamoreira.fisioneurapp.services;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.domain.enums.TipoPessoa;
import com.arrudamoreira.fisioneurapp.repositories.FisioterapeutaRepository;
import com.arrudamoreira.fisioneurapp.repositories.PacienteRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import static org.apache.coyote.http11.Constants.a;
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

    public void intanciateTestDatabase() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Fisioterapeuta fisio1 = new Fisioterapeuta(null, "Revihery C. Moreira", "04319203725", "revihery@gmail.com", pe.encode("123456Revy"), "1312354F", TipoPessoa.PESSOAFISICA);
        Fisioterapeuta fisio2 = new Fisioterapeuta(null, "Mario Luiz O. Arruda", "03319232188", "mario@gmail.com", pe.encode("123456Mario"), "1319954F", TipoPessoa.PESSOAFISICA);

        Paciente pac1 = new Paciente(null, sdf.parse("30/09/2019 10:35"), "08987934871", "992857488", "Luiz Carlos");
        Paciente pac2 = new Paciente(null, sdf.parse("12/08/2018 10:35"), "08987933871", "992857488", "Mario Luiz");
        Paciente pac3 = new Paciente(null, sdf.parse("11/12/2019 10:35"), "08987988871", "992857488", "Revihery Luiza");
        Paciente pac4 = new Paciente(null, sdf.parse("01/07/2020 10:35"), "08999935871", "992857488", "Beatriz Almeida");

        fisio1.getPacientes().addAll(Arrays.asList(pac1, pac2));
        fisio2.getPacientes().addAll(Arrays.asList(pac3, pac4));

        pac1.getFisioterapeutas().add(fisio1);
        pac2.getFisioterapeutas().add(fisio1);
        pac3.getFisioterapeutas().add(fisio2);
        pac4.getFisioterapeutas().add(fisio2);

        fisioterapeutaRepository.saveAll(Arrays.asList(fisio1, fisio2));
        pacienteRepository.saveAll(Arrays.asList(pac1, pac2, pac3, pac4));

    }
}
