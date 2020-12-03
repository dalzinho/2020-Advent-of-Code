package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class InputReader<T> {

    private final Caster<T> caster;

    public InputReader(Caster<T> caster) {
        this.caster = caster;
    }

    public List<T> readInputFile(String path) {
        URL resource = getClass().getClassLoader().getResource(path);
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        }

        File f = null;

        try {
            f = new File(resource.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        List<T> result = new ArrayList<>();
        try (BufferedReader b = new BufferedReader(new FileReader(f))) {

            String line;
            while((line = b.readLine()) != null) {
                T cast = caster.cast(line);
                result.add(cast);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return result;
    }

}
