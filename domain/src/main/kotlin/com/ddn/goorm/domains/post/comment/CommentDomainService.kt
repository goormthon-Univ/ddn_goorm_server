package com.ddn.goorm.domains.post.comment

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CommentDomainService (
    private val commentRepository: CommentRepository
) {
}