package com.ddn.goorm.domains.group.topic

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TopicDomainService (
    private val topicRepository: TopicRepository
) {
    @Transactional(readOnly = true)
    fun findTopicListByTeam(team: Long): List<Topic> {
        return topicRepository.findAllByTeam_Id(team)
    }

    fun createTopic(topic: Topic): Topic {
        return topicRepository.save(topic)
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): Topic {
        return topicRepository.findById(id)
            .orElseThrow{IllegalArgumentException("존재하지 않는 주제입니다.")}
    }
}