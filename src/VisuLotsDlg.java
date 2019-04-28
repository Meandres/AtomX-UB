
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class VisuLotsDlg extends javax.swing.JDialog {

   private ArrayList<Lot> ll;
   
    public VisuLotsDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setPreferredSize(new Dimension(700, 500));
        pack();
        initComponents();
        initPanneauCentre();
        setTitle("Visualisation des lots de la partie");
    }

    public VisuLotsDlg(java.awt.Frame parent, boolean modal, ArrayList<Lot> ll) {
       super(parent, modal);
       this.setPreferredSize(new Dimension(700, 500));
       pack();
       initComponents();
       this.ll = ll;
       initPanneauCentre();
       setTitle("Visualisation des lots de la partie");
    }

    private void initPanneauCentre()
    {
        ArrayList<Lot> listeLots = new ArrayList<Lot>();
        PCentre.removeAll();
        for(int i=0; i<this.ll.size(); i++)
        {
            if(this.ll.get(i).getImage()!=null)
                listeLots.add(this.ll.get(i));
        }
        int nbLignes = (int) (Math.floor(listeLots.size())+1)/2;
        PCentre.setLayout(new GridLayout(nbLignes, 2));
        for(int i=0; i<listeLots.size(); i++)
        {
            PanneauImage pi = new PanneauImage();
            pi.setImage(listeLots.get(i).getImage());
            PCentre.add(pi);
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
        jPanel2 = new javax.swing.JPanel();
        Fermer = new javax.swing.JButton();
        PCentre = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Photo des cadeaux à gagner");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.GridLayout());

        Fermer.setText("Fermer");
        Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FermerActionPerformed(evt);
            }
        });
        jPanel2.add(Fermer);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        PCentre.setLayout(new java.awt.GridLayout(1, 2));
        getContentPane().add(PCentre, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FermerActionPerformed
      this.setVisible(false);
      this.dispose();
    }//GEN-LAST:event_FermerActionPerformed

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
            java.util.logging.Logger.getLogger(VisuLotsDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisuLotsDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisuLotsDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisuLotsDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VisuLotsDlg dialog = new VisuLotsDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Fermer;
    private javax.swing.JPanel PCentre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
