class ParkingSystem {

    
    HashMap<Integer, Integer> mapper;
    
    public ParkingSystem(int big, int medium, int small) {
        mapper = new HashMap<Integer, Integer>();
        mapper.put (1, big);
        mapper.put (2, medium);
        mapper.put (3, small);
    }
    
    public boolean addCar(int carType) {
        
        if (mapper.get(carType) > 0)
        {
            mapper.put(carType, mapper.get(carType) - 1);
            return true;
        }
        else
            return false;
        
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
