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
import javax.swing.*;

public class AjoutJoueurDlg extends javax.swing.JDialog {
    // Attributs
    private Joueur nj;
    private boolean ok;
    BoutonImage bi;
    
    public AjoutJoueurDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal); // Appel du constructeur de la super classe
        initComponents();
        bi = new BoutonImage();
        jPanel4.add(bi);
        bi.setName("Photo");
        this.setSize(500,500);
        this.nj = new Joueur(); // Création d'une instance de nouveau joueur "par défaut"
        this.ok = false; // Indique l'état de la fenêtre
        Image ic = new ImageIcon(getClass().getResource("/joueurDefaut.png")).getImage();
        bi.setImage(ic);
        BPhoto.setText("Parcourir");
        setTitle("Ajout d'un joueur");
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
        Annuler = new javax.swing.JButton();
        Valider = new javax.swing.JButton();
        Panneau = new javax.swing.JPanel();
        LPseudo = new javax.swing.JLabel();
        Pseudo = new javax.swing.JTextField();
        LSolde = new javax.swing.JLabel();
        Solde = new javax.swing.JTextField();
        LCouleur = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BCouleur = new javax.swing.JButton();
        PanCouleur = new javax.swing.JPanel();
        LPhoto = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        BPhoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel1.add(Annuler);

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        jPanel1.add(Valider);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        Panneau.setLayout(new java.awt.GridLayout(4, 2));

        LPseudo.setText("Pseudo ?");
        Panneau.add(LPseudo);
        Panneau.add(Pseudo);

        LSolde.setText("Solde ?");
        Panneau.add(LSolde);
        Panneau.add(Solde);

        LCouleur.setText("Couleur préférée ?");
        Panneau.add(LCouleur);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        BCouleur.setText("Choisi !");
        BCouleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCouleurActionPerformed(evt);
            }
        });
        jPanel2.add(BCouleur);

        PanCouleur.setLayout(new java.awt.GridLayout(1, 1));
        jPanel2.add(PanCouleur);

        Panneau.add(jPanel2);

        LPhoto.setText("Photo ?");
        Panneau.add(LPhoto);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        BPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPhotoActionPerformed(evt);
            }
        });
        jPanel4.add(BPhoto);

        Panneau.add(jPanel4);

        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BCouleurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCouleurActionPerformed
      JColorChooser diag = new JColorChooser();
      Color coul = diag.showDialog(this, "COuleur", Color.red);
      if(coul!= null) // si une couleur a été choisie...
      {
          this.nj.setCouleur(coul);
          PanCouleur.setBackground(coul); // ..on l'affecte au joueur et on colorie le JPanel PanCouleur
      }
    }//GEN-LAST:event_BCouleurActionPerformed

    public boolean getOk()
    {
        return this.ok;
    }
    
    public Joueur getJoueur()
    {
        return this.nj;
    }
    
    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
       this.nj.setPseudo(Pseudo.getText());
       this.nj.setSolde(Double.parseDouble(Solde.getText())); 
        this.nj.setPhoto(bi.getImage()); // Récupère les informations saisies
       this.ok=true; 
       //fermeture de la fenêtre
       this.setVisible(false);
       this.dispose();
    }//GEN-LAST:event_ValiderActionPerformed

    private void BPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPhotoActionPerformed
    JFileChooser choix = new JFileChooser();
    choix.showOpenDialog(this);
    String path=choix.getSelectedFile().getAbsolutePath();
    bi.setImage(new ImageIcon(path).getImage());
    }//GEN-LAST:event_BPhotoActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
       this.setVisible(false);
       this.dispose();
    }//GEN-LAST:event_AnnulerActionPerformed

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
            java.util.logging.Logger.getLogger(AjoutJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AjoutJoueurDlg dialog = new AjoutJoueurDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Annuler;
    private javax.swing.JButton BCouleur;
    private javax.swing.JButton BPhoto;
    private javax.swing.JLabel LCouleur;
    private javax.swing.JLabel LPhoto;
    private javax.swing.JLabel LPseudo;
    private javax.swing.JLabel LSolde;
    private javax.swing.JPanel PanCouleur;
    private javax.swing.JPanel Panneau;
    private javax.swing.JTextField Pseudo;
    private javax.swing.JTextField Solde;
    private javax.swing.JButton Valider;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
