package org.oz.locale24_store_back.common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@ToString
public abstract class BasicEntity {

    @Column(name = "del_flag", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean delFlag = Boolean.FALSE;

    @Column(name = "reg_date",updatable = false)
    @CreatedDate
    private LocalDateTime regDate;

    @Column(name = "mod_date")
    @LastModifiedDate
    private LocalDateTime modDate;

    @Column(name = "creator")
    private String creator;

    // Soft Delete Boolean 값 변경
    public Boolean changeDelFlag(Boolean newDelFlag){
        return this.delFlag = newDelFlag;
    }
}
