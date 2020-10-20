package Week_01;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ClassLoaderNew extends ClassLoader {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File(this.getClass().getResource("/Hello.xlass").getPath());
        int length = (int)f.length();
        byte[] bytes = new byte[length];
        try {
            new FileInputStream(f).read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return super.findClass(name);
        }
        for (int i = 0; i < bytes.length; ++i) {
            bytes[i] = (byte)(255 - bytes[i]);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

}
