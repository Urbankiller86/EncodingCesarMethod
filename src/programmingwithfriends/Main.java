package programmingwithfriends;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {
    JFileChooser choose=new JFileChooser();
    File file;
    FileInputStream input;
    FileOutputStream output;
    String textFile="";
    public Main() {
        initComponents();
    }

    public String openFile(){
        String document="";
        try{    
            input=new FileInputStream(file);
            int ascci;
            while((ascci=input.read())!=-1){
                char caracter=(char)ascci;
                document+=caracter;
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error...");
        }return document;
    }
    
    public void open(){
        if(choose.showDialog(null, "Choose")==JFileChooser.APPROVE_OPTION){
            file=choose.getSelectedFile();
            if(file.canRead()){
                if(file.getName().endsWith(".txt")){
                    textFile=openFile();
                    this.jLabel2.setText(choose.getSelectedFile().getAbsolutePath());
                }else{
                    JOptionPane.showMessageDialog(null, "Not a text file");
                }
            }
        }
    }
    
    public String decode(){
        String newText="";
        Arrays arr=new Arrays();
        textFile=openFile().toUpperCase();
        for (int i = 0; i < textFile.length(); i++) {
            newText+=arr.getDecoded(textFile.charAt(i));
        }return newText;
    }
    
    public String encode(){
        String newText="";
        Arrays arr=new Arrays();
        textFile=textFile.toUpperCase();
        for (int i = 0; i < textFile.length(); i++) {
            newText+=arr.getEncode(textFile.charAt(i));
        }return newText;
    }
    public String saveFile(String documento){
        String mensaje=null;
        try{
            output=new FileOutputStream(file);
            byte[]bytxt=documento.getBytes();
            output.write(bytxt);
            mensaje="Saved";
            
        }catch(Exception e){
            mensaje="Error...";
        }return mensaje;
    }
    
    public void save(String newText){
        if(choose.showDialog(null,"Guardar")==JFileChooser.APPROVE_OPTION){
            file=choose.getSelectedFile();
            if(file.getName().endsWith("txt")){
                String mensaje=saveFile(newText);
                if(mensaje!=null){
                    JOptionPane.showMessageDialog(null,mensaje);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"No compatible");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Save as text file");
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Select .txt file");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Current PATH:");

        jLabel2.setText("                                                                    ");

        jButton2.setText("Encode");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Decode");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        save(encode());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        open();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        save(decode());
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
