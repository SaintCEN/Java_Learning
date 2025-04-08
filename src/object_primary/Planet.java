package object_primary;

public enum Planet {
    MERCURY("水星", 3.303e+23, 2.4397e6),
    VENUS("金星", 4.869e+24, 6.0518e6),
    EARTH("地球", 5.976e+24, 6.37814e6);

    private final String chineseName;
    private final double mass;
    private final double radius;

    Planet(String chineseName, double mass, double radius) {
        this.chineseName = chineseName;
        this.mass = mass;
        this.radius = radius;
    }

    public String getChineseName() {
        return chineseName;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double surfaceGravity() {
        final double G = 6.67300E-11;
        return G * mass / (radius * radius);
    }
}