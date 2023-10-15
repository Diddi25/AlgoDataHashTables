public class Node {
    String stringCode;
    Integer integerCode;
    String name;
    Integer population;
    public Node (String zip, String name, Integer population) {
        this.stringCode = zip;
        this.name = name;
        this.population = population;
    }
    public Node (Integer zip, String name, Integer population) {
        this.integerCode = zip;
        this.name = name;
        this.population = population;
    }
}
