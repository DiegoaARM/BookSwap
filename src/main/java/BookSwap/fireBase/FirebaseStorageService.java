package BookSwap.fireBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.google.cloud.storage.*;
import java.io.IOException;
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

            String url = String.format("https://storage.googleapis.com/%s/%s",
                    "bookswap-8eb14.firebasestorage.app", "images/" + fileName);
            urls.add(url);
        }

        return urls;
    }

    private String generateFileName(String originalFileName) {
        return System.currentTimeMillis() + "_" + originalFileName;
    }
}