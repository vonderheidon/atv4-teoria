import java.util.Map;

public class Questao3 {

    public static boolean pertenceLinguagem(Map<Character, String[]> producoes, String cadeia) {
        return verificar(producoes, 'S', cadeia, 0) == cadeia.length();
    }

    private static int verificar(Map<Character, String[]> producoes, char simboloAtual, String cadeia, int indice) {
        if (indice == cadeia.length() && (simboloAtual == 'A' || simboloAtual == 'B' || simboloAtual == 'S')) {
            return indice;
        }
        if (indice > cadeia.length()) {
            return -1;
        }

        for (String regra : producoes.get(simboloAtual)) {
            int novoIndice = indice;
            boolean valido = true;
            for (char simbolo : regra.toCharArray()) {
                if (simbolo == 'ε') {
                    break;
                } else if (Character.isLowerCase(simbolo)) {
                    if (novoIndice < cadeia.length() && cadeia.charAt(novoIndice) == simbolo) {
                        novoIndice++;
                    } else {
                        valido = false;
                        break;
                    }
                } else {
                    novoIndice = verificar(producoes, simbolo, cadeia, novoIndice);
                    if (novoIndice == -1) {
                        valido = false;
                        break;
                    }
                }
            }
            if (valido) return novoIndice;
        }
        return -1;
    }

    public static void main(String[] args) {
        Map<Character, String[]> gramatica = Map.of(
                'S', new String[]{"aA", "bB"},
                'A', new String[]{"aA", "ε"},
                'B', new String[]{"bB", "ε"}
        );

        String[] cadeiasTeste = {"aaa", "bb", "ab", "b", "a"};
        for (String cadeia : cadeiasTeste) {
            System.out.println("Cadeia \"" + cadeia + "\" pertence à linguagem? " + (pertenceLinguagem(gramatica, cadeia) ?  "Sim." : "Não."));
            System.out.println("---------");
        }
    }
}
