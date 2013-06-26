package aux;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TxtCommonMethods {
	// Sistema Operacional do Usuario
	public static final String soName = System.getProperty("os.name");

	// Pega a versao do S.O
	public static final String soVersion = System.getProperty("os.version");

	// Nome do usuario
	public static final String userName = System.getProperty("user.name");

	// Pasta raiz do usuario
	public static final String userHome = System.getProperty("user.home");

	// Pasta onde o programa esta sendo executado
	public static final String userDir = System.getProperty("user.dir");

	// Separador de arquivo
	public static final String fileSeparator = System
			.getProperty("file.separator");

	// Separador de caminho usado pelo S.O
	public static final String pathSeparator = System
			.getProperty("path.separator");

	// Diretorio do java
	public static final String javaHome = System.getProperty("java.home");

	// Versao do java
	public static final String javaVersion = System.getProperty("java.version");

	public static List<String> readTxtFile(File src) throws IOException {
		List<String> linhas = new ArrayList<String>();

		try {
			FileReader arq = new FileReader(src);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while (linha != null) {
				linhas.add(linha);
				linha = lerArq.readLine(); // le da segunda ate a ultima linha
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}
		return linhas;
	}

	public static void saveTxtFile(String conteudo, String nome, File diretorio)
			throws FileNotFoundException {
		PrintWriter out = new PrintWriter(new FileOutputStream(diretorio
				+ fileSeparator + nome));
		out.write(conteudo);
		out.flush();
		out.close();
	}
}
