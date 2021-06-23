public class TreeImpl {

    public static void main(String[] args) {
        int[] parent = {1, 2, 3, 4, -1};
        System.out.println(findHeight(parent, parent.length));
    }

    private static int findHeight(int[] parent, int n) {
        int[] visit = new int[n];
        int[] level = new int[n];
        int max = 0;
        for(int i =0;i<n;i++){
            visit[i] = 0;
            level[i] = 0;
        }
        for(int i =0;i<n;i++){
            if(visit[i] != 1)
                // calculate height
                level[i] = findLevel(parent, i, visit, level);

            max = Math.max(level[i], max);
        }
        return max;
    }

    private static int findLevel(int[] parent, int i, int[] visit, int[] level) {

        if(parent[i] == -1){
            visit[i] = 1;
            return 0;
        }
        if(visit[i]==1)
            return level[i];

        visit[i] = 1;

        level[i] = 1 +findLevel(parent, parent[i], visit,level);

        return level[i];
    }
}
