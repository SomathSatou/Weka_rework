package VaTou;

import java.util.Random;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Controller {

	/**
	 * pour ouvrir et traiter un projet comme sous weka
	 *
	 */
	public void arbreJ48(String chemin_file) {
		try {
			
			DataSource source = new DataSource(chemin_file);
			Instances data = source.getDataSet();
			int nbr_instances = data.numInstances();
			int nbr_iterations_pour_le_test = 1;

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

				System.out.println(eval.toSummaryString("\nResults\n======\n", false));
			}

		} catch (Exception e) {

		}
	}
}
