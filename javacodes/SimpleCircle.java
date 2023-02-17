
package simplecircle;


public class SimpleCircle {

    
    public static void main(String[] args) {
        // Create circle with radius one
        SimpleCircle circle = new SimpleCircle();
        System.out.println("The are of the circle with radius " + circle.radius + " is " + circle.getArea());
        
        // Create circle with radius 25
        SimpleCircle circle2 = new SimpleCircle(25);
        System.out.println("The are of the circle with radius " + circle2.radius + " is " + circle2.getArea());
        
        //// Create circle with radius 125
        SimpleCircle circle3 = new SimpleCircle(125);
        System.out.println("The are of the circle with radius " + circle3.radius + " is " + circle3.getArea());
   
        // Modigy circle radius 
        circle2.radius = 100;
        System.out.println("The are of the circle with radius " + circle2.radius + " is " + circle2.getArea());
    }
    double radius ;
    
    // Constructor a circle with radius 1
    SimpleCircle(){
        radius = 1;
    }
    // Constructor a circle with a specified radius
    SimpleCircle(double newRadius){
        radius = newRadius;
    }
    
    // Return the area of the circle
    double getArea(){
        return radius * radius * Math.PI;
    }
    
    // Return the perimeter of the circle
    double getPerimeter(){
        return 2 * radius * Math.PI;
    }
    
    // Set new radius
    void setRadius(double newRadius){
        radius = newRadius;
       
    }
    
}
