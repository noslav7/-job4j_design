package ru.job4j.assertj;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.serialization.xml.B;

import static org.assertj.core.api.Assertions.*;

public class BoxTest {

    @Test
    public void whenNoEdgesThanSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    private static final String UNKNOWN = "Unknown object";
    @Test
    public void whenThreeEdgesThanUnknown() {
        Box box = new Box(3, 10);
        String type = box.whatsThis();
        assertThat(type).isEqualTo(UNKNOWN);
    }

    @Test
    public void whenVertexIs5Than5Vertices() {
        Box box = new Box(5, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(5);
    }

    @Test
    public void whenVertexIs0ThanNoVertices() {
        Box box = new Box(0, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(0);
    }

    @Test
    public void whenVertexIs4ThanExists() {
        Box box = new Box(0, 10);
        boolean exists = box.isExist();
        assertThat(exists).isEqualTo(true);
    }

    @Test
    public void whenVertexIsMinusOneThanNotExists() {
        Box box = new Box(-1, 10);
        boolean exists = box.isExist();
        assertThat(exists).isEqualTo(false);
    }

    @Test
    public void whenVertexIs0ThanSphereArea() {
        Box box = new Box(-1, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(4 * Math.PI * (box.getEdge() * box.getEdge()));
    }

    @Test
    public void whenVertexIs6ThanHexagonalArea() {
        Box box = new Box(6, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(6 * (box.getEdge() * box.getEdge()));
    }
}