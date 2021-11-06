public class AnnotatedImage {
    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    public Annotation findByPoint(int x, int y) {
        for (Annotation annat : annotations) {
            if (annat.pointInShape(x, y)) return annat;
        }
        System.out.println("Ќет аннотации, содержащей эту точку!");
        return null;
    }

    public Annotation findByLabel(String label) {
        for (Annotation annat : annotations) {
            if (annat.getSignature().contains(label)) return annat;
        }
        System.out.println("Ќет аннотации, содержащей данную подстроку");
        return null;
    }
}
