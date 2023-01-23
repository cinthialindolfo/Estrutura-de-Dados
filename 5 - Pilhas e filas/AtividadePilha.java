public class AtividadePilha{

    public static void main(String[] args) {

        StackArray<String> sa = new StackArray<String>(3);

        System.out.println("Lista de nomes: ");

        sa.push("Erick");
        sa.push("Jose");
        sa.push("Maria");
        sa.push("Gabriel");

        System.out.println(sa);

        sa.pop();

        System.out.println(sa);

        sa.pop();

        System.out.println(sa);

        sa.pop();

        System.out.println(sa);

    }

}