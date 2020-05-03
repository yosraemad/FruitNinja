package fruitNinja.models.entities;

import javafx.scene.canvas.GraphicsContext;

public interface GameObject {
    double getXlocation();
    double getYlocation();
    Boolean isSliced();
    void fellOff();
    Boolean hasMovedOffScreen();
    void slice();
    boolean intersect(double x, double y);
    void render(GraphicsContext gc);
}
