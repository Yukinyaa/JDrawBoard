/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawboard;

import java.awt.Color;
import java.awt.event.ItemEvent;

/**
 *
 * @author User
 */
public class DrawingPanel extends javax.swing.JPanel {

    /**
     * Creates new form Right
     */
    public DrawingPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftBarPanel = new javax.swing.JPanel();
        SpoidButton = new javax.swing.JButton();
        ModeSelectToggleButton = new javax.swing.JToggleButton();
        RectangleButton = new javax.swing.JButton();
        TriangleButton = new javax.swing.JButton();
        CircleButton = new javax.swing.JButton();
        OctagonButton = new javax.swing.JButton();
        ColorButton = new javax.swing.JButton();
        bottomPanel = new javax.swing.JPanel();
        imagePanel = new javax.swing.JPanel();
        loadImageButton = new javax.swing.JButton();
        opacitySlider = new javax.swing.JSlider();
        saveAsButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        drawCanvas1 = new drawboard.DrawCanvas();

        SpoidButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drawboard/spoid_icon.png"))); // NOI18N
        SpoidButton.setFocusable(false);
        SpoidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpoidButtonActionPerformed(evt);
            }
        });

        ModeSelectToggleButton.setText("R");
        ModeSelectToggleButton.setFocusable(false);
        ModeSelectToggleButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ModeSelectToggleButtonItemStateChanged(evt);
            }
        });

        RectangleButton.setText("Rectangle");
        RectangleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RectangleButtonMouseClicked(evt);
            }
        });

        TriangleButton.setText("Triangle");

        CircleButton.setText("Circle");

        OctagonButton.setText("Octagon");
        OctagonButton.setToolTipText("");

        ColorButton.setBackground(new java.awt.Color(255, 255, 255));
        ColorButton.setText("color");
        ColorButton.setFocusable(false);

        javax.swing.GroupLayout leftBarPanelLayout = new javax.swing.GroupLayout(leftBarPanel);
        leftBarPanel.setLayout(leftBarPanelLayout);
        leftBarPanelLayout.setHorizontalGroup(
            leftBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftBarPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(leftBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CircleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RectangleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OctagonButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TriangleButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, leftBarPanelLayout.createSequentialGroup()
                        .addComponent(ColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SpoidButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
            .addComponent(ModeSelectToggleButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftBarPanelLayout.setVerticalGroup(
            leftBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RectangleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TriangleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CircleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OctagonButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ColorButton)
                    .addComponent(SpoidButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ModeSelectToggleButton)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        bottomPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        imagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        imagePanel.setMaximumSize(new java.awt.Dimension(310, 50));
        imagePanel.setMinimumSize(new java.awt.Dimension(310, 50));

        loadImageButton.setText("Load Image");
        loadImageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadImageButtonMouseClicked(evt);
            }
        });
        loadImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadImageButtonActionPerformed(evt);
            }
        });

        opacitySlider.setValue(100);

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelLayout.createSequentialGroup()
                .addComponent(loadImageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opacitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(opacitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadImageButton))
                .addContainerGap())
        );

        saveAsButton.setText("Save As");
        saveAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveAsButton)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveAsButton)
                        .addComponent(saveButton))
                    .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout drawCanvas1Layout = new javax.swing.GroupLayout(drawCanvas1);
        drawCanvas1.setLayout(drawCanvas1Layout);
        drawCanvas1Layout.setHorizontalGroup(
            drawCanvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        drawCanvas1Layout.setVerticalGroup(
            drawCanvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leftBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(drawCanvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leftBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 325, Short.MAX_VALUE))
                    .addComponent(drawCanvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SpoidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpoidButtonActionPerformed
        
    }//GEN-LAST:event_SpoidButtonActionPerformed

    private void loadImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadImageButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadImageButtonActionPerformed

    private void loadImageButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadImageButtonMouseClicked
        
    }//GEN-LAST:event_loadImageButtonMouseClicked

    private void saveAsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveAsButtonActionPerformed

    private void RectangleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RectangleButtonMouseClicked
        if(evt.getButton() != 1)
            return;
        drawCanvas1.c.NewShape(new SRectangle(drawCanvas1.s));
    }//GEN-LAST:event_RectangleButtonMouseClicked

    private void ModeSelectToggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ModeSelectToggleButtonItemStateChanged
        drawCanvas1.init();
        
        if(evt.getStateChange()==ItemEvent.SELECTED)
        {
            ModeSelectToggleButton.setBackground(new Color(0x22ff22));
            ModeSelectToggleButton.setText("Rectangular");
            drawCanvas1.c.d  = DrawingMode.R;
        }
        else if(evt.getStateChange()==ItemEvent.DESELECTED)
        {
            ModeSelectToggleButton.setBackground(new Color(0x22ff22));
            ModeSelectToggleButton.setText("Circular");
            drawCanvas1.c.d  = DrawingMode.C;
        }
    }//GEN-LAST:event_ModeSelectToggleButtonItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CircleButton;
    private javax.swing.JButton ColorButton;
    private javax.swing.JToggleButton ModeSelectToggleButton;
    private javax.swing.JButton OctagonButton;
    private javax.swing.JButton RectangleButton;
    private javax.swing.JButton SpoidButton;
    private javax.swing.JButton TriangleButton;
    private javax.swing.JPanel bottomPanel;
    private drawboard.DrawCanvas drawCanvas1;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel leftBarPanel;
    private javax.swing.JButton loadImageButton;
    private javax.swing.JSlider opacitySlider;
    private javax.swing.JButton saveAsButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
