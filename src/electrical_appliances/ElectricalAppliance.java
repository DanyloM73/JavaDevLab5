package electrical_appliances;

/**
 * Represents a general electrical appliance.
 * Contains information about the brand, power consumption,
 * electromagnetic emission, and plugging status.
 */
public abstract class ElectricalAppliance {
    private final String brand;
    private final double power;
    private final double electromagneticEmission;
    private boolean isPluggedIn;

    /**
     * Constructs an {@code ElectricalAppliance} object with specified brand, power
     * and electromagnetic emission values.
     *
     * @param brand the brand of the appliance
     * @param power the power consumption of the appliance in watts
     * @param electromagneticEmission the electromagnetic emission in microtesla
     * @throws IllegalArgumentException if power or electromagneticEmission is negative
     */
    public ElectricalAppliance(String brand, double power, double electromagneticEmission) {
        if (power < 0 || electromagneticEmission < 0) {
            throw new IllegalArgumentException("Power and electromagnetic emission cannot be negative.");
        }
        this.brand = brand;
        this.power = power;
        this.electromagneticEmission = electromagneticEmission;
        this.isPluggedIn = false;
    }

    /**
     * Plugs in the appliance.
     */
    public void plugIn() {
        System.out.println(getName() + " by " + brand + " was plugged in");
        isPluggedIn = true;
    }

    /**
     * Unplugs the appliance.
     */
    public void unplug() {
        System.out.println(getName() + " by " + brand + " was unplugged");
        isPluggedIn = false;
    }

    /**
     * Checks if the appliance is plugged in.
     *
     * @return {@code true} if the appliance is plugged in, otherwise {@code false}
     */
    public boolean isPluggedIn() {
        return isPluggedIn;
    }

    /**
     * Retrieves the power consumption of the appliance.
     *
     * @return the power consumption in watts
     */
    public double getPower() {
        return power;
    }

    /**
     * Retrieves the electromagnetic emission of the appliance.
     *
     * @return the electromagnetic emission in microtesla
     */
    public double getElectromagneticEmission() {
        return electromagneticEmission;
    }

    /**
     * Retrieves the brand of the appliance.
     *
     * @return the brand name
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Retrieves the name of the appliance. Can be overridden by subclasses.
     *
     * @return the name of the appliance
     */
    public String getName() {
        return "Some electrical appliance";
    }

    /**
     * @return a string describing the appliance
     */
    @Override
    public String toString() {
        return String.format("%s by %s [Power: %.2f W, EM Emission: %.2f µT, Plugged in: %s]",
                getName(), brand, power, electromagneticEmission, isPluggedIn);
    }
}
