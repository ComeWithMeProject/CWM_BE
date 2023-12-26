package com.cwm.develop.like;

import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import com.cwm.develop.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "LIKE_TB")
@Builder
public class Like_TB {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likeId")
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "areaBasedListId")
    private AreaBasedList1 areBasedListId;

}
