package TSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class ADN {
	private int[] genes;
	private double fitness;

	public ADN(int[] genes) {
		this.genes = genes;
	}

	// Create an ADN with random characters
	public static ADN randomCreate(int n) {
		int[] genes = new int[n];
		List<Integer> explore = new ArrayList<Integer>();
		// Them n dinh vao explore
		for (int i = 0; i < n; i++) {
			explore.add(i);
		}
		// Lay tung cai 1 ngau nhien o explore vao trong ADN
		for (int i = 0; i < n; i++) {
			Random rd = new Random();
			int choose = rd.nextInt(explore.size());
			genes[i] = explore.get(choose);
			explore.remove(choose);
		}
		return new ADN(genes);
	}

	public int size() {
		return this.genes.length;
	}

	public void calFitness(Map map) {
		this.fitness = Math.pow(100D / getPathCost(map), 10);
	}

	public double getPathCost(Map map) {
		double pathCost = 0;
		for (int i = 1; i < genes.length; i++) {
			pathCost += map.getPath(genes[i - 1], genes[i]);
		}
		pathCost+=map.getPath(genes[genes.length - 1], genes[0]);
		return pathCost;
	}

	public ADN crossover(ADN that) {
		int[] childGenes = new int[genes.length];
		Arrays.fill(childGenes, -1);
		// Random 2 cross points p1 and p2
		Random rd = new Random();
		Queue<Integer> remainList = new LinkedList<Integer>();
		int p1 = rd.nextInt(genes.length);
		int p2 = -1;
		do {
			p2 = rd.nextInt(genes.length);
		} while (p1 == p2);

		if (p1 > p2) {
			int tmp = p1;
			p1 = p2;
			p2 = tmp;
		}
		for (int num = 0; num < genes.length; num++) {
			remainList.add(num);
		}

		// Map value of ADN called "that" from p1 to p2 into child
		for (int i = p1; i <= p2; i++) {
			childGenes[i] = that.genes[i];
			remainList.remove(new Integer(childGenes[i]));
		}
		// Map value from ADN called "this" into child (without duplicate)
		for (int i = 0; i < p1; i++) {
			if (remainList.contains(this.genes[i])) {
				childGenes[i] = this.genes[i];
				remainList.remove(new Integer(childGenes[i]));
			}
		}
		for (int i = p2 + 1; i < genes.length; i++) {
			if (remainList.contains(this.genes[i])) {
				childGenes[i] = this.genes[i];
				remainList.remove(new Integer(childGenes[i]));
			}
		}
		// Fill all holes with contained numbers
		for (int i = 0; i < genes.length; i++) {
			if (childGenes[i] == -1) {
				childGenes[i] = remainList.poll();
			}
		}

		return new ADN(childGenes);
	}

	public int[] getGenes() {
		return genes;
	}

	public double getFitness() {
		return fitness;
	}

	// note
	public void mutate(double mutateRatio) {
		if (Math.random() > mutateRatio) {
			return;
		} else {
			// Random 2 cross points p1 and p2
			Random rd = new Random();
			int p1 = rd.nextInt(genes.length);
			int p2 = -1;
			do {
				p2 = rd.nextInt(genes.length);
			} while (p1 == p2);

			if (p1 > p2) {
				int tmp = p1;
				p1 = p2;
				p2 = tmp;
			}

			for (int i = p1; i < (p2 + p1 + 1) / 2; i++) {
				int temp = genes[i];
				genes[i] = genes[p2 - (i - p1)];
				genes[p2 - (i - p1)] = temp;
			}
		}
	}

	public String toString() {
		return Arrays.toString(genes);
	}

}
