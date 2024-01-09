import java.util.ArrayList;

public class Solution 
{
	public static int calculateScore(ArrayList<String> matchResult, int n) 
    {	
		// To record the scores.
		ArrayList<Integer> trackRecord = new ArrayList<>();

		for (String op : matchResult) 
        {	
			// Introduce a new score on the 'TRACKRECORD' which is sum of the previous two scores.
			if (op.equals("+")) 
            {
				trackRecord.add(trackRecord.get(trackRecord.size() - 1) + trackRecord.get(trackRecord.size() - 2));
			}

			// Nullify the previous score from the 'TRACKRECORD'.
			else if (op.equals("C")) 
            {
				trackRecord.remove(trackRecord.size() - 1);
			}

			// Introduce a new score on the 'TRACKRECORD' which is the double of the previous score.
			else if (op.equals("D")) 
            {
				trackRecord.add(trackRecord.get(trackRecord.size() - 1) * 2);
			}

			// Introduce a new score of 'OP' on the 'TRACKRECORD'.
			else 
            {
				trackRecord.add(Integer.parseInt(op));
			}
		}

		// Calculate the sum of all the scores on the 'TRACKRECORD'.
		int sumScore = 0;
		
        for (int score : trackRecord) 
        {
			sumScore = sumScore + score;
		}

		return sumScore;
	}
}
