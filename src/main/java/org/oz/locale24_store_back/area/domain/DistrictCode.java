package org.oz.locale24_store_back.area.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.oz.locale24_store_back.common.domain.BasicEntity;

@Entity
@Table(name = "tbl_districtcode")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DistrictCode extends BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_no")
    private Long districtNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_name", referencedColumnName = "area_name")
    private AreaCode areaCode;

    @Column(name = "district_name")
    private String districtName;
}