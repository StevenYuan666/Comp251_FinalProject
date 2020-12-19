import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class US_elections {
	
	public static int solution(int num_states, int[] delegates, int[] votes_Biden, int[] votes_Trump, int[] votes_Undecided){
		
		//use the knapsack algorithm to select the states with the maximum people need to convince
		//Then select the remaining states, that is the minimum number we need to convince
		//set the total number of delegates minus the number of absolute half number as weight limit
		
		//the number of delegates of each states is weight
		//the number of people need to convince is value
		//to record the total number of people need to convince
		int votesforTrump = 0;
		int votesforBiden = 0;
		int totalToConvince = 0;
		int totalDelegates = 0;
		int[] val = new int[num_states + 1];
		int[] wei = new int[num_states + 1];
		for(int i = 1; i < val.length; i ++) {
			totalDelegates += delegates[i - 1];
			wei[i] = delegates[i - 1];
			int toWin = (votes_Trump[i - 1] + votes_Undecided[i - 1] - votes_Biden[i - 1]) / 2 + 1;
			val[i] = toWin;
			//if Biden has already won, set the number of people need to convince as zero
			if(votes_Biden[i - 1] > votes_Trump[i - 1] + votes_Undecided[i - 1]) {
				val[i] = 0;
				votesforBiden += delegates[i - 1];
			}
			//if Trump has already won, set the number of people need to convince as infinity
			if(votes_Trump[i - 1] >= votes_Biden[i - 1] + votes_Undecided[i - 1]) {
				val[i] = Integer.MAX_VALUE / 2;
				votesforTrump += delegates[i - 1];
			}
			totalToConvince += val[i];
		}
		
		//to calculate the weight limit
		int halfNum = totalDelegates / 2 + 1;
		int weightLimit = totalDelegates - halfNum;
		if(votesforBiden >= halfNum) {
			return 0;
		}
		
		//like if total delegates is 14, Trump only need 7 to win, if it was 15, Trump need 8
		//but in both case, Biden will always need 8 to win
		if(totalDelegates % 2 == 1 && votesforTrump >= halfNum) {
			//System.out.println(votesforTrump);
			//System.out.println(totalDelegates / 2);
			return -1;
		}
		else if(totalDelegates % 2 == 0 && votesforTrump >= halfNum -1) {
			return -1;
		}
		
		//Initialize a matrix with dimension n * W, where n = num_
		int[][] M = new int[num_states + 1][weightLimit + 1];
		for(int w = 0; w <= weightLimit; w ++) {
			M[0][w] = 0;
		}
		
		//main body of the knapsack algorithm
		for(int i = 1; i <= num_states; i ++) {
			for(int w = 1; w <= weightLimit; w++) {
				// if(wi > w    M[i, w] <- M[i-1, w])
				if(wei[i] > w) {
					M[i][w] = M[i - 1][w];
				}
				//else M[i, w] <- max {M[i - 1, w], vi + M[i - 1, w - wi]}
				else {
					M[i][w] = Integer.max(M[i - 1][w], val[i] + M[i - 1][w - wei[i]]);
				}
			}
		}
		
		int maximum = M[num_states][weightLimit];
		int toConvince = totalToConvince - maximum;
		if(toConvince > Integer.MAX_VALUE / 2) {
			toConvince = toConvince - (Integer.MAX_VALUE / 2);
		}
		
		return toConvince;
		
	}

	public static void main(String[] args) {
	 try {
			String path = args[0];
      File myFile = new File(path);
      Scanner sc = new Scanner(myFile);
      int num_states = sc.nextInt();
      int[] delegates = new int[num_states];
      int[] votes_Biden = new int[num_states];
      int[] votes_Trump = new int[num_states];
 			int[] votes_Undecided = new int[num_states];	
      for (int state = 0; state<num_states; state++){
			  delegates[state] =sc.nextInt();
				votes_Biden[state] = sc.nextInt();
				votes_Trump[state] = sc.nextInt();
				votes_Undecided[state] = sc.nextInt();
      }
      sc.close();
      int answer = solution(num_states, delegates, votes_Biden, votes_Trump, votes_Undecided);
      	System.out.println(answer);
    	} catch (FileNotFoundException e) {
      	System.out.println("An error occurred.");
      	e.printStackTrace();
    	}
  	}

}