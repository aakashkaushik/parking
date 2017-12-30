package com.gojek;

import com.gojek.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private Map<Slot, Vehicle> slotVehicleMap = new HashMap<>();

    public void initializeSlots(int noOfSlots) {
        parkingLot = new ParkingLot();
        Slot[] slots = new Slot[noOfSlots];
        for (int i = 0; i < noOfSlots; i++) {
            slots[i] = new Slot(i + 1);
            slotVehicleMap.put(slots[i], null);
        }
        parkingLot.setSlots(slots);
    }

    public Slot getFreeSlot() {
        for (Slot slot : parkingLot.getSlots()) {
            if (!slot.isOccupied())
                return slot;
        }
        return null;
    }

    public void parkVehicle(Slot slot, Vehicle vehicle) {
        slotVehicleMap.put(slot, vehicle);
    }

    public void leaveSlot(int slotNumber) {
        Slot slot = parkingLot.getSlots()[slotNumber - 1];
        if (!slot.isOccupied())
            throw new ParkingException("Slot is not yet occupied");
        slot.setOccupied(false);
        slotVehicleMap.put(slot, null);
    }

    public Map<Slot, Vehicle> getSlotVehicleMap() {
        return slotVehicleMap;
    }

    public void setSlotVehicleMap(Map<Slot, Vehicle> slotVehicleMap) {
        this.slotVehicleMap = slotVehicleMap;
    }

    public List<Vehicle> getVehicleInfoByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Map.Entry<Slot, Vehicle> entry : slotVehicleMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().getColor().equals(Vehicle.COLOR.valueOf(color.toUpperCase()))) {
                vehicles.add(entry.getValue());
            }
        }
        return vehicles;
    }

    public Slot getSlotByVehicleRegNo(String registrationNo) {
        for (Map.Entry<Slot, Vehicle> entry : slotVehicleMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().getRegistrationNumber().equals(registrationNo)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<Slot> getSlotsByVehicleColor(String color) {
        List<Slot> slots = new ArrayList<>();
        for (Map.Entry<Slot, Vehicle> entry : slotVehicleMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().getColor().equals(Vehicle.COLOR.valueOf(color.toUpperCase()))) {
                slots.add(entry.getKey());
            }
        }
        return slots;
    }
}
