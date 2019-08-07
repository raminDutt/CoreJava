package coreJava.annotations;

public @interface QuadrantFour {
    Coordinate coordinate() default @Coordinate(x = 10, y = -5);

}
