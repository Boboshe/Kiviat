/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiviat.rp.tb;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Boris
 */
public class FenetreTest extends javax.swing.JFrame {

    private DefaultTableModel myTableModel;
    private Vector columnName = new Vector();
    //Ligne entrée en dur
    private final Line lign1 = new Line("axe1", 2, 1, 10);
    private final Line lign2 = new Line("axe2", 7, 5, 10);
    private final Line lign3 = new Line("axe3", 5, 0, 5);

    private ArrayList<Line> rows = new ArrayList<>();

    private String axeName;
    private double axeValue;
    private double axeMin;
    private double axeMax;

//    private int codeErrVerif = -1;
    private final int errMinMax = 0;
    private final int errNameExisting = 1;
    private final int errValue = 2;

    private String msgErreurToSend = "";

    /**
     * Creates new form NewJFrame
     */
    public FenetreTest() {
        initComponents();
        setTitle("Fenetre Test Kiviat");
        msgErreur.setForeground(Color.red);

        columnName.add("Name");
        columnName.add("Value");
        columnName.add("Minimum");
        columnName.add("Maximum");

        myTableModel = new DefaultTableModel(columnName, 0);
        myTableModel.addTableModelListener(kiviat1);

        myTableModel.addRow(lign1.getVector());
        myTableModel.addRow(lign2.getVector());
        myTableModel.addRow(lign3.getVector());

        //rows.add(lign1);
        //rows.add(lign2);
        //rows.add(lign3);

        jTable1.setModel(myTableModel);
        kiviat1.setModel(myTableModel);

//        int i = 1;
//        for (Line item : rows) {
//            System.out.println("[ELEM_" + (i++) + "]");
//            System.out.println("item name:" + item.getName());
//            System.out.println("item value:" + item.getValue());
//            System.out.println("item min:" + item.getMin());
//            System.out.println("item max:" + item.getMax());
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        kiviat1 = new kiviat.rp.tb.Kiviat();
        jPanel1 = new javax.swing.JPanel();
        axeNameField = new javax.swing.JTextField();
        axeValueField = new javax.swing.JTextField();
        axeMinField = new javax.swing.JTextField();
        axeMaxField = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        msgErreur = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout kiviat1Layout = new javax.swing.GroupLayout(kiviat1);
        kiviat1.setLayout(kiviat1Layout);
        kiviat1Layout.setHorizontalGroup(
            kiviat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        kiviat1Layout.setVerticalGroup(
            kiviat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        axeNameField.setText("row0");

        axeValueField.setText("0");

        axeMinField.setText("0");

        axeMaxField.setText("0");

        addBtn.setText("Add Row");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(axeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(axeValueField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(axeMinField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(axeMaxField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(msgErreur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(axeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(axeValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(axeMinField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(axeMaxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msgErreur, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kiviat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kiviat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* --- Boutons ---*/
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        axeName = axeNameField.getText();

        axeValue = Double.parseDouble(axeValueField.getText());
        axeMin = Double.parseDouble(axeMinField.getText());
        axeMax = Double.parseDouble(axeMaxField.getText());

        Line lign = new Line(axeName, axeValue, axeMin, axeMax);
        msgErreur.setText("");
        initMsgErreur();

        //Si la ligne est ok => on ajoute la ligne
        if (verifyRow(lign)) {
            rows.add(lign);
            myTableModel.addRow(lign.getVector());
            jTable1.setModel(myTableModel);
            //kiviat1.setModel(myTableModel);
            //msgErreur.setText(msgErreurToSend);
            this.validate();
        } 
        else { //Sinon on send le message d'erreur
            //On reinitialise le message d'erreur a envoyer
            msgErreur.setText(msgErreurToSend);
            //repaint();
        }

    }//GEN-LAST:event_addBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FenetreTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField axeMaxField;
    private javax.swing.JTextField axeMinField;
    private javax.swing.JTextField axeNameField;
    private javax.swing.JTextField axeValueField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private kiviat.rp.tb.Kiviat kiviat1;
    private javax.swing.JLabel msgErreur;
    // End of variables declaration//GEN-END:variables

    private boolean verifyRow(Line lign) {
//        System.out.println("[Lign] axeName: " + lign.getName() + ", axeValue: " + lign.getValue() + ", axeMin: " + lign.getMin() + ", axeMax: " + lign.getMax());

        //Les vérifications s'effectuent par l'inverse
        //On initialise verif à true
        boolean verif = true;

        //Vérifie que min < Max.
        //Si ce n'est pas le cas, min > Max, donc on passe verif à false
        if (lign.getMin() > lign.getMax()) {
            verif = false;
//            codeErrVerif = errMinMax;
            constituerMsgErreur(errMinMax);
        }

        if (lign.getValue() < lign.getMin() || lign.getValue() > lign.getMax()) //Vérifie que la valeur est comprise entre min et Max.
        //Si ce n'est pas le cas, (lign.getName() < lign.getMin()) [OU] (lign.getName() > lign.getMax()),
        //alors on passe verif à false
        {
//            System.out.println("lign value:" + lign.getValue());
//            System.out.println("lign min:" + lign.getMin());
//            System.out.println("lign max:" + lign.getMax());
            verif = false;
//            codeErrVerif = errValue;
            constituerMsgErreur(errValue);
        }

        //Vérifie que le nom saisie, n'existe pas déjà.
        //Si ce n'est pas le cas, lign.getName() = item.getName() = un nom existe déjà,
        //alors on passe verif à false
        for (Line item : rows) {
            if (item.getName().equals(lign.getName())) {
                verif = false;
//                codeErrVerif = errNameExisting;
                constituerMsgErreur(errNameExisting);
            }
        }

        terminateMsg();

        //Cas par défaut = true
        //Sinon une des conditions n'est pas respectées = false
        return verif;
    }

    private void initMsgErreur() {
        //reinstancie le message d'erreur à afficher
        msgErreurToSend = "<html> *[ERREUR] ";
    }

    private void constituerMsgErreur(int codeErrVerif) {

        switch (codeErrVerif) {
            case errMinMax:
                msgErreurToSend += "<br>La valeur du min doit être inférieure à celle du max.";
                break;
            case errNameExisting:
                msgErreurToSend += "<br>Le nom saisie existe déjà.";
                break;
            case errValue:
                msgErreurToSend += "<br>La valeur doit être comprise entre min et max.";
                break;
        }
        System.out.println("" + msgErreurToSend);
    }

    private void terminateMsg() {
        msgErreurToSend += "</html>";
    }

}
