package com.voca.backend.Entity;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
class UserVocaAssignmentKey implements Serializable {

    @Column(name = "user_id")
    Integer userId;

    @Column(name = "voca_id")
    Integer vocaId;

    UserVocaAssignmentKey() {
    }

    public UserVocaAssignmentKey(Integer userId, Integer vocaId) {
        this.userId = userId;
        this.vocaId = vocaId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVocaId() {
        return vocaId;
    }

    public void setVocaId(Integer vocaId) {
        this.vocaId = vocaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVocaAssignmentKey that = (UserVocaAssignmentKey) o;
        return userId.equals(that.userId) && vocaId.equals(that.vocaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, vocaId);
    }
}
