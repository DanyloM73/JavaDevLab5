import electrical_appliances.*;

import java.util.Random;
import java.util.Scanner;

/**
 * The main entry point for the application.
 * Demonstrates the functionality of managing electrical appliances in an apartment.
 */
public class Main {
    /**
     * The entry point of the application.
     * Creates an apartment, adds random electrical appliances, and performs various operations such as:
     * <ul>
     *     <li>Plugging in a random number of appliances</li>
     *     <li>Unplugging a random number of appliances</li>
     *     <li>Sorting appliances by power consumption</li>
     *     <li>Filtering appliances by electromagnetic emission range</li>
     *     <li>Calculating the total power consumption of plugged-in appliances</li>
     * </ul>
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        Apartment apartment = new Apartment(7);
        Random random = new Random();

        // Generate a random number of appliances to add
        int numberOfAppliances = 3 + random.nextInt(5); // 3 to 7 appliances
        for (int i = 0; i < numberOfAppliances; i++) {
            ElectricalAppliance appliance = createRandomAppliance();
            apartment.addAppliance(appliance);
        }

        System.out.println("\nElectrical appliances added to the apartment:");
        apartment.printAppliances();

        // Randomly plug in some appliances
        System.out.print("\n");
        int appliancesToPlugIn = 1 + random.nextInt(numberOfAppliances); // At least one appliance
        apartment.plugInSomeAppliances(appliancesToPlugIn);

        // Randomly unplug some of the plugged-in appliances
        int appliancesToUnplug = random.nextInt(appliancesToPlugIn); // Can be zero
        if (appliancesToUnplug != 0) System.out.print("\n");
        apartment.unplugSomeAppliances(appliancesToUnplug);

        // Calculate and display the total power consumption of plugged-in appliances
        System.out.printf("\nTotal power of plugged in devices: %.2f W\n",
                apartment.calculateTotalPowerConsumption());

        // Sort appliances by power consumption and display them
        apartment.sortAppliancesByPower();
        System.out.println("\nDevices sorted by power:");
        apartment.printAppliances();

        // Allow the user to filter appliances by electromagnetic emission range
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print("\nEnter the minimum value of the radiation range: ");
                    double minEmission = scanner.nextDouble();
                    System.out.print("Enter the maximum value of the radiation range: ");
                    double maxEmission = scanner.nextDouble();
                    if (minEmission > maxEmission) {
                        throw new IllegalArgumentException("Minimum value cannot be greater than the maximum value.");
                    }
                    ElectricalAppliance[] foundAppliances = apartment.findAppliancesByEmissionRange(minEmission, maxEmission);
                    System.out.println("\nDevices with electromagnetic radiation in a given range:");
                    for (ElectricalAppliance appliance : foundAppliances) {
                        System.out.println(appliance);
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Please enter the values again.");
                } catch (Exception e) {
                    System.out.println("Input error. Please try again.");
                    scanner.nextLine();
                }
            }
        }

    }

    /**
     * Creates a random {@code ElectricalAppliance} instance with a random brand and type.
     * Randomly selects one of the predefined appliance types:
     * <ul>
     *     <li>ElectricStove</li>
     *     <li>Hairdryer</li>
     *     <li>Microwave</li>
     *     <li>VacuumCleaner</li>
     *     <li>WashingMachine</li>
     * </ul>
     *
     * @return a randomly generated appliance
     */
    private static ElectricalAppliance createRandomAppliance() {
        Random random = new Random();
        String[] brands = {"Samsung", "LG", "Bosch", "Philips", "Panasonic"};
        String brand = brands[random.nextInt(brands.length)];

        return switch (random.nextInt(5)) {
            case 0 -> new ElectricStove(brand);
            case 1 -> new Hairdryer(brand);
            case 2 -> new Microwave(brand);
            case 3 -> new VacuumCleaner(brand);
            default -> new WashingMachine(brand);
        };
    }
}
