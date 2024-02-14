import java.net.InetAddress;

public class Node {
    private String name;
    private InetAddress address;
    private String domain; // Ajout du nom de domaine

    public Node(String name, InetAddress address, String domain) {
        this.name = name;
        this.address = address;
        this.domain = domain;
    }

    // Getters et setters pour le nom de domaine
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    // Autres getters et setters
    // ...
}
