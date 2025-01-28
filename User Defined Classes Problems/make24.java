/*
 * Make24
 */
import java.util.*;
public class make24 {
	static double epsilon = 1e-8;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Q = in.nextInt(); //# of queries

		int count = 0; //# of targets reachable
		for(int q=0; q<Q; q++) {
			Group A = new Group();
			for(int k=0; k<4; k++)
				A.ints.add(in.nextInt());
			int target = in.nextInt();
	
			A.genValues();
			if(contains(A.values, target))
				count++;
		}
		System.out.println(count);
		in.close();
	}
	
	static boolean contains(ArrayList<Double> list, double t) {
		for(double v : list)
			if(Math.abs(v-t)<epsilon)
				return true;
		return false;
	}

	static class Group {
		ArrayList<Integer> ints; //input integers
		ArrayList<Double> values; //double values reachable
		
		Group() {
			ints = new ArrayList<>();
			values = new ArrayList<>();
		}
		
		public void genValues() {
			if(ints.isEmpty()) return;
			
			if(ints.size()==1) {
				values.add((double)ints.get(0));
				return;
			}
			
			for(int j=0; j<ints.size(); j++) {
				Group g1 = new Group();
				g1.ints.addAll(ints);
				g1.ints.remove(j);
				
				Group g2 = new Group();
				g2.ints.add(ints.get(j));
				
				g1.genValues();
				g2.genValues();
				merge(g1, g2);
			}
			
			if(ints.size()==4) {
				for(int j=1; j<ints.size(); j++) {
					Group g1 = new Group();
					g1.ints.addAll(ints);
					g1.ints.remove(j);
					g1.ints.remove(0);
					
					Group g2 = new Group();
					g2.ints.add(ints.get(j));
					g2.ints.add(ints.get(0));
					
					g1.genValues();
					g2.genValues();
					merge(g1, g2);
				}
			}
		}
		
		public void merge(Group g1, Group g2) {
			for(double d1 : g1.values) {
				for(double d2 : g2.values) {
					if(!contains(values, d1+d2)) values.add(d1+d2);
					if(!contains(values, d1-d2)) values.add(d1-d2);
					if(!contains(values, d2-d1)) values.add(d2-d1);
					if(!contains(values, d1*d2)) values.add(d1*d2);
					if(d2!=0 && !contains(values, d1/d2)) values.add(d1/d2);
					if(d1!=0 && !contains(values, d2/d1)) values.add(d2/d1);
				}
			}
		}
	}
}
