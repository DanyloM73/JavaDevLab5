import electrical_appliances.ElectricalAppliance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Represents an apartment containing an array of {@link ElectricalAppliance} objects.
 * Allows operations such as adding appliances, calculating total power consumption,
 * and sorting or filtering appliances.
 */
public class Apartment {
    private ElectricalAppliance[] appliances;
    private int applianceCount;

    /**
     * Constructs an {@code Apartment} object with an initial size for appliances.
     *
     * @param size the initial size of the appliance array
     */
    public Apartment(int size) {
        appliances = new ElectricalAppliance[size];
        applianceCount = 0;
    }

    /**
     * Adds a new appliance to the apartment.
     *
     * @param appliance the appliance to be added
     */
    public void addAppliance(ElectricalAppliance appliance) {
        if (applianceCount == appliances.length) {
            expandArray();
        }
        appliances[applianceCount++] = appliance;
    }

    /**
     * Expands an array of electrical appliances.
     */
    private void expandArray() {
        ElectricalAppliance[] newAppliances = new ElectricalAppliance[appliances.length * 2];
        System.arraycopy(appliances, 0, newAppliances, 0, appliances.length);
        appliances = newAppliances;
    }

    /**
     * Calculates the total power consumption of all plugged-in appliances.
     *
     * @return the total power consumption in watts
     */
    public double calculateTotalPowerConsumption() {
        double totalPower = 0;
        for (int i = 0; i < applianceCount; i++) {
            if (appliances[i].isPluggedIn()) {
                totalPower += appliances[i].getPower();
            }
        }
        return totalPower;
    }

    /**
     * Sorts the appliances by their power consumption in ascending order.
     */
    public void sortAppliancesByPower() {
        Arrays.sort(appliances, 0, applianceCount, Comparator.comparingDouble(ElectricalAppliance::getPower));
    }

    /**
     * Finds appliances within a specified electromagnetic emission range.
     *
     * @param min the minimum electromagnetic emission
     * @param max the maximum electromagnetic emission
     * @return an array of appliances within the specified range
     * @throws IllegalArgumentException if the range is invalid
     */
    public ElectricalAppliance[] findAppliancesByEmissionRange(double min, double max) {
        if (min < 0 || max < 0 || min > max) {
            throw new IllegalArgumentException("Invalid range for electromagnetic emission.");
        }

        ElectricalAppliance[] matchingAppliances = new ElectricalAppliance[applianceCount];
        int matchingCount = 0;

        for (int i = 0; i < applianceCount; i++) {
            double emission = appliances[i].getElectromagneticEmission();
            if (emission >= min && emission <= max) {
                matchingAppliances[matchingCount++] = appliances[i];
            }
        }

        ElectricalAppliance[] result = new ElectricalAppliance[matchingCount];
        System.arraycopy(matchingAppliances, 0, result, 0, matchingCount);
        return result;
    }

    /**
     * Prints all appliances in the apartment.
     */
    public void printAppliances() {
        for (int i = 0; i < applianceCount; i++) {
            System.out.println(appliances[i]);
        }
    }

    /**
     * Plugs in a specified number of random appliances.
     *
     * @param count the number of appliances to plug in
     */
    public void plugInSomeAppliances(int count) {
        Random random = new Random();
        int pluggedInCount = 0;

        while (pluggedInCount < count) {
            int randomIndex = random.nextInt(applianceCount);
            if (!appliances[randomIndex].isPluggedIn()) {
                appliances[randomIndex].plugIn();
                pluggedInCount++;
            }
        }
    }

    /**
     * Unplugs a specified number of random appliances.
     *
     * @param count the number of appliances to unplug
     */
    public void unplugSomeAppliances(int count) {
        Random random = new Random();
        int unpluggedCount = 0;

        while (unpluggedCount < count) {
            int randomIndex = random.nextInt(applianceCount);
            if (appliances[randomIndex].isPluggedIn()) {
                appliances[randomIndex].unplug();
                unpluggedCount++;
            }
        }
    }
}
