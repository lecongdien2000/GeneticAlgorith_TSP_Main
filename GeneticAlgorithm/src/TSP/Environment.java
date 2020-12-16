package TSP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Environment {

	private List<ADN> population;
	private Map map;
	private int populationSize;
	private double mutateRatio;
	private WriteEnvironmentToExcel wete;
	private String title;
	
	public Environment(Map map, int populationSize, double mutateRatio, WriteEnvironmentToExcel wete, String title) throws IOException {
		this.populationSize = populationSize;
		this.mutateRatio = mutateRatio;
		this.map = map;
		this.wete = wete;
		this.title = title;
	}

	// Initialize population with n element
	public void generate() {
		population = new ArrayList<ADN>();
		for (int i = 0; i < populationSize; i++) {
			population.add(ADN.randomCreate(map.size()));
		}

	}

	public void draw(int limit) throws IOException {
		
		for (int loop = 0; loop < limit; loop++) {
			ADN best = population.get(0);
			List<ADN> newPopulation = new ArrayList<ADN>();
			// Calculate a fitness of each element
			this.calFitness();
			for (int i = 0; i < populationSize; i++) {
				if(best.getPathCost(map) > population.get(i).getPathCost(map)) best = population.get(i);
				// Pick two parents with probability using fitness
				ADN parentA = this.randomPick();
				ADN parentB = this.randomPick();
				// Crossover
				ADN child = parentA.crossover(parentB);
				// Mutation by a rarely percent
				child.mutate(mutateRatio);
				// Add new child into new population
				newPopulation.add(child);
			}
			// Replace old population with new population
			population = newPopulation;
			//Write best choice to excel
			wete.write(best.getPathCost(map), title);
		}
		wete.close();
	}

	private ADN randomPick() {
		double total = 0;
		for(ADN adn: population) {
			total += adn.getFitness();
		}
		double rdNum = Math.random();
		for(ADN adn: population) {
			rdNum -= adn.getFitness()/total;
			if(rdNum < 0) return adn;
		}
		return null;
	}

	private void calFitness() {
		for (ADN adn : population) {
			adn.calFitness(map);
		}
	}

}
