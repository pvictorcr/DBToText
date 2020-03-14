package pvctr.grupoa.dbtotext.filecreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileCreator {

	private static String path = "/Users/joaopaulo/Desktop/";

	public static void CreateFile(String fileName, StringBuilder sb) {

		BufferedWriter writer = null;
		try {

			File file = new File(path + fileName + ".txt");

			// This will output the full path where the file will be written to...
			System.out.println(file.getCanonicalPath());

			file.createNewFile();

			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "Cp1252"));
			writer.append(sb);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} catch (Exception e) {
			}
		}
	}
}
