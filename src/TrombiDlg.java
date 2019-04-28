
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class TrombiDlg extends javax.swing.JDialog {

    private LesJoueurs lj;
    
    public TrombiDlg(java.awt.Frame parent, boolean modal, LesJoueurs lj) {
        super(parent, modal);
        initComponents();
        this.lj = lj;
        this.setPreferredSize(new Dimension(800,500));
        initTrombi();
        setTitle("Trombinoscope des joueurs");
    }

   private void initTrombi()
   {
       int nb = this.lj.getNbJoueur();
       if(nb<4)
           PanPhotos.setLayout(new GridLayout(1,nb));
       else
           PanPhotos.setLayout(new GridLayout(2,2));
       for(int i=0; i<nb; i++)
       {
           PanneauImage pan = new PanneauImage(this.lj.getJoueur(i).getPhoto());
           pan.setName(""+i);
           pan.setPreferredSize(new Dimension(120,120));
           pan.addMouseListener(new MouseAdapter(){
               public void mouseClicked(MouseEvent evt){
                   AfficheInfosJoueurs(evt);}
           });
           PanPhotos.add(pan);
       }
       pack();
   }
   
   private void AfficheInfosJoueurs(MouseEvent evt)
   {
       PanneauImage pan = (PanneauImage)evt.getSource();
       int ind = Integer.parseInt(pan.getName());
       Joueur j = this.lj.getJoueur(ind);
       Edition.setForeground(j.getCouleur());
       Edition.setText(j.toString());
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        PanPhotos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Trombinoscope des Joueurs");
        jPanel2.add(jLabel1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        PanPhotos.setLayout(new java.awt.GridLayout(1, 1));
        jPanel1.add(PanPhotos);

        Edition.setColumns(20);
        Edition.setRows(5);
        Edition.setText("Cliquez sur un joueur pour connaître ses informations !");
        jScrollPane1.setViewportView(Edition);

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TrombiDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrombiDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrombiDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrombiDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TrombiDlg dialog = new TrombiDlg(new javax.swing.JFrame(), true, new LesJoueurs());
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
    private javax.swing.JTextArea Edition;
    private javax.swing.JPanel PanPhotos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
