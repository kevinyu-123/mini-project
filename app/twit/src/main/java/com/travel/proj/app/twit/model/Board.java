package com.travel.proj.app.twit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.travel.proj.app.login.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length=100)
    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)  // Many = board , user = one
    @JoinColumn(name="userId")
    private User user;


    @OneToMany(mappedBy = "board",fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"board"})
    @OrderBy("id desc")
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}


