package performance;

import mikera.util.Maths;
import mikera.util.mathz.FloatMaths;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class Benchmark extends SimpleBenchmark {
	double r=0;
	
	public void timeMikeraMin(int reps) {
		double c=0;
		for (int i=0; i<reps; i++) {
			c+=Maths.min(i,100);
		}
		r=c;
	}
	
	public void timeJavaMin(int reps) {
		double c=0;
		for (int i=0; i<reps; i++) {
			c+=Math.min(i,100);
		}
		r=c;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Benchmark().run();
	}

	private void run() {
		new Runner().run(new String[] {this.getClass().getCanonicalName()});
	}


}
