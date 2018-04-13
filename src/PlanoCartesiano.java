import javax.sound.sampled.BooleanControl;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanoCartesiano extends JFrame {

    public PlanoCartesiano(){
        //Agregar componentes
        Container contenedorPrinc = getContentPane();
        contenedorPrinc.setLayout(new BoxLayout(contenedorPrinc, BoxLayout.Y_AXIS));

        Lienzo lienzo = new Lienzo();
        contenedorPrinc.add(lienzo);

        JPanel panelBotones = new JPanel();

        panelBotones.setLayout(new FlowLayout());
        TitledBorder titPanelBotones = BorderFactory.createTitledBorder("");
        panelBotones.setBorder(titPanelBotones);

        //Agregar botones al panel de botones
        JLabel lblAncho = new JLabel("Ancho");
        lblAncho.setPreferredSize(new Dimension(50, 20));

        JTextField edtAncho = new JTextField();
        edtAncho.setPreferredSize(new Dimension(100, 20));

        JLabel lblAlto = new JLabel("Alto");
        lblAlto.setPreferredSize(new Dimension(50, 20));

        JTextField edtAlto = new JTextField();
        edtAlto.setPreferredSize(new Dimension(100, 20));

        JButton btnTamanioLienzo = new JButton("Establecer");

        panelBotones.add(lblAncho);
        panelBotones.add(edtAncho);
        panelBotones.add(lblAlto);
        panelBotones.add(edtAlto);
        panelBotones.add(btnTamanioLienzo);

        JButton btnColorLienzo = new JButton("Cambiar color...");
        panelBotones.add(btnColorLienzo);

        contenedorPrinc.add(panelBotones);

        btnColorLienzo.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Color colorLienzo = JColorChooser.showDialog(btnColorLienzo,
                                "Seleccionar color",
                                lienzo.getColorFondo());

                        if (colorLienzo != null){
                            lienzo.setColorFondo(colorLienzo);
                        }
                    }
                }

        );
        /*---------------------------
        class MiClase implements ActionListener{
            public void actionPerformed(ActionEvent event){
                lienzo.setPreferredSize(new Dimension(
                        Integer.parseInt(edtAncho.getText()),
                        Integer.parseInt(edtAlto.getText()))
                );
            }

        }

        MiClase oyente = new MiClase();

        btnTamanioLienzo.addActionListener(oyente);
        ---------------------------*/

        //Oyente como clase anónima
        btnTamanioLienzo.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        /*lienzo.setPreferredSize(new Dimension(
                                Integer.parseInt(edtAncho.getText()),
                                Integer.parseInt(edtAlto.getText()))
                        );*/

                        PlanoCartesiano.this.setSize(
                                Integer.parseInt(edtAncho.getText()),
                                Integer.parseInt(edtAlto.getText())
                        );

                    }

                }
                );
    }

    public static void main(String[] args){
        PlanoCartesiano plano2D = new PlanoCartesiano();

        plano2D.setSize(800, 600);
        plano2D.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        plano2D.setResizable(false);
        plano2D.setVisible(true);
    }

}
