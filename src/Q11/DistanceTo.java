package Q11;

public class DistanceTo implements Comparable<DistanceTo> {
    private String target;
    private int distance;

    public DistanceTo(String target, int distance) {
        this.target = target;
        this.distance = distance;
    }

    public String getTarget() {
        return target;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(DistanceTo other) {
        return this.distance - other.distance;
    }
}

