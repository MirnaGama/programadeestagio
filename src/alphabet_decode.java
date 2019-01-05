import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class alphabet_decode {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira uma sequ�ncia de n�meros com combina��es de 1 a 26:");
		String valor = sc.next();
		
		decode(valor);
		
	}
	
	
	// Determina a entrada, a sa�da e as combina��es
	public static void decode(String valor) {
		
		System.out.println("\nEntrada: "+valor);

		Set<String> combinacoes = decodeHelper("", valor);

		System.out.println("\nSa�da: " +combinacoes.size());
		System.out.println("\nCombina��es poss�veis: ");

		for (String string : combinacoes) {
			System.out.println(string.toUpperCase());
		}
	}

	// Transforma os n�meros em letras e checa as possibilidades de transforma��es por char
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
