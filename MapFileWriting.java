import java.io.File;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MapFileWriting {

	private static String nameOfFile = "Aggregation";
	private static int[] array = { 1234567, 2345678, 3456789 };

	public static void main(String[] args) throws Exception {

		File file = new File(nameOfFile);

		file.delete();

		try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {

			FileChannel fileChannel = randomAccessFile.getChannel();

			MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0,
					array.length * Integer.BYTES);

			IntBuffer intBuffer = mappedByteBuffer.asIntBuffer();

			int counter = 0;
			while (counter < array.length) {
				intBuffer.put(array[counter]);
				counter++;
			}
		}
	}
}
