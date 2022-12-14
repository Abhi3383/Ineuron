interface Vehicle {
	public int getNoOfWheels();

	class DefaultVehicle implements Vehicle {
		public int getNoOfWheels() {
			return 2;
		}
	}
}

class Bus implements Vehicle {
	public int getNoOfWheels() {
		return 6;
	}
}

class Launch_9 {
	public static void main(String args[]) {
		Bus b = new Bus();
		System.out.println("b : "+b.getNoOfWheels());// 6

		Vehicle.DefaultVehicle d = new Vehicle.DefaultVehicle();
		System.out.println("d : "+d.getNoOfWheels());// 2
	}
}