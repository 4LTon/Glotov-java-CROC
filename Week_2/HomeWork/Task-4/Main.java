public class Main {
    public static void main(String[] args) {

        Annotation annat1 = new Annotation(10, 10, 10, "Car");
        Annotation annat2 = new Annotation(0, 0, 10,20, "Men");
        System.out.println(annat1);
        System.out.println(annat2);

        Annotation[] annotations = new Annotation[] {annat1, annat2};

        AnnotatedImage img = new AnnotatedImage("img/photo.jpg", annotations);
    }
}