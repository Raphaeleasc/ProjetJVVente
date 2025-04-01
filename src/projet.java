
import java.awt.Choice;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class projet {
    public static void main(String[] args) {
        GestionajoutItem additem = new GestionajoutItem();
        additem.afficheDemandeItem();
    }
}
class Client{
    private String nom;
    private String prenom;
    private int age;
    private String ville;
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

    public float calculprix(){
        return this.prixuni*this.quantité;
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
    public float calculprixindustriel(){
        return calculprix()-(calculprix()*this.tauxReduc);
    }
}



// Gestion Interface
    class GestionInterface{

    }


// Gestion ajout item
    class GestionajoutItem{
        public void afficheDemandeItem(){
            JPanel panelAItem = new JPanel(); // Panel haut 
            GridLayout gridAtiem = new  GridLayout(4,2);
            panelAItem.setLayout(gridAtiem);
            JLabel[] labels = new JLabel[4];
            String[] nomlabel = {"Nom","Ville","Prix","quantité"};
            JTextField[] textfield1 = new JTextField[4];
            for(int x=0;x<nomlabel.length;x++){
                labels[x] = new JLabel(nomlabel[x]);
                textfield1[x] = new JTextField();
                panelAItem.add(labels[x]);
                panelAItem.add(textfield1[x]);
            }
            //Panel bas
            JPanel panelAItemBas = new JPanel();
            GridLayout gridAtiemBas = new  GridLayout(1,2);
            panelAItemBas.setLayout(gridAtiemBas);
            JButton[] buttons = new JButton[2];
            buttons[0] = new JButton("Valider");
            buttons[1] = new JButton("Annuler");
            panelAItemBas.add(buttons[0]);
            panelAItemBas.add(buttons[1]);
            
            //Panneau choixType
            JPanel choixPanel = new JPanel();
            GridLayout choixGridLayout = new GridLayout(1,2);
            choixPanel.setLayout(choixGridLayout);
            JLabel choixJLabel = new JLabel("Type de produit");
            Choice produitChoice = new Choice();
            produitChoice.add("Artisanal");
            produitChoice.add("Industriel");
            choixPanel.add(choixJLabel);
            choixPanel.add(produitChoice);
            
            // Panneau Principal
            JPanel PanelAItemMain = new JPanel();
            GridLayout GridAItemMain = new GridLayout(3,1);
            PanelAItemMain.setLayout(GridAItemMain);
            PanelAItemMain.add(panelAItem);
            PanelAItemMain.add(choixPanel);
            PanelAItemMain.add(panelAItemBas);
            JFrame frameAitem = new JFrame();
            frameAitem.add(PanelAItemMain);
            frameAitem.setSize(200,200);
            frameAitem.setVisible(true);
        }
    }
//Gestion affichage item