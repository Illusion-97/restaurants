package ad.ya.restaurants.files;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@RequestMapping("files")
@RequiredArgsConstructor
public class FilesController {
    private final FileService service;

    @PostMapping(consumes = "multipart/form-data")
    void saveFile(@RequestParam MultipartFile file) throws IOException {
        service.saveFile(file);
    }

    @GetMapping("{name}")
    public ResponseEntity<Resource> getFile(@PathVariable String name) throws MalformedURLException {
        Resource file = service.getFile(name);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=%s".formatted(file.getFilename()))
                .body(file);
    }
}
