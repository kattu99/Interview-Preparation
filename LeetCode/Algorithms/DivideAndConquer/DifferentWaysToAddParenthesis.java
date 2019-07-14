class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String input) {
        //build it up intelligently
        if(map.containsKey(input)) return map.get(input);
        List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length();i++) {
            if (input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> l1 = diffWaysToCompute(part1);
                List<Integer> l2 = diffWaysToCompute(part2);
                for (Integer p1: l1) {
                    for (Integer p2: l2) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1 + p2;
                                break;
                            case '-': c = p1 - p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        map.put(input, ret);
        return ret; 
     }
}