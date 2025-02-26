package ad.ya.restaurants.files;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Optional;

@RestController
@RequestMapping("files")
@RequiredArgsConstructor
public class FilesController {
    private final FileService service;

    @PostMapping(consumes = "multipart/form-data")
    void saveFile(@RequestParam MultipartFile file, @RequestParam String type) throws IOException {
        service.saveFile(file, type);
    }

    @GetMapping("{id}")
    public ResponseEntity<Resource> getFile(@PathVariable long id) throws MalformedURLException {

        return service.getFile(id)
                .map(file -> ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=%s".formatted(file.getFilename()))
                        .body(file))
                //.orElse(ResponseEntity.noContent().build());
                /*orElse est TOUJOURS exécuté, même si l'optional n'est PAS vide
                 orElseGet n'exécute sa fonction QUE si l'optional est vide */
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
