import java.util.ArrayList;
import java.util.List;

public class Questao2 {

    public static List<String> gerarCadeias(int n) {
        List<String> cadeias = new ArrayList<>();
        gerarCadeiasR("S", n, cadeias, "");
        return cadeias;
    }

    private static void gerarCadeiasR(String simbolo, int n, List<String> cadeias, String cadeiaAtual) {
        if (cadeiaAtual.length() == n) {
            if (!cadeiaAtual.contains("S") && !cadeiaAtual.contains("A") && !cadeiaAtual.contains("B")) {
                cadeias.add(cadeiaAtual);
            }
            return;
        }

        if (cadeiaAtual.length() > n) {
            return;
        }

        switch (simbolo) {
            case "S":
                gerarCadeiasR("A", n, cadeias, cadeiaAtual + "a");
                gerarCadeiasR("B", n, cadeias, cadeiaAtual + "b");
                gerarCadeiasR("ε", n, cadeias, cadeiaAtual + "c");
                break;
            case "A":
                gerarCadeiasR("A", n, cadeias, cadeiaAtual + "a");
                gerarCadeiasR("ε", n, cadeias, cadeiaAtual);
                break;
            case "B":
                gerarCadeiasR("B", n, cadeias, cadeiaAtual + "b");
                gerarCadeiasR("ε", n, cadeias, cadeiaAtual);
                break;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<String> cadeias = gerarCadeias(n);
        System.out.println("Cadeias de comprimento " + n + ":");
        for (String cadeia : cadeias) {
            System.out.println(cadeia);
        }
    }
}
