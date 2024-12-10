package electrical_appliances;

import java.util.Random;

/**
 * Represents an electric stove appliance.
 * Generates random power consumption and electromagnetic emission values
 * within a specified range.
 */
public class ElectricStove extends ElectricalAppliance {
    /**
     * Constructs an {@code ElectricStove} object with a specified brand.
     * The power consumption and electromagnetic emission values are
     * randomly generated within predefined ranges.
     *
     * @param brand the brand of the electric stove
     */
    public ElectricStove(String brand) {
        super(brand, getRandomPower(), getRandomElectromagneticEmission());
    }

    /**
     * Generates a random power consumption value for the electric stove.
     * The value is within the range of 1000 to 3000 watts.
     *
     * @return a random power consumption value
     */
    private static double getRandomPower() {
        return getRandomValue(1000, 3000);
    }

    /**
     * Generates a random electromagnetic emission value for the electric stove.
     * The value is within the range of 40 to 50 microteslas.
     *
     * @return a random electromagnetic emission value
     */
    private static double getRandomElectromagneticEmission() {
        return getRandomValue(40, 50);
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
     * For this class, it always returns "Electric stove".
     *
     * @return the name of the appliance
     */
    @Override
    public String getName() {
        return "Electric stove";
    }
}
