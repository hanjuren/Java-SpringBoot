package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "albums")
public class Album extends Item {

    private String artist;
}
