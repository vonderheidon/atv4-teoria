public class Questao1 {

    public static boolean pertenceLinguagem(String cadeia) {
        int indice = 0;
        char simboloAtual = 'S';

        while (indice < cadeia.length()) {
            if (simboloAtual == 'S') {
                if (cadeia.charAt(indice) == 'a') {
                    simboloAtual = 'A';
                    indice++;
                } else if (cadeia.charAt(indice) == 'b') {
                    simboloAtual = 'B';
                    indice++;
                } else {
                    return false;
                }
            } else if (simboloAtual == 'A') {
                if (cadeia.charAt(indice) == 'a') {
                    indice++;
                } else {
                    simboloAtual = 'ε';
                }
            } else if (simboloAtual == 'B') {
                if (cadeia.charAt(indice) == 'b') {
                    indice++;
                } else {
                    simboloAtual = 'ε';
                }
            } else {
                return false;
            }
        }

        return simboloAtual == 'A' || simboloAtual == 'B' || simboloAtual == 'ε';
    }

    public static void main(String[] args) {
        String[] cadeiasTeste = {"aaa", "bb", "ab", "b", "a"};
        for (String cadeia : cadeiasTeste) {
            System.out.println("Cadeia \"" + cadeia + "\" pertence à linguagem? " + (pertenceLinguagem(cadeia) ? "Sim." : "Não."));
            System.out.println("-----------");
        }
    }
}
