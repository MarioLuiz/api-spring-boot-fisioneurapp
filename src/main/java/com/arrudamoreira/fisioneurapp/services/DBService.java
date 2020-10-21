package com.arrudamoreira.fisioneurapp.services;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.domain.enums.TipoPessoa;
import com.arrudamoreira.fisioneurapp.repositories.FisioterapeutaRepository;
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

    public void intanciateTestDatabase() {
        
        Fisioterapeuta fisio1 = new Fisioterapeuta(null, "Revihery C. Moreira", "04319203725", "revihery@gmail.com", pe.encode("123456Revy"), "1312354F", TipoPessoa.PESSOAFISICA, null);
        Fisioterapeuta fisio2 = new Fisioterapeuta(null, "Mario Luiz O. Arruda", "03319232188", "mario@gmail.com", pe.encode("123456Mario"), "1319954F", TipoPessoa.PESSOAFISICA, null);

        fisioterapeutaRepository.saveAll(Arrays.asList(fisio1, fisio2));

    }
}
