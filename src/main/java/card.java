import java.util.ArrayList; // recorre una lista de elementos
import java.util.Collections; // son las colecciones de Java, contienen métodos estaticos
import java.util.List; // almacena y organiza elementos en un orden específico
import java.util.Random; // genera numeros pseudoaleatorios, ya que contienen un punto de partida que en este caso

class card { //se inicializan las variables palo, color y valor de tipo string
    public String palo;
    public String color;
    public String valor;

    public card(String palo, String color, String valor) { // se crea constructor card con atributos palo, color y valor
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    public String toString() { // convierte números en cadena
        return palo + ", " + color + ", " + valor;
    }
}

class Deck {
    public List<card> deck; // lista de cartas

    public Deck() {
        deck = new ArrayList<>();
        inicializarDeck();
    }

    public void inicializarDeck() { // constructor inicializarDeck crea las 52 cartas de poker, el cual contiene los arreglos con las cartas del póker
        String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String palo : palos) {
            String color;
            if (palo.equals("Tréboles") || palo.equals("Picas")) { // se valida el color del palo
                color = "Negro";
            } else {
                color = "Rojo";
            }
            for (String valor : valores) {
                deck.add(new card(palo, color, valor));
            }
        }
    }

    public void shuffle() { // método shuffle que mezcla el deck
        Collections.shuffle(deck);
        System.out.println("Se mezcló el Deck."); // mensaje que avisa que se ha mezclado el deck
    }

    public void head() { // método head muestra y remueve la primer carta del deck
        if (!deck.isEmpty()) { // !deck verifica si el deck no esta vacío
            card card = deck.remove(0);
            System.out.println(card);
            System.out.println("Quedan " + deck.size() + " cartas en el deck."); // da el mensaje sobre que el deck ha sido barajado
        } else {
            System.out.println("El deck está vacío.");
        }
    }

    public void pick() { // método pick el cual selecciona y remueve una carta al azar del deck
        if (!deck.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(deck.size());
            card card = deck.remove(index);
            System.out.println(card);
            System.out.println("Quedan " + deck.size() + " cartas en el deck."); // da el mensaje sobre las cartas restantes
        } else {
            System.out.println("El deck está vacío.");
        }
    }

    public void hand() {
        if (deck.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                card card = deck.remove(0);
                System.out.println(card);
            }
            System.out.println("Quedan " + deck.size() + " cartas en el deck."); // da el mensaje sobre las cartas obtenidas en mano y muestra la cantidad restante de cartas
        } else {
            System.out.println("No hay suficientes cartas en el deck.");
        }
    }
}

class Main { // IntelliJ refactorizó a class Main
    public static void main(String[] args) {
        Deck deck = new Deck();

        // Mezcla el deck
        deck.shuffle();

        // Muestra la primera carta del deck
        deck.head();

        // Selecciona una carta al azar
        deck.pick();

        // Obtener una mano de 5 cartas
        deck.hand();
    }
}