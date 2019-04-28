
import java.awt.*;
import javax.swing.*;
import java.lang.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gb346159
 */
public class AchatCartesDlg extends javax.swing.JDialog {
    //attributs
    private LesJoueurs ljc; // Variable de type LesJoueurs qui est notre liste de joueurs
    private int nbCol, nbLig, nbNum; // Varibles qui vont contenir le nombre de colonnes, de lignes, et de numéros de nos cartes en fonction du choix de l'utilisateur dans l'application principale
    private Joueur jc; // Attribut de joueur "courant", celui sélectionné dans la liste des joueurs
    private CarteLoto cc; // Attribut de carte "courante", celle générée par l'application
    private boolean achat; // Variable booléenne qui devient true lorsqu'un achat est effectué
    
    public AchatCartesDlg(java.awt.Frame parent, boolean modal, LesJoueurs ljc, int nbLig, int nbCol, int nbNum) {
        super(parent, modal);
        initComponents();
        this.setSize(500,500);
        this.ljc = ljc;
        this.nbCol = nbCol;
        this.nbLig = nbLig;
        this.nbNum = nbNum;
        this.achat = false;
        this.jc = ljc.getJoueur(0);
        this.cc = new CarteLoto(this.nbCol, this.nbNum);
        remplirListeJoueurs();
        Message.setText(""+this.jc.getPseudo()+" dispose de "+this.jc.getSolde()+"€");
        initCarte();
        afficheCarte();
        setTitle("Achat d'une ou plusieurs cartes");
    }

    public boolean getAchat()
    {
        return this.achat;
    }
    private void remplirListeJoueurs()
    {
        ListeJoueurs.removeAllItems();
        for(int i=0; i<this.ljc.getNbJoueur(); i++)
            ListeJoueurs.addItem(""+this.ljc.getJoueur(i).getPseudo());
    }
    private void initCarte()
    {
        Panneau.setLayout(new GridLayout(this.nbLig, this.nbCol));
        for(int i=0; i<this.nbLig*this.nbCol; i++)
        {
            JButton button = new JButton();
            Panneau.add(button);
        }
    }
    private void afficheCarte()
    {
        this.cc.initValeursCarte();
        int k=0;
        for(int i=0; i<this.nbLig;i++)
        {
            for(int j=0; j<this.nbCol; j++)
            {
                JButton b = (JButton)Panneau.getComponent(k);
                b.setText(""+this.cc.getVal(i,j));
                k++;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Panneau = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Message = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ListeJoueurs = new javax.swing.JComboBox<>();
        AutreChoix = new javax.swing.JButton();
        Acheter = new javax.swing.JButton();
        Quitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Acheter une ou plusieurs cartes");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        Panneau.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jPanel3.add(Message);

        jPanel2.add(jPanel3);

        jPanel4.setLayout(new java.awt.GridLayout(1, 4));

        ListeJoueurs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ListeJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeJoueursActionPerformed(evt);
            }
        });
        jPanel4.add(ListeJoueurs);

        AutreChoix.setText("Autre Choix");
        AutreChoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutreChoixActionPerformed(evt);
            }
        });
        jPanel4.add(AutreChoix);

        Acheter.setText("Acheter");
        Acheter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcheterActionPerformed(evt);
            }
        });
        jPanel4.add(Acheter);

        Quitter.setText("Quitter");
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });
        jPanel4.add(Quitter);

        jPanel2.add(jPanel4);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AutreChoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutreChoixActionPerformed
      Panneau.removeAll();
      initCarte();
      afficheCarte();
      
    }//GEN-LAST:event_AutreChoixActionPerformed

    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
       this.setVisible(false);
       this.dispose();
    }//GEN-LAST:event_QuitterActionPerformed

    private void AcheterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcheterActionPerformed
       if(this.jc.acheter(cc))
        {
            this.jc.setSolde(this.jc.getSolde()-this.cc.getPrix());
            Message.setText(""+this.jc.getPseudo()+" dispose de "+this.jc.getSolde()+"€");
            this.achat=true;
            this.jc.ajouteCarte(cc);
            this.setVisible(false);
            this.dispose();
        }
        else
            System.out.println("Le solde du joueur est insuffisant, ou alors il possède "+this.jc.getNbCartes()+" cartes.");
    }//GEN-LAST:event_AcheterActionPerformed

    private void ListeJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeJoueursActionPerformed
        if(ListeJoueurs.getSelectedIndex()!=-1)
        {
            this.jc = this.ljc.getJoueur(ListeJoueurs.getSelectedIndex());
            Message.setText(""+this.jc.getPseudo()+" dispose de "+this.jc.getSolde()+"€");
        }
    }//GEN-LAST:event_ListeJoueursActionPerformed

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
            java.util.logging.Logger.getLogger(AchatCartesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AchatCartesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AchatCartesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AchatCartesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LesJoueurs lj = new LesJoueurs();
                int a=0,b=0,c=0;
                AchatCartesDlg dialog = new AchatCartesDlg(new javax.swing.JFrame(), true, lj, a, b, c);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acheter;
    private javax.swing.JButton AutreChoix;
    private javax.swing.JComboBox<String> ListeJoueurs;
    private javax.swing.JLabel Message;
    private javax.swing.JPanel Panneau;
    private javax.swing.JButton Quitter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
