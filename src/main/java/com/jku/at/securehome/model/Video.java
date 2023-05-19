package com.jku.at.securehome.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String name;

    @Lob
    private byte[]data;

    public Video(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }
}
