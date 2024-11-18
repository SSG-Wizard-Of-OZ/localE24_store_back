package org.oz.locale24_store_back.store.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.oz.locale24_store_back.area.domain.AreaCode;
import org.oz.locale24_store_back.common.domain.BasicEntity;
import org.oz.locale24_store_back.localmaneger.domain.LocalManager;

@Entity
@Table(name = "store_info")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreInfoEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_no", nullable = false)
    private Long storeNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_no", referencedColumnName = "manager_no")
    private LocalManager managerNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_name", referencedColumnName = "area_name")
    private AreaCode areaCode;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "store_call")
    private String storeCall;

    @Column(name = "store_addr")
    private String storeAddr;

    @Column(name = "store_latitude")
    private String storeLatitude;

    @Column(name = "store_longitude")
    private String storeLongitude;

    @Column(name = "store_space_status")
    private Boolean storeSpaceStatus;


}
