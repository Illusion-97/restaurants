package ad.ya.restaurants.files;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileService {

    @Value("${file.storage.folder}")
    private Path storageFolder;
    private final FileRepository repository;

    @SneakyThrows
    public File saveFile(MultipartFile file, String type){
        String filename = file.getOriginalFilename();
        Files.copy(file.getInputStream(), storageFolder.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        return repository.save(new File().setNom(filename).setType(type));
    }

    public Optional<Resource> getFile(long id) {
        return repository.findById(id).map(this::fileToResource);
    }

    @SneakyThrows
    private Resource fileToResource(File file) {
        return new UrlResource(storageFolder.resolve(file.getNom()).toUri());
    }
}
