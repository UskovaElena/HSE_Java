import java.io.*;
import java.util.Map;

public class FileWork {
    private File file;

    public FileWork(File file) {
       this.file = file;
    }
    public String read() throws IOException {
            FileReader fr = new FileReader(this.file);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            StringBuilder strBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");
            while( ( line = br.readLine() ) != null ) {
                strBuilder.append( line );
                strBuilder.append( ls );
            }
            strBuilder.deleteCharAt(strBuilder.length()-1);
            return strBuilder.toString();
    }

    public void write(Map<Character, Integer> map) throws IOException {
        try {
            if (!this.file.exists()) {
                this.file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                for (Map.Entry<Character, Integer> m : map.entrySet()) {
                    out.write(m.getKey() + " - " + m.getValue().toString() + System.getProperty("line.separator"));
                }
            } finally {
                    out.close();
            }
        } catch(IOException e) {
            System.out.println("IOException message:" + e.getMessage());
        }
    }
}
