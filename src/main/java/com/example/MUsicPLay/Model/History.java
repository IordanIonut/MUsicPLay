package com.example.MUsicPLay.Model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long history_id;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user_id;
    @ManyToOne
    @JoinColumn(name = "content_id",referencedColumnName = "content_id")
    private Content content_id;

    public History(User userId, Content contentId) {
        this.user_id=userId;
        this.content_id=contentId;
    }
}
