//GLScopeMac.java
//GUI For Oscilloscope Functions


//Based on (GPL) Java OpenGL examples from
//http://plugins.netbeans.org/PluginPortal/faces/PluginDetailPage.jsp?pluginid=3260


//This program is free software; you can redistribute it and/or
//modify it under the terms of the GNU General Public License as
//published by the Free Software Foundation; either version 3 of the
//License, or (at your option) any later version.
//
//This program is distributed in the hope that it will be useful, but
//WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//General Public License for more details:
//http://www.gnu.org/licenses/gpl.txt

//Copyright 2009 Brian Satzinger


package scopeduino.display;

import com.sun.opengl.util.Animator;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import serial.ScopeDAQ;

/**
 *
 * @author cylab
 * @author mbien
 */
public class GLScopeMac extends JFrame {

    static {
        // When using a GLCanvas, we have to set the Popup-Menues to be HeavyWeight,
        // so they display properly on top of the GLCanvas
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
    }
    
    private Animator animator;
    GLRenderer rend;
    Refresher r;

    int oldx = -1;
    int oldy = -1;

    /** Creates new form MainFrame */
    public GLScopeMac() {
        initComponents();
        setTitle("Scopeduino");

        rend = new GLRenderer();

        canvas.addGLEventListener(rend);
        animator = new Animator(canvas);

        // This is a workaround for the GLCanvas not adjusting its size, when the frame is resized.
        canvas.setMinimumSize(new Dimension());         
        
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
    }

    @Override
    public void setVisible(boolean show){
        if(!show)
            animator.stop();
        super.setVisible(show);
        if(!show)
            animator.start();

        
        r = new Refresher(canvas);
        r.start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas = new GLCanvas(createGLCapabilites());
        jSlider1 = new JSlider();
        jLabel1 = new JLabel();
        jSlider2 = new JSlider();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jSlider3 = new JSlider();
        jSlider4 = new JSlider();
        jSlider5 = new JSlider();
        jSlider6 = new JSlider();
        jSlider7 = new JSlider();
        jCheckBox1 = new JCheckBox();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        canvas.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent evt) {
                canvasMouseWheelMoved(evt);
            }
        });
        canvas.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
                canvasMouseReleased(evt);
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                canvasMouseDragged(evt);
            }
        });

        jSlider1.setMaximum(200);
        jSlider1.setName("Time To Live"); // NOI18N
        jSlider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jSlider1.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                jSlider1PropertyChange(evt);
            }
        });

        jLabel1.setText("Time To Live:");

        jSlider2.setValue(0);
        jSlider2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });

        jLabel2.setText("Background:");

        jLabel3.setText("Transform");

        jSlider3.setMaximum(360);
        jSlider3.setValue(0);
        jSlider3.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                jSlider3StateChanged(evt);
            }
        });

        jSlider4.setMaximum(360);
        jSlider4.setValue(0);
        jSlider4.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                jSlider4StateChanged(evt);
            }
        });

        jSlider5.setMaximum(360);
        jSlider5.setValue(0);
        jSlider5.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                jSlider5StateChanged(evt);
            }
        });

        jSlider7.setMinimum(-100);
        jSlider7.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                jSlider7StateChanged(evt);
            }
        });

        jCheckBox1.setText("Hard First Trace");
        jCheckBox1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canvas, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(jSlider5, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jSlider4, 0, 173, Short.MAX_VALUE)
                        .addComponent(jSlider2, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addComponent(jSlider1, 0, 173, Short.MAX_VALUE)
                        .addComponent(jSlider3, 0, 173, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jSlider6, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSlider7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jCheckBox1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(canvas, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jSlider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jSlider2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(jSlider3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jSlider4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jSlider5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(jSlider7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSlider6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

            rend.rotate = !rend.rotate;


    }//GEN-LAST:event_formMouseClicked

    private void jSlider1PropertyChange(PropertyChangeEvent evt) {//GEN-FIRST:event_jSlider1PropertyChange
        // TODO add your handling code here:

        

        //
    }//GEN-LAST:event_jSlider1PropertyChange

    private void jSlider1StateChanged(ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        System.out.println(jSlider1.getValue());
        Trace.TTL = jSlider1.getValue();
    }//GEN-LAST:event_jSlider1StateChanged

    private void jSlider2StateChanged(ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        // TODO add your handling code here:
        float c = (float) jSlider2.getValue() / (float) jSlider2.getMaximum();

        ScopeSettings.backr = c;
        ScopeSettings.backg = c;
        ScopeSettings.backb = c;
    }//GEN-LAST:event_jSlider2StateChanged

    private void jSlider3StateChanged(ChangeEvent evt) {//GEN-FIRST:event_jSlider3StateChanged
        rend.xangle = jSlider3.getValue();
    }//GEN-LAST:event_jSlider3StateChanged

    private void jSlider4StateChanged(ChangeEvent evt) {//GEN-FIRST:event_jSlider4StateChanged
        // TODO add your handling code here:
        rend.yangle = jSlider4.getValue();
    }//GEN-LAST:event_jSlider4StateChanged

    private void jSlider5StateChanged(ChangeEvent evt) {//GEN-FIRST:event_jSlider5StateChanged
        // TODO add your handling code here:
        rend.zangle = jSlider5.getValue();
    }//GEN-LAST:event_jSlider5StateChanged

    private void jSlider7StateChanged(ChangeEvent evt) {//GEN-FIRST:event_jSlider7StateChanged
        ScopeSettings.amp = jSlider7.getValue() / 100.0f;
    }//GEN-LAST:event_jSlider7StateChanged

    private void jCheckBox1StateChanged(ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        ScopeSettings.hardFirstTrace = jCheckBox1.isSelected();
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void canvasMouseDragged(MouseEvent evt) {//GEN-FIRST:event_canvasMouseDragged
        // TODO add your handling code here:
        if ((oldx == -1) || (oldy == -1))
        {
            oldx = evt.getX();
            oldy = evt.getY();
            return;
        }

        int dx = evt.getX() - oldx;
        int dy = oldy - evt.getY();


        oldx = evt.getX();
        oldy = evt.getY();

        rend.translate(dx, dy, 0);
    }//GEN-LAST:event_canvasMouseDragged

    private void canvasMouseReleased(MouseEvent evt) {//GEN-FIRST:event_canvasMouseReleased
        //Mouse drag ended
        oldx = -1;
        oldy = -1;
    }//GEN-LAST:event_canvasMouseReleased

    private void canvasMouseWheelMoved(MouseWheelEvent evt) {//GEN-FIRST:event_canvasMouseWheelMoved
        int dz =  -1 * evt.getWheelRotation();

        rend.translate(0, 0, dz);
    }//GEN-LAST:event_canvasMouseWheelMoved

    /**
     * Called from within initComponents().
     * hint: to customize the generated code choose 'Customize Code' in the contextmenu
     * of the selected UI Component you wish to cutomize in design mode.
     * @return Returns customized GLCapabilities.
     */
    private GLCapabilities createGLCapabilites() {
        
        GLCapabilities capabilities = new GLCapabilities();
        capabilities.setHardwareAccelerated(true);

        // try to enable 2x anti aliasing - should be supported on most hardware
        capabilities.setNumSamples(2);
        capabilities.setSampleBuffers(true);
        
        return capabilities;
    }
    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        // Run this in the AWT event thread to prevent deadlocks and race conditions
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                // switch to system l&f for native font rendering etc.
                try{
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }catch(Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.INFO, "can not enable system look and feel", ex);
                }

                GLScopeMac frame = new GLScopeMac();
                frame.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GLCanvas canvas;
    private JCheckBox jCheckBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JSlider jSlider1;
    private JSlider jSlider2;
    private JSlider jSlider3;
    private JSlider jSlider4;
    private JSlider jSlider5;
    private JSlider jSlider6;
    private JSlider jSlider7;
    // End of variables declaration//GEN-END:variables

}
