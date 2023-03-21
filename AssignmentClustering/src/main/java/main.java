import java.io.File;
import net.sf.javaml.clustering.evaluation.SumOfSquaredErrors;
import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.core.Instance;
import net.sf.javaml.distance.DistanceMeasure;
import net.sf.javaml.tools.data.FileHandler;
import net.sf.javaml.clustering.evaluation.ClusterEvaluation;
import net.sf.javaml.clustering.KMedoids;
import net.sf.javaml.clustering.evaluation.AICScore;
import net.sf.javaml.clustering.evaluation.Gamma;
import net.sf.javaml.distance.EuclideanDistance;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.clustering.DensityBasedSpatialClustering;
import net.sf.javaml.clustering.evaluation.CIndex;
import net.sf.javaml.core.Dataset;

import net.sf.javaml.clustering.evaluation.AICScore;
import net.sf.javaml.clustering.evaluation.BICScore;


import net.sf.javaml.tools.data.FileHandler;

public class main {

    public static void main(String[] args) {


        Dataset data = FileHandler.loadDataset(new File("iris.data"), 4, ",");


        Clusterer KmeansCLustering = new KMeans();
        Clusterer DensityClustering = new DensityBasedSpatialClustering();
        Clusterer KmedoidsClustering = new KMedoids();

        Dataset[] KmeansClustering = kmeans.cluster(data);


        ClusterCheck ClusterAICScore = new AICScore(); //Euclidean distance for AIC scoring

        ClusterCheck BICSCore = new BICScore();

        EDCalc euc = new EuclideanDistance();

        ClusterCheck Cindex = new CIndex();

        ClusterCheck SumSquaredError = new SumOfSquaredErrors();

        ClusterCheck gamma = new Gamma();


        // Printing the scores for Kmeans clustering algorithm

        double KmeansAICScore = ClusterAICScore.score(KmeansClustering);
        double kmeansCIndexScore = Cindex.score(KmeansClustering);
        double KmeansBIC = BICSCore.score(KmeansClustering);
        double GammaScoreKmeans = gamma.score(KmeansClustering);

        System.out.println("The KMeans AIC is: " + KmeansAICScore);
        System.out.println("The KMeans CINDEX is: " + kmeansCIndexScore);
        System.out.println("The KMeans BIC is: " + KmeansBIC);
        System.out.println("The KMeans Gamma is: " + GammaScoreKmeans);
        System.out.println("Sum of Squared Error for Kmeans is " + SumSquaredError);

        printClusterAlgorithm(KmeansClustering); //print the output of KMEANS cluster


        //for Density based Clustering
        Dataset[] DensityBasedCluster = dbscan.cluster(data);

        ClusterCheck DensityClusterAICScore = new AICScore(); //Euclidean distance for AIC scoring

        ClusterCheck DensityBICSCore = new BICScore();

        EDCalc Densityeuc = new EuclideanDistance();

        ClusterCheck DensityCindex = new CIndex();

        ClusterCheck DensitySumSquaredError = new SumOfSquaredErrors();

        ClusterCheck Densitygamma = new Gamma();

        double DensityAICScore = DensityClusterAICScore.score(DensityBasedCluster);
        double DensityCIndexScore = DensityCindex.score(DensityBasedCluster);
        double DensityBIC = DensityBICSCore.score(DensityBasedCluster);
        double DensityGamma = Densitygamma.score(DensityBasedCluster);

        System.out.println("The Density Based Cluster AIC is: " + DensityAICScore);
        System.out.println("The Density Based Cluster Cindex is: " + DensityCIndexScore);
        System.out.println("The Density Based Cluster BIC is: " + DensityBIC);
        System.out.println("The Density Based Cluster Gamma is: " + DensityGamma);

        printClusterAlgorithm(DensityBasedCluster); //print the output of Density cluster

        //for KMedoids clustering scores
        //create the
        Dataset[] KMedoidsCluster = kmdoids.cluster(data);


        ClusterCheck KMClusterAICScore = new AICScore(); //Euclidean distance for AIC scoring

        ClusterCheck KMBICSCore = new BICScore();

        EDCalc KMeuc = new EuclideanDistance();

        ClusterCheck KMCindex = new CIndex();

        ClusterCheck KMSumSquaredError = new SumOfSquaredErrors();

        ClusterCheck KMgamma = new Gamma();

        double KmedoidsAICScore = KMClusterAICScore.score(KMedoidsCluster);
        double KMCIndexScore = KMCindex.score(KMedoidsCluster);
        double KMBIC = KMBICSCore.score(KMedoidsCluster);
        double GammaScoreKM = KMgamma.score(KMedoidsCluster);

        System.out.println("The Density Based Cluster AIC is: " + KmedoidsAICScore);
        System.out.println("The Density Based Cluster Cindex is: " + KMCIndexScore);
        System.out.println("The Density Based Cluster BIC is: " + KMBIC);
        System.out.println("The Density Based Cluster Gamma is: " + GammaScoreKM);

        printClusterAlgorithm(KMedoidsCluster); //print the output of Kmedoids cluster


        //printing the clusters when the cluster algorithm calls it
        //kmeans cluster first gets printed

        private static void printClusterAlgorithm (Dataset[] CA){

            int counter = 0;
            System.out.println("Printing Cluster Algorithm");

            for (int counter; counter < CA.length; counter++) {
                System.out.println("Cluster Output: " + (counter + 1) + ";");

                for (Instance instanceCA : CA[counter]) {
                    System.out.println(instanceCA);

                }

            }

            System.out.println("Cluster Output Done");
        }


    }
}












