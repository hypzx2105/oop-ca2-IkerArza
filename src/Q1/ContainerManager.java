package Q1;

import java.util.ArrayList;
import java.util.List;

public class ContainerManager {
    private List<IMeasurableContainer> containers;

    public ContainerManager() {
        this.containers = new ArrayList<>();
    }

    public void add(IMeasurableContainer container) {
        containers.add(container);
    }

    public double totalWeight() {
        double total = 0;
        for (IMeasurableContainer container : containers) {
            total += container.weight();
        }
        return total;
    }

    public double totalRectangularVolume() {
        double total = 0;
        for (IMeasurableContainer container : containers) {
            total += container.rectangularVolume();
        }
        return total;
    }

    public void clearAll() {
        containers.clear();
    }

    public List<IMeasurableContainer> getAllContainers() {
        return new ArrayList<>(containers);
    }
}

