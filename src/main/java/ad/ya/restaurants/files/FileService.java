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

    public void saveFile(MultipartFile file, String type) throws IOException {
        String filename = file.getOriginalFilename();
        repository.save(new File().setNom(filename).setType(type));
        Files.copy(file.getInputStream(), storageFolder.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
    }

    public Optional<Resource> getFile(long id) throws MalformedURLException {
        /*Optional<File> optionalFile = repository.findById(id);
        if(optionalFile.isPresent()) {
            return new UrlResource(storageFolder.resolve(optionalFile.get().getNom()).toUri());
        }
        return null;*/

        return repository.findById(id).map(this::fileToResource);
    }

    @SneakyThrows
    private Resource fileToResource(File file) {
        return new UrlResource(storageFolder.resolve(file.getNom()).toUri());
    }
}
