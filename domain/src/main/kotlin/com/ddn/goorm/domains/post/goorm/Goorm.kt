package com.ddn.goorm.domains.post.goorm

import com.ddn.goorm.domains.BaseEntity
import com.ddn.goorm.domains.group.member.Member
import com.ddn.goorm.domains.group.team.Team
import com.ddn.goorm.domains.group.topic.Topic
import com.ddn.goorm.domains.post.comment.Comment
import javax.persistence.*

@Entity
class Goorm(
    @Column(length = 64)
    var title: String? = "",

    @Column(columnDefinition = "text")
    var contents: String? = "",

    @Column(columnDefinition = "tinyint")
    var isPin: Boolean? = false,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "member")
    var member: Member? = null,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "topic")
    var topic: Topic? = null
) : BaseEntity() {

    @OneToMany (
        mappedBy = "goorm",
        cascade = [CascadeType.ALL]
    )
    var comments: List<Comment>? = null


    fun updateIsFin() {
        this.isPin = !this.isPin!!
    }

}