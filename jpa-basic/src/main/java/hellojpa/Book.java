package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends Item {

    private String author;

    private String isbn;
}
