package trApp.trDesktopApp.CustomControl;

import javax.swing.*;

import trInfrastructure.AppStyle;

import java.awt.*;

public class RBLabelText extends JPanel{
    private RBLabel    lblEtiqueta = new RBLabel();
    private RBTextBox  txtContenido= new RBTextBox();

    public RBLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(  etiqueta, 
                                            AppStyle.FONT_SMALL, 
                                            AppStyle.COLOR_FONT_LIGHT, 
                                            AppStyle.ALIGNMENT_LEFT); 
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
