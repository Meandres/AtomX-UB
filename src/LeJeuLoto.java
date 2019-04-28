/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gb346159
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class LeJeuLoto extends javax.swing.JFrame {
    // Attributs
    private int option; // Variable qui va stocker le choix de l'option choisie
    private int nbCol; // Variable stockant le nombre de colonnes
    private int nbNum; // Variable stockant le nombre de lignes
    private boolean ca; // Variable (initiée à false) qui indique si une carte a oui ou non été achetée lors de la partie
    private int nbJoueurs = 2;
    private final int MAX = 90;
    private int[] boules;
    private LesJoueurs lj;
    private ArrayList<Lot> ll;
    private ArrayList<Lot> llenjeu;
    private Lot lotenjeu;
    public LeJeuLoto() {
        initComponents(); // Création de l'interface (gérée par l'IDE)
        this.option = 1; // Par défaut, le mode de jeu est Quine
        jLabel5.setText("Option choisie: Quine");
        this.nbCol = 5; // Par défaut, le nombre de colonnes est de 5
        this.nbNum = 5; // Par défaut, le nombre de numéros est de 5
        this.ca = false; // Aucune carte n'a été achetée à la création de la fenêtre
        this.lj = new LesJoueurs(); // Création d'une instance LesJoueurs (où seront stockés tous nos joueurs)
        initJoueurs(); // Initialisation des deux joueurs "par défaut" (Lara et Jack)
        Tirage.setEnabled(false);
        boules = new int[MAX];
        initBoules();
        this.setSize(1200,800);
        jMenuItem6.setEnabled(false);
        this.ll = new ArrayList<Lot>();
        this.llenjeu = new ArrayList<Lot>();
        this.lotenjeu = new Lot();
        initLots();
        initLotsEnJeu();
        Arreter.setText("Lot à gagner");
        this.setTitle("Jeu du Loto");
    }
    
    private void initLots()
    {
        Lot boilloire = new Lot("Bouilloire", 1);
        boilloire.setImage(new ImageIcon(getClass().getResource("Images/Bouilloire.jpg")).getImage());
        Lot fer = new Lot("Fer à repasser", 1);
        fer.setImage(new ImageIcon(getClass().getResource("Images/Fer à repasser.jpg")).getImage());
        Lot machinel = new Lot("Machine à laver", 3);
        machinel.setImage(new ImageIcon(getClass().getResource("Images/Machine à laver.jpg")).getImage());
        Lot machiner = new Lot("Machine à raclette", 2);
        machiner.setImage(new ImageIcon(getClass().getResource("Images/Machine à raclette.jpg")).getImage());
        this.ll.add(boilloire);
        this.ll.add(fer);
        this.ll.add(machinel);
        this.ll.add(machiner);
    }
    
    private void initLotsEnJeu()
    {
        this.llenjeu.clear();
        for(int i=0; i<this.ll.size(); i++)
        {
            if(this.ll.get(i).getNiveau()==option)
                this.llenjeu.add(this.ll.get(i));
        }
    }
    
    private void initBoules()
    {
        for(int i=0; i<MAX; i++)
            boules[i]=0;
    }
    private void initJoueurs()
    {
      GestionJoueurs gj = new GestionJoueurs();
      jButton1.setText(gj.getDefaultJoueur1().getPseudo());
      jButton1.setBackground(gj.getDefaultJoueur1().getCouleur());
      jButton2.setText(gj.getDefaultJoueur2().getPseudo());
      jButton2.setBackground(gj.getDefaultJoueur2().getCouleur());
      lj.ajouteJoueur(gj.getDefaultJoueur1());
      lj.ajouteJoueur(gj.getDefaultJoueur2()); // Récupération des 2 joueurs par défaut, Lara et Jack, contenu dans la JList de GestionJoueurs et ajout dans le jeu
    }
    
    private void afficheCartes()
    {
        int cpt = 0;
        for(int i=0; i<lj.getNbJoueur(); i++)
        {
            Joueur j = lj.getJoueur(i);
            int numCartes = j.getNbCartes();
            switch(numCartes)
            {
                case 0: {cpt += 2;break;}
                case 1: {JPanel pan = (JPanel)jPanel7.getComponent(cpt);j.getCarte(0).dessineCarte(pan, j.getCouleur());cpt+=2;break;}
                case 2: {JPanel pan = (JPanel)jPanel7.getComponent(cpt);j.getCarte(0).dessineCarte(pan, j.getCouleur());cpt++;pan = (JPanel)jPanel7.getComponent(cpt);j.getCarte(1).dessineCarte(pan, j.getCouleur());cpt++;break;}
            }
            
        }
    }
    
    private boolean tousOntCarte()
    {
        boolean reponse = true;
        for(int i=0; i<lj.getNbJoueur(); i++)
        {
            if(lj.getJoueur(i).getNbCartes()<1)
                reponse = false;
        }
        return reponse;
    }
    
    private void setNouveauLot()
    {
        int rnd = (int)(Math.random()*this.llenjeu.size()+1);
            if(this.llenjeu.get(rnd-1).getImage()!=null)
                Arreter.setIcon(new ImageIcon(this.llenjeu.get(rnd-1).getImage().getScaledInstance(180, 100, 180)));
            else
            {
                Arreter.setIcon(null);
                Arreter.setText(this.llenjeu.get(rnd-1).getDescription());
            }
            lotenjeu = this.llenjeu.get(rnd-1);
            jMenuItem5.setEnabled(false);
            jMenuItem1.setEnabled(false);
            jMenuItem2.setEnabled(false);
            LCadeau.setText(lotenjeu.getDescription());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PNord = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PSud = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HistoriqueTirage = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Tirage = new javax.swing.JButton();
        LNumero = new javax.swing.JLabel();
        Arreter = new javax.swing.JButton();
        PCenter = new javax.swing.JPanel();
        PanCadeau = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        LCadeau = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Voici les cartes dont vous disposez");
        PNord.add(jLabel1);

        getContentPane().add(PNord, java.awt.BorderLayout.NORTH);

        PSud.setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jLabel2.setText("Historique du tirage des boules");
        jPanel1.add(jLabel2);

        HistoriqueTirage.setColumns(20);
        HistoriqueTirage.setRows(5);
        jScrollPane1.setViewportView(HistoriqueTirage);

        jPanel1.add(jScrollPane1);

        PSud.add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jLabel5.setText("Option choisie: ");
        jPanel13.add(jLabel5);
        jPanel13.add(jLabel6);

        jPanel2.add(jPanel13);

        jPanel4.setLayout(new java.awt.GridLayout(1, 3));

        jPanel5.setLayout(new java.awt.GridLayout(1, 1));

        Tirage.setText("Tirage");
        Tirage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TirageActionPerformed(evt);
            }
        });
        jPanel5.add(Tirage);
        jPanel5.add(LNumero);

        Arreter.setText("Arreter");
        jPanel5.add(Arreter);

        jPanel4.add(jPanel5);

        jPanel2.add(jPanel4);

        PSud.add(jPanel2);

        getContentPane().add(PSud, java.awt.BorderLayout.SOUTH);

        PCenter.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Cadeau: ");
        PanCadeau.add(jLabel4);
        PanCadeau.add(LCadeau);

        PCenter.add(PanCadeau, java.awt.BorderLayout.SOUTH);

        jPanel7.setLayout(new java.awt.GridLayout(4, 2));

        jPanel8.setLayout(new java.awt.GridLayout(3, 5));
        jPanel7.add(jPanel8);

        jPanel9.setLayout(new java.awt.GridLayout(3, 5));
        jPanel7.add(jPanel9);

        jPanel10.setLayout(new java.awt.GridLayout(3, 5));
        jPanel7.add(jPanel10);

        jPanel11.setLayout(new java.awt.GridLayout(3, 5));
        jPanel7.add(jPanel11);

        jPanel12.setLayout(new java.awt.GridLayout(3, 5));
        jPanel7.add(jPanel12);

        jPanel14.setLayout(new java.awt.GridLayout(3, 5));
        jPanel7.add(jPanel14);

        jPanel15.setLayout(new java.awt.GridLayout(3, 5));
        jPanel7.add(jPanel15);

        jPanel16.setLayout(new java.awt.GridLayout(3, 5));
        jPanel7.add(jPanel16);

        PCenter.add(jPanel7, java.awt.BorderLayout.CENTER);

        getContentPane().add(PCenter, java.awt.BorderLayout.CENTER);

        jPanel6.setLayout(new java.awt.GridLayout(4, 1));

        jButton1.setText("Joueur1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1);

        jButton2.setText("Joueur2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2);

        jButton3.setText("Joueur3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3);

        jButton4.setText("Joueur4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4);

        getContentPane().add(jPanel6, java.awt.BorderLayout.EAST);

        jMenu1.setText("Ajout");

        jMenuItem1.setText("Joueur");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Lot");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Action");

        jMenuItem3.setText("Options");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Démarrer Jeu");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Acheter Cartes");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Continuer");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Recommencer");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Galerie");

        jMenuItem8.setText("Joueurs");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Lots");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        OptionsDlg diag = new OptionsDlg(this, true, this.ca, this.nbCol, this.nbNum);
        diag.setVisible(true);
        if(diag.isOk()){
        this.nbCol = diag.getNbCol();
        this.nbNum = diag.getNbNum();
        this.option = diag.getChoix(); // Récupération des informations saisies dans la boite OptionDlg 
        if(this.option == 1)
            jLabel5.setText("Option choisie: Quine");
        else if(this.option == 2)
            jLabel5.setText("Option choisie: Double Quine");
        else if(this.option == 3)
            jLabel5.setText("Option choisie: Carton plein");
        HistoriqueTirage.append("Vous jouez avec "+this.nbCol+" colonnes et "+this.nbNum+" numéros.\n");}
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        AchatCartesDlg diagAchat = new AchatCartesDlg(this, true, lj, 3, nbCol, nbNum);
        diagAchat.setVisible(true);
        this.ca = diagAchat.getAchat();
        // Une carte a été achetée -> la variable passe à true et il est impossible de changer le nombre de colonnes ou de numéros
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AjoutJoueurDlg diagAjout = new AjoutJoueurDlg(this, true);
        diagAjout.setVisible(true);
        Joueur nj = diagAjout.getJoueur(); 
        JButton button;
        if(nbJoueurs<4 && diagAjout.getOk()) // Si il y a moins que 4 joueurs et que l'utilisateur a confirmé la saisie...
        {
            button = (JButton)jPanel6.getComponent(nbJoueurs);
            button.setText(nj.getPseudo());
            button.setBackground(nj.getCouleur());
             // ...on récupère les informations saisies pour le nouveau joueur dans la boite AjoutJoueursDlg et on ajoute les informations au jeu (sur le bouton adéquat)
            lj.ajouteJoueur(nj);
            nbJoueurs++;
        }
        else if(nbJoueurs==4 && diagAjout.getOk())
            System.out.println("Il y a déjà 4 joueurs."); // Message d'erreur
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VisuJoueurDlg visuJoueur = new VisuJoueurDlg(this, true, lj.getJoueur(0));
        visuJoueur.setVisible(true); // Ouverture d'une boite de dialogue où sont affichées les informations du joueur 1
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       VisuJoueurDlg visuJoueur = new VisuJoueurDlg(this, true, lj.getJoueur(1));
        visuJoueur.setVisible(true); // Ouverture d'une boite de dialogue où sont affichées les informations du joueur 1
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(this.nbJoueurs >=3) // Si le joueur 3 a été créé...
        {
            VisuJoueurDlg visuJoueur = new VisuJoueurDlg(this, true, lj.getJoueur(2));
            visuJoueur.setVisible(true); // ...ouverture d'une boite de dialogue où sont affichées les informations du joueur 3
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(this.nbJoueurs >=4) // Si le joueur 4 a été créé...
        {
            VisuJoueurDlg visuJoueur = new VisuJoueurDlg(this, true, lj.getJoueur(3));
            visuJoueur.setVisible(true); // ...ouverture d'une boite de dialogue où sont affichées les informations du joueur 4
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
      TrombiDlg trombi = new TrombiDlg(this, true, this.lj);
      trombi.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void TirageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TirageActionPerformed
        LesJoueurs gagnants = new LesJoueurs();
        int rnd; int random = 0;
        do
        {
            rnd = (int)(Math.random()*90+1);
        }
        while(boules[rnd-1]!=0);
        LNumero.setText(""+rnd);
        HistoriqueTirage.append("Boule tirée: "+rnd+"\n");
        boolean possede = false;
        for(int i=0; i<lj.getNbJoueur(); i++)
        {
            Joueur joueur = lj.getJoueur(i);
            for(int j=0; j<joueur.getNbCartes(); j++)
            {
                if(joueur.getCarte(j).estDans(rnd))
                {
                    possede = true;
                    joueur.getCarte(j).placePion(rnd);
                    afficheCartes();
                }
                    
            }
        }
        if(possede)
        {
            for(int i=0; i<lj.getNbJoueur(); i++)
            {
                Joueur joueur = lj.getJoueur(i);
                for(int j=0; j<joueur.getNbCartes(); j++)
                {
                    if(joueur.getCarte(j).cartonGagnant(this.option))
                    {
                        gagnants.ajouteJoueur(joueur);
                        HistoriqueTirage.append("Le joueur "+lj.getJoueur(i).getPseudo()+" a réalisé un");
                        switch(this.option)
                        {
                            case 1: {HistoriqueTirage.append(" Queen.\n");break;}
                            case 2: {HistoriqueTirage.append("e Double Queen.\n");break;}
                            case 3: {HistoriqueTirage.append(" Carton plein.\n");break;}
                        }
                    }
                        
                }
            }
        }
        if(gagnants.getNbJoueur()>1)
        {
            random = (int)(Math.random()*(gagnants.getNbJoueur()+1));
        }
        if(gagnants.getNbJoueur()!=0)
        {
            HistoriqueTirage.append("Le joueur "+gagnants.getJoueur(random).getPseudo()+" l'emporte.\n");
            gagnants.getJoueur(random).ajouteLot(lotenjeu);
            HistoriqueTirage.append("Il/elle gagne le "+lotenjeu.toString());
            switch(this.option)
            {
                case 1: {HistoriqueTirage.append("Le jeu est terminé.\n Si vous voulez continuer à jouer, appuyer sur le bouton Continuer du menu Action, afin de passer en Double Quine.\n");Tirage.setEnabled(false);jMenuItem6.setEnabled(true);jMenuItem3.setEnabled(false);break;}
                case 2: {HistoriqueTirage.append("Le jeu est terminé.\n Si vous voulez continuer à jouer, appuyer sur le bouton Continuer du menu Action, afin de passer en Carton Plein.\n");Tirage.setEnabled(false);jMenuItem6.setEnabled(true);jMenuItem3.setEnabled(false);break;}
                case 3: {HistoriqueTirage.append("Le jeu est terminé.");Tirage.setEnabled(false);jMenuItem6.setEnabled(false);break;} 
            }
        }
    }//GEN-LAST:event_TirageActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if(tousOntCarte())
        {
            Tirage.setEnabled(true);
            afficheCartes();
            this.setSize(1200,800);
            jMenuItem4.setEnabled(false);
            jMenuItem3.setEnabled(false);
            Arreter.setText("");
            setNouveauLot();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
     switch(option)
     {
         case 1: {option = 2;jLabel5.setText("Option choisie: Double Quine");Tirage.setEnabled(true);jMenuItem6.setEnabled(false);initLotsEnJeu();setNouveauLot();break;}
         case 2: {option = 3;jLabel5.setText("Option choisie: Carton Plein");Tirage.setEnabled(true);jMenuItem6.setEnabled(false);initLotsEnJeu();setNouveauLot();break;}
     }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
    HistoriqueTirage.setText("");
    Arreter.setIcon(null);
    LCadeau.setText("");
    jMenuItem1.setEnabled(true);
    jMenuItem2.setEnabled(true);
    jMenuItem5.setEnabled(true);
    jMenuItem3.setEnabled(true);
    jMenuItem4.setEnabled(true);
    this.ca = false;
    Arreter.setText("Lot à gagner");
        for(int i=0; i<lj.getNbJoueur(); i++)
            {
                Joueur joueur = lj.getJoueur(i);
                for(int j=0; j<joueur.getNbCartes(); j++)
                { 
                    joueur.getCartes().remove(j);
                } 
            }
    jPanel8.removeAll();
    jPanel9.removeAll();
    jPanel10.removeAll();
    jPanel11.removeAll();
    jPanel12.removeAll();
    jPanel14.removeAll();
    jPanel15.removeAll();
    jPanel16.removeAll();
    Tirage.setEnabled(false);
    jMenuItem6.setEnabled(false);
    LNumero.setText("");
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        AjoutLotDlg lotdiag = new AjoutLotDlg(this, true);
        lotdiag.setVisible(true);
        if(lotdiag.getOk())
        {
            Lot lot = new Lot(lotdiag.getLot().getDescription(), lotdiag.getLot().getNiveau());
            lot.setImage(lotdiag.getLot().getImage());
            this.ll.add(lot);
            initLotsEnJeu();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
    initLotsEnJeu();    
    VisuLotsDlg visulots = new VisuLotsDlg(this, true, this.llenjeu);
    visulots.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeJeuLoto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Arreter;
    private javax.swing.JTextArea HistoriqueTirage;
    private javax.swing.JLabel LCadeau;
    private javax.swing.JLabel LNumero;
    private javax.swing.JPanel PCenter;
    private javax.swing.JPanel PNord;
    private javax.swing.JPanel PSud;
    private javax.swing.JPanel PanCadeau;
    private javax.swing.JButton Tirage;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
