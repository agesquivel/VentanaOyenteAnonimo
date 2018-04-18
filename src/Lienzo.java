import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lienzo extends JPanel {

    private Color colorFondo;
    private int XOrigen = 100, YOrigen = 100;

    private accionesRaton oyenteRaton;

    public Lienzo(){
        super();

        //Obtener el ancho y alto del JFrame
        this.setPreferredSize(new Dimension(800, 400));
        this.colorFondo = Color.BLACK;
        //this.setBackground(colorFondo);

        accionesRaton oyenteRaton = new accionesRaton();
        this.addMouseListener(oyenteRaton);
        this.addMouseMotionListener(oyenteRaton);
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }

    @Override
    public void paintComponent(Graphics g){
        //Colorear el fondo de la pantalla
        g.setColor(this.colorFondo);
        g.fillRect(0,0, this.getWidth(), this.getHeight());

        //XOrigen = this.getWidth() / 2;
        //YOrigen = this.getHeight() / 2;

        //Dibujar ejeX
        g.setColor(Color.GREEN);
        g.drawLine(0, YOrigen, this.getWidth()-1, YOrigen);

        //Dibujar ejeY
        g.drawLine(XOrigen, 0, XOrigen, this.getHeight()-1);


        //cálculos
        int nValoresNeg = (XOrigen / 40) * -1;
        int nValoresPos = (this.getWidth() - XOrigen / 40);

        for (int valorX = nValoresNeg;  valorX <= nValoresPos; valorX++) {

            //Dibujar las marcas del ejeX
            g.drawLine(XOrigen + (valorX * 40), YOrigen - 10,
                    XOrigen + (valorX * 40), YOrigen + 10);

            g.drawString("" + valorX, XOrigen + (valorX * 40), YOrigen + 30);

        }

        repaint();
    }

    //clase oyente interna

    class accionesRaton extends MouseAdapter
            implements MouseMotionListener {

        boolean bandMueveOrigen = false;

        @Override
        public void mouseClicked(MouseEvent e) {
            //Click derecho activa modificación de coord origen
            if (e.getButton() == MouseEvent.BUTTON3){
                if (((e.getX() >= XOrigen - 20) && (e.getX() <= XOrigen + 20))
                       && ((e.getY() >= YOrigen - 20) && (e.getY() <= YOrigen + 20)) ) {
                    bandMueveOrigen = true;

                }

            } //Click derecho desactiva modificación de coord origen
            else if (e.getButton() == MouseEvent.BUTTON1){
                bandMueveOrigen = false;
            }

            System.out.println("X = " + e.getX() + " Y = " + e.getY()
                    + " Origen = (" + XOrigen + " ," + YOrigen + ")"
                    + " Botón = " + e.getButton() + " mover = " + bandMueveOrigen);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //Si la bandMueveOrigen está activa
            // cambiar x,y del origen con la posición actual de cursor

            System.out.println("Pos (" + e.getX() + "," + e.getY()
                    + " Origen = (" + XOrigen + " ," + YOrigen + ")"
                    + " Botón = " + e.getButton() + " mover = " + bandMueveOrigen);

            if (bandMueveOrigen) {
                XOrigen = e.getX();
                YOrigen = e.getY();

                repaint();
            }
        }

    }

}








