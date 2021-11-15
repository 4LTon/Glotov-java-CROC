import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Directory {
    private Path path;

    public Directory (String path) { this.path = Paths.get(path);}

    // список файлов в директории и поддиректориях
    public List<Path> fileList() throws IOException {
        List<Path> result;
        try (Stream<Path> paths = Files.walk(path)) {
            result = paths.filter(Files::isRegularFile)
                    .filter(Directory::isFileExtensionLog)
                    .collect(Collectors.toList());
        }
        return result;
    }

    // проверка, является ли файл логом
    public static boolean isFileExtensionLog(Path path) {
        String fileName = path.getFileName().toString();
        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf == -1 || fileName.equals("MAIN.log")) return false;

        String fileExtension = fileName.substring(lastIndexOf);
        return  fileExtension.equals(".log") || fileExtension.equals(".trace");
    }

    // Буферизация файлов
    public List<BufferedReader> readersToDir() throws IOException {
        ArrayList<BufferedReader> readers = new ArrayList<>();
        for (Path file : this.fileList()) {
            readers.add(new BufferedReader(
                    new FileReader(file.getParent().toString() + "\\" + file.getFileName().toString())
            ));
        }
        return readers;
    }
}