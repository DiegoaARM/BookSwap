package BookSwap.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "copies")
public class Copy {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "id_book")
    @ManyToOne
    private Book book;

    @JoinColumn(name = "id_user")
    @ManyToOne
    @JsonIgnoreProperties(value="copiesList")
    private User user;

    @JoinColumn(name = "id_editorial")
    @ManyToOne
    private Editorial editorial;

    @JoinColumn(name = "id_usage")
    @ManyToOne
    private Usage usage;

    @Column(name = "num_pages")
    private int num_pages;

    @Column(name = "created_at")
    private Date created_at;

    @OneToMany(mappedBy = "copy", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Copy_image> imagesList;
}
