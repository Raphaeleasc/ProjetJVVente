public class projet {
    
}

class Produit{
    public int prixuni;
    public int quantité;
    public String nom;
    public String ville;
    public Produit(){
        this.prixuni = 0;
        this.quantité = 0;
        this.nom = "none";
        this.ville = "none";
    }
    public Produit(int prixuni,int quantité,String nom,String ville){
        this.prixuni = prixuni;
        this.quantité = quantité;
        this.nom = nom;
        this.ville = ville;

    }
}
class ProduitA extends Produit{
    public String qualité;// bas de gamme ou haute gamme
    public ProduitA(){
        super();
        this.qualité = "none";
    }
    public ProduitA(int prixuni,int quantité,String nom,String ville,String qualité){
        super(prixuni, quantité, nom, ville);
        this.qualité = qualité;
    }
}
class ProduitB extends Produit{
    public int tauxReduc;// bas de gamme ou haute gamme
    public ProduitB(){
        super();
        this.tauxReduc = 0;
    }
    public ProduitB(int prixuni,int quantité,String nom,String ville,int tauxReduc){
        super(prixuni, quantité, nom, ville);
        this.tauxReduc = tauxReduc;
    }
}