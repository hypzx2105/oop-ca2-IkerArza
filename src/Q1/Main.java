package Q1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContainerManager manager = new ContainerManager();


        Box box1 = new Box(2, 3, 4, 10);
        Cylinder cylinder1 = new Cylinder(5, 2, 8);
        Pyramid pyramid1 = new Pyramid(3, 3, 6);


        manager.add(box1);
        manager.add(cylinder1);
        manager.add(pyramid1);


        System.out.println("Total Weight: " + manager.totalWeight());
        System.out.println("Total Rectangular Volume: " + manager.totalRectangularVolume());


        List<IMeasurableContainer> allContainers = manager.getAllContainers();

        for (IMeasurableContainer container : allContainers) {

            if (container instanceof Box) {
                Box box = (Box) container;
                System.out.println("Box: Length=" + box.getLength() + ", Width=" + box.getWidth()
                        + ", Depth=" + box.getDepth() + ", Weight=" + box.getWeight());

            } else if (container instanceof Cylinder) {
                Cylinder cylinder = (Cylinder) container;
                System.out.println("Cylinder: Height=" + cylinder.getHeight() + ", Diameter="
                        + cylinder.getDiameter() + ", Weight=" + cylinder.getWeight());

            } else if (container instanceof Pyramid) {
                Pyramid pyramid = (Pyramid) container;
                System.out.println("Pyramid: Length=" + pyramid.getLength() + ", SideLength="
                        + pyramid.getSideLength() + ", Weight=" + pyramid.getWeight());

            }
        }


        manager.clearAll();
        System.out.println("All containers cleared.");
    }
}

