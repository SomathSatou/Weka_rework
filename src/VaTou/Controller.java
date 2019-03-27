package VaTou;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Vector;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;



public class Controller {

	/**
	 * pour ouvrir et traiter un projet comme sous weka
	 *
	 */
	public Resultat_tableau arbreJ48(String chemin_file) {
		Resultat_tableau resultat = new Resultat_tableau();
		
		try {
			
			DataSource source = new DataSource(chemin_file);
			Instances data = source.getDataSet();
			int nbr_instances = data.numInstances();
			int nbr_iterations_pour_le_test = 1;

			Vector<Integer> nbr_feuilles = new Vector<Integer>();
			Vector<Double> pourcentage_reussite = new Vector<Double>();
			
			
			/*
			 * setting class attribute if the data format does not provide this information
			 * For example, the XRFF format saves the class attribute information as well ca
			 * c'est important
			 */
			if (data.classIndex() == -1)
				data.setClassIndex(data.numAttributes() - 1);

			String[] options = new String[3]; // changer la taille si plus d'argments en compte
			options[0] = "-U"; 		// unpruned tree
			J48 tree = new J48(); // new instance of tree

			/* boucle en fonction du nombre d'exemple */
			for (int i = 2; i < nbr_instances; i += nbr_instances * 0.1) {
				System.out.println(" itération : " + nbr_iterations_pour_le_test + ", nombre de feuilles minimum : " + i );
				nbr_iterations_pour_le_test++;
				
				// modification du numbre min par feuille ici 
				options[1] = "-M" ;
				options[2]= Integer.toString(i) ;
				
				tree.setOptions(options); // set the options
				tree.buildClassifier(data); // build classifier

				Evaluation eval = new Evaluation(data);
				eval.crossValidateModel(tree, data, 5, new Random(1)); // ici 5 constante pour la crossvalidation

				//System.out.println(eval.toSummaryString("\nResults\n======\n", false));
				System.out.println("Resultats summary \n pourcentage bien classé : " + eval.pctCorrect() + "\n");
				
				nbr_feuilles.add(i);
				pourcentage_reussite.add(eval.pctCorrect());
			}
			
			resultat.setNbr_feuilles(nbr_feuilles);
			resultat.setPourcentage_reussite(pourcentage_reussite);
			
			resultat.affichage();
			

		} catch (Exception e) {

		}
		
		return resultat;
	}
}
