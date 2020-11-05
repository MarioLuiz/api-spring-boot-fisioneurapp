package com.arrudamoreira.fisioneurapp.services;

import com.arrudamoreira.fisioneurapp.domain.Avaliacao;
import com.arrudamoreira.fisioneurapp.domain.Endereco;
import com.arrudamoreira.fisioneurapp.domain.EvolucaoClinica;
import com.arrudamoreira.fisioneurapp.domain.Exame;
import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.domain.Prontuario;
import com.arrudamoreira.fisioneurapp.domain.enums.TipoPessoa;
import com.arrudamoreira.fisioneurapp.repositories.AvaliacaoRepository;
import com.arrudamoreira.fisioneurapp.repositories.EnderecoRepository;
import com.arrudamoreira.fisioneurapp.repositories.EvolucaoClinicaRepository;
import com.arrudamoreira.fisioneurapp.repositories.ExameRepository;
import com.arrudamoreira.fisioneurapp.repositories.FisioterapeutaRepository;
import com.arrudamoreira.fisioneurapp.repositories.PacienteRepository;
import com.arrudamoreira.fisioneurapp.repositories.ProntuarioRepository;
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

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    
    @Autowired
    private EvolucaoClinicaRepository evolucaoClinicaRepository;
    
    @Autowired
    private ExameRepository exameRepository;

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

        Prontuario pront1 = new Prontuario(null, 378511, "I932", sdf.parse("25/08/2020 10:44"), "Paciente reclama de fortes dores na coluna");
        Prontuario pront2 = new Prontuario(null, 853581, "G185", sdf.parse("01/07/2019 07:21"), "Paciente reclama de fortes dores na cabeça");
        Prontuario pront3 = new Prontuario(null, 218742, "G587", sdf.parse("21/06/2018 08:31"), "Paciente reclama de fortes dores na costas");
        Prontuario pront4 = new Prontuario(null, 128795, "H232", sdf.parse("17/07/2017 20:32"), "Paciente reclama de fortes dores na perna");
        
        Exame ex1 = new Exame(null, "Raio-x coluna", sdf.parse("21/08/2020 18:35"), "Exame em perfeitas condições", "C5 e C6 trincadas");
        Exame ex2 = new Exame(null, "Raio-x cabeça", sdf.parse("30/10/2020 13:12"), "Exame em perfeitas condições", "Fratura na parte superior da cabeça");
        Exame ex3 = new Exame(null, "Raio-x Tibia", sdf.parse("15/09/2020 15:37"), "Exame em perfeitas condições", "Osso trincado");
        Exame ex4 = new Exame(null, "Raio-x Femour", sdf.parse("01/11/2020 09:11"), "Exame em perfeitas condições", "Osso com pequenas perfurações em toda parte frontal");

        Avaliacao ava1 = new Avaliacao(null, sdf.parse("17/07/2017 20:32"), pac1.toString(),
                "Paciente sempre reclama de dores nas costas", "Pacente disse melhora na dorres nas costas",
                "Bom, mas com desliexo do braço direito", "Avanacado, mas sem melhorias nos ultimos atendimentos",
                "Dor nas costas", "Tratar a dor nas costas do paciente");
        Avaliacao ava2 = new Avaliacao(null, sdf.parse("11/07/2019 07:42"), pac2.toString(),
                "Paciente sempre reclama de dores nas costas", "Pacente disse melhora na dorres nas costas",
                "Bom, mas com desliexo do braço direito", "Avanacado, mas sem melhorias nos ultimos atendimentos",
                "Dor nas costas", "Tratar a dor nas costas do paciente");
        Avaliacao ava3 = new Avaliacao(null, sdf.parse("21/01/2020 21:35"), pac3.toString(),
                "Paciente sempre reclama de dores nas costas", "Pacente disse melhora na dorres nas costas",
                "Bom, mas com desliexo do braço direito", "Avanacado, mas sem melhorias nos ultimos atendimentos",
                "Dor nas costas", "Tratar a dor nas costas do paciente");
        Avaliacao ava4 = new Avaliacao(null, sdf.parse("19/11/2019 18:22"), pac4.toString(),
                "Paciente sempre reclama de dores nas costas", "Pacente disse melhora na dorres nas costas",
                "Bom, mas com desliexo do braço direito", "Avanacado, mas sem melhorias nos ultimos atendimentos",
                "Dor nas costas", "Tratar a dor nas costas do paciente");
        
        EvolucaoClinica evo1 = new EvolucaoClinica(null, sdf.parse("11/07/2020 07:22"), "Conciente e disposto", "Foi realizado estimulo dos menbros inferiores e da lombar do paciente");
        EvolucaoClinica evo2 = new EvolucaoClinica(null, sdf.parse("21/08/2020 13:14"), "Conciente e disposto", "Foi realizado estimulo dos menbros superiores e da pescoço do paciente");
        EvolucaoClinica evo3 = new EvolucaoClinica(null, sdf.parse("15/09/2020 18:01"), "Conciente e disposto", "Foi realizado estimulo dos menbros inferiores e da ombros do paciente");
        EvolucaoClinica evo4 = new EvolucaoClinica(null, sdf.parse("07/10/2020 15:18"), "Conciente e disposto", "Foi realizado estimulo dos menbros superiores e da costas do paciente");

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
        
        ende1.setPaciente(pac1);
        ende2.setPaciente(pac2);
        ende3.setPaciente(pac3);
        ende4.setPaciente(pac4);

        pac1.setProntuario(pront1);
        pac2.setProntuario(pront2);
        pac3.setProntuario(pront3);
        pac4.setProntuario(pront4);

        pront1.setPaciente(pac1);
        pront2.setPaciente(pac2);
        pront3.setPaciente(pac3);
        pront4.setPaciente(pac4);
        
        pront1.getAvaliacoes().add(ava1);
        pront2.getAvaliacoes().add(ava2);
        pront3.getAvaliacoes().add(ava3);
        pront4.getAvaliacoes().add(ava4);

        ava1.setProntuario(pront1);
        ava2.setProntuario(pront2);
        ava3.setProntuario(pront3);
        ava4.setProntuario(pront4);
        
        pront1.getEvolucoesClinicas().add(evo1);
        pront2.getEvolucoesClinicas().add(evo2);
        pront3.getEvolucoesClinicas().add(evo3);
        pront4.getEvolucoesClinicas().add(evo4);
        
        evo1.setProntuario(pront1);
        evo2.setProntuario(pront2);
        evo3.setProntuario(pront3);
        evo4.setProntuario(pront4);
        
        pront1.getExames().add(ex1);
        pront2.getExames().add(ex2);
        pront3.getExames().add(ex3);
        pront4.getExames().add(ex4);
        
        ex1.setProntuario(pront1);
        ex2.setProntuario(pront2);
        ex3.setProntuario(pront3);
        ex4.setProntuario(pront4);
        
        fisioterapeutaRepository.saveAll(Arrays.asList(fisio1, fisio2));
        pacienteRepository.saveAll(Arrays.asList(pac1, pac2, pac3, pac4));
        enderecoRepository.saveAll(Arrays.asList(ende1, ende2, ende3, ende4));
        prontuarioRepository.saveAll(Arrays.asList(pront1, pront2, pront3, pront4));
        avaliacaoRepository.saveAll(Arrays.asList(ava1, ava2, ava3, ava4));
        evolucaoClinicaRepository.saveAll(Arrays.asList(evo1,evo2,evo3,evo4));
        exameRepository.saveAll(Arrays.asList(ex1,ex2,ex3,ex4));
        
    }
}
