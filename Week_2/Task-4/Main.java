public class Main {
    public static void main(String[] args) {

        Annotation annat1 = new Annotation(10, 10, 8, "Car");
        Annotation annat2 = new Annotation(0, 0, 10,5, "Men");

        Annotation[] annotations = new Annotation[] {annat1, annat2};

        AnnotatedImage img = new AnnotatedImage("img/photo.jpg", annotations);
    }
}
