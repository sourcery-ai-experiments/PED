/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presets;

/**
 *
 * @author Manuel Mora Monge
 */

import java.awt.*;
import javax.swing.*;

public class Custom_JPanel extends JPanel{
    
    private Image backgroundImage;

    public Custom_JPanel(String imageName) {
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo escalada al tamaño del panel
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
