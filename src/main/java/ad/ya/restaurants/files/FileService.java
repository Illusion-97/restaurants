package ad.ya.restaurants.files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    @Value("${file.storage.folder}")
    private Path storageFolder;


    public void saveFile(MultipartFile file) throws IOException {
        Files.copy(file.getInputStream(), storageFolder.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
    }

    public Resource getFile(String name) throws MalformedURLException {
        return new UrlResource(storageFolder.resolve(name).toUri());
    }
}
