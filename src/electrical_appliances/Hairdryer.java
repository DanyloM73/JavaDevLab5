package electrical_appliances;

import java.util.Random;

/**
 * Represents a hairdryer appliance.
 * Generates random power consumption and electromagnetic emission values
 * within a specified range.
 */
public class Hairdryer extends ElectricalAppliance {
    /**
     * Constructs a {@code Hairdryer} object with a specified brand.
     * The power consumption and electromagnetic emission values are
     * randomly generated within predefined ranges.
     *
     * @param brand the brand of the hairdryer
     */
    public Hairdryer(String brand) {
        super(brand, getRandomPower(), getRandomElectromagneticEmission());
    }

    /**
     * Generates a random power consumption value for the hairdryer.
     * The value is within the range of 500 to 1000 watts.
     *
     * @return a random power consumption value
     */
    private static double getRandomPower() {
        return getRandomValue(500, 1000);
    }

    /**
     * Generates a random electromagnetic emission value for the hairdryer.
     * The value is within the range of 1500 to 2000 microteslas.
     *
     * @return a random electromagnetic emission value
     */
    private static double getRandomElectromagneticEmission() {
        return getRandomValue(1500, 2000);
    }

    /**
     * Generates a random value within a specified range.
     *
     * @param min the minimum value of the range (inclusive)
     * @param max the maximum value of the range (inclusive)
     * @return a random value between min and max
     */
    private static double getRandomValue(double min, double max) {
        return min + (max - min) * new Random().nextDouble();
    }

    /**
     * Returns the name of this electrical appliance.
     * For this class, it always returns simple name of the class.
     *
     * @return the name of the appliance
     */
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
