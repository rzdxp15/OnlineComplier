import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class test {
	public static void main(String args[]) throws IOException {
		InputStream iS=new FileInputStream("E:/testclass.class");
		byte[]b=new byte[iS.available()];
		iS.read();
		
		iS.close();
		for(int i=0;i<b.length;i++)
		System.out.print(b[i]);
	}
}
