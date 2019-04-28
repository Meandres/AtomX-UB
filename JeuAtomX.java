/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx_1_0;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author Gabriel
 */
public class JeuAtomX extends javax.swing.JFrame {

    private Joueur joueur;
    // private LesJoueurs lj;
    private Jeu lejeu;
    public Joueur getJoueur() 
    {
        return this.joueur;
    }
    
    
    
    
    public JeuAtomX() {
        initComponents();
        this.setSize(new Dimension(800,800));
        this.setPreferredSize(new Dimension(800,800));
        Historique.setText("Veuillez ajouter au moins un joueur pour commencer.");
        this.joueur = new Joueur();
        jMenuItem2.setEnabled(false);
        jMenuItem3.setEnabled(false);
    }

    private void initJeu(int taille)
    {
        int cpt=1;
        PCentre.removeAll();
        PCentre.setLayout(new GridLayout(taille+2, taille+2));
        for(int i=0; i<taille+2; i++)
        {
            for(int j=0; j<taille+2; j++)
            {
                if(i==0 || i==(taille+1) || j%(taille+1)==0)
                {
                    if((j==0&&i==0) || (j==0&&i==(taille+1)) || (j==(taille+1)&&i==0) || (j==(taille+1)&&i==(taille+1)))
                    {
                        JButton button = new JButton();
                        button.setBackground(new Color(212,208,200));
                        PCentre.add(button);
                    }
                    else
                    {
                        JButton button = new JButton();
                        button.setBackground(Color.white);
                        button.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent evt)
                            {
                                buttonActionPerformed(evt); 
                            }
                        });
                        button.setName(""+cpt);
                        cpt++;
                        PCentre.add(button);
                    } 
                }
                else
                {
                    JButton button = new JButton();
                    button.setBackground(Color.black);
                    PCentre.add(button);
                }
            }
        }
        this.lejeu = new Jeu(taille, this);
        Historique.append("\nCliquer sur une des cases blanches pour lancer votre particule.");
        pack();
    }
    
    private void buttonActionPerformed(ActionEvent evt)
    {
        JButton boutonclique = (JButton)evt.getSource();
        int nombre = Integer.parseInt(boutonclique.getName());
        if((nombre>=1 && nombre<=this.lejeu.getTaille()))
        {
            this.lejeu.tour(nombre-1, 0);
        }
        else if((nombre>=3*this.lejeu.getTaille()+1 && nombre<=Math.pow(this.lejeu.getTaille(), 2)))
        {
            this.lejeu.tour((nombre%(3*this.lejeu.getTaille()))-1, this.lejeu.getTaille()-1);
        }
        
        /*else if((nombre%(this.lejeu.getTaille()))%2!=0)
        {
            System.out.println((int)(nombre%this.lejeu.getTaille())+"eeeeeraeraerarea");
            int temp;
            if((int) (nombre%this.lejeu.getTaille())==1)
            {
                System.out.println((int) (nombre%this.lejeu.getTaille())+"eeee");
                this.lejeu.tour(0, (int) (nombre%this.lejeu.getTaille()));
                
            }
            else
            {
                temp = nombre%this.lejeu.getTaille()-2;
                this.lejeu.tour(temp, 0);
            }
            
        }*/
        else if((nombre%2==0 && this.lejeu.getTaille()%2!=0) || (nombre%2!=0 && this.lejeu.getTaille()%2==0))
        {
            if(nombre%this.lejeu.getTaille()==1)
               this.lejeu.tour(0, nombre%this.lejeu.getTaille()-1);
            else if(nombre%this.lejeu.getTaille()==3)
                this.lejeu.tour(0, nombre%this.lejeu.getTaille()-2);
            else if(nombre%this.lejeu.getTaille()==0)
                this.lejeu.tour(0, nombre%this.lejeu.getTaille()+2);
            else if(nombre%this.lejeu.getTaille()==2)
                this.lejeu.tour(0, nombre%this.lejeu.getTaille()+1);
            else if(nombre%this.lejeu.getTaille()==4)
                this.lejeu.tour(0, nombre%this.lejeu.getTaille());
        }
        else
        {
            if(nombre%this.lejeu.getTaille()==1)
               this.lejeu.tour(this.lejeu.getTaille()-1, nombre%this.lejeu.getTaille()+2);
            else if(nombre%this.lejeu.getTaille()==3)
                this.lejeu.tour(this.lejeu.getTaille()-1, nombre%this.lejeu.getTaille()+1);
            else if(nombre%this.lejeu.getTaille()==0)
                this.lejeu.tour(this.lejeu.getTaille()-1, nombre%this.lejeu.getTaille());
            else if(nombre%this.lejeu.getTaille()==2)
                this.lejeu.tour(this.lejeu.getTaille()-1, nombre%this.lejeu.getTaille()-1);
            else if(nombre%this.lejeu.getTaille()==4)
                this.lejeu.tour(this.lejeu.getTaille()-1, nombre%this.lejeu.getTaille()-2);
        }
    }
    
   /* Jeu j=new Jeu(10);
        do{
            j.tour();
        }while(!j.isFini());*/
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PCentre = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Historique = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("AtomX");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        PCentre.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(PCentre, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(1, 1));

        Historique.setColumns(20);
        Historique.setRows(5);
        jScrollPane2.setViewportView(Historique);

        jPanel2.add(jScrollPane2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jMenu1.setText("Jeu");

        jMenuItem1.setText("Commencer");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Options");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Arrêter");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      AjoutJoueurDlg diag = new AjoutJoueurDlg(this, true);
      diag.setVisible(true);
      if(diag.getOk())
      {
          this.joueur.setPseudo(diag.getJoueur().getPseudo());
          this.joueur.setSolde(diag.getJoueur().getSolde());
          Historique.setText("");
          Historique.append("Votre pseudo est "+this.joueur.getPseudo()+", et votre solde est de "+this.joueur.getSolde()+"€.");
          jMenuItem2.setEnabled(true);
          jMenuItem3.setEnabled(true);
          jMenuItem1.setEnabled(false);
      }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
     jMenuItem1.setEnabled(true);
     jMenuItem2.setEnabled(false);
     jMenuItem3.setEnabled(false);
     PCentre.removeAll();
     Historique.setText("Veuillez ajouter au moins un joueur pour commencer.");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      OptionsDlg optiondiag = new OptionsDlg(this, true);
      optiondiag.setVisible(true);
      if(optiondiag.isOk())
      {
          jMenuItem2.setEnabled(false);
          this.lejeu = new Jeu(optiondiag.getTaille(), this);
          initJeu(optiondiag.getTaille());
      }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(JeuAtomX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JeuAtomX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JeuAtomX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JeuAtomX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JeuAtomX().setVisible(true);
            }
        });
    }

    public javax.swing.JTextArea Historique;
    private javax.swing.JPanel PCentre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    /*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Historique;
    private javax.swing.JPanel PCentre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
*/
}
