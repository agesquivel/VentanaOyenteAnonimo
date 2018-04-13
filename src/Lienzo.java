import javax.swing.*;
import java.awt.*;

public class Lienzo extends JPanel {

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }

    private Color colorFondo;
    private int XOrigen, YOrigen;

    public Lienzo(){
        super();

        //Obtener el ancho y alto del JFrame
        this.setPreferredSize(new Dimension(800, 400));
        this.colorFondo = Color.BLACK;
        //this.setBackground(colorFondo);
    }

    @Override
    public void paintComponent(Graphics g){
        //Colorear el fondo de la pantalla
        g.setColor(this.colorFondo);
        g.fillRect(0,0, this.getWidth(), this.getHeight());

        XOrigen = this.getWidth() / 2;
        YOrigen = this.getHeight() / 2;

        g.setColor(Color.GREEN);
        g.drawLine(0, YOrigen, this.getWidth()-1, YOrigen);

        repaint();
    }
}
