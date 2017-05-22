/*
INSTALL
Choose your binary build - x64 or x86 (based on which version of
the JVM you are installing to)

NOTE: You MUST match your architecture.  You can't install the i386
version on a 64-bit version of the JDK and vice-versa.

For a JDK installation:

Copy RXTXcomm.jar ---> <JAVA_HOME>\jre\lib\ext
Copy rxtxSerial.dll ---> <JAVA_HOME>\jre\bin
Copy rxtxParallel.dll ---> <JAVA_HOME>\jre\bin
 */
package charts;

import Arduino.Arduino;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Window extends javax.swing.JFrame {

    Arduino Arduino = new Arduino();
    SerialPortEventListener evento = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            if (Arduino.MessageAvailable() == true) {
                String data = Arduino.PrintMessage();
                String[] data_separada = data.split(";");
                //Obtiendo valores
                int planta1 = Integer.parseInt(data_separada[0]);
                jLabelPlanta1.setText(planta1 + "%");
                int planta2 = Integer.parseInt(data_separada[1]);
                jLabelPlanta2.setText(planta2 + "%");
                int planta3 = Integer.parseInt(data_separada[2]);
                jLabelPlanta3.setText(planta3 + "%");
                int planta4 = Integer.parseInt(data_separada[3]);
                jLabelPlanta4.setText(planta4 + "%");
                
                //Alerta en planta 1
                if(planta1 < 10){
                    jLabelPlanta1.setForeground(Color.red);
                }else if(planta1 > 90){
                    jLabelPlanta1.setForeground(Color.red);
                }else{
                    jLabelPlanta1.setForeground(Color.black);
                }
                //Alerta en planta 2
                if(planta2 < 10){
                    jLabelPlanta2.setForeground(Color.red);
                }else if(planta2 > 90){
                    jLabelPlanta2.setForeground(Color.red);
                }else{
                    jLabelPlanta2.setForeground(Color.black);
                }
                //Alerta en planta 3
                if(planta3 < 10){
                    jLabelPlanta3.setForeground(Color.red);
                }else if(planta3 > 90){
                    jLabelPlanta3.setForeground(Color.red);
                }else{
                    jLabelPlanta3.setForeground(Color.black);
                }
                //Alerta en planta 4
                if(planta4 < 10){
                    jLabelPlanta4.setForeground(Color.red);
                }else if(planta4 > 90){
                    jLabelPlanta4.setForeground(Color.red);
                }else{
                    jLabelPlanta4.setForeground(Color.black);
                }
            }
        }
    };

    public Window() {
        initComponents();
        try {
            Arduino.ArduinoRX("COM3", 2000, 9600, evento);
        } catch (Exception e) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, e);
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

        jLabelPlanta1 = new javax.swing.JLabel();
        jLabelPlanta2 = new javax.swing.JLabel();
        jLabelPlanta3 = new javax.swing.JLabel();
        jLabelPlanta4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Humedad en plantas");

        jLabelPlanta1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPlanta1.setText("##%");

        jLabelPlanta2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPlanta2.setText("##%");

        jLabelPlanta3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPlanta3.setText("##%");

        jLabelPlanta4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPlanta4.setText("##%");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Planta 1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Planta 2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Planta 3");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Planta 4");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel5.setText("Humedad en plantas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabelPlanta1)
                            .addComponent(jLabel3))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabelPlanta2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPlanta3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelPlanta4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPlanta1)
                    .addComponent(jLabelPlanta2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPlanta3)
                    .addComponent(jLabelPlanta4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelPlanta1;
    private javax.swing.JLabel jLabelPlanta2;
    private javax.swing.JLabel jLabelPlanta3;
    private javax.swing.JLabel jLabelPlanta4;
    // End of variables declaration//GEN-END:variables
}
