package org.example;

import java.util.*;

class CarServiceStation {
    private Map<String, Map<String, Integer>> services;

    public CarServiceStation() {
        services = new HashMap<>();
        services.put("BS01", new HashMap<String, Integer>() {{
            put("hatchback", 2000);
            put("sedan", 4000);
            put("suv", 5000);
        }});
        services.put("EF01", new HashMap<String, Integer>() {{
            put("hatchback", 5000);
            put("sedan", 8000);
            put("suv", 10000);
        }});
        services.put("CF01", new HashMap<String, Integer>() {{
            put("hatchback", 2000);
            put("sedan", 4000);
            put("suv", 6000);
        }});
        services.put("BF01", new HashMap<String, Integer>() {{
            put("hatchback", 1000);
            put("sedan", 1500);
            put("suv", 2500);
        }});
        services.put("GF01", new HashMap<String, Integer>() {{
            put("hatchback", 3000);
            put("sedan", 6000);
            put("suv", 8000);
        }});
    }
    public int calculateBill(String carType, List<String> serviceCodes) {
        int totalBill = 0;

        for (String serviceCode : serviceCodes) {
            Map<String, Integer> service = services.get(serviceCode);
            totalBill += service.get(carType);
        }
        return totalBill;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarServiceStation carServiceStation = new CarServiceStation();
        System.out.println("Enter the car type: ");
        String carType = sc.next();
        System.out.println("Enter the service codes (comma-separated): ");
        String serviceCodesStr = sc.next();
        List<String> serviceCodes = Arrays.asList(serviceCodesStr.split(","));
        int totalBill = carServiceStation.calculateBill(carType, serviceCodes);
        System.out.println("Total Bill: ₹" + totalBill);
        if (totalBill > 10000) {
            System.out.println("Complimentary cleaning will be provided.");
        }
    }
}