package coreJava.annotations;

public @interface QuadrantTwo {
    Coordinate coordinate() default @Coordinate(x = -10, y = 5);

}
