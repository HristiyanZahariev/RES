import bg.elsys.ip.rest.Car;
import bg.elsys.ip.rest.GenerateData;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hristiyan on 21.11.16.
 */
public class TestGenerateData {
    @Test
    public void testAddNewCar() {
        Car car = new Car("RandomCar123", "C220", 2016, "black");
        GenerateData.getInstance().addNewCar(car);
        for (Car mobileCar : GenerateData.getInstance().getCars()) {
            if (mobileCar.getManufacture() == "RandomCar123") {
                assertTrue("Car is added", true);
            }
        }
    }

    @Test
    public void findByIdReturnsCorectId() {
        Car car = new Car("BMW", "M5", 2016, "white");
        car.setId(20);
        GenerateData.getInstance().addNewCar(car);
        System.out.print(car.getId());
        assertEquals(car.getId(), 20, 0.00001);
    }

    @Test
    public void findByIdReturnsNoCar() {
        assertEquals(GenerateData.getInstance().findById(-5), null);
    }

    @Test
    public void testGetRandomYear() {
        assertTrue(1940 <= GenerateData.getInstance().getRandomYear() && GenerateData.getInstance().getRandomYear() <= 2016);
    }
}
