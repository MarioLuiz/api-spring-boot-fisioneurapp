package com.arrudamoreira.fisioneurapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.arrudamoreira.fisioneurapp.domain.Atendimento;
import com.arrudamoreira.fisioneurapp.domain.Endereco;
import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.domain.Prontuario;
import com.arrudamoreira.fisioneurapp.domain.enums.Perfil;
import com.arrudamoreira.fisioneurapp.repositories.AtendimentoRepository;
import com.arrudamoreira.fisioneurapp.repositories.EnderecoRepository;
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

//	@Autowired
//	private AvaliacaoRepository avaliacaoRepository;

//	@Autowired
//	private EvolucaoClinicaRepository evolucaoClinicaRepository;

//	@Autowired
//	private ExameRepository exameRepository;

//	@Autowired
//	private EncaminhamentoRepository encaminhamentoRepository;

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
		Fisioterapeuta fisio2 = new Fisioterapeuta(null, "Mario Luiz O. Arruda", "03319232188", "marioluiz.arruda@gmail.com",
				pe.encode("123456Mario"), "1319954F", "1992-02-24");
		Fisioterapeuta fisio3 = new Fisioterapeuta(null, "Maria Juliana", "04399903725", "maria@gmail.com",
				pe.encode("123456Maria"), "9312587F", "1993-07-02");
		Fisioterapeuta fisio4 = new Fisioterapeuta(null, "Carlos Raphael", "03319232199", "carlos@gmail.com",
				pe.encode("123456Mario"), "1819954F", "1897-03-28");
		Fisioterapeuta fisio5 = new Fisioterapeuta(null, "Ivy Carolina", "04315553725", "ivy@gmail.com",
				pe.encode("123456Ivy"), "1912354F", "1991-08-03");
		Fisioterapeuta fisio6 = new Fisioterapeuta(null, "Isis Moreira", "03332132188", "isis@gmail.com",
				pe.encode("123456Isis"), "0519954F", "1980-05-15");
		Fisioterapeuta fisio7 = new Fisioterapeuta(null, "Bernardo Chaves", "02119203725", "bernardo@gmail.com",
				pe.encode("123456Bernardo"), "0612354F", "1985-06-06");
		Fisioterapeuta fisio8 = new Fisioterapeuta(null, "Kaique Vitor", "03318532188", "kaique@gmail.com",
				pe.encode("123456Kaique"), "1310954F", "1987-09-21");
		Fisioterapeuta fisio9 = new Fisioterapeuta(null, "Kamile Vitória", "04319203725", "kamile@gmail.com",
				pe.encode("123456Kamile"), "0312354F", "1995-10-03");
		Fisioterapeuta fisio10 = new Fisioterapeuta(null, "Marilia Arruda", "03319299188", "marilia@gmail.com",
				pe.encode("123456Marilia"), "1919954F", "2000-01-19");

		fisio2.addPerfil(Perfil.ADMIN_FISIO);

		Paciente pac1 = new Paciente(null, sdf.parse("30/09/2019 10:44"), "08987934871", "67992857488", "Luiz Carlos",
				"1992-06-17", "luiz@gmail.com", true);
		Paciente pac2 = new Paciente(null, sdf.parse("12/08/2018 00:12"), "08987933872", "67992857488", "Mario Luiz",
				"1992-02-24", "marioluiz@gmail.com", true);
		Paciente pac3 = new Paciente(null, sdf.parse("11/12/2019 05:33"), "08987988873", "67992857488",
				"Revihery Luiza", "1990-04-12", "reviheryluiza@gmail.com", true);
		Paciente pac4 = new Paciente(null, sdf.parse("01/07/2020 09:19"), "08999935874", "67992857488",
				"Beatriz Almeida", "1963-11-11", "beatrizalmeida@gmail.com", true);
		Paciente pac5 = new Paciente(null, sdf.parse("11/12/2019 09:33"), "09287988876", "67992857488",
				"Troiano Matheus Dangelo", "1989-04-07", "matheus@gmail.com", true);
		Paciente pac6 = new Paciente(null, sdf.parse("01/07/2020 09:19"), "09399935877", "67992857488",
				"Rui Carlos Fernando Fusca", "1981-11-05", "carlosfernando@gmail.com", true);
		Paciente pac7 = new Paciente(null, sdf.parse("11/10/2021 08:33"), "09487988876", "67992857488",
				"Dennys Carlos Ricardo", "1982-09-04", "dennys@gmail.com", true);
		Paciente pac8 = new Paciente(null, sdf.parse("01/09/2020 07:19"), "09599935877", "67992857488",
				"Carlos Fernando", "1983-11-18", "carlosfernando1@gmail.com", true);
		Paciente pac9 = new Paciente(null, sdf.parse("11/08/2019 06:33"), "09687988876", "67992857488",
				"Marcelo Luiz Oliveira", "1984-08-03", "marcelo@gmail.com", true);
		Paciente pac10 = new Paciente(null, sdf.parse("12/07/2020 10:19"), "01177935877", "67992857488",
				"Carla Roberta de Souza", "1985-11-30", "carla@gmail.com", true);
		Paciente pac11 = new Paciente(null, sdf.parse("13/06/2019 11:33"), "08987988876", "67992857488",
				"Nenna da Silva", "1986-04-28", "nenna@gmail.com", false);
		Paciente pac12 = new Paciente(null, sdf.parse("14/03/2020 12:19"), "08999988877", "67992857488",
				"Rudilene Moreira", "1987-10-23", "rudilene@gmail.com", false);
		Paciente pac13 = new Paciente(null, sdf.parse("15/02/2019 13:33"), "08987999876", "67992857488",
				"Raizen Amoedo", "1988-01-19", "raizen@gmail.com", false);
		Paciente pac14 = new Paciente(null, sdf.parse("16/01/2020 14:19"), "08999935877", "67992857488",
				"Luis Inacio Lula", "1989-04-15", "luis@gmail.com", false);
		Paciente pac15 = new Paciente(null, sdf.parse("17/04/2020 15:19"), "08911935877", "67992857488",
				"Adolpho Carlos", "1991-06-24", "adopho@gmail.com", false);
		Paciente pac16 = new Paciente(null, sdf.parse("18/05/2019 16:33"), "08922988876", "67992857488",
				"Andrio Algusto Luiz", "1990-04-17", "andrio@gmail.com", false);
		Paciente pac17 = new Paciente(null, sdf.parse("19/06/2020 17:19"), "08933935877", "67992857488",
				"Lorena Martins", "1991-12-11", "lorena@gmail.com", false);
		Paciente pac18 = new Paciente(null, sdf.parse("20/03/2019 07:33"), "08944988876", "67992857488",
				"Reviane Chaves Amorim", "1992-07-03", "reviane@gmail.com", false);
		Paciente pac19 = new Paciente(null, sdf.parse("21/04/2020 09:19"), "08955935877", "67992857488",
				"Thor Oliveira Arruda", "1993-02-02", "thor@gmail.com", false);
		Paciente pac20 = new Paciente(null, sdf.parse("22/05/2020 08:19"), "08966935877", "67992857488",
				"Baruk Adamastor Pedra", "1994-09-01", "baruk@gmail.com", false);

		Endereco ende1 = new Endereco(null, 79114785, 138, "Rua Belmonte", "Vila Célia", pac1);
		Endereco ende2 = new Endereco(null, 52114785, 1500, "Avenida Mato Grosso", "Centro", pac2);
		Endereco ende3 = new Endereco(null, 79384785, 1321, "Rua florida", "Vila Carvalho", pac3);
		Endereco ende4 = new Endereco(null, 79994785, 897, "Rua Castelo branco", "Bairro Monte Castelo", pac4);

		Prontuario pront1 = new Prontuario(null, 20208251, "I9327", sdf.parse("25/08/2020 10:44"),
				"Paciente reclama de fortes dores nos joelhos");
		Prontuario pront2 = new Prontuario(null, 2019712, "G185", sdf.parse("01/09/2019 07:21"),
				"Paciente reclama de fortes dores na cabeça");
		Prontuario pront3 = new Prontuario(null, 20186213, "G587", sdf.parse("21/06/2016 08:31"),
				"Paciente reclama de fortes dores na costas");
		Prontuario pront4 = new Prontuario(null, 20177184, "H232", sdf.parse("17/04/2019 20:32"),
				"Paciente reclama de fortes dores na perna");
		Prontuario pront5 = new Prontuario(null, 20208255, "I9328", sdf.parse("03/01/2020 10:44"),
				"Paciente reclama de fortes dores na perna esquerda");
		Prontuario pront6 = new Prontuario(null, 2019716, "V278", sdf.parse("01/07/2019 07:21"),
				"Paciente com quadro de paralisia cerebral");
		Prontuario pront7 = new Prontuario(null, 20186217, "T853", sdf.parse("21/06/2011 08:31"),
				"Paciente paraplégico");
		Prontuario pront8 = new Prontuario(null, 20177188, "I982", sdf.parse("17/11/2012 20:32"),
				"Paciente tetraplégico");
		Prontuario pront9 = new Prontuario(null, 20208259, "P215", sdf.parse("14/12/2015 10:44"),
				"Paciente não possui perna esquerda");
		Prontuario pront10 = new Prontuario(null, 20197110, "X127", sdf.parse("01/03/2013 07:21"),
				"Paciente não consegue mexer os dedos da mão esquerda");

//		Avaliacao ava1 = new Avaliacao(null, sdf.parse("17/07/2017 20:32"), pac1.toString(),
//				"Paciente sempre reclama de dores nas costas", "Pacente disse melhora na dorres nas costas",
//				"Bom, mas com desliexo do braço direito", "Avanacado, mas sem melhorias nos ultimos atendimentos",
//				"Dor nas costas", "Tratar a dor nas costas do paciente");
//		Avaliacao ava2 = new Avaliacao(null, sdf.parse("11/07/2019 07:42"), pac2.toString(),
//				"Paciente sempre reclama de dores nas costas", "Pacente disse melhora na dorres nas costas",
//				"Bom, mas com desliexo do braço direito", "Avanacado, mas sem melhorias nos ultimos atendimentos",
//				"Dor nas costas", "Tratar a dor nas costas do paciente");
//		Avaliacao ava3 = new Avaliacao(null, sdf.parse("21/01/2020 21:35"), pac3.toString(),
//				"Paciente sempre reclama de dores nas costas", "Pacente disse melhora na dorres nas costas",
//				"Bom, mas com desliexo do braço direito", "Avanacado, mas sem melhorias nos ultimos atendimentos",
//				"Dor nas costas", "Tratar a dor nas costas do paciente");
//		Avaliacao ava4 = new Avaliacao(null, sdf.parse("19/11/2019 18:22"), pac4.toString(),
//				"Paciente sempre reclama de dores nas costas", "Pacente disse melhora na dorres nas costas",
//				"Bom, mas com desliexo do braço direito", "Avanacado, mas sem melhorias nos ultimos atendimentos",
//				"Dor nas costas", "Tratar a dor nas costas do paciente");

//		EvolucaoClinica evo1 = new EvolucaoClinica(null, sdf.parse("11/07/2020 07:22"), "Conciente e disposto",
//				"Foi realizado estimulo dos membros inferiores e da lombar do paciente");
//		EvolucaoClinica evo2 = new EvolucaoClinica(null, sdf.parse("21/08/2020 13:14"), "Conciente e disposto",
//				"Foi realizado estimulo dos membros superiores e da pescoço do paciente");
//		EvolucaoClinica evo3 = new EvolucaoClinica(null, sdf.parse("15/09/2020 18:01"), "Conciente e disposto",
//				"Foi realizado estimulo dos membros inferiores e da ombros do paciente");
//		EvolucaoClinica evo4 = new EvolucaoClinica(null, sdf.parse("07/10/2020 15:18"), "Conciente e disposto",
//				"Foi realizado estimulo dos membros superiores e da costas do paciente");

//		Exame ex1 = new Exame(null, "Raio-x coluna", sdf.parse("21/08/2020 18:35"), "Exame em perfeitas condições",
//				"C5 e C6 trincadas");
//		Exame ex2 = new Exame(null, "Raio-x cabeça", sdf.parse("30/10/2020 13:12"), "Exame em perfeitas condições",
//				"Fratura na parte superior da cabeça");
//		Exame ex3 = new Exame(null, "Raio-x Tibia", sdf.parse("15/09/2020 15:37"), "Exame em perfeitas condições",
//				"Osso trincado");
//		Exame ex4 = new Exame(null, "Raio-x Femour", sdf.parse("01/11/2020 09:11"), "Exame em perfeitas condições",
//				"Osso com pequenas perfurações em toda parte frontal");

//		Encaminhamento ec1 = new Encaminhamento(null, "Neurofuncional", sdf.parse("01/11/2020 06:59"),
//				"Encaminhado para especialista em Neuro");
//		Encaminhamento ec2 = new Encaminhamento(null, "Respiratória", sdf.parse("02/11/2020 07:31"),
//				"Encaminhado para especialista em Fisio respiratória");
//		Encaminhamento ec3 = new Encaminhamento(null, "Traumato-Órtopedica", sdf.parse("03/11/2020 08:20"),
//				"Encaminhado para especialista Ortopédista");
//		Encaminhamento ec4 = new Encaminhamento(null, "Oncológica", sdf.parse("04/11/2020 09:12"),
//				"Encaminhado para especialista em Oncologia");

		Atendimento ate1 = new Atendimento(null, sdf.parse("01/01/2011 07:22"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da lombar do paciente", pront1, fisio1);
		Atendimento ate2 = new Atendimento(null, sdf.parse("02/02/2012 13:14"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da pescoço do paciente", pront2, fisio2);
		Atendimento ate3 = new Atendimento(null, sdf.parse("03/03/2013 18:01"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da ombros do paciente", pront3, fisio3);
		Atendimento ate4 = new Atendimento(null, sdf.parse("04/04/2014 15:18"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da costas do paciente", pront4, fisio4);
		Atendimento ate5 = new Atendimento(null, sdf.parse("05/05/2015 07:22"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da lombar do paciente", pront5, fisio5);
		Atendimento ate6 = new Atendimento(null, sdf.parse("06/06/2016 13:14"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da pescoço do paciente", pront6, fisio6);
		Atendimento ate7 = new Atendimento(null, sdf.parse("07/07/2017 18:01"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da ombros do paciente", pront7, fisio7);
		Atendimento ate8 = new Atendimento(null, sdf.parse("08/10/2018 15:18"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da costas do paciente", pront8, fisio8);
		Atendimento ate9 = new Atendimento(null, sdf.parse("19/08/2019 07:22"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da lombar do paciente", pront9, fisio9);
		Atendimento ate10 = new Atendimento(null, sdf.parse("10/09/2020 13:14"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da pescoço do paciente", pront10, fisio10);
		Atendimento ate11 = new Atendimento(null, sdf.parse("11/11/2021 18:01"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da ombros do paciente", pront1, fisio1);
		Atendimento ate12 = new Atendimento(null, sdf.parse("12/12/2010 15:18"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da costas do paciente", pront2, fisio2);
		Atendimento ate13 = new Atendimento(null, sdf.parse("13/01/2011 07:22"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da lombar do paciente", pront3, fisio3);
		Atendimento ate14 = new Atendimento(null, sdf.parse("14/02/2012 13:14"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da pescoço do paciente", pront4, fisio4);
		Atendimento ate15 = new Atendimento(null, sdf.parse("15/03/2013 18:01"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da ombros do paciente", pront5, fisio5);
		Atendimento ate16 = new Atendimento(null, sdf.parse("16/04/2014 15:18"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da costas do paciente", pront6, fisio6);
		Atendimento ate17 = new Atendimento(null, sdf.parse("17/05/2015 07:22"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da lombar do paciente", pront7, fisio7);
		Atendimento ate18 = new Atendimento(null, sdf.parse("18/06/2016 13:14"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da pescoço do paciente", pront8, fisio8);
		Atendimento ate19 = new Atendimento(null, sdf.parse("19/07/2017 18:01"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da ombros do paciente", pront9, fisio9);
		Atendimento ate20 = new Atendimento(null, sdf.parse("20/08/2018 15:18"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da costas do paciente", pront10, fisio10);
		Atendimento ate21 = new Atendimento(null, sdf.parse("21/09/2019 07:22"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da lombar do paciente", pront1, fisio1);
		Atendimento ate22 = new Atendimento(null, sdf.parse("22/10/2020 13:14"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da pescoço do paciente", pront2, fisio2);
		Atendimento ate23 = new Atendimento(null, sdf.parse("12/11/2021 18:01"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da ombros do paciente", pront3, fisio3);
		Atendimento ate24 = new Atendimento(null, sdf.parse("11/12/2010 15:18"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da costas do paciente", pront4, fisio4);
		Atendimento ate25 = new Atendimento(null, sdf.parse("03/01/2011 18:01"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da ombros do paciente", pront5, fisio5);
		Atendimento ate26 = new Atendimento(null, sdf.parse("07/02/2012 15:18"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da costas do paciente", pront6, fisio6);
		Atendimento ate27 = new Atendimento(null, sdf.parse("15/03/2013 18:01"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da ombros do paciente", pront7, fisio7);
		Atendimento ate28 = new Atendimento(null, sdf.parse("08/04/2014 15:18"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da costas do paciente", pront8, fisio8);
		Atendimento ate29 = new Atendimento(null, sdf.parse("11/05/2015 18:01"), "Conciente e disposto",
				"Foi realizado estimulo dos membros inferiores e da ombros do paciente", pront9, fisio9);
		Atendimento ate30 = new Atendimento(null, sdf.parse("29/06/2016 15:18"), "Conciente e disposto",
				"Foi realizado estimulo dos membros superiores e da costas do paciente", pront10, fisio10);

		fisio1.getPacientes().addAll(Arrays.asList(pac1, pac11));
		fisio2.getPacientes().addAll(Arrays.asList(pac2, pac12));
		fisio3.getPacientes().addAll(Arrays.asList(pac3, pac13));
		fisio4.getPacientes().addAll(Arrays.asList(pac4, pac14));
		fisio5.getPacientes().addAll(Arrays.asList(pac5, pac15));
		fisio6.getPacientes().addAll(Arrays.asList(pac6, pac16));
		fisio7.getPacientes().addAll(Arrays.asList(pac7, pac17));
		fisio8.getPacientes().addAll(Arrays.asList(pac8, pac18));
		fisio9.getPacientes().addAll(Arrays.asList(pac9, pac19));
		fisio10.getPacientes().addAll(Arrays.asList(pac10, pac20));

		pac1.getFisioterapeutas().add(fisio1);
		pac2.getFisioterapeutas().add(fisio2);
		pac3.getFisioterapeutas().add(fisio3);
		pac4.getFisioterapeutas().add(fisio4);
		pac5.getFisioterapeutas().add(fisio5);
		pac6.getFisioterapeutas().add(fisio6);
		pac7.getFisioterapeutas().add(fisio7);
		pac8.getFisioterapeutas().add(fisio8);
		pac9.getFisioterapeutas().add(fisio9);
		pac10.getFisioterapeutas().add(fisio10);
		pac11.getFisioterapeutas().add(fisio1);
		pac12.getFisioterapeutas().add(fisio2);
		pac13.getFisioterapeutas().add(fisio3);
		pac14.getFisioterapeutas().add(fisio4);
		pac15.getFisioterapeutas().add(fisio5);
		pac16.getFisioterapeutas().add(fisio6);
		pac17.getFisioterapeutas().add(fisio7);
		pac18.getFisioterapeutas().add(fisio8);
		pac19.getFisioterapeutas().add(fisio9);
		pac20.getFisioterapeutas().add(fisio10);

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
		pac5.setProntuario(pront5);
		pac6.setProntuario(pront6);
		pac7.setProntuario(pront7);
		pac8.setProntuario(pront8);
		pac9.setProntuario(pront9);
		pac10.setProntuario(pront10);

		pront1.setPaciente(pac1);
		pront2.setPaciente(pac2);
		pront3.setPaciente(pac3);
		pront4.setPaciente(pac4);
		pront5.setPaciente(pac5);
		pront6.setPaciente(pac6);
		pront7.setPaciente(pac7);
		pront8.setPaciente(pac8);
		pront9.setPaciente(pac9);
		pront10.setPaciente(pac10);

//		pront1.getAvaliacoes().add(ava1);
//		pront2.getAvaliacoes().add(ava2);
//		pront3.getAvaliacoes().add(ava3);
//		pront4.getAvaliacoes().add(ava4);
//
//		ava1.setProntuario(pront1);
//		ava2.setProntuario(pront2);
//		ava3.setProntuario(pront3);
//		ava4.setProntuario(pront4);

//		pront1.getEvolucoesClinicas().add(evo1);
//		pront2.getEvolucoesClinicas().add(evo2);
//		pront3.getEvolucoesClinicas().add(evo3);
//		pront4.getEvolucoesClinicas().add(evo4);
//
//		evo1.setProntuario(pront1);
//		evo2.setProntuario(pront2);
//		evo3.setProntuario(pront3);
//		evo4.setProntuario(pront4);
//
//		pront1.getExames().add(ex1);
//		pront2.getExames().add(ex2);
//		pront3.getExames().add(ex3);
//		pront4.getExames().add(ex4);
//
//		ex1.setProntuario(pront1);
//		ex2.setProntuario(pront2);
//		ex3.setProntuario(pront3);
//		ex4.setProntuario(pront4);
//
//		pront1.getEncaminhamentos().add(ec1);
//		pront2.getEncaminhamentos().add(ec2);
//		pront3.getEncaminhamentos().add(ec3);
//		pront4.getEncaminhamentos().add(ec4);
//
//		ec1.setProntuario(pront1);
//		ec2.setProntuario(pront2);
//		ec3.setProntuario(pront3);
//		ec4.setProntuario(pront4);

		ate1.setProntuario(pront1);
		ate2.setProntuario(pront2);
		ate3.setProntuario(pront3);
		ate4.setProntuario(pront4);
		ate5.setProntuario(pront5);
		ate6.setProntuario(pront6);
		ate7.setProntuario(pront7);
		ate8.setProntuario(pront8);
		ate9.setProntuario(pront9);
		ate10.setProntuario(pront10);
		ate11.setProntuario(pront1);
		ate12.setProntuario(pront2);
		ate13.setProntuario(pront3);
		ate14.setProntuario(pront4);
		ate15.setProntuario(pront5);
		ate16.setProntuario(pront6);
		ate17.setProntuario(pront7);
		ate18.setProntuario(pront8);
		ate19.setProntuario(pront9);
		ate20.setProntuario(pront10);
		ate21.setProntuario(pront1);
		ate22.setProntuario(pront2);
		ate23.setProntuario(pront3);
		ate24.setProntuario(pront4);
		ate25.setProntuario(pront5);
		ate26.setProntuario(pront6);
		ate27.setProntuario(pront7);
		ate28.setProntuario(pront8);
		ate29.setProntuario(pront9);
		ate30.setProntuario(pront10);

		pront1.getAtendimentos().addAll(Arrays.asList(ate1, ate11, ate21));
		pront2.getAtendimentos().addAll(Arrays.asList(ate2, ate12, ate22));
		pront3.getAtendimentos().addAll(Arrays.asList(ate3, ate13, ate23));
		pront4.getAtendimentos().addAll(Arrays.asList(ate4, ate14, ate24));
		pront5.getAtendimentos().addAll(Arrays.asList(ate5, ate15, ate25));
		pront6.getAtendimentos().addAll(Arrays.asList(ate6, ate16, ate26));
		pront7.getAtendimentos().addAll(Arrays.asList(ate7, ate17, ate27));
		pront8.getAtendimentos().addAll(Arrays.asList(ate8, ate18, ate28));
		pront9.getAtendimentos().addAll(Arrays.asList(ate9, ate19, ate29));
		pront10.getAtendimentos().addAll(Arrays.asList(ate10, ate20, ate30));

		fisioterapeutaRepository.saveAll(
				Arrays.asList(fisio1, fisio2, fisio3, fisio4, fisio5, fisio6, fisio7, fisio8, fisio9, fisio10));
		pacienteRepository.saveAll(Arrays.asList(pac1, pac2, pac3, pac4, pac5, pac6, pac7, pac8, pac9, pac10, pac11,
				pac12, pac13, pac14, pac15, pac16, pac17, pac18, pac19, pac20));
		enderecoRepository.saveAll(Arrays.asList(ende1, ende2, ende3, ende4));
		prontuarioRepository.saveAll(Arrays.asList(pront1, pront2, pront3, pront4));
//		avaliacaoRepository.saveAll(Arrays.asList(ava1, ava2, ava3, ava4));
//		evolucaoClinicaRepository.saveAll(Arrays.asList(evo1, evo2, evo3, evo4));
//		exameRepository.saveAll(Arrays.asList(ex1, ex2, ex3, ex4));
//		encaminhamentoRepository.saveAll(Arrays.asList(ec1, ec2, ec3, ec4));
		atendimentoRepository.saveAll(
				Arrays.asList(ate1, ate2, ate3, ate4, ate5, ate6, ate7, ate8, ate9, ate10, ate11, ate12, ate13, ate14, ate15,
						ate16, ate17, ate18, ate19, ate20, ate21, ate22, ate23, ate24, ate25, ate26, ate27, ate28, ate29, ate30));

	}
}
