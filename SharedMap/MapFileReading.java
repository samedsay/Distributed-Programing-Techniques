import java.io.File;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MapFileReading {
	private static String nameOfFile = "Aggregation";
	private static int[] array = new int[3];

	public static void main(String[] args) throws Exception {
		try (RandomAccessFile file = new RandomAccessFile(new File(nameOfFile), "r")) {

			FileChannel fileChannel = file.getChannel();

			MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

			IntBuffer intBuffer = mappedByteBuffer.asIntBuffer();

			int counter = 0;
			while (counter < intBuffer.limit()) {
				array[counter] = intBuffer.get();
				counter++;
			}

			System.out
					.println(array[0] + " + " + array[1] + " + " + array[2] + " = " + (array[0] + array[1] + array[2]));
		}
	}

}
