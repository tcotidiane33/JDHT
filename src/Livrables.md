Spécification :

Objectif : Le but de ce projet est de concevoir une infrastructure de résolution de noms de ressources Internet basée sur une Distributed Hash Table (DHT) utilisant le concept de hachage consistent. Cette infrastructure permettra de mapper des noms de domaine à des nœuds de manière distribuée et efficace.

Fonctionnalités :

Ajout de nœuds : Les nœuds peuvent être ajoutés à l'infrastructure en spécifiant leur adresse IP.
Résolution de noms de domaine : Les noms de domaine peuvent être résolus en déterminant le nœud responsable de ce domaine.
Obtention de tous les nœuds connectés : Il est possible d'obtenir tous les nœuds connectés au nœud responsable d'un domaine donné.
Identification du nœud principal : La DHT permettra également d'identifier le nœud principal responsable de la résolution des noms de domaine pour un domaine donné.
Architecture :

L'architecture de la solution proposée repose sur les éléments suivants :

DistributedHashTable : Classe principale représentant la Distributed Hash Table.

Attributs :
virtualNodes : TreeMap stockant les nœuds virtuels avec leur hash correspondant.
domainNodeMap : Map associant les noms de domaine aux nœuds.
Méthodes :
addNode(String nodeName): Ajoute un nœud à la DHT.
resolveDomain(String domain): Résout un nom de domaine en déterminant le nœud responsable.
resolveDomain(String domain): Renvoie tous les nœuds connectés au nœud responsable pour un domaine donné.
getHash(String node): Fonction de hachage utilisant le hachage consistant.
main(String[] args): Méthode principale pour tester la DHT.
Main : Classe principale contenant la méthode main pour tester la DHT.

Livrables :

Code source complet de l'implémentation de la DHT en Java.
Document de spécification détaillant les fonctionnalités, l'architecture et les décisions de conception.
Rapport de test décrivant les scénarios de test utilisés pour valider le fonctionnement de la DHT.
Guide d'utilisation expliquant comment utiliser et intégrer la DHT dans d'autres applications.