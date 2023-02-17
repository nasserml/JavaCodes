
package testsimplecircle;


public class TestSimpleCircle {

    public static void main(String[] args) {
        //Create circile with radius 1
       SimpleCircle circle = new SimpleCircle();
       System.out.println("The of the circle of radius " + circle.radius + " is " + circle.getArea());
    
       // Create circle with radius 25
       SimpleCircle circle2 = new SimpleCircle(25);
       System.out.println("The area of cicle of radius " + circle2.radius + " is " + circle2.getArea());
       
       // Create a circle with radius 125
       SimpleCircle circle3 = new SimpleCircle(125);
       System.out.println("The area of a circle with radius " + circle3.radius + " is " + circle3.getArea());
       
       // Modify circle radius
       circle2.radius = 100 ;
       System.out.println("The area of a circle with radius " + circle2.radius + " is " + circle2.getArea());

       
    }
    
    
}
class SimpleCircle {
        double radius;
        
        // Construct a circle with radius 1
        SimpleCircle(){
            radius = 1;
            
        }
        SimpleCircle(double newRadius){
            radius = newRadius;
        }
        
        //Return the area of the circle
        double getArea() {
            return radius * radius * Math.PI;
        }
        
        // Return the perimeter of this circle
        double getPerimeter(){
            return 2 * radius * Math.PI;
            
        }
        void setRadius(double newRadius) {
            radius = newRadius;
        }
    }