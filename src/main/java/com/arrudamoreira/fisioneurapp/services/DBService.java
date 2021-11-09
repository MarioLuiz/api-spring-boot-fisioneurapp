package com.arrudamoreira.fisioneurapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.arrudamoreira.fisioneurapp.domain.Atendimento;
import com.arrudamoreira.fisioneurapp.domain.Avaliacao;
import com.arrudamoreira.fisioneurapp.domain.Encaminhamento;
import com.arrudamoreira.fisioneurapp.domain.Endereco;
import com.arrudamoreira.fisioneurapp.domain.EvolucaoClinica;
import com.arrudamoreira.fisioneurapp.domain.Exame;
import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.domain.Prontuario;
import com.arrudamoreira.fisioneurapp.domain.enums.Perfil;
import com.arrudamoreira.fisioneurapp.repositories.AtendimentoRepository;
import com.arrudamoreira.fisioneurapp.repositories.AvaliacaoRepository;
import com.arrudamoreira.fisioneurapp.repositories.EncaminhamentoRepository;
import com.arrudamoreira.fisioneurapp.repositories.EnderecoRepository;
import com.arrudamoreira.fisioneurapp.repositories.EvolucaoClinicaRepository;
import com.arrudamoreira.fisioneurapp.repositories.ExameRepository;
import com.arrudamoreira.fisioneurapp.repositories.FisioterapeutaRepository;
import com.arrudamoreira.fisioneurapp.repositories.PacienteRepository;
import com.arrudamoreira.fisioneurapp.repositories.ProntuarioRepository;

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

	@Autowired
	private EncaminhamentoRepository encaminhamentoRepository;
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;

	public void intanciateTestDatabase() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		SimpleDateFormat sdfNascimento = new SimpleDateFormat("dd/MM/yyyy");

		// Date dataNascimentoFisio1 = sdfNascimento.parse("25/04/1990");
		// dataNascimentoFisio1.getTime()
		// Date dataNascimentoFisio2 = sdfNascimento.parse("24/02/1992");
		// dataNascimentoFisio2.getTime()

		Fisioterapeuta fisio1 = new Fisioterapeuta(null, "Revihery C. Moreira", "04319203725", "revihery@gmail.com",
				pe.encode("123456Revy"), "1312354F", "1990-04-25");
		Fisioterapeuta fisio2 = new Fisioterapeuta(null, "Mario Luiz O. Arruda", "03319232188", "mario@gmail.com",
				pe.encode("123456"), "1319954F", "1992-02-24");

		fisio2.addPerfil(Perfil.ADMIN_FISIO);

		Paciente pac1 = new Paciente(null, sdf.parse("30/09/2019 10:44"), "08987934871", "67992857488", "Luiz Carlos",
				"1992-06-17", "luiz@gmail.com");
		Paciente pac2 = new Paciente(null, sdf.parse("12/08/2018 00:12"), "08987933872", "67992857488", "Mario Luiz",
				"1992-02-24", "marioluiz@gmail.com");
		Paciente pac3 = new Paciente(null, sdf.parse("11/12/2019 05:33"), "08987988873", "67992857488", "Revihery Luiza",
				"1990-04-25", "reviheryluiza@gmail.com");
		Paciente pac4 = new Paciente(null, sdf.parse("01/07/2020 09:19"), "08999935874", "67992857488", "Beatriz Almeida",
				"1963-11-18", "beatrizalmeida@gmail.com");
		Paciente pac5 = new Paciente(null, sdf.parse("11/12/2019 09:33"), "09287988876", "67992857488",
				"Troiano Matheus Dangelo", "1989-04-25", "matheus@gmail.com");
		Paciente pac6 = new Paciente(null, sdf.parse("01/07/2020 09:19"), "09399935877", "67992857488",
				"Rui Carlos Fernando Fusca", "1981-11-18", "carlosfernando@gmail.com");
		Paciente pac7 = new Paciente(null, sdf.parse("11/10/2021 08:33"), "09487988876", "67992857488",
				"Dennys Carlos Ricardo", "1982-04-25", "dennys@gmail.com");
		Paciente pac8 = new Paciente(null, sdf.parse("01/09/2020 07:19"), "09599935877", "67992857488", "Carlos Fernando",
				"1983-11-18", "carlosfernando1@gmail.com");
		Paciente pac9 = new Paciente(null, sdf.parse("11/08/2019 06:33"), "09687988876", "67992857488",
				"Marcelo Luiz Oliveira", "1984-04-25", "marcelo@gmail.com");
		Paciente pac10 = new Paciente(null, sdf.parse("12/07/2020 10:19"), "01177935877", "67992857488",
				"Carla Roberta de Souza", "1985-11-18", "carla@gmail.com");
		Paciente pac11 = new Paciente(null, sdf.parse("13/06/2019 11:33"), "08987988876", "67992857488", "Nenna da Silva",
				"1986-04-25", "nenna@gmail.com");
		Paciente pac12 = new Paciente(null, sdf.parse("14/03/2020 12:19"), "08999988877", "67992857488",
				"Rudilene Moreira", "1987-11-18", "rudilene@gmail.com");
		Paciente pac13 = new Paciente(null, sdf.parse("15/02/2019 13:33"), "08987999876", "67992857488", "Raizen Amoedo",
				"1988-04-25", "raizen@gmail.com");
		Paciente pac14 = new Paciente(null, sdf.parse("16/01/2020 14:19"), "08999935877", "67992857488",
				"Luis Inacio Lula", "1989-11-18", "luis@gmail.com");
		Paciente pac15 = new Paciente(null, sdf.parse("17/04/2020 15:19"), "08911935877", "67992857488", "Adolpho Carlos",
				"1991-11-18", "adopho@gmail.com");
		Paciente pac16 = new Paciente(null, sdf.parse("18/05/2019 16:33"), "08922988876", "67992857488",
				"Andrio Algusto Luiz", "1990-04-25", "andrio@gmail.com");
		Paciente pac17 = new Paciente(null, sdf.parse("19/06/2020 17:19"), "08933935877", "67992857488", "Lorena Martins",
				"1991-11-18", "lorena@gmail.com");
		Paciente pac18 = new Paciente(null, sdf.parse("20/03/2019 07:33"), "08944988876", "67992857488",
				"Reviane Chaves Amorim", "1992-04-25", "reviane@gmail.com");
		Paciente pac19 = new Paciente(null, sdf.parse("21/04/2020 09:19"), "08955935877", "67992857488",
				"Thor Oliveira Arruda", "1993-11-18", "thor@gmail.com");
		Paciente pac20 = new Paciente(null, sdf.parse("22/05/2020 08:19"), "08966935877", "67992857488",
				"Baruk Adamastor Pedra", "1994-11-18", "baruk@gmail.com");

		Endereco ende1 = new Endereco(null, 79114785, 138, "Rua Belmonte", "Vila Célia", pac1);
		Endereco ende2 = new Endereco(null, 52114785, 1500, "Avenida Mato Grosso", "Centro", pac2);
		Endereco ende3 = new Endereco(null, 79384785, 1321, "Rua florida", "Vila Carvalho", pac3);
		Endereco ende4 = new Endereco(null, 79994785, 897, "Rua Castelo branco", "Bairro Monte Castelo", pac4);

		Prontuario pront1 = new Prontuario(null, 20208251, "I932", sdf.parse("25/08/2020 10:44"),
				"Paciente reclama de fortes dores na coluna");
		Prontuario pront2 = new Prontuario(null, 2019712, "G185", sdf.parse("01/07/2019 07:21"),
				"Paciente reclama de fortes dores na cabeça");
		Prontuario pront3 = new Prontuario(null, 20186213, "G587", sdf.parse("21/06/2018 08:31"),
				"Paciente reclama de fortes dores na costas");
		Prontuario pront4 = new Prontuario(null, 20177184, "H232", sdf.parse("17/07/2017 20:32"),
				"Paciente reclama de fortes dores na perna");

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

		EvolucaoClinica evo1 = new EvolucaoClinica(null, sdf.parse("11/07/2020 07:22"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da lombar do paciente");
		EvolucaoClinica evo2 = new EvolucaoClinica(null, sdf.parse("21/08/2020 13:14"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da pescoço do paciente");
		EvolucaoClinica evo3 = new EvolucaoClinica(null, sdf.parse("15/09/2020 18:01"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da ombros do paciente");
		EvolucaoClinica evo4 = new EvolucaoClinica(null, sdf.parse("07/10/2020 15:18"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da costas do paciente");

		Exame ex1 = new Exame(null, "Raio-x coluna", sdf.parse("21/08/2020 18:35"), "Exame em perfeitas condições",
				"C5 e C6 trincadas");
		Exame ex2 = new Exame(null, "Raio-x cabeça", sdf.parse("30/10/2020 13:12"), "Exame em perfeitas condições",
				"Fratura na parte superior da cabeça");
		Exame ex3 = new Exame(null, "Raio-x Tibia", sdf.parse("15/09/2020 15:37"), "Exame em perfeitas condições",
				"Osso trincado");
		Exame ex4 = new Exame(null, "Raio-x Femour", sdf.parse("01/11/2020 09:11"), "Exame em perfeitas condições",
				"Osso com pequenas perfurações em toda parte frontal");

		Encaminhamento ec1 = new Encaminhamento(null, "Neurofuncional", sdf.parse("01/11/2020 06:59"),
				"Encaminhado para especialista em Neuro");
		Encaminhamento ec2 = new Encaminhamento(null, "Respiratória", sdf.parse("02/11/2020 07:31"),
				"Encaminhado para especialista em Fisio respiratória");
		Encaminhamento ec3 = new Encaminhamento(null, "Traumato-Órtopedica", sdf.parse("03/11/2020 08:20"),
				"Encaminhado para especialista Ortopédista");
		Encaminhamento ec4 = new Encaminhamento(null, "Oncológica", sdf.parse("04/11/2020 09:12"),
				"Encaminhado para especialista em Oncologia");
		
		Atendimento ate1 = new Atendimento(null, sdf.parse("11/07/2020 07:22"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da lombar do paciente");
		Atendimento ate2 = new Atendimento(null, sdf.parse("21/08/2020 13:14"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da pescoço do paciente");
		Atendimento ate3 = new Atendimento(null, sdf.parse("15/09/2020 18:01"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da ombros do paciente");
		Atendimento ate4 = new Atendimento(null, sdf.parse("07/10/2020 15:18"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da costas do paciente");

		fisio1.getPacientes().addAll(Arrays.asList(pac1, pac2));
		fisio2.getPacientes().addAll(Arrays.asList(pac3, pac4));

		pac1.getFisioterapeutas().add(fisio1);
		pac2.getFisioterapeutas().add(fisio1);
		pac3.getFisioterapeutas().add(fisio2);
		pac4.getFisioterapeutas().add(fisio2);

		pac1.setEndereco(ende1);
		pac2.setEndereco(ende2);
		pac3.setEndereco(ende3);
		pac4.setEndereco(ende4);

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

		pront1.getEncaminhamentos().add(ec1);
		pront2.getEncaminhamentos().add(ec2);
		pront3.getEncaminhamentos().add(ec3);
		pront4.getEncaminhamentos().add(ec4);

		ec1.setProntuario(pront1);
		ec2.setProntuario(pront2);
		ec3.setProntuario(pront3);
		ec4.setProntuario(pront4);
		
		ate1.setProntuario(pront1);
		ate2.setProntuario(pront2);
		ate3.setProntuario(pront3);
		ate4.setProntuario(pront4);
		
		pront1.getAtendimentos().add(ate1);
		pront2.getAtendimentos().add(ate2);
		pront3.getAtendimentos().add(ate3);
		pront4.getAtendimentos().add(ate4);

		fisioterapeutaRepository.saveAll(Arrays.asList(fisio1, fisio2));
		pacienteRepository.saveAll(Arrays.asList(pac1, pac2, pac3, pac4, pac5, pac6, pac7, pac8, pac9, pac10, pac11,
				pac12, pac13, pac14, pac15, pac16, pac17, pac18, pac19, pac20));
		enderecoRepository.saveAll(Arrays.asList(ende1, ende2, ende3, ende4));
		prontuarioRepository.saveAll(Arrays.asList(pront1, pront2, pront3, pront4));
		avaliacaoRepository.saveAll(Arrays.asList(ava1, ava2, ava3, ava4));
		evolucaoClinicaRepository.saveAll(Arrays.asList(evo1, evo2, evo3, evo4));
		exameRepository.saveAll(Arrays.asList(ex1, ex2, ex3, ex4));
		encaminhamentoRepository.saveAll(Arrays.asList(ec1, ec2, ec3, ec4));
		atendimentoRepository.saveAll(Arrays.asList(ate1,ate2,ate3,ate4));

	}
}
