package electrical_appliances;

import java.util.Random;

/**
 * Represents a vacuum cleaner appliance.
 * Generates random power consumption and electromagnetic emission values
 * within a specified range.
 */
public class VacuumCleaner extends ElectricalAppliance {
    /**
     * Constructs a {@code VacuumCleaner} object with a specified brand.
     * The power consumption and electromagnetic emission values are
     * randomly generated within predefined ranges.
     *
     * @param brand the brand of the vacuum cleaner
     */
    public VacuumCleaner(String brand) {
        super(brand, getRandomPower(), getRandomElectromagneticEmission());
    }

    /**
     * Generates a random power consumption value for the vacuum cleaner.
     * The value is within the range of 500 to 2000 watts.
     *
     * @return a random power consumption value
     */
    private static double getRandomPower() {
        return getRandomValue(500, 2000);
    }

    /**
     * Generates a random electromagnetic emission value for the vacuum cleaner.
     * The value is within the range of 600 to 800 microteslas.
     *
     * @return a random electromagnetic emission value
     */
    private static double getRandomElectromagneticEmission() {
        return getRandomValue(600, 800);
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
     * For this class, it always returns "Vacuum cleaner".
     *
     * @return the name of the appliance
     */
    @Override
    public String getName() {
        return "Vacuum cleaner";
    }
}
