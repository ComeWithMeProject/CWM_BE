package com.cwm.develop.like;

import com.cwm.develop.like.dto.LikeRequestDto;
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
    private AreaBasedList1 areaBasedList1Id;

    public Like_TB(LikeRequestDto requestDto) {
        this.userId = requestDto.getUserId();
        this.areaBasedList1Id = requestDto.getAreaBasedList1();
    }
}
