package Binary_Searching;

public class Koko_Eating_Bananas {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int p : piles)
            right = Math.max(right, p);

        while (left < right) {
            int mid_h = (left + right) / 2;
            int reqHrs = 0;
            for (int p : piles) {
                reqHrs += (int) Math.ceil((double) p / mid_h);
            }
            if (reqHrs <= h)
                right = mid_h;
            else
                left = mid_h + 1;
        }
        return right;
    }
}
