import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistributedHashTable {
    private static final int NUM_VIRTUAL_NODES = 20;
    private final Map<Integer, String> virtualNodes = new HashMap<>();
    private final Map<String, String> domainNodeMap = new HashMap<>();

    public void addNode(String nodeName) {
        for (int i = 0; i < NUM_VIRTUAL_NODES; i++) {
            String virtualNode = nodeName + "#" + i;
            int hash = getHash(virtualNode);
            virtualNodes.put(hash, nodeName);
        }
        domainNodeMap.put(nodeName, nodeName);
    }

    public Map<String, List<String>> resolveDomain(String domain) {
        Map<String, List<String>> result = new HashMap<>();
        List<String> connectedNodes = new ArrayList<>();
        String primaryNode = null;
        for (String node : domainNodeMap.values()) {
            connectedNodes.add(node);
            if (primaryNode == null) {
                primaryNode = node;
            }
        }
        result.put("primaryNode", new ArrayList<>(List.of(primaryNode)));
        result.put("connectedNodes", connectedNodes);
        return result;
    }

    private int getHash(String node) {
        return node.hashCode();
    }

    public static void main(String[] args) {
        DistributedHashTable dht = new DistributedHashTable();

        try {
            for (int i = 0; i <= 255; i++) {
                for (int j = 0; j <= 255; j++) {
                    String ipAddress = "192.168." + i + "." + j;
                    dht.addNode(ipAddress);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String domain = "dht.transmissionbt.com";
        Map<String, List<String>> domainInfo = dht.resolveDomain(domain);
        String primaryNode = domainInfo.get("primaryNode").get(0);
        List<String> connectedNodes = domainInfo.get("connectedNodes");

        System.out.println("Le nœud principal responsable pour le domaine " + domain + " est : " + primaryNode);

        if (!connectedNodes.isEmpty()) {
            System.out.println("Tous les nœuds connectés au domaine " + domain + " :");
            for (String connectedNode : connectedNodes) {
                System.out.println(connectedNode);
            }
        } else {
            System.out.println("Aucun nœud connecté au domaine " + domain);
        }
    }
}
