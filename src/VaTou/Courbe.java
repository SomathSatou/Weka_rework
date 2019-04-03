package VaTou;

import java.text.DecimalFormat;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Courbe extends JPanel {

    public Courbe( Resultat_tableau res ) {
        super();
        this.setBounds( 530, 5, 700, 700 );
        // this.setSize( 500, 500 );

        DecimalFormat df2 = new DecimalFormat( ".###" );

        // create a dataset...
        XYSeries series = new XYSeries( "J48" );
        for ( int i = 0; i < res.getNbr_feuilles().size(); i++ ) {
            series.add( res.getNbr_feuilles().get( i ),
                    res.getPourcentage_reussite().get( i ) );
        }
        XYDataset xyDataset = new XYSeriesCollection( series );

        // create a line chart...
        JFreeChart chart = ChartFactory.createXYLineChart(
                "", // Title
                "Nombre de feuille", // X-Axis label
                "% de réssite", // Y-Axis label
                xyDataset, // Dataset
                PlotOrientation.VERTICAL,
                true,
                true,
                false );

        ChartPanel CP = new ChartPanel( chart );
        this.add( CP );

    }

}