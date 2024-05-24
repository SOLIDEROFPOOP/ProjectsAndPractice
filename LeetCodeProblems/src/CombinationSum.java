import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(candidates, target, 0 , new ArrayList<>(),results);
        return results;
    }
    private void backtrack(int[] candidates , int target , int start , List<Integer> current , List<List<Integer>> results){
        if (target == 0){
            results.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;
        for (int i = start; i < candidates.length; i++){
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i , current, results);
            current.remove(current.size() - 1);
        }
    }
}
