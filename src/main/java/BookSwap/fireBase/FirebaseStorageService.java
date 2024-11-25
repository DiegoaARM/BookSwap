package BookSwap.fireBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.google.cloud.storage.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class FirebaseStorageService {

    private final Storage storage;

    @Autowired
    public FirebaseStorageService(Storage storage) {
        this.storage = storage;
    }

    public List<String> uploadFiles(List<MultipartFile> files) throws IOException {
        List<String> urls = new ArrayList<>();

        for (MultipartFile file : files) {
            String fileName = generateFileName(file.getOriginalFilename());
            BlobId blobId = BlobId.of("bookswap-8eb14.firebasestorage.app", "images/" + fileName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                    .setContentType(file.getContentType())
                    .build();

            storage.create(blobInfo, file.getBytes());

            // URL correcta para Firebase Storage
            String url = String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media",
                    "bookswap-8eb14.firebasestorage.app",
                    URLEncoder.encode("images/" + fileName, StandardCharsets.UTF_8));
            urls.add(url);
        }

        return urls;
    }

    public void deleteFile(String fileUrl) {
        try {
            // Extraer el nombre del archivo de la URL
            String filePath = fileUrl.replace("https://storage.googleapis.com/bookswap-8eb14.firebasestorage.app/", "");

            // Crear el BlobId usando el bucket y el path
            BlobId blobId = BlobId.of("bookswap-8eb14.firebasestorage.app", filePath);

            // Eliminar el archivo
            boolean deleted = storage.delete(blobId);

            if (!deleted) {
                throw new RuntimeException("Failed to delete file: " + fileUrl);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting file from Firebase: " + e.getMessage());
        }
    }

    private String generateFileName(String originalFileName) {
        return System.currentTimeMillis() + "_" + originalFileName;
    }
}