//producer thread operation
class Producer extends Thread {

	// Producer producing the data in StringBuffer
	StringBuffer sb;

	// variable used by thread for communication
	boolean dataProvider = false;

	// constructor injection
	public Producer() {
		// StringBuffer object is created with a default capacity 16
		sb = new StringBuffer();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 10; i++) {

			try {
				sb.append(i + ": ");
				Thread.sleep(1000);
				System.out.println("appending");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// informing the consumer the data is produced
		dataProvider = true;
	}

}

//consumer thread operations
class Consumer extends Thread {

	// Creating producer object to get the produced data from Stringbuffer
	Producer producer;

	public Consumer(Producer producer) {
		this.producer = producer;
	}

	@Override
	public void run() {

		// check for the producer dataProvider for the dataProvider variable
		// if true only consume the data otherwise enter into sleeping state
		while (producer.dataProvider == false) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Consume the data produced by the producer
		System.out.println(producer.sb);
	}

}

//Very less efficient method
public class MultiThreading_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Producer obj1 = new Producer();
		Consumer obj2 = new Consumer(obj1);

		Thread t1 = new Thread(obj1);// producer thread
		Thread t2 = new Thread(obj2);// consumer thread
		
		t2.start(); //consumer should wait
		t1.start(); //producer should start
	}

}
