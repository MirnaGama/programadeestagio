import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class alphabet_decode {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira uma sequência de números com combinações de 1 a 26:");
		String valor = sc.next();
		
		decode(valor);
		
	}
	
	
	// Determina a entrada, a saída e as combinações
	public static void decode(String valor) {
		
		System.out.println("\nEntrada: "+valor);

		Set<String> combinacoes = decodeHelper("", valor);

		System.out.println("\nSaída: " +combinacoes.size());
		System.out.println("\nCombinações possíveis: ");

		for (String string : combinacoes) {
			System.out.println(string.toUpperCase());
		}
	}

	// Transforma os números em letras e checa as possibilidades de transformações por char
	private static Set<String> decodeHelper(String prefixo, String code) {
		Set<String> set = new HashSet<String>();
		
		if (code.length() == 0) {
			set.add(prefixo);
			return set;
		}

		if (code.charAt(0) == '0')
			return set;
		    set.addAll(decodeHelper(prefixo + (char) (code.charAt(0) - '1' + 'a'), code.substring(1)));

		if (code.length() >= 2 && code.charAt(0) == '1') {
			set.addAll(decodeHelper(prefixo + (char) (10 + code.charAt(1) - '1' + 'a'), code.substring(2)));
			char c = (char) (10 + code.charAt(1) - '1' + 'a');
		}

		if (code.length() >= 2 && code.charAt(0) == '2' && code.charAt(1) <= '6') {
			set.addAll(decodeHelper(prefixo + (char) (20 + code.charAt(1) - '1' + 'a'), code.substring(2)));
		}

		return set;
	}
}
