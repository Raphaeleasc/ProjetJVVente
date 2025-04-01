
import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
    class GestionajoutItem implements  ItemListener{
        private JPanel panelAItem = new JPanel();
        private JPanel panelAItemBas = new JPanel();
        private JPanel choixPanel = new JPanel();
        private JPanel PanelAItemMain = new JPanel();
        private Choice qualProduitChoice = new Choice();
        private JTextField remiseTextField = new JTextField();
        private JLabel remiseJLabel = new JLabel("Taux Remise");
        private JLabel qualiteLabel = new JLabel("Qualite");
        private int change = 0;
        public void afficheDemandeItem(){
             // Panel haut 
            GridLayout gridAtiem = new  GridLayout(4,2);
            this.panelAItem.setLayout(gridAtiem);
            JLabel[] labels = new JLabel[4];
            String[] nomlabel = {"Nom","Ville","Prix","quantité"};
            JTextField[] textfield1 = new JTextField[4];
            for(int x=0;x<nomlabel.length;x++){
                labels[x] = new JLabel(nomlabel[x]);
                textfield1[x] = new JTextField();
                this.panelAItem.add(labels[x]);
                this.panelAItem.add(textfield1[x]);
            }
            //Panel bas
            GridLayout gridAtiemBas = new  GridLayout(1,2,6,6);
            this.panelAItemBas.setLayout(gridAtiemBas);
            JButton[] buttons = new JButton[2];
            buttons[0] = new JButton("Valider");
            buttons[1] = new JButton("Annuler");
            this.panelAItemBas.add(buttons[0]);
            this.panelAItemBas.add(buttons[1]);
            
            //Panneau choixType
            GridLayout choixGridLayout = new GridLayout(0,2,6,6);
            this.choixPanel.setLayout(choixGridLayout);
            JLabel choixJLabel = new JLabel("Type de produit");
            Choice produitChoice = new Choice();
            produitChoice.add("Artisanal");
            produitChoice.add("Industriel");
            this.choixPanel.add(choixJLabel);
            this.choixPanel.add(produitChoice);
            produitChoice.addItemListener(this);
            this.qualProduitChoice.add("Basse qualite");
            this.qualProduitChoice.add("Haute qualité");
            // Panneau Principal
            GridLayout GridAItemMain = new GridLayout(2,1);
            this.PanelAItemMain.setLayout(GridAItemMain);
            JPanel AItem1JPanel = new JPanel();
            AItem1JPanel.setLayout(GridAItemMain);
            this.PanelAItemMain.add(this.panelAItem);
            AItem1JPanel.add(this.choixPanel);
            AItem1JPanel.add(this.panelAItemBas);
            this.PanelAItemMain.add(AItem1JPanel);
            JFrame frameAitem = new JFrame();
            frameAitem.add(this.PanelAItemMain);
            frameAitem.setSize(200,200);
            frameAitem.setVisible(true);
        }
        public void itemStateChanged(ItemEvent item){
            Object obj = item.getItem();
            String selection = (String)obj;
            System.out.println("choix : "+selection);
            if (this.change == 1){
                this.choixPanel.remove(2);
                this.choixPanel.remove(2);
            }
            if(selection.equals("Artisanal")){
                this.choixPanel.add(this.qualiteLabel);
                this.choixPanel.add(this.qualProduitChoice);
            }
            else if(selection.equals("Industriel")){
                this.choixPanel.add(this.remiseJLabel);
                this.choixPanel.add(this.remiseTextField);                
            }
            this.PanelAItemMain.revalidate();
            this.PanelAItemMain.repaint();
            this.change=1;
        }
    }
//Gestion affichage item