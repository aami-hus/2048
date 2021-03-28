package src;

public class Services{

	public static double[] normal(double[] v){

		double total = 0;
		double [] normArr = new double[v.length]; 
		for(double i : v){
			total = total + i;
		}
		for(int i = 0; i < v.length; i++){
			normArr[i] = v[i]/total;
		}
		return normArr;

	}

}