package testgeometricobject;
public class TestGeometricObject {
    // Main method
    public static void main(String[] args) {
        // Create tow geometric objects
        GeometricObject geoObject1 = new Circle(5);
        GeometricObject geoObject2 = new Rectangle(5, 3);
        System.out.println("The tow objects have the same area? " +
                equalArea(geoObject1, geoObject2));
         // Display circle
        displayGeometricObject(geoObject1);
        
        // Display rectangle
        displayGeometricObject(geoObject2);
        
        // SortRectangles
        ComparableRectangle[] rectangles = {
            new ComparableRectangle(3.4, 5.4),
            new ComparableRectangle(13.4, 55.4),
            new ComparableRectangle(7.4, 35.4),
            new ComparableRectangle(1.4, 25.4)
        };
        java.util.Arrays.sort(rectangles);
        for (Rectangle rectangle: rectangles) {
            System.out.print(rectangle + " ");
            System.out.println();
        }
    }
    
    // a method for comparing the areas of tow geometric object
    public static boolean equalArea(GeometricObject object1,
            GeometricObject object2) {
        return object1.getArea() == object2.getArea();
    }
    
    // Amethod for displaying a geometric object
    public static void displayGeometricObject(GeometricObject object) {
        System.out.println();
        System.out.println("The area is " + object.getArea());
        System.out.println("The perimeter is " + object.getPerimeter());
    }
}
