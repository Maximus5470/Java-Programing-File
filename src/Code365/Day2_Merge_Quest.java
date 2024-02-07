package Code365;

import java.util.Scanner;

public class Day2_Merge_Quest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(evaluate(input));
    }

    public static String evaluate(String input) {
        String[] pairs = input
                .substring(2, input.length()-2)
                .split("\\],\\[");
        Interval[] intervals = new Interval[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            intervals[i] = new Interval(pairs[i]);
        }
        StringBuilder output = new StringBuilder("[");
        StringBuilder exclude = new StringBuilder();
        boolean revaluate = false;
        OUT: for (int i = 0; i < intervals.length; i++) {
            if(exclude.indexOf(Integer.toString(i)) > -1) continue;
            for (int j = i + 1; j < intervals.length; j++) {
                Interval mergeResult = Interval.merge(intervals[i], intervals[j]);
                if(mergeResult != null) {
                    output.append(mergeResult).append(",");
                    exclude.append(j).append(" ");
                    revaluate = true;
                    continue OUT;
                }
            }
            output.append(intervals[i]).append(",");
        }
        output.deleteCharAt(output.length() - 1).append("]");
        return revaluate?evaluate(output.toString()):output.toString();
    }

    public static class Interval {
        public final int start, end;

        public Interval(String interval) {
            this(
                    Integer.parseInt(interval.split(",")[0]),
                    Integer.parseInt(interval.split(",")[1])
            );
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Interval other) {
            return (this.start < other.start) && (this.end < other.end) && (this.end > other.start);
        }

        public static Interval merge(Interval interval1, Interval interval2) {
            if (interval1.overlaps(interval2)) {
                return new Interval(interval1.start, interval2.end);
            } else if (interval2.overlaps(interval1)) {
                return new Interval(interval2.start, interval1.end);
            } else return null;
        }

        @Override
        public String toString() {
            return "["+start+","+end+"]";
        }
    }
}
