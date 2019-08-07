package coreJava.annotations;

public @interface QuadrantThree {

    Coordinate coordinate() default @Coordinate(x = -10, y = -5);
}
