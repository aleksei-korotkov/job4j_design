package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisUnknownObject() {
        Box box = new Box(10, 5);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void ifCubeThenEightVertices() {
        Box box = new Box(8, 10);
        assertThat(box.getNumberOfVertices()).isEqualTo(8);
    }

    @Test
    void ifUnknownObjectThenMinusOneVertices() {
        Box box = new Box(8, -10); // Отрицательное ребро
        assertThat(box.getNumberOfVertices()).isEqualTo(-1);
    }

    @Test
    void ifCubeThenTrue() {
        Box box = new Box(8, 10); // Сфера
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void ifUnknownObjectThenFalse() {
        Box box = new Box(8, -10); // Сфера
        assertThat(box.isExist()).isFalse();
    }

    @Test
    void ifCubeAndEdgeIs10ThenAreaIs600() {
        Box box = new Box(8, 10);
        double expectedArea = 6 * (10 * 10);
        assertThat(box.getArea()).isEqualTo(expectedArea, withPrecision(0.001d));
    }

    @Test
    void ifUnknownObjectThenAreaIsZero() {
        Box box = new Box(7, 10); // 7 вершин — неизвестная фигура
        assertThat(box.getArea()).isZero();
    }
}