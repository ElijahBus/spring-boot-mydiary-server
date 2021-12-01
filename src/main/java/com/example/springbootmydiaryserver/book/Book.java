package com.example.springbootmydiaryserver.book;

import com.example.springbootmydiaryserver.embedables.Directory;
import com.example.springbootmydiaryserver.note.Note;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SecondaryTable(
        name = "author",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "book_id")
)
public class Book {

    @Id
    @GenericGenerator(
            name = "book_uuid",
            strategy = "org.hibernate.id.UUIDHexGenerator",
            parameters = @Parameter(name = "separator", value = "-")
    )
    @GeneratedValue(generator = "uuid")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Embedded
    @AttributeOverride(name = "shelfNumber", column = @Column(name = "shelf_number"))
    private Directory directory;
    
    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(table = "author", name = "author_name")
    private String authorName;

    @Column(table = "author", name = "author_phone")
    private String authorPhone;

    @OneToOne(mappedBy = "book", fetch = FetchType.LAZY)
    @JsonIgnore
    private PublicationHouse publicationHouse;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Collection<Note> note;

    public Book(String name,
                Directory directory,
                LocalDate publicationDate,
                LocalDate createdAt,
                String authorName,
                String authorPhone) {
        this.name = name;
        this.directory = directory;
        this.publicationDate = publicationDate;
        this.createdAt = createdAt;
        this.authorName = authorName;
        this.authorPhone = authorPhone;

    }
}