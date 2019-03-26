package VaTou;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
    	
        /**
         *  TEST CONTROLLER arbreJ48  : Attention de bien mettre le bon chemin de fichier 
         *  */
        Controller arbretest = new Controller();
        
        JFrame frame = new JFrame();
        frame.setBounds( 100, 100, 500, 500 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout( null );

        JLabel viewPath = new JLabel( "chemin du fichier" );
        viewPath.setBounds( 10, 10, 480, 20 );
        // bouton pour chercher un fichier
        JButton btnNewButton = new JButton( "Get File" );
        btnNewButton.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed( ActionEvent arg0 ) {

                // TODO Auto-generated method stub
                MyFileOpener of = new MyFileOpener();
                try {
                    viewPath.setText( of.pick_me() );
                } catch ( Exception e ) {
                    e.printStackTrace();
                }

            }
        } );
        btnNewButton.setBounds( 10, 30, 480, 40 );

        JLabel algo = new JLabel( "choix de l'algorithme : " );
        algo.setBounds( 10, 70, 480, 20 );

        String[] algos = { "J48", "item2" };
        JComboBox choixAlgo = new JComboBox( algos );
        choixAlgo.setBounds( 10, 90, 480, 30 );

        JButton launch = new JButton( "Démarer les tests" );
        launch.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed( ActionEvent arg0 ) {
                arbretest.arbreJ48(viewPath.getText());

            }
        } );
        launch.setBounds( 150, 120, 200, 50 );

        frame.getContentPane().add( viewPath );
        frame.getContentPane().add( btnNewButton );
        frame.getContentPane().add( algo );
        frame.getContentPane().add( choixAlgo );
        frame.getContentPane().add( launch );

        frame.setVisible( true );
        


        arbretest.arbreJ48("/home/etudiant/Cours/Semestre2/IA/weka-3-8-3/data/iris.arff");
    }
    

}
