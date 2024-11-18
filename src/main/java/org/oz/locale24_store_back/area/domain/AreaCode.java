package org.oz.locale24_store_back.area.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.oz.locale24_store_back.common.domain.BasicEntity;

@Entity
@Table(name = "tbl_areacode")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AreaCode extends BasicEntity {
    @Id
    @Column(name = "area_name", nullable = false)
    private String areaName;
}