package tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import logic.KNN;
import model.Person;

import org.junit.Before;
import org.junit.Test;

import aux.TxtCommonMethods;

public class KNNTest {
	private KNN knn;
	List<Person> people;
	Person person6;
	String userDir;
	String fileSeparator;
	StringBuilder knnResult;
	int contadorIteracoesTreinamento = 0;
	int contadorIteracoesTeste = 0;

	@Before
	public void setUp() throws IOException {
		this.knn = new KNN();
		this.userDir = System.getProperty("user.dir");
		this.fileSeparator = System.getProperty("file.separator");
		knnResult = new StringBuilder();
		KNN.K = 5;
	}

	@Test
	public void mainTest() throws IOException {

		// carregando e inserindo dados de treinamento
		List<String> linhasTreinamento = TxtCommonMethods.readTxtFile(new File(
				this.userDir + this.fileSeparator + "treinamento.csv"));

		for (int i = 1; i < linhasTreinamento.size(); i++) {
			String a, b, c;

			String[] linha = linhasTreinamento.get(i).split(",");
			a = linha[0];
			b = linha[1];
			c = linha[5];
			if ((c.isEmpty())) {
				c = "30.0";
			}

			boolean survived = false;

			int pclass = Integer.parseInt(b);
			float age = Float.parseFloat(c);
			int aux = Integer.parseInt(a);
			if (aux == 1) {
				survived = true;
			}

			Person p = new Person(survived, pclass, age);

			knn.addPerson(p);
			contadorIteracoesTreinamento++;
		}

		// carregando, inserindo e aplicando o algoritmo desenvolvido nos dados
		// de teste!
		List<String> linhasTeste = TxtCommonMethods.readTxtFile(new File(
				this.userDir + this.fileSeparator + "teste.csv"));
		int value = 0;
		for (int i = 0; i < linhasTeste.size(); i++) {
			String a, c;

			String[] linha = linhasTeste.get(i).split(",");
			a = linha[0];
			c = linha[4];
			if ((c.isEmpty())) {
				c = "30.0";
			}

			boolean survived = false;

			int pclass = Integer.parseInt(a);
			float age = Float.parseFloat(c);

			Person p = new Person(survived, pclass, age);
			Person solved = knn.solve(p);
			value = 0;
			if (solved.isSurvived())
				value = 1;

			knnResult.append(value + "\n");

			contadorIteracoesTeste++;

		}

		// exibindo resultados encontrados e armazenando em arquivo txt para
		// verificacao
		System.out.println(knnResult.toString());
		TxtCommonMethods.saveTxtFile(knnResult.toString(),
				"resultado-knn-sinval.txt", new File(userDir));

	}
}
